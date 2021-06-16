package com.web.automation.data;

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
        int rand = (int)(Math.random() * ((3000 - 2000) + 1) + 2000);
        firstName = "Juan" + rand;
        lastName = "Montes" + rand;
        email = "juan@montes" + rand + ".com";
        password = "juan123*";
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
