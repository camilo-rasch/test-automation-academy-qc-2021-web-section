package com.web.automation.data;

/**
 * Parent of the other classes of test.
 * @author juandaniel.castano
 */

public class User {

    /**
     * Declare the variables
     */

    private String firstUserName;
    private String lastUserName;
    private String emailUser;
    private String passwordUser;

    /**
     * Constructor
     * @param firstUserName To received firstUserName value from User object
     * @param lastUserName To received lastUserName value from User object
     * @param emailUser To received emailUser value from User object
     * @param passwordUser To received passwordUser value from User object
     */

    public User(String firstUserName, String lastUserName, String emailUser, String passwordUser){
        this.firstUserName = firstUserName;
        this.lastUserName = lastUserName;
        this.emailUser = emailUser;
        this.passwordUser = passwordUser;
    }

    /**
     * Get value of firstUserName String
     * @return firstUserName
     */

    public String getFirstUserName() {
        return firstUserName;
    }

    /**
     * Get value of lastUserName String
     * @return lastUserName
     */

    public String getLastUserName() {
        return lastUserName;
    }

    /**
     * Get value of UserName String
     * @return firstUserName
     */

    public String getEmailUser() {
        return emailUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }
}
