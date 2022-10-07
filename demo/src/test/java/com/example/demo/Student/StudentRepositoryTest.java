package com.example.demo.Student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {
    @Autowired
    public StudentRepository underTest;
    @Test
    void findByEmail() {
        String email = "dev@gmail.com";
        Student student = new Student(2,"dev", "dev@gmail.com", LocalDate.of(1995,8,15),27);
        underTest.save(student);
        assertThat(underTest.findByEmail(email)).isNotNull();
    }

    @Test
    void existsByEmail() {
        String email = "dev@gmail.com";
        Student student = new Student("dev", "dev@gmail.com", LocalDate.of(1995,8,15));
        underTest.save(student);
        assertThat(underTest.existsByEmail(email)).isTrue();
    }
}