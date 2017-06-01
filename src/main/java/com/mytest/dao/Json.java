package com.mytest.dao;

import java.util.HashMap;
import java.util.Map;

import com.mytest.entity.User;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.json.annotations.JSON;

/**
 *
 * structs2返回json的demo
 *
 */
public class Json extends ActionSupport{

    private static final long serialVersionUID = 1L;

    private Map<String,Object> dataMap;

    public void setDataMap(Map<String, Object> dataMap) {
        this.dataMap = dataMap;
    }

    public Map<String, Object> getDataMap() {
        return dataMap;
    }

    private String key = "Just see see";

    /*返回json数据*/
    public String retJson() {
        dataMap = new HashMap<String, Object>();
        User user = new User();
        user.setName("张三");
        user.setPassword("123");
        dataMap.put("user", user);
        dataMap.put("success", true);
        return SUCCESS;
    }



    @JSON(serialize=false)
    public String getKey() {
        return key;
    }

}