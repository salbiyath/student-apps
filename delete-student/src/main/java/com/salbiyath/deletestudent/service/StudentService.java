package com.salbiyath.deletestudent.service;

import com.salbiyath.deletestudent.dto.ServiceResponse;
import com.salbiyath.deletestudent.entity.Student;
import com.salbiyath.deletestudent.repository.StudentRepository;
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


    public ResponseEntity<ServiceResponse> deleteStudent(Integer id){
        try {

            Optional<Student> studentById = repository.findById(Long.valueOf(id));

            if (studentById.isEmpty()){
                return ResponseEntity.status(400).body(ServiceResponse.builder()
                        .statusCode("400")
                        .status("Failed")
                        .message("Failed get student, the provided id is invalid")
                        .data(null)
                        .build());
            }

            repository.deleteById(Long.valueOf(id));

            return ResponseEntity.ok().body(ServiceResponse.builder()
                    .statusCode("00")
                    .status("Success")
                    .message("Success delete student")
                    .data(studentById)
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


}
