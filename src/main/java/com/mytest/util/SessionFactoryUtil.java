package com.mytest.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by JDY on 2016/2/22.
 *
 * ���������ĳ�ʼ������
 */
public class SessionFactoryUtil {

    public static Session getSession() {
        Configuration cfg = new Configuration();
        cfg.configure();
        ServiceRegistry serviceRegistry =new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        SessionFactory sf = cfg.configure().buildSessionFactory(serviceRegistry);
        Session session = sf.openSession();
        return session;
    }

    public static void main(String[] args) {

    }
}
