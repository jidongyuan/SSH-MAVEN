package com.mytest.dao;


import com.mytest.entity.bean.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by JDY on 2016/2/16.
 *
 * 插入数据(用户名、密码)
 */
public class studentTest {

    public static void main(String[] args) {

        StudentEntity st = new StudentEntity();
        st.setName("沈峰");
        st.setPassword("123456");

        Configuration cfg = new Configuration();

        cfg.configure();
        ServiceRegistry serviceRegistry =new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        SessionFactory sf = cfg.configure().buildSessionFactory(serviceRegistry);
        Session session = sf.openSession();
        session.beginTransaction();                    //事务开启
        session.save(st);                            //保存对象
        session.getTransaction().commit();
        session.close();
        sf.close();
    }

}
