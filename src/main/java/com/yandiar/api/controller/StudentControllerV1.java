package com.yandiar.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yandiar.api.models.Student;
import com.yandiar.api.service.StudentServiceV1;

import jakarta.servlet.ServletException;

@RestController
@RequestMapping("v1")
public class StudentControllerV1 {
    
    @Autowired
    private StudentServiceV1 studentServiceV1;

    @GetMapping(value = "/student")
    private ResponseEntity<?> getAll(
            ) throws ServletException {
        List<Student> lst = studentServiceV1.getAll();
        return new ResponseEntity<List<Student>>(lst, HttpStatus.OK);
    }

    @PostMapping(value = "/student")
    private ResponseEntity<?> setStudent(
            @RequestBody Student student
            ) throws ServletException {
        List<Student> lst = studentServiceV1.setStudent(student);
        return new ResponseEntity<List<Student>>(lst, HttpStatus.OK);
    }
}
