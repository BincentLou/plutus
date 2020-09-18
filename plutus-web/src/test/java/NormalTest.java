import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.http.client.methods.HttpPost;
import org.json.JSONException;
import org.json.JSONObject;

import com.david.freedom.plutus.decode.RSA2048Util;
import com.david.freedom.plutus.decode.RSAKeyFactory;
import com.david.freedom.plutus.mvc.filter.DecodeAndHttpServletRequestReplacedFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @version $Id: null.java, v 1.0 2020/9/4 12:31 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class NormalTest {


    public static void main(String[] args) throws ParseException {

        Date date = new Date();
        long timstamp = date.getTime();
        // Integer timeInt = Integer.valueOf(String.valueOf(DateUtils.parseDate(DateFormatUtils.format(timstamp,"YYYY-MM-dd"),"YYYY-MM-dd").getTime()));
        Integer timeInt = new Integer("132131321321");
        String  dateStr = DateFormatUtils.format(Long.valueOf(timeInt),"YYYY-MM-dd");
        System.out.println(dateStr);
        // 1600358400000

    }

    private static int caculate(int i, int deep) {
        if(deep>8){
            throw new IllegalArgumentException("");
        }
        if(i==2){
            return 2;
        }
        if(i==1){
            return 1;
        }
        deep++;
        return caculate(i-1, deep)+caculate(i-2, deep);
    }

    private static void encodTest() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userName","娄文斌");
        jsonObject.put("address","南京紫金保险");
        String jsonString = jsonObject.toString();
        String encodeString = RSA2048Util.rsaEncrypt(jsonString, DecodeAndHttpServletRequestReplacedFilter.publicKey);
        System.out.println(encodeString);
    }

    private static void getKeyPair() throws NoSuchAlgorithmException {
        String text =  Base64.getEncoder().encodeToString("HABX:9n6S5UwZ".getBytes());
        System.out.println(text);

//        httpPost();

        RSAKeyFactory.KeyPairObject keyPair = RSAKeyFactory.getKeyPair();
        System.out.println(keyPair.getPrivateKey());
        System.out.println("------------------------------");
        System.out.println(keyPair.getPublicKey());
    }


    private static void httpPost() throws JsonProcessingException {
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
//        0qwWtnhOkCW1+/3eG68xDjeZzPZjpXhjjxP9E3FJU8PyCdA8QKdRBkaZBPRD3Jzcj89SSD8ej2lk
//        22L3PGD8wq03fJ/TWzY0BYHG0BnqkMH48FOO4YQk8z4/1o+n/yHx48pITE5Hj5AmZ03gBV5mMvOz
//        9yx/ziDAruef+XRFCC3CrzN6JDbgsJr9nQBIlpSVdrA02ObMH+mpKJPqyVME2sbl5zzo+lbNzERq
//        tPoMGGAxqh5iVP7YdFgvywNEHqezFlr133b/Ow==
        System.out.println(objectMapper.writeValueAsString(map));

//        StringEntity stringEntity = new StringEntity(map.toString(),"utf-8");
//        stringEntity.setContentType("application/json;charset=UTF-8");
//        httpPost.addHeader("Authorization","Basic SEFCWDo5bjZTNVV3Wg==");
//        httpPost.setEntity(stringEntity);
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        httpClient.execute(httpPost);
//        httpClient.close();
    }

    static class User implements Serializable,Comparable<User>{
        private static final long serialVersionUID = -5784733683967309613L;

        private String userName;

        private String address;

        public String getUserName() {
            return userName;
        }

        public User setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public String getAddress() {
            return address;
        }

        public User setAddress(String address) {
            this.address = address;
            return this;
        }

        public User(String userName, String address) {
            this.userName = userName;
            this.address = address;
        }

        @Override
        public String toString() {
            return "User{" + "userName='" + userName + '\'' + ", address='" + address + '\'' + '}';
        }


        @Override
        public int compareTo(User o) {
            return 0;
        }
    }
}
