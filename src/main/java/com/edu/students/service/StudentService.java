package com.edu.students.service;

import com.edu.students.entity.Student;

import java.util.List;

public interface StudentService {

    public Student getStudent(Long id);

    public List<Student> getStudents();

    public Student addStudent(Student student);

}
