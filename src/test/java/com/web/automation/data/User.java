package com.web.automation.data;


/**
 * Users information class.
 * @author norma.losada
 */
public class User {

    private String firstName;
    private String lastName;
    private String firstNameSecondTraveler;
    private String lastNameSecondTraveler;
    private String phoneNumber;


    /**
     * Constructor
     *
     */
    public User() {
        int rand = (int)(Math.random() * ((3000 - 2000) + 1) + 2000);
        this.firstName = generateRandomNames(1);
        this.lastName = generateRandomLastName(1);
        this.firstNameSecondTraveler = generateRandomNames(1);
        this.lastNameSecondTraveler = generateRandomLastName(1);
        this.phoneNumber = "000555" + rand;
    }

    /**
     * Get first name.
     * @return String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set last_name.
     * @param firstName String
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get last name.
     * @return String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set last_name.
     * @param lastName String
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get phone number.
     * @return String
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set last_name.
     * @param phoneNumber String
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get first name for second traveler.
     * @return String
     */
    public String getFirstNameSecondTraveler() {
        return firstNameSecondTraveler;
    }

    /**
     * Set first name for second traveler.
     * @param firstNameSecondTraveler String
     */
    public void setFirstNameSecondTraveler(String firstNameSecondTraveler) {
        this.firstNameSecondTraveler = firstNameSecondTraveler;
    }

    /**
     * Get last name for second traveler.
     * @return String
     */
    public String getLastNameSecondTraveler() {
        return lastNameSecondTraveler;
    }

    /**
     * Set last_name for second traveler.
     * @param lastNameSecondTraveler String
     */
    public void setLastNameSecondTraveler(String lastNameSecondTraveler) {
        this.lastNameSecondTraveler = lastNameSecondTraveler;
    }

    /**
     * Create random name
     * @param amount int
     * @return string with the name
     *
     */
    public static String generateRandomNames(int amount) {
        String[] randomNames = new String[amount];
        String name = "";
        String[] names = { "Andrea", "David", "Camilo", "Maria", "Jose", "Antonia", "Martina", "Mo",
                "Pablo", "Emilio", "Gonzalo", "Laura", "Catalina", "Jaime", "Celeste", "Carina", "Paola",
                "Bernardo", "Nidia", "Sergio"};
        for (int i = 0; i < amount; i++) {
            randomNames[i] = names[(int) (Math.floor(Math.random() * ((names.length - 1) - 0 + 1) + 0))];
            name = randomNames[i];
        }
        return name;
    }

    /**
     * Create random lastName
     * @param amount int
     * @return string with the lastName
     *
     */
    public static String generateRandomLastName(int amount) {
        String[] randomLastNames = new String[amount];
        String lastName = "";
        String[] lastNames = { "Losada", "Perez", "Murcia", "Pantoja", "Matinez", "Pinzon", "Tobon", "Alsaadi",
                "Mendez", "Rojas", "Zarate", "Lopez", "Ortiz", "Cadena", "Ramirez", "Motta", "Bahamon",
                "Cortez", "Gomez", "Saavedra"};
        for (int i = 0; i < amount; i++) {
            randomLastNames[i] = lastNames[(int) (Math.floor(Math.random() * ((lastNames.length - 1) - 0 + 1) + 0))];
            lastName = randomLastNames[i];
        }
        return lastName;
    }
}
