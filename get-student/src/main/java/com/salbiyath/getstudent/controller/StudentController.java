package com.salbiyath.getstudent.controller;

import com.salbiyath.getstudent.dto.ServiceResponse;
import com.salbiyath.getstudent.service.StudentService;
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


    @GetMapping("/getAll/{pageNumber}/{pageSize}")
    public ResponseEntity<ServiceResponse> getAllStudent(
            @PathVariable("pageNumber") Integer pageNumber,
            @PathVariable("pageSize") Integer pageSize){
        return service.getAllStudent(pageNumber, pageSize, null);
    }

    @GetMapping("/getAll/{pageNumber}/{pageSize}/{sort}")
    public ResponseEntity<ServiceResponse> getAllStudent(
            @PathVariable("pageNumber") Integer pageNumber,
            @PathVariable("pageSize") Integer pageSize,
            @PathVariable("sort") String sort){
        return service.getAllStudent(pageNumber, pageSize, sort);
    }

    @GetMapping(value = "getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResponse> getStudentById(@PathVariable Integer id ){
        return service.getStudentById(id);
    }

}
