package com.example.demo.Student;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    public StudentDTO convertToDTO(Student student){
        return modelMapper.map(student,StudentDTO.class);
    }
    @PostMapping("/add")
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }
    @GetMapping
    public List<StudentDTO> findAll(){
        return studentService.findAll().stream().map(this::convertToDTO).collect(Collectors.toList()) ;
    }
    @GetMapping("search/{email}")
    public StudentDTO findByEmail(@PathVariable String email) {
        return convertToDTO(studentService.findByEmail(email));
    }
}
