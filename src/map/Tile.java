package map;

import game.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Tile {
    public int x;
    public int y;
    public BufferedImage image;
    GamePanel gp;

    // constructor for tile
    public Tile(TileType type, int x, int y, GamePanel gp) {
        this.gp = gp;
        this.x = x;
        this.y = y;
        setTypeProperties(type);
    }

    private void setTypeProperties(TileType type) {
        try {
            File file;
            if (type.equals(TileType.GRASS)) {
                file = new File("CozyFarmGame/src/main/model/res/tiles/grass.png");
                FileInputStream fis = new FileInputStream(file);
                image = ImageIO.read(fis);
            } else if (type.equals(TileType.GRASS_TOP_LEFT)) {
                file = new File("CozyFarmGame/src/main/model/res/tiles/edge-topleft.png");
                FileInputStream fis = new FileInputStream(file);
                image = ImageIO.read(fis);
            } else if (type.equals(TileType.GRASS_TOP_MIDDLE)) {
                file = new File("CozyFarmGame/src/main/model/res/tiles/edge-top.png");
                FileInputStream fis = new FileInputStream(file);
                image = ImageIO.read(fis);
            } else if (type.equals(TileType.GRASS_TOP_RIGHT)) {
                file = new File("CozyFarmGame/src/main/model/res/tiles/edge-topright.png");
                FileInputStream fis = new FileInputStream(file);
                image = ImageIO.read(fis);
            } else if (type.equals(TileType.GRASS_LEFT_MIDDLE)) {
                file = new File("CozyFarmGame/src/main/model/res/tiles/edge-left.png");
                FileInputStream fis = new FileInputStream(file);
                image = ImageIO.read(fis);
            } else if (type.equals(TileType.GRASS_LEFT_BOTTOM)) {
                file = new File("CozyFarmGame/src/main/model/res/tiles/edge-bottomleft.png");
                FileInputStream fis = new FileInputStream(file);
                image = ImageIO.read(fis);
            } else if (type.equals(TileType.GRASS_RIGHT_BOTTOM)) {
                file = new File("CozyFarmGame/src/main/model/res/tiles/edge-bottomright.png");
                FileInputStream fis = new FileInputStream(file);
                image = ImageIO.read(fis);
            } else if (type.equals(TileType.GRASS_BOTTOM_MIDDLE)) {
                file = new File("CozyFarmGame/src/main/model/res/tiles/edge-bottom.png");
                FileInputStream fis = new FileInputStream(file);
                image = ImageIO.read(fis);
            } else if (type.equals(TileType.GRASS_RIGHT_MIDDLE)) {
                file = new File("CozyFarmGame/src/main/model/res/tiles/edge-right.png");
                FileInputStream fis = new FileInputStream(file);
                image = ImageIO.read(fis);
            } else if (type.equals(TileType.COLLISION)) {
                file = new File("CozyFarmGame/src/main/model/res/tiles/collision.png");
                FileInputStream fis = new FileInputStream(file);
                image = ImageIO.read(fis);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // EFFECTS: draws the tile onto the screen
    public void draw(Graphics2D g2) {
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
