package com.yandiar.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(path = "/")
public class HelloController {
    
    @GetMapping(value = "/hello")
    private ResponseEntity<?> setVerifikasiNik(
            HttpServletRequest req, HttpServletResponse resp
            ) throws ServletException {
        Map<String, Object> map = new HashMap<>();
        map.put("hello", "world");
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }
}
