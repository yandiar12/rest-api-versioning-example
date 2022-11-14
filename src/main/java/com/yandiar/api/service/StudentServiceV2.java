package com.yandiar.api.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yandiar.api.models.StudentV2;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentServiceV2 {
    List<StudentV2> lst = new ArrayList<>( 
        Arrays.asList(
            new StudentV2(1, "Yandi", "Garut", "Male"),
            new StudentV2(2, "Opik", "Bandung", "Male"),
            new StudentV2(3, "Freddy", "Tanggerang", "Male"),
            new StudentV2(4, "Reza", "Depok", "Male")
    ));


    public List<StudentV2> getAll() {
        
        log.info("get all student : {}", lst.toString());

        return lst;
    }

    public List<StudentV2> setStudent(StudentV2 student) {
        StudentV2 s = new StudentV2(
            student.getId(),
            student.getName(),
            student.getAddress(),
            student.getGender()
        );
        lst.add(s);
        return lst;
    }
}
