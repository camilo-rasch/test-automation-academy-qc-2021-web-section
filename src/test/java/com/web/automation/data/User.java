package com.web.automation.data;

import org.testng.annotations.DataProvider;

/**
 * Object information class.
 * @author juan.montes
 */
public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    /**
     * Constructor
     */
    public User() {
        int rand = (int)(Math.random() * ((15000 - 1000) + 2) + 2000);
        firstName = "Silvana" + rand;
        lastName = "Perez" + rand;
        email = "silvana" + rand + "@hotmail.com";
        password = "Password123";
    }

    /**
     * Get first name.
     * @return string
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get last name.
     * @return String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Get email.
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Get password.
     * @return String
     */
    public String getPassword() {
        return password;
    }


    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
