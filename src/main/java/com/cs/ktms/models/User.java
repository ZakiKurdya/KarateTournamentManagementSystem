package com.cs.ktms.models;

public class User {

    private String email;
    private String gender;
    private String lastname;
    private String firstname;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return "User, Email: " + email + ", Gender: " + gender + ", Name: " + firstname + " " + lastname + ".";
    }
}
// Zaki Kurdya