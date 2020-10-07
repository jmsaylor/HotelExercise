package com.johnmsaylor.room;

import com.johnmsaylor.client.Client;

public interface Room {
    boolean isOccupied();
    boolean reserve(Client client);
    void checkout();
    void showDetails();
    String getType();
    String getNumber();
    String getFloor();
    int getAveragePrice();
}
