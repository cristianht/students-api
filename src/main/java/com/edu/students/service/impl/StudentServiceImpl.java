package com.edu.students.service.impl;

import com.edu.students.entity.Student;
import com.edu.students.repository.StudentRepository;
import com.edu.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository repository;

    @Override
    public Student getStudent(Long id) {
        Student student = new Student();
        student.setId(id);
        student.setFirstname("Cristian");
        student.setLastname("Tirimacco");
        return student;
    }

    @Override
    public List<Student> getStudents() {
        return null;
    }

    @Override
    public Student addStudent(Student student) {
        Student studentAdded = repository.save(student);
        return studentAdded;
    }
}
