package com.example.springbootvalidation.springbootvalidation.entities;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;



public class LoginData {

    @NotBlank(message = "Username cannot be blank")
    private String userName;

    @Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Invalid Email")
    private String email;
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "LoginData [userName=" + userName + ", email=" + email + "]";
    }
    
}
