package com.example.springbootrestserviceswebclient.controller;

import com.example.springbootrestserviceswebclient.entity.Student;
import com.example.springbootrestserviceswebclient.response.StudentResponse;
import com.example.springbootrestserviceswebclient.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    @Operation(summary = "Get department info by providing studentId",security = @SecurityRequirement(name = "Authorization"), responses =
            {@ApiResponse(content = @Content(schema = @Schema(implementation = Student.class)))})
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully retrieved student by Id"),
            @ApiResponse(responseCode = "400", description = "Student not found") })
    private ResponseEntity<StudentResponse> getStudentDetails(@PathVariable("id") int id){
        StudentResponse student = studentService.getStudentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

}
