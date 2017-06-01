
package com.mytest.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.mytest.entity.StudentResEntity;
import com.mytest.entity.bean.GoodEntity;
import com.mytest.entity.bean.StudentEntity;
import org.apache.struts2.ServletActionContext;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author XHW
 *
 * @date 2011-6-18
 *
 * 查询表中所有记录
 *
 */

public class test {

    private StudentResEntity studentResEntity;

    private GoodEntity goodEntity;

    private List<GoodEntity> list;

    /**
     * @param args
     */
    public static void main(String[] args) {
//        test test = new test();
//        test.getAllFruit();
    }


    public void where() {

        studentResEntity = new StudentResEntity();

        // 使用where查询
        Configuration cfg = new Configuration();

        cfg.configure();
        ServiceRegistry serviceRegistry =new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        SessionFactory sf = cfg.configure().buildSessionFactory(serviceRegistry);
        Session session = sf.openSession();
        session.beginTransaction();
        Query query = session
                .createQuery("from StudentEntity");

        List<StudentEntity> list = query.list();

        System.out.println(list.size());

        for (StudentEntity studentResEntity : list) {
            System.out.println(String.valueOf(studentResEntity.getId()) + " " + String.valueOf(studentResEntity.getName()));
        }

        session.getTransaction().commit();


    }

    /*查询表中所有的水果*/
    public String getAllFruit() {

        goodEntity = new GoodEntity();

        // 使用where查询
        Configuration cfg = new Configuration();

        cfg.configure();
        ServiceRegistry serviceRegistry =new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        SessionFactory sf = cfg.configure().buildSessionFactory(serviceRegistry);
        Session session = sf.openSession();
        session.beginTransaction();
        Query query = session
                .createQuery("from GoodEntity ");

        list = query.list();

        System.out.println(list.size());

        for (GoodEntity goodEntity : list) {
            System.out.println(String.valueOf(goodEntity.getId()) + " " + String.valueOf(goodEntity.getGoodName()));
        }

        session.getTransaction().commit();

        return "success";

    }

    public List<GoodEntity> getList() {
        return list;
    }

    public void setList(List<GoodEntity> list) {
        this.list = list;
    }
}