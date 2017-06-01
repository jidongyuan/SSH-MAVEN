package com.mytest.FastJson;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class MainTest {

    public static void main(String[] args) {
        // 对象构造
        Node node = new Node("1", "12", "jone", false, new Tree("green", true));
        String jsonStr = JSON.toJSONString(node);
        System.out.println(jsonStr);
        Node node3 = JSON.parseObject(jsonStr, Node.class);
        System.out.println("FastJson解析结果【对象】：" + node3.getName());

        // 字符串构造
        System.out.println("////////////////////////");
        String response = "{\"id\":\"2\",\"name\":\"节点01\",\"open\":true,\"pId\":\"1\",\"tree\":{\"color\":\"gree\",\"tree\":true}}";
        Node node4 = JSON.parseObject(response, Node.class);
        System.out.println("FastJson解析结果【字符串】：" + " is tree: "
                + node4.getTree().isTree() + "  color:  "
                + node4.getTree().getColor() + "  name: " + node4.getName()
                + " isopen: " + node4.isOpen());

        // util方法构造
        System.out.println("////////////////////////");
        Map<String, Object> map = new HashMap();
        map.put("color", "blue");
        map.put("tree", true);
        StringBuilder builder = new StringBuilder();
        builder.append("{").append(buildJsonParamByStrObject("节点02", "name"))
                .append(",").append(buildJsonParamByStrObject(true, "open"))
                .append(",").append(buildJsonParamByMapObject(map, "tree"))
                .append("}");
        System.out.println("builder " + builder.toString());
        Node node2 = JSON.parseObject(builder.toString(), Node.class);
        System.out.println("FastJson解析结果【util】：" + " is tree: "
                + node2.getTree().isTree() + "  color:  "
                + node2.getTree().getColor() + "  name: " + node2.getName()
                + "  isopen: " + node2.isOpen());
    }

    /**
     *
     * 功能描述: <br>
     * 〈功能详细描述〉 构造key:value 键值对
     */
    public static StringBuilder buildJsonParamByMapObject(Map<String, Object> params,
                                                          String key) {
        StringBuilder builder = new StringBuilder();
        String val = JSON.toJSONString(params);
        builder.append("\"" + key + "\":" + val);
        return builder;
    }

    /**
     *
     * 功能描述: <br>
     * 〈功能详细描述〉 构造key:value 键值对
     */
    public static StringBuilder buildJsonParamByStrObject(Object params, String key) {
        StringBuilder builder = new StringBuilder();
        String val = JSON.toJSONString(params);
        builder.append("\"" + key + "\":" + val);
        return builder;
    }

}
