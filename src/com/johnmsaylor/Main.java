package com.johnmsaylor;

import com.johnmsaylor.client.Client;
import com.johnmsaylor.hotel.Hotel;
import com.johnmsaylor.room.StandardRoom;
import com.johnmsaylor.room.SuiteRoom;

public class Main {

    public static void main(String[] args) {
	    var hotel = new Hotel("Babylon", 10);

	    var client = new Client("John Saylor", 3,"444-321-1234");

	    var room = new StandardRoom("101B", "1", 150, 1, 2);
	    room.clean();
	    var suite = new SuiteRoom("404A", "4",400,3,2);
		suite.clean();
		suite.reStock();

	    hotel.addRoom(room);
	    hotel.addRoom(suite);

	    hotel.showAvailableRooms();

        hotel.reserveRoom(client);
		client.chargeRoom();

        hotel.showAvailableRooms();

        hotel.checkout(client);

        hotel.showAvailableRooms();

    }
}
