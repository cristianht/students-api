package com.edu.students.dto;

import com.edu.students.entity.Student;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Component
public class StudentDTO {

    private Long id;

    @NotNull (message = "firstname no puede ser nulo")
    @NotBlank(message = "firstname no puede ser vacío")
    private String firstname;

    @NotNull
    private String lastname;

    @NotNull
    private String email;
    private String phone;

    public Student toEntity() {
        Student entity = new Student();

        entity.setId(this.id);
        entity.setFirstname(this.firstname);
        entity.setLastname(this.lastname);
        entity.setEmail(this.email);
        entity.setPhone(this.phone);

        return entity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
