package com.techexamproject.techexamproject;

public class Account {

    private String firstName;
    private String lastName;
    private String email;
    private String myDate;
    private String gender;

    public Account(String firstName, String lastName, String email, String myDate, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.myDate = myDate;
        this.gender = gender;
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

    public String getMyDate() {
        return myDate;
    }

    public void setMyDate(String myDate) {
        this.myDate = myDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
