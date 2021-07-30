package com.hmp.JerseyDemoRest.dao;

import com.hmp.JerseyDemoRest.Bean.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class UserDao {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testDB");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    public List<User> getALlUserInfo(){
        Query query = entityManager.createQuery("select a from User a");
        List<User> list = query.getResultList();
        return list;

    }
}
