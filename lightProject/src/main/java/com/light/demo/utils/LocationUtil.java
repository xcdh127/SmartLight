package com.light.demo.utils;

import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.util.Map;

public class LocationUtil {
    public static void main(String[] args) {
        Map<String, Object> getcitydetailbyjingwei = getcitydetailbyjingwei(118.46566, 36.55001);
        Object result = getcitydetailbyjingwei.get("result");
    }

    public static Map<String, Object> getcitydetailbyjingwei(double jing, double wei) {
        Map<String, Object> map = null;
        String url = "http://api.map.baidu.com/reverse_geocoding/v3/?"
                + "ak=OFluelPjpmdE1eeEkXDHK5ulHilNaKTq&output=json&coordtype=wgs84ll&location="
                + wei + "," + jing;
        try {
            HttpClient client = HttpClientBuilder.create().build();//构建一个Client
            HttpGet get = new HttpGet(url.toString());    //构建一个GET请求
            HttpResponse response = client.execute(get);//提交GET请求
            HttpEntity result = response.getEntity();//拿到返回的HttpResponse的"实体"
            String content = EntityUtils.toString(result);
            JSONObject res = JSONObject.fromObject(content);
            map = JsonUtil.parseJSON2Map(res); //通过下面的函数将json转化为map
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("获取地址失败");
        }
        return map;
    }
}
