package com.springbootconnector.accesshttp.controller;

import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class AccessHttpController {

    @RequestMapping("/doPostGetJson")
    public String doPostGetJson() throws JSONException {
        //此处将要发送的数据转换为json格式字符串
        String jsonText = "{id: 1}";
        JSONObject json = new JSONObject(jsonText);
        JSONObject sr = this.doPost(json);
        log.info("返回参数: " + sr);
        return sr.toString();
    }

    public static JSONObject doPost(JSONObject date) {
        HttpClient client = HttpClients.createDefault();
        // 要调用的接口方法
        String url = "http://10.10.10.46:9090/hello";
        HttpPost post = new HttpPost(url);
        JSONObject jsonObject = null;
        try {
            StringEntity s = new StringEntity(date.toString());
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");
            post.setEntity(s);
            post.addHeader("content-type", "text/html;charset=UTF-8");
            HttpResponse res = client.execute(post);
            String response1 = EntityUtils.toString(res.getEntity());
            log.info(response1.toString());
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 返回json格式:
                jsonObject = new JSONObject(response1);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return jsonObject;
    }


}
