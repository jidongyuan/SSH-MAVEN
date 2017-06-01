
package com.mytest.dao;


import com.mytest.entity.StudentResEntity;
import com.mytest.entity.bean.GoodEntity;
import com.mytest.entity.bean.StudentEntity;
import com.mytest.util.SessionFactoryUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 *
 * @author XHW
 *
 * @date 2011-6-18
 *
 * 封装了对数据库的基本操作
 *
 */
public class HibernateBaseDao {

    private StudentResEntity studentResEntity;

    private GoodEntity goods;

    private Session session;


    /**
     * @param args
     */
    public static void main(String[] args) {
        HibernateBaseDao test = new HibernateBaseDao();
//        test.where();
//        test.update();
//        test.delete();
        test.queryGoods();
    }


    /*查询操作*/
    public void where() {
        studentResEntity = new StudentResEntity();

        session = SessionFactoryUtil.getSession();

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

    public  void queryGoods() {

        goods = new GoodEntity();

        session = SessionFactoryUtil.getSession();

        session.beginTransaction();
        Query query = session
                .createQuery("from GoodEntity ");

        List<GoodEntity> list = query.list();

        System.out.println(list.size());

        for (GoodEntity goodsResEntity : list) {
            System.out.println(String.valueOf(goodsResEntity.getId()) + " " + String.valueOf(goodsResEntity.getGoodName()));
        }

        session.getTransaction().commit();
    }

    /*更新操作*/
    public void update() {

        session = SessionFactoryUtil.getSession();
        session.beginTransaction();
        Query query = session
                .createQuery("update StudentEntity set name=? where id=?");
        query.setString(0, "嵇冬元(修改)");//设置第一个参数的参数值
        query.setInteger(1, 2); //设置id为2
        int rowCount = query.executeUpdate();
        System.out.println(rowCount);
        session.getTransaction().commit();

    }

    /*删除操作*/
    public void delete() {
        session = SessionFactoryUtil.getSession();
        session.beginTransaction();
        Query query = session.createQuery("delete from StudentEntity where id=?");
        query.setInteger(0, 2);
        int rowCount = query.executeUpdate();
        System.out.println(rowCount);
        session.getTransaction().commit();
    }

}