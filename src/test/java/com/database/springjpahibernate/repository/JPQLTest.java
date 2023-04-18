package com.database.springjpahibernate.repository;

import com.database.springjpahibernate.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class JPQLTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    public void jpql_basic(){
        List resultList = em.createQuery("SELECT c FROM Course c").getResultList();
        logger.info("SELECT c FROM Course c -> {}", resultList);
    }

    @Test
    public void jpql_typed(){
        TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("SELECT c FROM Course c -> {}", resultList);
    }

    @Test
    public void jpql_where(){
        TypedQuery<Course> query =
                em.createQuery("SELECT c FROM Course c WHERE name like 'A%'", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("SELECT c FROM Course c WHERE name like '%A' -> {}", resultList);
    }

    @Test
    public void jpql_basic_named_query(){
        List resultList = em.createNamedQuery("query_get_all_courses").getResultList();
        logger.info("SELECT c FROM Course c -> {}", resultList);
    }

    @Test
    public void jpql_typed_named_query(){
        TypedQuery<Course> query = em.createNamedQuery("query_get_all_courses", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("SELECT c FROM Course c -> {}", resultList);
    }

    @Test
    public void jpql_where_named_query(){
        TypedQuery<Course> query =
                em.createNamedQuery("query_get_a_first_char", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("SELECT c FROM Course c WHERE name like '%A' -> {}", resultList);
    }
}
