package com.example.demo;

import java.time.LocalDate;

public class UserBuilder {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dob;

    public UserBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setDob(LocalDate dob) {
        this.dob = dob;
        return this;
    }

    public User createUser() {
        return new User(firstName, lastName, email, dob);
    }
}