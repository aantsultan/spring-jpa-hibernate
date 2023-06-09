package com.database.springjpahibernate;

import com.database.springjpahibernate.entity.Course;
import com.database.springjpahibernate.repository.CourseRepository;
import com.database.springjpahibernate.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaHibernateApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository repository;

	@Autowired
	private StudentRepository studentRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		repository.playWithEntityManager();
//		repository.playWithEntityManager2();
//		repository.playWithEntityManager3();

//		studentRepository.saveStudentWithPassport();
		studentRepository.complexOperation();
	}

}
