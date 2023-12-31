package com.edu.students.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull (message = "firstname no puede ser nulo")
    @NotBlank (message = "firstname no puede ser vacío")
    @Column(length = 30, nullable = false)
    private String firstname;

    @NotNull (message = "lastname no puede ser nulo")
    @NotBlank (message = "lastname no puede ser vacío")
    @Column(length = 30, nullable = false)
    private String lastname;

    @NotNull (message = "email no puede ser nulo")
    @NotBlank (message = "email no puede ser vacío")
    @Column(length = 30, nullable = false)
    private String email;

    @Column(length = 30)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String phone;

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
