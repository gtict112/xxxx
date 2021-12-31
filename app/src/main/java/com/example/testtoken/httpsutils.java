package com.example.testtoken;

import static android.content.ContentValues.TAG;

import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class httpsutils {

    JSONObject jSONObject1 = new JSONObject();

    public httpsutils() {
    }

    public void https_post() throws IOException {

        URL url = null;
        HttpURLConnection coon = null;
        try {
            url = new URL("http://test-device-id-query.wanyol.com/device/query");
            coon = (HttpURLConnection) url.openConnection();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            coon.setRequestMethod("POST");
            coon.setRequestProperty("Content-Type", "application/json");
            coon.getOutputStream().write(String.valueOf(jSONObject1).getBytes());
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        coon.setReadTimeout(6000);
        try {
            Log.d(TAG, "run: ddddd"+coon.getResponseCode());
            if(coon.getResponseCode() == 200){
                //获取输入流
                Log.d(TAG, "run: ddddd");
                String ttt = null;
                InputStream is = coon.getInputStream();
                BufferedReader reader = null;
                StringBuffer sbf = new StringBuffer();
                reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                String strRead = null;
                while ((strRead = reader.readLine()) != null) {
                    sbf.append(strRead);
                    sbf.append("\r\n");
                }
                reader.close();
                ttt = sbf.toString();

                int len = 0;}
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public String toString() {
        return "httpsutils{}";
    }
}
