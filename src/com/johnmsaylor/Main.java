package com.johnmsaylor;

import com.johnmsaylor.client.Client;
import com.johnmsaylor.hotel.Hotel;
import com.johnmsaylor.room.StandardRoom;
import com.johnmsaylor.room.SuiteRoom;
import com.johnmsaylor.ux.Console;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	    var hotel = new Hotel("Biltmore", 10);
	    var room = new StandardRoom("101B", "1", 150, 1, 2);
	    room.clean();
	    var suite = new SuiteRoom("404A", "4",400,3,2);
		suite.clean();
		suite.reStock();

	    hotel.addRoom(room);
	    hotel.addRoom(suite);

	    String input;
        do {
			System.out.println("--------------------------");
			System.out.println("WELCOME TO HOTEL " + hotel.getName().toUpperCase());
			System.out.println("--------------------------");
			System.out.println("1) Show Available Rooms");
			System.out.println("2) Check-in");
			System.out.println("3) Check-out");
			System.out.println("0) Quit");
			input = scanner.next().trim();
			switch (Integer.parseInt(input)) {
				case 1:
					hotel.showAvailableRooms();
					break;
				case 2:
					hotel.reserveRoom(new Client(Console.getClientName(), Console.getPartySize(), Console.getClientPhone()));
					break;
				case 3:
					hotel.checkout();
					break;
				default:
					continue;
			}
		} while (!input.equals("0"));
    }
}
