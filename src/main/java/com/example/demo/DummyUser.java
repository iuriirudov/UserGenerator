package com.example.demo;

import java.time.LocalDate;
import java.util.Random;

public class DummyUser {

    private final String[] firstNames = {
            "John",
            "Samantha",
            "George",
            "Eric",
            "Sean",
            "Chris",
            "Danny",
            "Robert",
            "David"
    };

    private final String[] lastNames = {
            "Johnson",
            "Samson",
            "Clinton",
            "Enkel",
            "Simpson",
            "Cole",
            "Daniels",
            "Robertson",
            "Davidson"
    };

    private final String[] domains = { "mail.com", "hotmail.com", "gmail.com", "yahoo.com" };

    private String randomize(String[] value) {
        return value[new Random().nextInt(value.length)];
    }

    private String createEmail(String firstName, String lastName) {
        return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + randomize(domains);
    }

    private LocalDate createDob() {
        int startYear = LocalDate.now().getYear() - 67;
        int endYear = LocalDate.now().getYear() - 18;

        int year = new Random().nextInt(startYear, endYear);
        int month = new Random().nextInt(1,13);
        int day = new Random().nextInt(1, 29);

        return LocalDate.of(year, month, day);
    }

    public User createDummyUser() {
        String firstName = randomize(firstNames);
        String lastName = randomize(lastNames);

        return new UserBuilder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(createEmail(firstName, lastName))
                .setDob(createDob())
                .createUser();
    }

}
