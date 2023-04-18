package com.database.springjpahibernate.repository;

import com.database.springjpahibernate.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class NativeQueryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    public void native_query_basic() {
        List resultList = em.createNativeQuery("SELECT * FROM COURSE", Course.class).getResultList();
        logger.info("SELECT * FROM COURSE -> {}", resultList);
    }

    @Test
    public void native_query_with_parameter() {
        Query query = em.createNativeQuery("SELECT * FROM COURSE WHERE id = ?", Course.class);
        query.setParameter(1, 10001L);
        List<Course> resultList = query.getResultList();
        logger.info("SELECT * FROM COURSE WHERE id = ? -> {}", resultList);
    }

    @Test
    public void native_query_with_named_parameter() {
        Query query = em.createNativeQuery("SELECT * FROM COURSE WHERE id = :id", Course.class);
        query.setParameter("id", 10001L);
        List<Course> resultList = query.getResultList();
        logger.info("SELECT * FROM COURSE WHERE id = :id -> {}", resultList);
    }

    @Test
    @Transactional
    public void native_query_with_update() {
        Query query = em.createNativeQuery("UPDATE COURSE SET last_updated_date=CURRENT_TIMESTAMP()", Course.class);
        int noOfRowsUpdated = query.executeUpdate();
        logger.info("noOfRowsUpdated -> {}", noOfRowsUpdated);
    }
}
