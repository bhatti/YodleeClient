package com.plexobject.yodlee.domain;

public class User {
    private String emailAddress;
    private String loginName;
    private String password;
    private String firstName;
    private String lastName;
    private String middleInitial = "";
    private String address1;
    private String address2 = "";
    private String city;
    private String country;

    public User() {

    }

    public User(String emailAddress, String loginName, String password,
            String firstName, String lastName, String middleInitial,
            String address1, String address2, String city, String country) {
        this.emailAddress = emailAddress;
        this.loginName = loginName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.country = country;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "User [loginName=" + loginName + ", password=" + password
                + ", address1=" + address1 + ", address2=" + address2
                + ", city=" + city + ", country=" + country + ", firstName="
                + firstName + ", lastName=" + lastName + ", middleInitial="
                + middleInitial + ", emailAddress=" + emailAddress + "]";
    }
}
