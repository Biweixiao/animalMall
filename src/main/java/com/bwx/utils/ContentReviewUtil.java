package com.bwx.utils;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import javax.net.ssl.SSLContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * @Author BiWeixiao
 * @Date Created in 22:06 20/4/29
 */

public class ContentReviewUtil {
    public static final String APP_ID = "19538675";
    public static final String API_KEY = "cDafbNlhh10GbG8u6hE9ZSlc";
    public static final String SECRET_KEY = "UphlD98Ggp7UseoWOhuo2ikpm5WnCx42";
    public static final String WORD_URL = "https://aip.baidubce.com/rest/2.0/solution/v1/text_censor/v2/user_defined";
    public static final String TOKEN_URL = "https://aip.baidubce.com/oauth/2.0/token?grant_type=client_credentials&client_id=";
    public static final String IMG_URL = "https://aip.baidubce.com/rest/2.0/solution/v1/img_censor/v2/user_defined";
    public String token = "24.eb278e6e73acba4223e60b853f6a34b6.2592000.1590823082.282335-19538675";

    //文字检查
    public boolean checkWord(String text) {
        HttpClient client = HttpClientBuilder.create().build();
        String url = WORD_URL + "?access_token=" + token;
        HttpPost post = new HttpPost(url);
        try {
            StringEntity stringEntity = new StringEntity("text=" + text);
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/x-www-form-urlencoded");
            post.setEntity(stringEntity);
            HttpResponse httpResponse = client.execute(post);
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String result = EntityUtils.toString(httpResponse.getEntity());
                boolean ImgCheckResult = (result.substring(result.length() - 2, result.length() - 1).equals("1"));
                System.out.println(result);
                System.out.println(ImgCheckResult);
                return ImgCheckResult;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    //图片检查
    public boolean checkImg(String imgUrl) {
        System.out.println("图片地址：" + imgUrl);
        HttpClient client = HttpClientBuilder.create().build();
        String url = IMG_URL + "?access_token=" + token;
        HttpPost post = new HttpPost(url);
        try {
            StringEntity stringEntity = new StringEntity("imgUrl=" + imgUrl);
            stringEntity.setContentType("application/x-www-form-urlencoded");
            post.setEntity(stringEntity);
            HttpResponse httpResponse = client.execute(post);
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String result = EntityUtils.toString(httpResponse.getEntity());
                System.out.println(result);
                boolean checkResult = (result.substring(result.length() - 2, result.length() - 1).equals("1"));
                System.out.println(checkResult);
                return checkResult;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    //获取百度的token
    public boolean getAuth() {
        String authHost = TOKEN_URL + API_KEY + "&client_secret=" + SECRET_KEY;
        try {
            URL realUrl = new URL(authHost);
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            Map<String, List<String>> map = connection.getHeaderFields();
            for (String key : map.keySet()) {
                System.out.println(key + "------->" + map.get(key));
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            System.err.println("result:" + result);
            JSONObject jsonObject = new JSONObject(result);
            String access_token = jsonObject.getString("access_token");
            System.out.println(access_token);
            token = access_token;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return false;
    }
}
