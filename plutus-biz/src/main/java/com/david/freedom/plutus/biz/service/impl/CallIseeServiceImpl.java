package com.david.freedom.plutus.biz.service.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.david.freedom.plutus.biz.service.CallIseeService;

import com.google.common.hash.Hashing;

/**
 * @version $Id: null.java, v 1.0 2020/9/16 3:45 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class CallIseeServiceImpl implements CallIseeService {

    public static void main(String[] args) throws Exception {
        //访问地址(具体host值以线下提供为准)
        String url = "http://localhost:8080/openApi/bizCallback";
        //发送内容
        //orgNo输入的是控制台上配置的各个公司自己的代码
        String requestBody = "{\"request\":{\"campaignName\":\"大家保险\",\"underwritingTime\":1562556614391,\"iseeBiz\":\"XX21000.CdxmNVjQ7HHpFVSVEtfhg49.T\",\"orgNo\":\"DAJIA001\",\"campaignId\":\"10002542595\",\"orderNo\":\"donghaotest001\",\"applyTime\":1562049408000,\"policyNo\":\"IH1100012806366293\",\"customer\":[{\"customIdNo\":\"310109199207021383\",\"customIdType\":\"111\",\"customType\":1,\"customMobile\":\"18317714237\",\"customName\":\"测试\"},{\"customIdNo\":\"310109199207021383\",\"customIdType\":\"111\",\"customType\":2,\"customMobile\":\"18317714237\",\"customName\":\"测试\"}]},\"sendTime\":\"2019-05-19 11:30:10\",\"UUID\":\"cdd7ec4a-4522-4e54-845a-4baa41455e8b\",\"requestType\":\"01\",\"companyId\":\"zhongan\"}";

        String result = callBack(url, requestBody);
        System.out.println("result:" + result);
    }

    private static String callBack(String url, String requestBody) throws IOException {
        //示例使用httpclient-4.5.2.jar guava-21.0.jar

        //签名key
        String key = "isee123456";

        //生成签名
        String iseeGwSign = sign(key, requestBody);

        // 生成httpclient 客户端
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        //构建请求信息
        HttpPost httpPost = new HttpPost(url);

        //添加签名头信息
        httpPost.setHeader("ISEE_GW_SIGN", iseeGwSign);

        //添加request body
        StringEntity sendEntity = new StringEntity(requestBody, "utf-8");
        sendEntity.setContentEncoding("utf-8");
        sendEntity.setContentType("text/plain");
        httpPost.setEntity(sendEntity);

        System.out.println("请求报文:" + requestBody);
        // 示例内容提生产签名如下：4d9281656f6f203470603ab10b30dfec8e0b0e897b704fd6a74e35aec6336314
        System.out.println("请求签名:" + iseeGwSign);

        //可能会网络波动或服务端不稳定引起失败，建议自定义httpClient重发机制
        CloseableHttpResponse response = httpClient.execute(httpPost);

        if(response.getStatusLine().getStatusCode() != 200) {
            //可能是网络波动或服务端不稳定引起，建议有一定重发机制
            return null;
        }

        //获取返回报文
        String resBody = EntityUtils.toString(response.getEntity(), "utf-8");

        //返回签名(容器可能会对header的name重命名，getFirstHeader按忽略大小写取值)
        Header header = response.getFirstHeader("ISEE_GW_SIGN");
        if(header == null) {
            System.out.println("消息头签名获取失败，可能是非法请求");
            Arrays.asList(response.getAllHeaders()).stream().forEach(s -> {
                System.out.println(s.getName() + ":" + s.getValue());
            });
            return null;
        }
        String resHeaderSign = header.getValue();
        System.out.println("返回报文:" + resBody);
        System.out.println("返回签名:" + resHeaderSign);

        //验证返回数据有效性
        String resSign = sign(key, resBody);

        if(resSign.equals(resHeaderSign)) {
            JSONObject jsonObject = JSON.parseObject(resBody);
            String responseCode = jsonObject.getString("responseCode");
            if("0".equals(responseCode)) {
                System.out.println("服务端响应正常");
            } else {
                System.out.println("错误码:" + responseCode);
            }
        } else {
            // 非法返回
        }
        httpClient.close();
        return resBody;
    }

    private static String sign(String key, String body) throws UnsupportedEncodingException {
        //jdk1.8自带Base64 或者可使用commons-codec提供的，很多jar都有类似工具类
        String base64Body = Base64.getEncoder().encodeToString(body.getBytes("utf-8"));
        //Hashing由谷歌的guava封装，也可以直接使用jdk自带的
        return Hashing.hmacSha256(key.getBytes("utf-8")).hashString(base64Body, StandardCharsets.UTF_8).toString();
    }
}
