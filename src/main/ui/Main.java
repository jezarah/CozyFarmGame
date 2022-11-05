package ui;

import model.InventoryFullException;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

// Main for TestItemsInConsole
//        try {
//            TestItemsinConsole newGame = new TestItemsinConsole();
//        } catch (InventoryFullException e) {
//            System.out.println("Inventory Full???");
//        }
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Rosewood Farm");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack(); // So we can see it

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();


    }
}