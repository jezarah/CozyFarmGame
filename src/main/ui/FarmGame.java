package ui;

import model.*;

import java.sql.SQLOutput;
import java.util.Scanner;

import static model.ItemType.CARROT;

public class FarmGame {

    private Player player;
    private Inventory inventory;
    private Scanner input;


    public FarmGame() throws InventoryFullException {
        boolean keepGoing = true;

        System.out.println("Hello Farmer! Welcome to Rosewood Farm <3");
        System.out.println("What's your name? (you can type it and I'll remember!)");

        input = new Scanner(System.in);
        String playerName = input.nextLine();

        player = new Player(playerName);
        inventory = new Inventory();

        System.out.println("Let's test the inventory and the items classes!");
        Item carrot = new Item(CARROT, 1);

        inventory.addItem(carrot,1);

        for (Item i : inventory.getItems()) {
            System.out.println(i.getType().name);
        }
        System.out.println("Let's pick our fave flower, and add it to our inventory");

        input = new Scanner(System.in);
        String flowerName = input.nextLine().toUpperCase();

        Item flower = new Item(flowerName,1);
        inventory.addItem(flower, 1);

        for (Item i : inventory.getItems()) {
            System.out.println(i.getType().name);
        }
        System.out.println("Thanks for the help " + player.getName() + "!");
    }

}
