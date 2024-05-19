package com.engeto.hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Guest {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public Guest(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGuestSummary() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d. M. yyyy");
        String formattedBirthDate = formatter.format(birthDate);
        return firstName + " " + lastName + " (" + formattedBirthDate + ")";
    }
}
