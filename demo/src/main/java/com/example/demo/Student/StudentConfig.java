package com.example.demo.Student;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;

@Configuration
@EnableSwagger2
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
       return args -> {
           Student student = new Student("raj", "raj@gmail.com", LocalDate.of(1995,8,15));
           studentRepository.save(student);
       };
    }
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
