package com.samgoggin.labourfinder;

public class Company {


    private String email;
    private String password;
    private String companyName;
    private String address;
    private String ManagerName;
    private String number;

    public Company() {

    }

    public Company(String email, String password) {
         this.email = email;
         this.password = password;
    }

    public Company(String email, String password, String companyName, String address, String managerName, String number) {
        this.email = email;
        this.password = password;
        this.companyName = companyName;
        this.address = address;
        ManagerName = managerName;
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAddress() {
        return address;
    }

    public String getManagerName() {
        return ManagerName;
    }

    public String getNumber() {
        return number;
    }
}
