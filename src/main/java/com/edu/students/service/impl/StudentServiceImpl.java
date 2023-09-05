package com.edu.students.service.impl;

import com.edu.students.dto.StudentDTO;
import com.edu.students.entity.Student;
import com.edu.students.exceptions.BussinessException;
import com.edu.students.repository.StudentRepository;
import com.edu.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository repository;

    @Override
    public Student getStudent(Long id) {
        Optional<Student> student = repository.findById(id);

        if (student.isPresent()) {
            return student.get();
        } else {
            return null;
        }
    }

    @Override
    public List<Student> getStudents() {
        return repository.findAll();
    }

    @Override
    public Student addStudent(Student student) {

        Optional<Student> studentOptional =
                repository.findByEmail(student.getEmail());

        if (studentOptional.isPresent()) {
            throw new BussinessException("El email con el que " +
                    "desea crear el estudiante ya se encuentra en uso");
        } else {
            Student studentAdded = repository.save(student);
            return studentAdded;
        }

    }

    @Override
    public Student updateStudent(StudentDTO studentDTO, Long id) {
        Optional<Student> studentFind = repository.findById(id);

        if (studentFind.isPresent()) {
            studentDTO.setId(studentFind.get().getId());
            return repository.save(studentDTO.toEntity());
        } else {
            throw new BussinessException("El id que quiere modificar no existe");
        }
    }

}
