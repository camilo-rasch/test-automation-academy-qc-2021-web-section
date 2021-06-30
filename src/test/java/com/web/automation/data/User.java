package com.web.automation.data;

/**
 * Users information class.
 * @author norma.losada
 */
public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String emailStorage;

    /**
     * Constructor
     */
    public User() {
        int rand = (int)(Math.random() * ((3000 - 2000) + 1) + 2000);
        firstName = "norma" + rand;
        lastName = "losada" + rand;
        email = "norma@losada" + rand + ".com";
        password = "norma3103";
        emailStorage = "losada.norma@gmail.com";
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
     * Get email.
     * @return String
     */
    public String getEmailStorage() {
        return emailStorage;
    }

    /**
     * Set username.
     * @param username
     */
    public void setUsername(String username) {
        this.email = username;
    }

    /**
     * Get password.
     * @return string
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set password.
     *  @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
