package game;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Rosewood Farm");

        Game game = new Game();
        GamePanel gamePanel = new GamePanel(game.input, game);
        GameLoop gameLoop = new GameLoop(game, gamePanel);
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gameLoop.startGameThread();
    }
}