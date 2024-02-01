package com.salbiyath.deletestudent.controller;

import com.salbiyath.deletestudent.dto.ServiceResponse;
import com.salbiyath.deletestudent.service.StudentService;
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


    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResponse> getStudentById(@PathVariable Integer id ){
        return service.deleteStudent(id);
    }

}
