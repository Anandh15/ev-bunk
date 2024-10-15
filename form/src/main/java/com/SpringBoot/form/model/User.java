package com.SpringBoot.form.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_data")  
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    @Column(name="Id", length=50)
    private Integer id;
    
    @Column(name="FirstName", nullable=false, length=255)
    private String firstname;
    
    @Column(name="LastName", nullable=false, length=255)
    private String lastname;
    
    @Column(name="Email", nullable=false, unique=true, length=255)
    private String email;
    
    @Column(name="Password", nullable=false, length=255)
    private String password;
    
    @Column(name="Role", nullable=false)
    private String role;
    
    public User() {
    }

    public User(int id, String firstname, String lastname, String email, String password, String role) {
        super();
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
                + ", password=" + password + ", role=" + role + "]";
    }
}
