package com.web.automation.data;

/**
 * Object information class.
 * @author Silvana.perez
 */
public class SignInUserData {

    private String email;
    private String password;

    /**
     * Constructor
     */
    public SignInUserData() {
        int rand = (int)(Math.random() * ((3000 - 2000) + 1) + 2000);
        email = "silvana" + rand + "@hotmail.com";
        password = "Password123";
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
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
