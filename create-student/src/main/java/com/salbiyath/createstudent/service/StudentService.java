package com.salbiyath.createstudent.service;

import com.salbiyath.createstudent.dto.ServiceResponse;
import com.salbiyath.createstudent.dto.StudentRequest;
import com.salbiyath.createstudent.entity.Student;
import com.salbiyath.createstudent.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class StudentService {

    StudentRepository repository;

    @Autowired
    public void setRepository(StudentRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<ServiceResponse> createStudent(StudentRequest studentRequest){
        try {

            Student student = Student.builder()
                    .nis(studentRequest.getNis())
                    .name(studentRequest.getName())
                    .age(studentRequest.getAge())
                    .gender(studentRequest.getGender())
                    .createdAt(new Date())
                    .updatedAt(new Date())
                    .build();

            Student saved = repository.save(student);

            return ResponseEntity.ok().body(ServiceResponse.builder()
                    .statusCode("00")
                    .status("Success")
                    .message("Success create student")
                    .data(saved)
                    .build());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.ok().body(ServiceResponse.builder()
                    .statusCode("01")
                    .status("Failed")
                    .message("Failed create student, please try again later!")
                    .build());
        }
    }


}
