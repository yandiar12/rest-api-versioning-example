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

import com.yandiar.api.models.StudentV2;
import com.yandiar.api.service.StudentServiceV2;

import jakarta.servlet.ServletException;

@RestController
@RequestMapping("v2/student")
public class StudentControllerV2 {
    
    @Autowired
    private StudentServiceV2 studentServiceV2;

    @GetMapping
    private ResponseEntity<?> getAll(
            ) throws ServletException {
        List<StudentV2> lst = studentServiceV2.getAll();
        return new ResponseEntity<List<StudentV2>>(lst, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<?> setStudent(
            @RequestBody StudentV2 student
            ) throws ServletException {
        List<StudentV2> lst = studentServiceV2.setStudent(student);
        return new ResponseEntity<List<StudentV2>>(lst, HttpStatus.OK);
    }
}
