package com.example.springbootrestserviceswebclient.service;

import com.example.springbootrestserviceswebclient.entity.Student;
import com.example.springbootrestserviceswebclient.repository.StudentRepo;
import com.example.springbootrestserviceswebclient.response.DepartmentResponse;
import com.example.springbootrestserviceswebclient.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private WebClient webClient;

    public StudentResponse getStudentById(int id){

        Optional<Student> student = studentRepo.findById(id);
        StudentResponse studentResponse = mapper.map(student, StudentResponse.class);

        //Using WebClient
        DepartmentResponse departmentResponse = webClient.get().uri("/department/" + id).retrieve().bodyToMono(DepartmentResponse.class).block();
        studentResponse.setDepartmentResponse(departmentResponse);

        return studentResponse;
    }

}
