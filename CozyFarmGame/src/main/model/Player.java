package model;

// Represents the Player with a name, extends an abstract Sprite

import ui.GamePanel;
import ui.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public class Player extends Sprite {
    public static final int PLAYER_SPEED = 2;

    GamePanel gp;
    KeyHandler keyH;

    // private String name; TODO

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }

    // MODIFIES: this
    // EFFECTS: sets the Players default coordinates and speed
    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 2;
        direction = "down";
    }

    public void getPlayerImage() {

        try {

//            up1 = ImageIO.read(getClass().getResourceAsStream("/player/Character-Facing-Back-1.png"));
//            up2 = ImageIO.read(getClass().getResourceAsStream("/player/Character-Facing-Back-2.png"));
//            down1 = ImageIO.read(getClass().getResourceAsStream("/player/Character-Facing-Front-1.png"));
//            down2 = ImageIO.read(getClass().getResourceAsStream("/player/Character-Facing-Front-2.png"));
//            left1 = ImageIO.read(getClass().getResourceAsStream("/player/Character-Facing-Left-1.png"));
//            left2 = ImageIO.read(getClass().getResourceAsStream("/player/Character-Facing-Left-2.png"));
//            right1 = ImageIO.read(getClass().getResourceAsStream("/player/Character-Facing-Right-1.png"));
//            right2 = ImageIO.read(getClass().getResourceAsStream("/player/Character-Facing-Right-2.png"));

            File file = new File("CozyFarmGame/src/main/model/res/player/Character-Facing-Back-1.png");
            FileInputStream fis = new FileInputStream(file);
            up1 = ImageIO.read(fis);

            file = new File("CozyFarmGame/src/main/model/res/player/Character-Facing-Back-2.png");
            fis = new FileInputStream(file);
            up2 = ImageIO.read(fis);

            file = new File("CozyFarmGame/src/main/model/res/player/Character-Facing-Front-1.png");
            fis = new FileInputStream(file);
            down1 = ImageIO.read(fis);

            file = new File("CozyFarmGame/src/main/model/res/player/Character-Facing-Front-2.png");
            fis = new FileInputStream(file);
            down2 = ImageIO.read(fis);

            file = new File("CozyFarmGame/src/main/model/res/player/Character-Facing-Left-1.png");
            fis = new FileInputStream(file);
            left1 = ImageIO.read(fis);

            file = new File("CozyFarmGame/src/main/model/res/player/Character-Facing-Left-2.png");
            fis = new FileInputStream(file);
            left2 = ImageIO.read(fis);

            file = new File("CozyFarmGame/src/main/model/res/player/Character-Facing-Right-1.png");
            fis = new FileInputStream(file);
            right1 = ImageIO.read(fis);

            file = new File("CozyFarmGame/src/main/model/res/player/Character-Facing-Right-2.png");
            fis = new FileInputStream(file);
            right2 = ImageIO.read(fis);

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    // MODIFIES: this
    // EFFECTS: Updates players coordinates based on keys Pressed
    public void update() {

        if (keyH.upPressed) {
            direction = "up";
            y -= speed;
        } else if (keyH.downPressed) {
            direction = "down";
            y += speed;
        } else if (keyH.rightPressed) {
            direction = "right";
            x += speed;
        } else if (keyH.leftPressed) {
            direction = "left";
            x -= speed;
        }
    }


    // EFFECTS: draws the player character onto the
    public void draw(Graphics2D g2) {

        //g2.setColor(Color.white);
        //g2.fillRect(x, y, gp.tileSize, gp.tileSize); temporary Player Character

        BufferedImage image = null;

        switch(direction) {
            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
            case "left":
                image = left1;
                break;
            case "right":
                image = right1;
                break;
        }

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);


    }

}
