package com.mytest.action;

import com.mytest.dao.UserDao;
import com.mytest.entity.reponse.LoginResEntity;
import com.mytest.entity.reponse.RegisterResEntity;
import com.mytest.entity.request.LoginReqEntity;
import com.mytest.entity.request.RegisterReqEntity;

/**
 * Created by JDY on 2016/6/29 0029.
 *
 *
 */
public class UserAction {

    private LoginReqEntity loginReqEntity;

    private LoginResEntity loginResEntity;

    private RegisterReqEntity registerReqEntity;

    private RegisterResEntity registerResEntity;

    private UserDao userDao;


    public static void main(String[] args) {
       /* LoginReqEntity loginReqEntity = new LoginReqEntity();
        loginReqEntity.setName("jdy");
        loginReqEntity.setPassword("123");
        UserAction userAction = new UserAction();
        userAction.login(loginReqEntity.getName(),loginReqEntity.getPassword());*/
    }

    public String login(){
        loginResEntity = new LoginResEntity();

        userDao = new UserDao();
        String response = userDao.login(loginReqEntity.getName(), loginReqEntity.getPassword());
        if(response.equals("-2")){
            loginResEntity.setCode("-2");
            loginResEntity.setMessage("密码不正确！");
            return "success";
        }

        if(response.equals("-1")){
            loginResEntity.setCode("-1");
            loginResEntity.setMessage("你还未注册！");
            return "success";
        }

        if(response.equals("1")){
            loginResEntity.setCode("1");
            loginResEntity.setMessage("登录成功！");
            return "success";
        }

        return "success";
    }

    /*用户注册*/
    public String register(){
        registerResEntity = new RegisterResEntity();
        userDao = new UserDao();
        String response = userDao.register(registerReqEntity);
        System.out.println(response);
        if(response == "-1"){
            registerResEntity.setCode("-1");
            registerResEntity.setMessage("用户已存在！");
            return "success";
        }
        if(response == "1"){
            registerResEntity.setCode("1");
            registerResEntity.setMessage("注册成功！");
            return "success";
        }
        return "success";
    }

    public LoginReqEntity getLoginReqEntity() {
        return loginReqEntity;
    }

    public void setLoginReqEntity(LoginReqEntity loginReqEntity) {
        this.loginReqEntity = loginReqEntity;
    }

    public LoginResEntity getLoginResEntity() {
        return loginResEntity;
    }

    public void setLoginResEntity(LoginResEntity loginResEntity) {
        this.loginResEntity = loginResEntity;
    }

    public RegisterReqEntity getRegisterReqEntity() {
        return registerReqEntity;
    }

    public void setRegisterReqEntity(RegisterReqEntity registerReqEntity) {
        this.registerReqEntity = registerReqEntity;
    }

    public RegisterResEntity getRegisterResEntity() {
        return registerResEntity;
    }

    public void setRegisterResEntity(RegisterResEntity registerResEntity) {
        this.registerResEntity = registerResEntity;
    }
}
