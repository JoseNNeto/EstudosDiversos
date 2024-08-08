package com.testemongodb.mongotest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.testemongodb.mongotest.model.Student;
import com.testemongodb.mongotest.repository.StudentRepository;

@RestController
public class MainController {

    @Autowired
    private StudentRepository studentRepository;
    
    @PostMapping("/addStudent")
    public void addStudent(@RequestBody Student student) {
        studentRepository.save(student);
        System.out.println("Student added successfully");
    }
}
