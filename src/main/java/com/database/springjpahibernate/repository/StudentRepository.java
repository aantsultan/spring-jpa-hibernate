package com.database.springjpahibernate.repository;

import com.database.springjpahibernate.entity.Passport;
import com.database.springjpahibernate.entity.Student;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StudentRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Student findById(Long id) {
        return em.find(Student.class, id);
    }

    public Student save(Student student) {
        if (student.getId() == null) {
            em.persist(student);
        } else {
            em.merge(student);
        }
        return student;
    }

    public void deleteById(Long id) {
        Student student = findById(id);
        em.remove(student);
    }

    public void saveStudentWithPassport() {
        Passport passport = new Passport("Z123456");
        em.persist(passport);

        Student student = new Student("Elaina");
        student.setPassport(passport);
        em.persist(student);
    }

    public void complexOperation(){
        // in hibernate, persistence context = session

        // Database Operation 1 - Retrieve Student
        Student student = em.find(Student.class, 20001L);
        em.persist(student);
        // persistence context (student)

        // Database Operation 2 - Retrieve Passport
        Passport passport = student.getPassport();
        em.persist(passport);
        // persistence context (student, passport)

        // Database Operation 3 - Update Passport
        passport.setNumber("E123459");
        em.merge(passport);
        // persistence context (student, passport++)

        // Database Operation 4 - Update Student
        student.setName("Aant - Updated");
        em.merge(student);
        // persistence context (student++, passport++)
    }

}
