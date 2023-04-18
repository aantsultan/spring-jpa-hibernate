package com.database.springjpahibernate.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@NamedQueries(
    value = {
            @NamedQuery(name = "query_get_all_courses", query = "SELECT c FROM Course c"),
            @NamedQuery(name = "query_get_a_first_char", query = "SELECT c FROM Course c WHERE name like 'A%'")
    }
)
public class Course {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp
    private LocalDateTime createdDate;

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Course[%s]", name);
    }
}
