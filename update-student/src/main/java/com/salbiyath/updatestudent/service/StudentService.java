package com.salbiyath.updatestudent.service;

import com.salbiyath.updatestudent.dto.ServiceResponse;
import com.salbiyath.updatestudent.dto.StudentRequest;
import com.salbiyath.updatestudent.entity.Student;
import com.salbiyath.updatestudent.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

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

            Optional<Student> studentById = repository.findById(Long.valueOf(studentRequest.getId()));

            if (studentById.isEmpty()){
                return ResponseEntity.status(400).body(ServiceResponse.builder()
                        .statusCode("400")
                        .status("Failed")
                        .message("Failed update student, the provided data is invalid")
                        .data(null)
                        .build());
            }

            Student student = studentById.get();
            student.setNis(Long.valueOf(studentRequest.getNis()));
            student.setName(studentRequest.getName());
            student.setAge(studentRequest.getAge());
            student.setGender(studentRequest.getGender());
            student.setUpdatedAt(new Date());

            Student saved = repository.save(student);

            return ResponseEntity.ok().body(ServiceResponse.builder()
                    .statusCode("00")
                    .status("Success")
                    .message("Success update student")
                    .data(saved)
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
