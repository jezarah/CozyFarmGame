package entity;

import game.GamePanel;
import input.Input;
import map.Map;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.event.KeyEvent;

public class Player extends Sprite {
    private static final int STARTING_SPEED = 4;
    private static final int STARTING_X = 3552;
    private static final int STARTING_Y = 1072;
    private static final Color COLLISION_COLOR = new Color(237, 28, 36);
    GamePanel gp;
    Input input;
    Map map;

    // private String name; // TODO: add player name

    public Player(GamePanel gp, Map map, Input input) {
        this.gp = gp;
        this.input = input;
        this.map = map;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = STARTING_X;
        y = STARTING_Y;
        speed = STARTING_SPEED;
        currImage = down1;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            File file = new File("src/res/player/BaseCharacter-Back1.png");
            FileInputStream fis = new FileInputStream(file);
            up1 = ImageIO.read(fis);

            file = new File("src/res/player/BaseCharacter-Back2.png");
            fis = new FileInputStream(file);
            up2 = ImageIO.read(fis);

            file = new File("src/res/player/BaseCharacter-Back3.png");
            fis = new FileInputStream(file);
            up3 = ImageIO.read(fis);

            file = new File("src/res/player/BaseCharacter-Front1.png");
            fis = new FileInputStream(file);
            down1 = ImageIO.read(fis);

            file = new File("src/res/player/BaseCharacter-Front2.png");
            fis = new FileInputStream(file);
            down2 = ImageIO.read(fis);

            file = new File("src/res/player/BaseCharacter-Front3.png");
            fis = new FileInputStream(file);
            down3 = ImageIO.read(fis);

            file = new File("src/res/player/BaseCharacter-Left1.png");
            fis = new FileInputStream(file);
            left1 = ImageIO.read(fis);

            file = new File("src/res/player/BaseCharacter-Left2.png");
            fis = new FileInputStream(file);
            left2 = ImageIO.read(fis);

            file = new File("src/res/player/BaseCharacter-Right1.png");
            fis = new FileInputStream(file);
            right1 = ImageIO.read(fis);

            file = new File("src/res/player/BaseCharacter-Right2.png");
            fis = new FileInputStream(file);
            right2 = ImageIO.read(fis);

        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update() {
        if (input.isCurrentlyPressed(KeyEvent.VK_W)) {
            direction = "up";
            y -= speed;
            if (checkCollisionMoveUp(map.collisionImage)) {
                y += speed;
            }
        } else if (input.isCurrentlyPressed(KeyEvent.VK_S)) {
            direction = "down";
            y += speed;
            if (checkCollisionMoveDown(map.collisionImage)) {
                y -= speed;
            }
        } else if (input.isCurrentlyPressed(KeyEvent.VK_D)) {
            direction = "right";
            x += speed;
            if (checkCollisionMoveRight(map.collisionImage)) {
                x -= speed;
            }
        } else if (input.isCurrentlyPressed(KeyEvent.VK_A)) {
            direction = "left";
            x -= speed;
            if (checkCollisionMoveLeft(map.collisionImage)) {
                x += speed;
            }
        } else {
            animationCounter = 0;
            spriteNum = 0;
        }
        animationCounter++;
        if (animationCounter > 10) {
            if (spriteNum == 0 || spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            animationCounter = 0;
        }
    }

    /** Check for Players Collisions **/
    private boolean checkCollisionMoveRight(BufferedImage collisionImage) {
        Color pixelColor;
        for (int i = 0; i < (double) gp.tileSize /gp.scale*0.25; i++) {
            pixelColor = new Color(collisionImage.getRGB(
                    (int) ((double) x /gp.scale + (double) gp.tileSize /gp.scale*0.875),
                    (int) ((double) y /gp.scale + (double) gp.tileSize /gp.scale*0.75 + i)));
            if (pixelColor.equals(COLLISION_COLOR)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCollisionMoveLeft(BufferedImage collisionImage) {
        Color pixelColor;
        for (int i = 1; i < (double) gp.tileSize /gp.scale*0.25; i++) {
            pixelColor = new Color(collisionImage.getRGB(
                    (int) ((double) x /gp.scale + (double) gp.tileSize /gp.scale*0.125),
                    (int) ((double) y /gp.scale + (double) gp.tileSize /gp.scale*0.75 + i)));
            if (pixelColor.equals(COLLISION_COLOR)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCollisionMoveUp(BufferedImage collisionImage) {
        Color pixelColor;
        for (int i = 0; i < (double) gp.tileSize/gp.scale*0.75; i++) {
            pixelColor = new Color(collisionImage.getRGB(
                    (int) ((double) x /gp.scale + (double) gp.tileSize /gp.scale*0.125 + i),
                    (int) ((double) y /gp.scale + (double) gp.tileSize /gp.scale*0.75)));
            if (pixelColor.equals(COLLISION_COLOR)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCollisionMoveDown(BufferedImage collisionImage) {
        Color pixelColor;
        for (int i = 1; i < (double) gp.tileSize/gp.scale*0.75; i++) {
            pixelColor = new Color(collisionImage.getRGB(
                    (int) ((double) x /gp.scale + (double) gp.tileSize /gp.scale*0.125 + i),
                    (int) ((double) y /gp.scale + (double) gp.tileSize /gp.scale)));
            if (pixelColor.equals(COLLISION_COLOR)) {
                return true;
            }
        }
        return false;
    }

    public void draw(Graphics2D g2) {
        switch(direction) {
            case "up":
                if (spriteNum == 0) {
                    currImage = up1;
                } else if (spriteNum == 1) {
                    currImage = up2;
                } else {
                    currImage = up3;
                }
                break;
            case "down":
                if (spriteNum == 0) {
                    currImage = down1;
                } else if (spriteNum == 1) {
                    currImage = down2;
                } else {
                    currImage = down3;
                }
                break;
            case "left":
                if (spriteNum == 0 || spriteNum == 1) {
                    currImage = left1;
                } else {
                    currImage = left2;
                }
                break;
            case "right":
                if (spriteNum == 0 || spriteNum == 1) {
                    currImage = right1;
                } else {
                    currImage = right2;
                }
                break;
        }
        g2.drawImage(currImage, x, y, gp.tileSize, gp.tileSize, null);
        /**Draw axis bounded box for collision detection (for development)**/
//        g2.drawLine((int) (x + gp.tileSize*0.125), (int) (y + gp.tileSize*0.75), (int) (x + gp.tileSize*0.125), y + gp.tileSize);
//        g2.drawLine((int) (x + gp.tileSize*0.125), (int) (y + gp.tileSize*0.75), (int) (x + gp.tileSize*0.875), (int) (y + gp.tileSize*0.75));
//        g2.drawLine((int) (x + gp.tileSize*0.875), (int) (y + gp.tileSize*0.75), (int) (x + gp.tileSize*0.875), y + gp.tileSize);
//        g2.drawLine((int) (x + gp.tileSize*0.125), y + gp.tileSize, (int) (x + gp.tileSize*0.875), y + gp.tileSize);
    }

}
