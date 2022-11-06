package model;

/*
An abstract class that represents an in game Sprite with an xCoord, yCoord and speed
 */

import java.awt.image.BufferedImage;

public abstract class Sprite {

    public int x, y;
    public int speed;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;

//    /*
//    MODIFIES: this
//    EFFECTS: moves the Sprite to the right the amount of speed
//     */    public void moveRight() {
//        this.x += speed;
//    }
//
//    /*
//    MODIFIES: this
//    EFFECTS: moves the Sprite to the left the amount of speed
//     */
//    public void moveLeft() {
//        this.x-= speed;
//    }
//
//    /*
//    MODIFIES: this
//    EFFECTS: moves the Sprite up the amount of speed
//   */
//    public void moveUp() {
//        this.y -= speed;
//    }
//
//    /*
//    MODIFIES: this
//    EFFECTS: moves the Sprite down the amount of speed
//   */
//    public void moveDown() {
//        this.y += speed;
//    }
//


}
