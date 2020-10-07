package com.johnmsaylor.room;

import com.johnmsaylor.client.Client;

public abstract class RoomTemplate {
    private String number;
    private String type;
    private String floor;
    private boolean isOccupied;
    private boolean needsCleaning;
    private Client occupant;
    public int averagePrice;

    public RoomTemplate(String number, String type, String floor, int averagePrice) {
        this.number = number;
        this.type = type;
        this.floor = floor;
        this.averagePrice = averagePrice;
        this.isOccupied = false;
        this.needsCleaning = true;
        this.occupant = null;
    }
    // reserve = Should change room to isOccupied and assign the client to the occupant if isOccupied and needsCleaning are false otherwise print “unavailable” Should return true if successful or false if issue.
    public boolean reserve(Client client) {
        if (!isOccupied && !needsCleaning) {
            occupant = client;
            isOccupied = true;
            return true;
        }
        System.out.println("Unavailable.");
        return false;
    }
    // checkout = remove the client from object and mark isOccupied as false, set needsCleaning to true, display o outstanding balance for the client.
    public void checkout() {
        System.out.println("Outstanding Balance: " + occupant.getOutstanding());
        occupant = null;
        isOccupied = false;
        needsCleaning = true;
    }
    // clean = set needsCleaning to false
    public void clean() {
        needsCleaning = false;
    }

    public String getType() {
        return type;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public String getNumber() {
        return number;
    }

    public String getFloor() {
        return floor;
    }

    public int getAveragePrice() {
        return averagePrice;
    }
}
