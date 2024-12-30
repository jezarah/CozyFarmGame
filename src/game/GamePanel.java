package game;

import input.Input;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    final int originalTileSize = 16; // 16x16 tile
    public final int scale = 3;
    public final int tileSize = originalTileSize * scale; // display tile size
    public final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    public final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
    private final Game game;

    public GamePanel(Input input, Game game) {
        this.game = game;
        float[] background = Color.RGBtoHSB(96, 160, 167, null);
        this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setBackground(Color.getHSBColor(background[0], background[1], background[2]));
        this.setDoubleBuffered(true);
        this.addKeyListener(input);
        this.addMouseListener(input);
        this.addMouseMotionListener(input);
        this.setFocusable(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if (game.gameStarted) {
            g.translate(-game.camera.camX, -game.camera.camY);
            game.map.draw(g2);
            game.player.draw(g2);
            game.map.drawForeground(g2);
            g2.setColor(Color.white);
            g2.setFont(new Font("SansSerif", Font.PLAIN, 16));
            g2.drawString("FPS: " + game.fps, game.player.x - SCREEN_WIDTH/2 + 2,
                            game.player.y - SCREEN_HEIGHT/2 + tileSize/scale);
        } else {
            game.titleMenu.draw(g2);
            g2.setColor(Color.white);
            g2.drawString("FPS: " + game.fps, 5, 15);
        }
        g2.dispose();
    }
}
