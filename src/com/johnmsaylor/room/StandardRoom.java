package com.johnmsaylor.room;

import com.johnmsaylor.client.Client;
import com.johnmsaylor.ux.Console;

public class StandardRoom extends RoomTemplate implements Room{
    private int rooms;
    private int beds;

    public StandardRoom(String number, String floor, int averagePrice, int rooms, int beds) {
        super(number, "STANDARD", floor, averagePrice);
        this.rooms = rooms;
        this.beds = beds;
    }

    //    override reserve = if party size > beds * 2 print unavailable otherwise run standard reserve
    @Override
    public boolean reserve(Client client) {
        if (client.getPartySize() < beds * 2) {
            return super.reserve(client);
        }
        return false;
    }

    @Override
    public void showDetails() {
        Console.showRoom(getType(), getNumber(), getFloor(), getAveragePrice());
    }
}
