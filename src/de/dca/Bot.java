package de.dca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

public class Bot
{
    public String authorization;
    public static Bot login(String email, String password) throws MalformedURLException {
        try {
           HttpURLConnection conn =  getrawHttpUrl(new URL("https://discord.com/api/v6/auth/login"));
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("captcha_key", "null");
            params.put("email", email);
            params.put("gift_code_sku_id", "null");
            params.put("login_source", "null");
            params.put("password", password);
            params.put("undelete", "false");

            sendData(conn, params);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private static void getResp(){

        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        StringBuilder resp = new StringBuilder();
        for (int c; (c = in.read()) >= 0; )
            resp.append((char) c);

        return resp;
    }
    private static void sendData( HttpURLConnection conn, Map<String, Object> params) throws IOException {
        params.put("content", "aaaaaaaa");
        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String, Object> param : params.entrySet()) {
            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }

        byte[] postDataBytes = postData.toString().getBytes("UTF-8");
        conn.getOutputStream().write(postDataBytes);
    }
    private static HttpURLConnection getHttpUrl(URL url, String akey) throws IOException {

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("authorization", akey);
        conn.setRequestProperty("Host", "support.smg-gun.de");
        conn.setRequestProperty("Connection", "keep-alive");
        conn.setRequestProperty("User-gent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.97 Safari/537.36");
        conn.setRequestProperty("Accepte", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        conn.setRequestProperty("Accept-Language", "keep-alive");
        conn.setRequestProperty("keep-alive", "timeout=1000");
        conn.setRequestProperty("Connection", "en-US,en;q=0.9,de-DE;q=0.8,de;q=0.7,ro;q=0.6");

        return conn;
    }
    private static HttpURLConnection getrawHttpUrl(URL url) throws IOException {

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Host", "support.smg-gun.de");
        conn.setRequestProperty("Connection", "keep-alive");
        conn.setRequestProperty("User-gent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.97 Safari/537.36");
        conn.setRequestProperty("Accepte", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        conn.setRequestProperty("Accept-Language", "keep-alive");
        conn.setRequestProperty("keep-alive", "timeout=1000");
        conn.setRequestProperty("Connection", "en-US,en;q=0.9,de-DE;q=0.8,de;q=0.7,ro;q=0.6");

        return conn;
    }

}
