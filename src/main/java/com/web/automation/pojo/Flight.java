package com.web.automation.pojo;

public class Flight {

    private String departure;
    private String destination;
    private String flightDuration;
    private String flightPrice;
    private String airLine_company;


    public Flight(String departure, String destination, String flightDuration, String flightPrice, String airLine_company) {
        this.departure = departure;
        this.destination = destination;
        this.flightDuration = flightDuration;
        this.flightPrice = flightPrice;
        this.airLine_company = airLine_company;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(String flightDuration) {
        this.flightDuration = flightDuration;
    }

    public String getFlightPrice() {
        return flightPrice;
    }

    public void setFlightPrice(String flightPrice) {
        this.flightPrice = flightPrice;
    }

    public String getAirLine_company() {
        return airLine_company;
    }

    public void setAirLine_company(String airLine_company) {
        this.airLine_company = airLine_company;
    }
}
