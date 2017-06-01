package com.mytest.dao;

import com.mytest.entity.JavaBean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/6/6 0006.
 * String 转换为JSON对象
 */
public class StringToJSON {

    private JavaBean bean;

    public JavaBean getBean() {
        return bean;
    }

    public void setBean(JavaBean bean) {
        this.bean = bean;
    }

    public static void main(String[] args) throws JSONException{

    }

    public String retJsonArr(){
        //定义JSON字符串
        String jsonStr = "{\"id\": 2," +
                " \"title\": \"json title\", " +
                "\"config\": {" +
                "\"width\": 34," +
                "\"height\": 35," +
                "}, \"data\": [" +
                "\"JAVA\", \"JavaScript\", \"PHP\"" +
                "]}";

        //转换成为JSONObject对象
        JSONObject jsonObj = null;
        try {
            jsonObj = new JSONObject(jsonStr);


            //从JSONObject对象中获取数据
            bean = new JavaBean();

            //根据属性名称获取int型数据;
            bean.setId(jsonObj.getInt("id"));

            //根据属性名获取String数据;
            bean.setTitle(jsonObj.getString("title"));

            //根据属性名获取JSONObject类
            JSONObject config = jsonObj.getJSONObject("config");
            bean.setWidth(config.getInt("width"));
            bean.setHeight(config.getInt("height"));
        }catch (JSONException e) {
            e.printStackTrace();
        }

        //根据属性名获取JSONArray数组
        /*JSONArray data = jsonObj.getJSONArray("data");
        for(int index = 0, length = data.length(); index < length; index++) {
            //这里在org.json.JSONArray对象中居然没有找到toArray方法，求各位网友给出解决办法啊！
            //            bean.setLanguages(String[]);
        }*/

        return "success";
    }

}
