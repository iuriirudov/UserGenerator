package com.example.demo;

import java.time.LocalDate;
import java.util.UUID;

public class User {

    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final LocalDate dob;

    public User(String firstName, String lastName, String email, LocalDate dob) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDob() {
        return dob;
    }
}
