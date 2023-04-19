package com.database.springjpahibernate.repository;

import com.database.springjpahibernate.entity.Student;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository repository;

    @Autowired
    EntityManager em;

    @Test
    public void retrieveStudentAndPassportDetails(){
        Student student = em.find(Student.class, 20001L);
        logger.info("student -> {}", student);
        logger.info("student passport -> {}", student.getPassport());
    }

    @Test
    public void findById_basic() {
        Student student = repository.findById(20001L);
        assertEquals("Aant", student.getName());
    }

}
