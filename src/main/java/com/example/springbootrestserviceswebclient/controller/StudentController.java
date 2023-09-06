package com.example.springbootrestserviceswebclient.controller;

import com.example.springbootrestserviceswebclient.response.StudentResponse;
import com.example.springbootrestserviceswebclient.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student/{id}")
    private ResponseEntity<StudentResponse> getStudentDetails(@PathVariable("id") int id){
        StudentResponse student = studentService.getStudentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

}
