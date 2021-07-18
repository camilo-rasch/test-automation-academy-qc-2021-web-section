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
        firstName = "customerName";
        lastName = "customerLname";
        phoneNumber = "57" + rand;        
    }

    /**
     * Get first Name
     * @return
     */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Set first name
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Get last name
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Set last name
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Get phone Number
	 * @return
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Set phone number
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
