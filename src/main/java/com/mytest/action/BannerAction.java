package com.mytest.action;

import com.mytest.entity.bean.BannerEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;

/**
 * Created by Administrator on 2016-08-08.
 *
 * ��ȡbanner����
 *
 */
public class BannerAction {

    private List<BannerEntity> list;

    public String getBannerData(){
        Configuration cfg = new Configuration();
        cfg.configure();
        ServiceRegistry serviceRegistry =new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        SessionFactory sf = cfg.configure().buildSessionFactory(serviceRegistry);
        Session session = sf.openSession();
        session.beginTransaction();
        Query query = session
                .createQuery("from BannerEntity ");

        list = query.list();

        System.out.println(list.get(0));

        for (BannerEntity bannerEntity : list) {
            System.out.println(String.valueOf(String.valueOf(bannerEntity.getImgUrl())));
        }

        session.getTransaction().commit();

        return "success";

    }

    public List<BannerEntity> getList() {
        return list;
    }

    public void setList(List<BannerEntity> list) {
        this.list = list;
    }
}
