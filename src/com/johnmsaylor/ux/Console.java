package com.johnmsaylor.ux;

import com.johnmsaylor.client.Client;
import com.johnmsaylor.room.Room;

import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Console {
    public static Scanner scanner = new Scanner(System.in);

    public static String readType() {
        System.out.println("STANDARD or SUITE - Please type");
        return scanner.next().toUpperCase();
    }

    public static boolean readCreditCard() {
        System.out.println("Enter Credit Card Number");
        scanner.next();
        return true;
    }

    public static void showRoom(String type, String roomNumber, String floor, int price) {
        System.out.println(type + " " + roomNumber + " " + floor + " " + price);
    }

    public static void showRooms(List<Room> rooms) {
        showRooms((Queue<Room>) rooms);
    }

    public static void showRooms(Queue<Room> rooms) {
        int count = 1;
        for (var room : rooms) {
            System.out.print(count + ") ");
            showRoom(room.getType(), room.getNumber(), room.getFloor(), room.getAveragePrice());
        }
    }

    public static Room chooseRoom(Queue<Room> rooms) {
        showRooms(rooms);
        System.out.println("Enter room number to select");
        String roomNumberSelected = scanner.next();

        if (Integer.parseInt(roomNumberSelected) < 100) {
            var temp = (List<Room>) rooms;
            return temp.get(Integer.parseInt(roomNumberSelected) - 1);
        } else if (roomNumberSelected.length() > 3) {
            for (var room : rooms) {
                if (room.getNumber().equals(roomNumberSelected)) {
                    return room;
                }
            }
        }
        System.out.println("Error Finding Room");
        return null;
    }

    public static void printConfirmation(Room room, Client client) {
        System.out.println("Reservation Confirmed");
        System.out.print(client.getName() + " - ");
        Console.showRoom(room.getType(),room.getNumber(), room.getFloor(), room.getAveragePrice());
        System.out.println("--------------------");
    }
}
