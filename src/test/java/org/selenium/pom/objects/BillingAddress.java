package org.selenium.pom.objects;

public class BillingAddress {
    private String firstName;
    private String lastName;
    private String billingCompany;
    private String country;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String email;

    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // Here we create the constructor for defining the parameters here instead the test class
    public BillingAddress(String firstName, String lastName, String billingCompany, String country, String streetAddress, String city, String state, String zipCode, String phoneNumber, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.billingCompany = billingCompany;
        //this.country = country;
        this.streetAddress = streetAddress;
        this.city = city;
       // this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    public BillingAddress() {}

    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public String getFirstName() {
        return firstName;
    }
    public BillingAddress setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    public String getLastName() {
        return lastName;
    }
    public BillingAddress setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    public String getBillingCompany() {
        return billingCompany;
    }
    public BillingAddress setBillingCompany(String billingCompany) {
        this.billingCompany = billingCompany;
        return this;
    }
    public String getStreetAddress() {
        return streetAddress;
    }
    public BillingAddress setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
        return this;
    }
    public String getCity() {
        return city;
    }
    public BillingAddress setCity(String city) {
        this.city = city;
        return this;
    }
    public String getZipCode() {
        return zipCode;
    }
    public BillingAddress setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public BillingAddress setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
    public String getEmail() {
        return email;
    }
    public BillingAddress setEmail(String email) {
        this.email = email;
        return this;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
}
