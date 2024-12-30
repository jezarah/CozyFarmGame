package display;

import entity.Player;
import game.GamePanel;

public class Camera {
    public int offsetMaxX;
    public int offsetMaxY;
    public int offsetMinX;
    public int offsetMinY;

    public int camX;
    public int camY;

    private final Player player;
    private final GamePanel gamePanel;

    public Camera(GamePanel gp, Player p) {
        //Setting offset max's and minimums
        offsetMaxX = 0;
        offsetMaxY = 0;
        offsetMinX = 0;
        offsetMinY = 0;
        player = p;
        gamePanel = gp;
    }

    public void update() {
        camX = player.x - (gamePanel.SCREEN_WIDTH / 2);
        camY = player.y - (gamePanel.SCREEN_HEIGHT / 2);
    }
}
