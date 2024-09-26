//package com.fif.repository;
//
//import com.fif.entity.Person;
//import com.fif.entity.PersonLogin;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//import javax.persistence.NoResultException;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//
//@Repository
//public class PersonDao {
//
//    @PersistenceContext
//    private EntityManager em;
//
//    @Transactional(readOnly = true)
//    public PersonLogin get(String username) throws NoResultException {
//        Query query = em.createQuery("SELECT p FROM PersonLogin p WHERE p.username = :username", PersonLogin.class);
//        query.setParameter("username", username);
//        return (PersonLogin) query.getSingleResult();
//    }
//}
