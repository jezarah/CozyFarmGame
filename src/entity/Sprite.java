package entity;

/*
An abstract class that represents an in game Sprite with an xCoord, yCoord and speed
 */

import java.awt.image.BufferedImage;

public abstract class Sprite {
    public int x, y;
    public int speed;

    public BufferedImage currImage;
    public BufferedImage up1, up2, up3, down1, down2, down3, left1, left2, right1, right2;
    public String direction;

    public int animationCounter = 0;
    public int spriteNum = 1;
}
