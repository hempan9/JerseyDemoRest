package com.hmp.JerseyDemoRest.service;

import com.hmp.JerseyDemoRest.Bean.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepo {

    User u = new User();
    User u1 = new User();

    public List<User> setUserInfo(){

        List<User> userList = new ArrayList<>();
                u.setId(1);
        u.setName("Ram");

        u1.setId(2);
        u1.setName("Hari");
        userList.add(u);
        userList.add(u1);
        return userList;
    }


}
