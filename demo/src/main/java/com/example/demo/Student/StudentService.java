package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    public final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student) {
        if(studentRepository.existsByEmail(student.getEmail())){
            throw new IllegalArgumentException("email is already used ");
        }
        studentRepository.save(student);
    }
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
    public Student findByEmail(String email) {
       return studentRepository.findByEmail(email);
    }
}
