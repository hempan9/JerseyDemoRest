package com.hmp.JerseyDemoRest.dao;
import com.hmp.JerseyDemoRest.Bean.User;

import javax.persistence.*;
import java.util.List;
public class UserDao {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testDB");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    public List<User> getALlUserInfo(){
        Query query = entityManager.createQuery("select a from User a");
        List<User> list = query.getResultList();
        return list;

    }
    /*
    * post data into database
    *
    *
    * */
    public void getConnection(User user){
        EntityTransaction et = entityManager.getTransaction();
        et.begin();
        entityManager.persist(user);
        et.commit();
        entityManager.close();
        entityManagerFactory.close();

    }

}
