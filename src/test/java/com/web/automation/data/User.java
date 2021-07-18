package com.web.automation.data;

/**
 * Object information class.
 * @author jessica.cardona
 */
public class User {
	
	private String firstName;
    private String lastName;
    private String phoneNumber;
    
    /**
     * Constructor
     */
    public User() {
        int rand = (int)(Math.random() * ((3000 - 2000) + 1) + 2000);
        firstName = "name" + rand;
        lastName = "Lname" + rand;
        phoneNumber = "057" + rand;        
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
