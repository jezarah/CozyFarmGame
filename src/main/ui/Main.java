package ui;

import model.Inventory;
import model.InventoryFullException;

public class Main {
    public static void main(String[] args) {

        try {
            FarmGame newGame = new FarmGame();
        } catch (InventoryFullException e) {
            System.out.println("Inventory Full???");
        }
    }
}