package com.web.automation.data;

public class Passenger {

    private String firstNamePassenger1;
    private String middleNamePassenger1;
    private String lastNamePassenger1;
    private String phoneNumberPassenger1;
    private String firstNamePassenger2;
    private String middleNamePassenger2;
    private String lastNamePassenger2;


    public Passenger(String firstNamePassenger1, String middleNamePassenger1, String lastNamePassenger1, String phoneNumberPassenger1,
                     String firstNamePassenger2, String middleNamePassenger2, String lastNamePassenger2) {

        this.firstNamePassenger1 = firstNamePassenger1;
        this.middleNamePassenger1 = middleNamePassenger1;
        this.lastNamePassenger1 = lastNamePassenger1;
        this.phoneNumberPassenger1 = phoneNumberPassenger1;
        this.firstNamePassenger2 = firstNamePassenger2;
        this.middleNamePassenger2 = middleNamePassenger2;
        this.lastNamePassenger2 = lastNamePassenger2;
    }



    public String getFirstNamePassenger1() {
        return firstNamePassenger1;
    }

    public void setFirstNamePassenger1(String firstNamePassenger1) {
        this.firstNamePassenger1 = firstNamePassenger1;
    }

    public String getMiddleNamePassenger1() {
        return middleNamePassenger1;
    }

    public void setMiddleNamePassenger1(String middleNamePassenger1) {
        this.middleNamePassenger1 = middleNamePassenger1;
    }

    public String getLastNamePassenger1() {
        return lastNamePassenger1;
    }

    public void setLastNamePassenger1(String lastNamePassenger1) {
        this.lastNamePassenger1 = lastNamePassenger1;
    }

    public String getPhoneNumberPassenger1() {
        return phoneNumberPassenger1;
    }

    public void setPhoneNumberPassenger1(String phoneNumberPassenger1) {
        this.phoneNumberPassenger1 = phoneNumberPassenger1;
    }

    public String getFirstNamePassenger2() {
        return firstNamePassenger2;
    }

    public void setFirstNamePassenger2(String firstNamePassenger2) {
        this.firstNamePassenger2 = firstNamePassenger2;
    }

    public String getMiddleNamePassenger2() {
        return middleNamePassenger2;
    }

    public void setMiddleNamePassenger2(String middleNamePassenger2) {
        this.middleNamePassenger2 = middleNamePassenger2;
    }

    public String getLastNamePassenger2() {
        return lastNamePassenger2;
    }

    public void setLastNamePassenger2(String lastNamePassenger2) {
        this.lastNamePassenger2 = lastNamePassenger2;
    }
}
