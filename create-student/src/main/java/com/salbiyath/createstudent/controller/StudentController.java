package com.salbiyath.createstudent.controller;

import com.salbiyath.createstudent.dto.ServiceResponse;
import com.salbiyath.createstudent.dto.StudentRequest;
import com.salbiyath.createstudent.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    StudentService service;

    @Autowired
    public void setService(StudentService service) {
        this.service = service;
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResponse> createStudent(@RequestBody @Valid StudentRequest request){
        return service.createStudent(request);
    }

}
