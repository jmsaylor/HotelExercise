package com.johnmsaylor.hotel;

import com.johnmsaylor.ux.Console;
import com.johnmsaylor.client.Client;
import com.johnmsaylor.room.Room;

import java.util.*;

public class Hotel {
    private String name;
    private int rooms;
    private Queue<Room> availableStandards = new LinkedList<>();
    private List<Room> reservedStandards = new ArrayList<>();
    private Queue<Room> availableSuites = new LinkedList<>();
    private List<Room> reservedSuites = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();

    public Hotel(String name, int rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        switch (room.getType()) {
            case "STANDARD":
                availableStandards.add(room);
                break;
            case "SUITE":
                availableSuites.add(room);
                break;
            default:
        }
    }
//    reserveRoom = pull a room from the correct list. if empty print ‘unavailable’ otherwise, run the checkout for the room and move the room from available to reserved. Using the correct collection will make this easier. Add client to clients list
    public void reserveRoom(Client client) {

        String roomType = Console.readType();
        var rooms = roomType.equals("STANDARD") ? availableStandards : availableSuites;

        Room room = Console.chooseRoom((List<Room>) rooms);

        if (room.reserve(client)) {
            client.setCurrentRoom(room);
            Console.printConfirmation(room, client);
        } else {
            System.out.println("Not available for some reason.");
        }
    }
//    checkoutRoom = run the checkout process for a room and move the room from reserved to available.
    public void checkout(Client client) {
        System.out.println("Please pay: " + client.getOutstanding());
        if (Console.readCreditCard()) {
            var room = client.getRoom();
            room.checkout();
            client.makePayment(client.getOutstanding());
            client.clearCurrentRoom();
            if (room.getType().equals("STANDARD")) {
                reservedStandards.remove(room);
            } else {
                reservedSuites.remove(room);
            }
            addRoom(room);
            System.out.println("Thank you for your stay");
        }
    }
//    getClientBalance = get the balance of a client by either their room number or name
//
//    Once the above is done add in a HotelRoom interface that the two rooms will implement and update the hotel and client classes to utilize the HotelRoom interface to connect to these objects.
//
//    additional challenge add a calculate price method. this method should increase the price by x% for each person above bed * 2 with a maximum capacity for the room at bed * 2 + room * 2. example a 1 bed 1 room can take 4 people max with 2 having a fee applied. a 2 bed 2 room has max occupancy of 8 with 4 being subject to fee. a 1 bed 3 room also has 8 occupancy but 6 fees can be applied. the standard room applies a 5% fee and suites apply an 8% fee. note this means the standard rooms will no longer deny at 2*bed but now deny at 2*bed + 2 * room. while the suite will not deny but if over capacity increase price by additional 50% per person after capacity.

    public void showAvailableRooms() {
        System.out.println("AVAILABLE ROOMS");
        System.out.println("***STANDARD ROOMS***");
        Console.showRooms((List<Room>) availableStandards);
        System.out.println("***SUITES***");
        Console.showRooms((List<Room>) availableSuites);
    }

    public List<Room> getAllAvailableRooms() {
        // how to join to lists?

//        var temp = new ArrayList<Room>();
//        temp = Arrays.asList(st)
//        return
    }
}
