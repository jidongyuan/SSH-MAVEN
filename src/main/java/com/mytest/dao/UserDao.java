package com.mytest.dao;

import com.mytest.entity.bean.UserEntity;
import com.mytest.entity.request.RegisterReqEntity;
import com.mytest.util.SessionFactoryUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;

/**
 * Created by Administrator on 2016/6/30 0030.
 *
 *
 *
 */
public class UserDao {

    private SessionFactoryUtil sessionFactoryUtil;

    public static void main(String[] args) {
        /*RegisterReqEntity registerReqEntity = new RegisterReqEntity();
        registerReqEntity.setName("liuyifei");
        registerReqEntity.setPassword("123456");
        UserDao userDao = new UserDao();
        userDao.register(registerReqEntity);*/
    }


    /*用户登录*/
    public String login(String username,String password) {
        Configuration cfg = new Configuration();
        cfg.configure();
        ServiceRegistry serviceRegistry =new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        SessionFactory sf = cfg.configure().buildSessionFactory(serviceRegistry);
        Session session = sf.openSession();
        session.beginTransaction();
        Query query = session
                .createQuery("select name,password from UserEntity where name = '" + username + "'");
        List<Object[]> list = query.list();
        if(list.size() == 0){
            System.out.println("您还未注册！");
            return "-1";
        }
        for(Object[] object : list){
            String name = (String)object[0];
            String passwd = (String)object[1];
            if(password != passwd){
                System.out.println("密码不正确！");
                return "-2";
            }
            System.out.println(name + " : " + passwd);
        }
        session.getTransaction().commit();

        return "1";

    }

    /*用户注册*/
    public String register(RegisterReqEntity registerReqEntity){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(registerReqEntity.getName());
        userEntity.setPassword(registerReqEntity.getPassword());
        sessionFactoryUtil = new SessionFactoryUtil();
        Session session = sessionFactoryUtil.getSession();
        session.beginTransaction();
        Query query = session
                .createQuery("select name from UserEntity where name = '" + registerReqEntity.getName() + "'");
        List<Object[]> list = query.list();
        if(list.size() > 0){
            return "-1";
        }
        try{
            session.save(userEntity);
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e);
        }
        return "1";
    }

}
