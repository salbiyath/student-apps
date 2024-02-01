package com.salbiyath.updatestudent.controller;

import com.salbiyath.updatestudent.dto.ServiceResponse;
import com.salbiyath.updatestudent.dto.StudentRequest;
import com.salbiyath.updatestudent.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    StudentService service;

    @Autowired
    public void setService(StudentService service) {
        this.service = service;
    }

    @PutMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResponse> createStudent(@RequestBody @Valid StudentRequest request){
        return service.createStudent(request);
    }

}
