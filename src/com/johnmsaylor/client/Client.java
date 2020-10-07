package com.johnmsaylor.client;

import com.johnmsaylor.room.Room;

public class Client {
    private String name;
    private int partySize;
    private int currentBill;
    private int prepaid;
    private String phoneNumber;
    private String roomNumber = null;
    private String roomType = null;
    public Room room;

    public Client(String name, int partySize, String phoneNumber) {
        this.name = name;
        this.partySize = partySize;
        this.phoneNumber = phoneNumber;
        this.currentBill = 0;
        this.prepaid = 0;
    }

    //    makePayment = increase prepaid
    public void makePayment(int amt) {
        prepaid += amt;
    }

    //    chargeRoom = increase current bill
    public void chargeRoom() {
        if (room != null) {
            currentBill += room.getAveragePrice();
        } else {
            System.out.println("Billing Error");
        }
    }

    //    getOustanding = get outstanding balance
    public int getOutstanding() {
        return currentBill - prepaid;
    }

    public int getPartySize() {
        return partySize;
    }

    public void setCurrentRoom(Room room) {
        this.room = room;
        roomNumber = room.getNumber();
        roomType = room.getType();
    }

    public void clearCurrentRoom() {
        room = null;
        roomNumber = null;
        roomType = null;
    }

    public String getName() {
        return name;
    }

    public Room getRoom() {
        return room;
    }
}
