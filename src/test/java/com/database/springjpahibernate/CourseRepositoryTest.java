package com.database.springjpahibernate;

import com.database.springjpahibernate.entity.Course;
import com.database.springjpahibernate.repository.CourseRepository;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
public class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository repository;

    @Test
    public void findById_basic(){
        Course course = repository.findById(10001L);
        assertEquals("Aant", course.getName());
    }

    @Test
    @DirtiesContext // springboot automatic reset data after delete
    public void deleteById_basic(){
        repository.deleteById(10002L);
        assertNull(repository.findById(10002L));
    }

    @Test
    @DirtiesContext // springboot automatic reset data after delete
    public void save_basic(){
        // get a course
        Course course = repository.findById(10001L);
        assertEquals("Aant", course.getName());

        //update details
        course.setName("Aant Cool");
        repository.save(course);

        Course course1 = repository.findById(10001L);
        assertEquals("Aant Cool", course1.getName());
    }

    @Test
    @DirtiesContext // springboot automatic reset data after delete
    public void playWithEntityManager(){
        repository.playWithEntityManager();
    }

}
