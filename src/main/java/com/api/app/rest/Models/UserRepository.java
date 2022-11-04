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

    public List<String> getUserNames(){

        Query query = entityManager.createQuery("select userName from User");
        List<String> listWithUserName =  query.getResultList();
         return listWithUserName;
    }


}
