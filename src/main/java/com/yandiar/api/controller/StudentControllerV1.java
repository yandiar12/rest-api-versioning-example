package com.yandiar.api.controller;

import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yandiar.api.models.Student;
import com.yandiar.api.service.StudentServiceV1;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("v1/student")
@Api(value = "Student API", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Student"})
public class StudentControllerV1 {
    
    @Autowired
    private StudentServiceV1 studentServiceV1;

    @GetMapping
    private ResponseEntity<?> getAll(
            ) throws ServletException {
        List<Student> lst = studentServiceV1.getAll();
        return new ResponseEntity<List<Student>>(lst, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<?> setStudent(
            @RequestBody Student student
            ) throws ServletException {
        List<Student> lst = studentServiceV1.setStudent(student);
        return new ResponseEntity<List<Student>>(lst, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteStudent(
            @PathVariable int id
            ) throws ServletException {
        List<Student> lst = studentServiceV1.deleteStudent(id);
        return new ResponseEntity<List<Student>>(lst, HttpStatus.OK);
    }
}
