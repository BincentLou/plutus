package isee;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.hash.Hashing;

import lombok.extern.slf4j.Slf4j;

/**
 * @version $Id: null.java, v 1.0 2020/9/16 7:55 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
@Slf4j
public class CallIseeTest {


    private final static String ISEE_GW_SIGN =  "ISEE_GW_SIGN";

    private final static String RESPONSE_CODE =  "responseCode";

    @Value("${isee.url:http://localhost:8080/openApi/bizCallback}")
    private static String ISEE_CALL_BACK_URL = "http://localhost:8080/openApi/bizCallback";

    @Value("${isee.key:isee123456}")
    private static String key = "isee123456";

    public static void main(String[] args){

        BaseIseeRequest request = new BaseIseeRequest();
        request.setApplyTime(new Date());
        callIseeVedioSave(request);

    }

    public static BaseIseeResponse callIseeVedioSave(@Valid BaseIseeRequest request) {

        // 访问地址
        String url = getUrl();
        //转json
        String jsonRequest = getJsonRequest(request);
        //加密
        String signStr = sign(jsonRequest);

        // 生成httpclient 客户端
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        //拼装 post
        HttpPost httpPost = getHttpPost(url, jsonRequest, signStr);

        //可能会网络波动或服务端不稳定引起失败，建议自定义httpClient重发机制
        try(CloseableHttpResponse response = httpClient.execute(httpPost)) {
            log.error("调用Isee服务返回状态：{}",response.getStatusLine().getStatusCode());
            // AssertUtils.checkCondition(response.getStatusLine().getStatusCode() == 200,EnumPAPHError.CALL_ISEE_FAILED);

            //返回签名(容器可能会对header的name重命名，getFirstHeader按忽略大小写取值)
            Header header = response.getFirstHeader(ISEE_GW_SIGN);
            // AssertUtils.checkCondition(header!=null,EnumPAPHError.ISEE_RESPONSE_ILLEGAL);

            //验证返回数据有效性
            String resHeaderSign = header.getValue();
            //获取返回报文
            String resBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
            String resSign = sign(resBody);
            // AssertUtils.checkCondition(resSign.equals(resHeaderSign),EnumPAPHError.ISEE_RESPONSE_ILLEGAL);


            // 校验返回状态
            log.debug("服务端返回数据{}",resBody);
            JSONObject jsonObject = JSON.parseObject(resBody);
            String responseCode = jsonObject.getString(RESPONSE_CODE);
            // AssertUtils.checkCondition(BaseIseeResponse.SUCCESS.equals(responseCode),EnumPAPHError.CALL_ISEE_FAILED);

            BaseIseeResponse result = jsonObject.toJavaObject(BaseIseeResponse.class);
            return result;
        } catch (IOException e) {
            log.error("出错了",e.getMessage(),e);
            return BaseIseeResponse.builder().responseMsg(e.getMessage()).responseCode(BaseIseeResponse.UNSIGN_FAIL).build();
        }
    }

    @NotNull
    private static HttpPost getHttpPost(String url, String jsonRequest, String signStr) {
        //构建请求信息
        HttpPost httpPost = new HttpPost(url);
        //添加签名头信息
        httpPost.setHeader(ISEE_GW_SIGN, signStr);
        //添加request body
        StringEntity sendEntity = getSendEntity(jsonRequest);
        httpPost.setEntity(sendEntity);
        return httpPost;
    }

    @NotNull
    private static StringEntity getSendEntity(String jsonRequest) {
        StringEntity sendEntity = new StringEntity(jsonRequest, StandardCharsets.UTF_8);
        sendEntity.setContentEncoding("utf-8");
        sendEntity.setContentType("text/plain");
        return sendEntity;
    }

    // 序列化
    private static String getJsonRequest(BaseIseeRequest request) {
        return  JSONObject.toJSONString(request);
    }

    private static String sign(String requestJson) {
        //jdk1.8自带Base64 或者可使用commons-codec提供的，很多jar都有类似工具类
        String base64Body = Base64.getEncoder().encodeToString(requestJson.getBytes(StandardCharsets.UTF_8));
        //Hashing由谷歌的guava封装，也可以直接使用jdk自带的
        return Hashing.hmacSha256(key.getBytes(StandardCharsets.UTF_8)).hashString(base64Body, StandardCharsets.UTF_8).toString();
    }


    private static String getUrl() {
        return ISEE_CALL_BACK_URL;
    }
}
