import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * @version $Id: null.java, v 1.0 2020/9/4 12:31 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class NormalTest {

    public static void main(String[] args) throws IOException {

        String text =  Base64.getEncoder().encodeToString("HABX:9n6S5UwZ".getBytes());
        System.out.println(text);

        HttpPost httpPost = new HttpPost("http://127.0.0.1:8080/addRegistrationInfo");

//        {
//	"userName":"娄文斌",
//	"telephone":"12345677654",
//	"cretNo":"234576543456",
//	"registrationStatusEnum":"已备份"
//	}

        JSONObject object = new JSONObject();
        Map<String,String> map= new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        map.put("userName","louwb");
        map.put("telephone","12345677654");
        map.put("cretNo","234576543456");
        map.put("registrationStatusEnum","正常");
        try {
            object.put("param",objectMapper.writeValueAsString(map));
        } catch (JSONException e) {
            e.printStackTrace();
        }



        StringEntity stringEntity = new StringEntity(map.toString(),"utf-8");
        stringEntity.setContentType("application/json;charset=UTF-8");
        httpPost.addHeader("Authorization","Basic SEFCWDo5bjZTNVV3Wg==");
        httpPost.setEntity(stringEntity);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        httpClient.execute(httpPost);
        httpClient.close();
    }
}
