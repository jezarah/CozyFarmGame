package game;

import display.Camera;
import entity.Player;
import game.ui.TitleMenu;
import input.Input;
import map.Map;

import java.awt.*;

public class Game {
    /** Game States **/
    public boolean gameStarted;
    public boolean gamePaused;

    public final GamePanel gamePanel;
    public final Input input;
    public final TitleMenu titleMenu;
    public final Player player;
    public final Camera camera;
    public final Map map;
    public int fps;

    public Game() {
        input = new Input();
        gamePanel = new GamePanel(input, this);
        map = new Map(gamePanel);
        titleMenu = new TitleMenu(gamePanel, this);
        player = new Player(gamePanel, map, input);
        camera = new Camera(gamePanel, player);

        gameStarted = false;
        gamePaused = false;
    }

    public void update() {
        if (!gamePaused) {
            if (gameStarted) {
                player.update();
                camera.update();
            } else {
                titleMenu.update();
            }
        }
    }

    public Point getMousePosition() {
        return input.getMousePosition();
    }

    public boolean isMousePressed() {
        return input.isMousePressed();
    }
}
