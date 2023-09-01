package com.edu.students.controller;

import com.edu.students.entity.Student;
import com.edu.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apistudents/v1")
public class StudentController {

    @Autowired
    StudentService studentService;

    //@GetMapping("/students")
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String getStudents() {
        return "Devuelvo los estudiantes";
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.studentService.getStudent(id), HttpStatus.OK);
    }

    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return new ResponseEntity<>(this.studentService.addStudent(student), HttpStatus.CREATED);
    }

}
