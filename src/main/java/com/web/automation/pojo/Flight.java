package com.web.automation.pojo;

/**
 * Data provider class.
 * @author juandaniel.castano@globant.com
 */

public class Flight {

    /**
     * Class' variables are defined
     */
    private String departure;
    private String destination;
    private String flightDuration;
    private String flightPrice;
    private String airLineCompany;


    /**
     * Constructor method
     * @param departure String
     * @param destination String
     * @param flightDuration String
     * @param flightPrice String
     * @param airLineCompany String
     */

    public Flight(String departure, String destination, String flightDuration, String flightPrice, String airLineCompany) {
        this.departure = departure;
        this.destination = destination;
        this.flightDuration = flightDuration;
        this.flightPrice = flightPrice;
        this.airLineCompany = airLineCompany;
    }

    /**
     * Get departure value
     * @return departure String
     */

    public String getDeparture() {
        return departure;
    }

    /**
     * Set departure value
     * @param departure String
     */

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    /**
     * Get destination value
     * @return destination String
     */

    public String getDestination() {
        return destination;
    }

    /**
     * Set destination value
     * @param destination String
     */

    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * Get flightDuration value
     * @return flightDuration String
     */

    public String getFlightDuration() {
        return flightDuration;
    }

    /**
     * Set flightDuration value
     * @param flightDuration String
     */

    public void setFlightDuration(String flightDuration) {
        this.flightDuration = flightDuration;
    }

    /**
     * Get flightPrice value
     * @return flightPrice String
     */

    public String getFlightPrice() {
        return flightPrice;
    }

    /**
     * Set flightPrice value
     * @param flightPrice String
     */

    public void setFlightPrice(String flightPrice) {
        this.flightPrice = flightPrice;
    }

    /**
     * Get airLineCompany value
     * @return airLineCompany String
     */

    public String getAirLineCompany() {
        return airLineCompany;
    }

    /**
     * Set airLineCompany String
     * @param airLineCompany String
     */

    public void setAirLine_company(String airLineCompany) {
        this.airLineCompany = airLineCompany;
    }
}
