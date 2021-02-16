package com.samgoggin.labourfinder;

public class User {

    private String email;
    private String  password;
    private String fullName;
    private String address;
    private String experience;
    private String number;

    public User() {
    }
    public User(String email, String  password){
        this.email = email;
        this.password = password;
    }

    public User(String email, String password, String fullName, String address, String experience, String number) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.experience = experience;
        this.number = number;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getExperience() {
        return experience;
    }

    public String getNumber() {
        return number;
    }
}
