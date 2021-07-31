package com.hmp.JerseyDemoRest.service;

import com.hmp.JerseyDemoRest.Bean.User;
import com.hmp.JerseyDemoRest.dao.UserDao;

import java.util.ArrayList;
import java.util.List;

public class UserRepo {
    UserDao dao = new UserDao();
    /*
     *
     * function to get result set from dao class and
     * @return teh result list
     * */
    public List<User> setUserInfo(User u){
        List<User> userList = dao.getALlUserInfo();
        return userList;
    }


}
