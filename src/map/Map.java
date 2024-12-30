package map;

import game.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Map {
    GamePanel gp;
    public BufferedImage mapImage;
    public BufferedImage collisionImage;
    public BufferedImage foregroundImage;

    public Map(GamePanel gp) {
        this.gp = gp;
        try {
            File file = new File("src/res/map/Map.png");
            FileInputStream fis = new FileInputStream(file);
            mapImage = ImageIO.read(fis);
            file = new File("src/res/map/collisions-square.png");
            fis = new FileInputStream(file);
            collisionImage = ImageIO.read(fis);
            file = new File("src/res/map/Map-Foreground.png");
            fis = new FileInputStream(file);
            foregroundImage = ImageIO.read(fis);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(mapImage, 0, 0, mapImage.getWidth()*gp.scale, mapImage.getHeight()*gp.scale, null);
        // Draw Collision Map for Development
        // g2.drawImage(collisionImage, 0, 0, collisionImage.getWidth()*gp.scale, collisionImage.getHeight()*gp.scale, null);
    }

    public void drawForeground(Graphics2D g2) {
        g2.drawImage(foregroundImage, 0, 0, foregroundImage.getWidth()*gp.scale, foregroundImage.getHeight()*gp.scale, null);
    }
}
