package com.salbiyath.getstudent.service;

import com.salbiyath.getstudent.dto.ServiceResponse;
import com.salbiyath.getstudent.entity.Student;
import com.salbiyath.getstudent.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class StudentService {

    StudentRepository repository;

    @Autowired
    public void setRepository(StudentRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<ServiceResponse> getAllStudent(Integer pageNumber, Integer pageSize, String sort) {
        try {
            Pageable pageable = null;
            if (sort != null) {
                pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, sort);
            } else {
                pageable = PageRequest.of(pageNumber, pageSize);
            }
            Page<Student> all = repository.findAll(pageable);

            return ResponseEntity.ok(ServiceResponse.builder()
                    .status("Success")
                    .statusCode("00")
                    .message("Success get student")
                    .data(all)
                    .build());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.ok().body(ServiceResponse.builder()
                    .statusCode("01")
                    .status("Failed")
                    .message("Failed update student, please try again later!")
                    .build());
        }
    }

    public ResponseEntity<ServiceResponse> getStudentById(Integer id){
        try {

            Optional<Student> studentById = repository.findById(Long.valueOf(id));

            return studentById.map(student -> ResponseEntity.ok().body(ServiceResponse.builder()
                    .statusCode("00")
                    .status("Success")
                    .message("Success get student")
                    .data(student)
                    .build())).orElseGet(() -> ResponseEntity.status(400).body(ServiceResponse.builder()
                    .statusCode("400")
                    .status("Failed")
                    .message("Failed get student, the provided id is invalid")
                    .data(null)
                    .build()));

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.ok().body(ServiceResponse.builder()
                    .statusCode("01")
                    .status("Failed")
                    .message("Failed update student, please try again later!")
                    .build());
        }
    }


}
