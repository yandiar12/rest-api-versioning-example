package com.yandiar.api.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yandiar.api.models.Student;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentServiceV1 {
    
    List<Student> lst = new ArrayList<>( 
        Arrays.asList(
            new Student(1, "Yandi", "Garut"),
            new Student(2, "Opik", "Bandung"),
            new Student(3, "Freddy", "Tanggerang"),
            new Student(4, "Reza", "Depok")
    ));


    public List<Student> getAll() {
        
        log.info("get all student : {}", lst.toString());

        return lst;
    }

    public List<Student> setStudent(Student student) {
        Student s = new Student(
            student.getId(),
            student.getName(),
            student.getAddress()
        );
        lst.add(s);
        return lst;
    }

    public List<Student> deleteStudent(int id) {
        for (int i=0; i<lst.size(); i++) {
            if (lst.get(i).getId() == id) {
                lst.remove(i);
                break;
            }
        }
        return lst;
    }
}
