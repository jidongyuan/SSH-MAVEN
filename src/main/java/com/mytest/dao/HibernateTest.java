///**
//*
//*/
//package com.mytest.dao;
//
//import java.util.List;
//
//import com.mytest.entity.StudentResEntity;
//import com.mytest.util.sessionFactoryUtil;
//
//
//import org.hibernate.*;
//
///**
//*
//* @author XHW
//*
//* @date 2011-6-18
//*
//*/
//public class HibernateTest {
//
//    private sessionFactoryUtil sessionFactoryUtil  ;
//
//    private StudentResEntity studentResEntity;
//
//    public HibernateTest() {
//
//    }
//
//    /**
//     * @param args
//     */
//    public static void main(String[] args) {
//        HibernateTest test = new HibernateTest();
//        test.where();
////        test.function();
////        test.update();
////        test.jiaoChaCheck();
////        test.innerJoin();
////        test.QBC();
////        test.leftOuterJoin();
////        test.rightOuterJoin();
//    }
//
//
//    public void where() {
//
//        studentResEntity = new StudentResEntity();
//
//        sessionFactoryUtil = new sessionFactoryUtil();
//        // 使用where查询
//        Session session = sessionFactoryUtil.getSessionFactory()
//                .openSession();
//        session.beginTransaction();
//        Query query = session
//                .createQuery("from student where id = 2");
//        List<studentResEntity> list = query.list();
//
//        for ( StudentResEntity studentResEntity : list) {
//            System.out.println(studentResEntity.getId() + studentResEntity.getName());
//        }
//        // 投影查询 中使用where子句
////        query = session.createQuery("select username from User where id=2");
////        List<String> listname = query.list();
////
////        for (String name : listname) {
////            System.out.println(name);
////        }
////        // in查询
////        query = session
////                .createQuery("from User where username in ('Hongten','Hanyuan','dfgd')");
////        List<User> listin = query.list();
////
////        for (User user : listin) {
////            System.out.println(user.getId() + user.getUsername());
////        }
////        // like查询
////        query = session.createQuery("from User where username not like 'Hon%'");
////        List<User> listlike = query.list();
////
////        for (User user : listlike) {
////            System.out.println(user.getId() + user.getUsername());
////        }
////        // null查询
////        query = session.createQuery("from User where password is null");
////        List<User> listnull = query.list();
////
////        for (User user : listnull) {
////            System.out.println(user.getId() + user.getUsername());
////        }
////        // and查询
////        query = session
////                .createQuery("from User where password is not null and id<5");
////        List<User> listand = query.list();
////
////        for (User user : listand) {
////            System.out.println(user.getId() + user.getUsername()
////                    + user.getPassword());
////        }
////        // order by
////        query = session.createQuery("from User order by username,id desc");
////
////        List<User> listorderby = query.list();
////
////        for (User user : listorderby) {
////            System.out.println(user.getId() + user.getUsername());
////        }
////        // 使用"?"号 作为参数占位符，一条HQL语句中可以使用多个？
////        // query.setInteger(0,2)
////        // query.setString(0,"Hongten")
////        query = session
////                .createQuery("select username from User where username=?");
////        query.setString(0, "Hongten");
////        List<String> listwenhao = query.list();
////        for (String name : listwenhao) {
////            System.out.println(name);
////        }
//
//        session.getTransaction().commit();
//
//    }
//
////    public void function() {// 把大写字母转化为小写字母
////        // 作用可以用在：比如在一个用户注册的程序中，大小写不容易区分，但是全部转化为小写后就可以很容易进行比较
////        Session session = HibernateSessionFactoryUtil.getSessionFactory()
////                .openSession();
////        session.beginTransaction();
////        // 输出原始的数据
////        Query query = session.createQuery("select username from User");
////        List<String> list = query.list();
////
////        for (String name : list) {
////            System.out.println(name);
////        }
////        System.out.println("-------------------------------------------");
////        // 输出的数据全部转化为小写
////        query = session.createQuery("select lower(username) from User");
////        List<String> listChange = query.list();
////
////        for (String name : listChange) {
////            System.out.println(name);
////        }
////        session.getTransaction().commit();
////    }
////
////    public void update() {
////        Session session = HibernateSessionFactoryUtil.getSessionFactory()
////                .openSession();
////        session.beginTransaction();
////        Query query = session
////                .createQuery("update User set username='洪伟1231' where id=?");
////        query.setInteger(0, 3);
////        int rowCount = query.executeUpdate();
////        System.out.println(rowCount);
////        session.getTransaction().commit();
////    }
////
////    public void operateProfile() {// 对profile这个类执行HQL语句操作
////        Session session = HibernateSessionFactoryUtil.getSessionFactory()
////                .openSession();
////        session.beginTransaction();
////        // 执行查询操作
////        Query query = session.createQuery("from Profile");
////        List<Profile> list = query.list();
////        for (Profile profile : list) {
////            System.out.println(profile.getId() + profile.getEmail()
////                    + profile.getAddress() + profile.getMobile()
////                    + profile.getPostcode());
////        }
////        // 执行删除操作
//        query = session.createQuery("delete from Profile where id=?");
//        query.setInteger(0, 3);
//        int rowCount = query.executeUpdate();
//        System.out.println(rowCount);
//        session.getTransaction().commit();
////    }
////
////    public void jiaoChaCheck() {//交叉查询
////        //这种方法查询出来的结果是笛卡尔积，对于我们开发中没有多大用处
////        Session session = HibernateSessionFactoryUtil.getSessionFactory()
////                .openSession();
////        session.beginTransaction();
////        Query query=session.createQuery("from User,Profile");
////
////        List<Object[]> list=query.list();
////
////        for(Object[] values:list){
////            User user=(User)values[0];
////            System.out.print("ID :"+user.getId()+",UserName:"+user.getUsername()+",Password:"+user.getPassword());
////            Profile profile=(Profile)values[1];
////            System.out.println(profile.getEmail()+profile.getMobile()+profile.getAddress()+profile.getPostcode());
////        }
////
////        session.getTransaction().commit();
////    }
////
////    public void innerJoin(){//内连接查询
////        /**
////         * 下面三种hql语句都是可以得到相同的结果
////         * String hql="select p from Profile as p inner join p.user";
////         * 在下面的hql语句中加入"fetch"后，此hql语句变为了"迫切HQL"语句，这样的查询效率要比上面的hql语句要高
////         * String hql="select p from Profile as p inner join fetch p.user";
////         *
////         * String hql="select p from Profile p,User u where p.user=u";
////         * String hql="select p from Profile p,User u where p.user.id=u.id";
////         *
////         */
////        Session session = HibernateSessionFactoryUtil.getSessionFactory()
////                .openSession();
////        session.beginTransaction();
////        String hql="select p from Profile as p inner join fetch p.user";
////        //String hql="select p from Profile p,User u where p.user=u";
////        //String hql="select p from Profile p,User u where p.user.id=u.id";
////        Query query=session.createQuery(hql);
////        List<Profile> list=query.list();
////        for(Profile p:list){
////            System.out.println("ID:"+p.getUser().getId()+"   Username: "+p.getUser().getUsername()+"   Email: "+p.getEmail()+",   Address: "+p.getAddress());
////        }
////        session.getTransaction().commit();
////    }
////
////    public void QBC(){//QBC中实现内连接查询
////        Session session=HibernateSessionFactoryUtil.getSessionFactory().openSession();
////        session.beginTransaction();
////        Criteria criteria=session.createCriteria(Profile.class).createCriteria("user");
////        List<Profile> list=criteria.list();
////
////        for(Profile p:list){
////            System.out.println("ID:"+p.getUser().getId()+"   Username: "+p.getUser().getUsername()+"   Email: "+p.getEmail()+",   Address: "+p.getAddress());
////        }
////        //QBC中实现外连接
////        System.out.println("##################################################");
////        criteria=session.createCriteria(Profile.class).setFetchMode("user", FetchMode.JOIN);
////        List<Profile> listp=criteria.list();
////
////        for(Profile p:list){
////            System.out.println("ID:"+p.getUser().getId()+"   Username: "+p.getUser().getUsername()+"   Email: "+p.getEmail()+",   Address: "+p.getAddress());
////        }
////        session.getTransaction().commit();
////    }
////
////    public void leftOuterJoin(){//左外连接
////        /**
////         * String hql="select p from Profile p left outer join p.user order by p.user.id";
////         * 在下面的hql语句中加入"fetch"后，此hql语句变为了"迫切HQL"语句，这样的查询效率要比上面的hql语句要高
////         * String hql="select p from Profile p left outer join fetch p.user order by p.user.id";
////         *
////         * String hqlu="select u from User u left outer join u.profiles";
////         *  在下面的hql语句中加入"fetch"后，此hql语句变为了"迫切HQL"语句，这样的查询效率要比上面的hql语句要高
////         * String hqlu="select u from User u left outer join fetch u.profiles";
////         */
////        Session session=HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
////        session.beginTransaction();
////        String hql="select p from Profile p left outer join fetch p.user order by p.user.id";
////        Query query=session.createQuery(hql);
////
////        List<Profile> list=query.list();
////        for(Profile p:list){
////            System.out.println("ID:"+p.getUser().getId()+"   Username: "+p.getUser().getUsername()+"   Email: "+p.getEmail()+",   Address: "+p.getAddress());
////        }
////
////        System.out.println("-------------------------------------");
////        String hqlu="select u from User u left outer join fetch u.profiles";
////        query=session.createQuery(hqlu);
////
////        List<User> listu=query.list();
////        for(User u:listu){
////            System.out.println(u.getId()+u.getUsername()+u.getProfiles());
////        }
////        session.getTransaction().commit();
////
////    }
////
////    public void rightOuterJoin(){//右外连接
////        Session session=HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
////        session.beginTransaction();
////        String hql="select u from User u right outer join u.profiles order by u.id";
////        Query query=session.createQuery(hql);
////
////        List<User> listu=query.list();
////        for(User user:listu){
////            System.out.println(user.getId()+user.getUsername()+user.getProfiles());
////        }
////
////        session.getTransaction().commit();
////
////    }
//
//}