package com.edu.students.controller;

import com.edu.students.dto.StudentDTO;
import com.edu.students.entity.Student;
import com.edu.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/apistudents/v1")
public class StudentController {

    @Autowired
    StudentService studentService;

    //@GetMapping("/students")
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(this.studentService.getStudents());
        //return new ResponseEntity<>(this.studentService.getStudents(), HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.studentService.getStudent(id));
        //return new ResponseEntity<>(this.studentService.getStudent(id), HttpStatus.OK);
    }

    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student) {
        Student studentAdded = this.studentService.addStudent(student);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(HttpHeaders.LOCATION, String.format("/students/%d", studentAdded.getId()));
        return ResponseEntity.created(URI
                .create(String.format("/students/%d", studentAdded.getId())))
                .body(studentAdded);
        //return new ResponseEntity<Student>(studentAdded, responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Object> updateStudent(@PathVariable("id") Long id,
                                                @Valid @RequestBody StudentDTO student) {
        Student studentMod = this.studentService.updateStudent(student, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
