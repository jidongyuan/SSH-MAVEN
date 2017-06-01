package com.mytest.dao;

import com.mytest.entity.JavaBean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/6/6 0006.
 * String ת��ΪJSON����
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
        //����JSON�ַ���
        String jsonStr = "{\"id\": 2," +
                " \"title\": \"json title\", " +
                "\"config\": {" +
                "\"width\": 34," +
                "\"height\": 35," +
                "}, \"data\": [" +
                "\"JAVA\", \"JavaScript\", \"PHP\"" +
                "]}";

        //ת����ΪJSONObject����
        JSONObject jsonObj = null;
        try {
            jsonObj = new JSONObject(jsonStr);


            //��JSONObject�����л�ȡ����
            bean = new JavaBean();

            //�����������ƻ�ȡint������;
            bean.setId(jsonObj.getInt("id"));

            //������������ȡString����;
            bean.setTitle(jsonObj.getString("title"));

            //������������ȡJSONObject��
            JSONObject config = jsonObj.getJSONObject("config");
            bean.setWidth(config.getInt("width"));
            bean.setHeight(config.getInt("height"));
        }catch (JSONException e) {
            e.printStackTrace();
        }

        //������������ȡJSONArray����
        /*JSONArray data = jsonObj.getJSONArray("data");
        for(int index = 0, length = data.length(); index < length; index++) {
            //������org.json.JSONArray�����о�Ȼû���ҵ�toArray���������λ���Ѹ�������취����
            //            bean.setLanguages(String[]);
        }*/

        return "success";
    }

}
