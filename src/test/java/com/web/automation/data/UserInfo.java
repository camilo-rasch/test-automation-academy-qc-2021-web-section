package com.web.automation.data;

/**
 * User Info class. Data provider background
 * @author fabio.alarcon
 */

public class UserInfo {

    private String firstNameText;
    private String lastNameText;
    private String emailText;
    private String passwordText;

    /**
     * Constructor
     * @param firstNameText
     * @param lastNameText
     * @param emailText
     * @param passwordText
     */
    public UserInfo(String firstNameText, String lastNameText, String emailText, String passwordText) {
        this.firstNameText = firstNameText;
        this.lastNameText = lastNameText;
        this.emailText = emailText;
        this.passwordText = passwordText;
    }

    /**
     * Method get to the first name
     * @return String first Name
     */
    public String getFirstNameText() {
        return firstNameText;
    }

    /**
     * Method get to the last name
     * @return String last Name
     */
    public String getLastNameText() {
        return lastNameText;
    }

    /**
     * Method get to the email
     * @return String email
     */
    public String getEmailText() {
        return emailText;
    }

    /**
     * Method get to the password
     * @return String password
     */
    public String getPasswordText() {
        return passwordText;
    }
}