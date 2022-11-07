package com.api.app.rest.Models;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

//    public User userName( String userName){
////
//        Query query = entityManager.createQuery("select userName from User");
//       String UserName = (String) query.getSingleResult();
//       return null;
//
//    }


}
