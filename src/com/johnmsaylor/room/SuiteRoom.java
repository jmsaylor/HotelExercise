package com.johnmsaylor.room;

import com.johnmsaylor.client.Client;
import com.johnmsaylor.ux.Console;

public class SuiteRoom extends RoomTemplate implements Room{
    private int rooms;
    private int beds;
    private boolean kitchinette;
    private boolean needsRestock;

    public SuiteRoom(String number, String floor, int averagePrice, int rooms, int beds) {
        super(number, "SUITE", floor, averagePrice);
        this.rooms = rooms;
        this.beds = beds;
    }


    //    override reserve = include a check on needsRestock then run standard reserve.
    @Override
    public boolean reserve(Client client) {
        if (!needsRestock) {
            return super.reserve(client);
        } else {
            System.out.println("Unavailable. Needs Restock first");
            return false;
        }
    }

    //    override checkout = set needsRestock to true run standard checkout.
    @Override
    public void checkout() {
        needsRestock = true;
        super.checkout();
    }

    @Override
    public void showDetails() {
        Console.showRoom(getType(), getNumber(), getFloor(), getAveragePrice());
    }

    //  restock() = set needs restock to false
    public void reStock() {
        needsRestock = false;
    }
}
