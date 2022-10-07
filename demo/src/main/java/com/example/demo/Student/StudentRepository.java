package com.example.demo.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{
    @Query("select s from Student s where s.email = ?1")
    Student findByEmail(String email);
    @Query("select case when count(s)>0 then true else false end from Student s where s.email=?1")
    boolean existsByEmail(String email);
}
