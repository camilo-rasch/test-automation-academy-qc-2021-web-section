package com.web.automation.data;

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
	        firstName = "Jessica" + rand;
	        lastName = "Cardona" + rand;
	        email = "jessica@cardona" + rand + ".com";
	        password = "Jessica123**";
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

}


