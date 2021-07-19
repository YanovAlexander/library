package com.library.model.entity;

import com.library.dto.enums.UserRole;
import com.library.dto.enums.UserStatus;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotEmpty
    @Column(name = "first_name")
    private String firstName;
    @NotEmpty
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    @NotEmpty
    private String email;
    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    @Column(name = "user_status")
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
    @NotEmpty
    @Column(name = "password")
    private String password;

    public User(int id, String firstName, String lastName, String email, UserRole userRole, UserStatus userStatus, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userRole = userRole;
        this.userStatus = userStatus;
        this.password = password;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
