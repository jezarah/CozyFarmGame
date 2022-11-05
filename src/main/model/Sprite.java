package model;

/*
An abstract class that represents an in game Sprite with an xCoord, yCoord and speed
 */

public abstract class Sprite {

    private int xCoord;
    private int yCoord;
    private int speed;

    /*
    MODIFIES: this
    EFFECTS: moves the Sprite to the right the amount of speed
     */
    public void moveRight() {
        this.xCoord += speed;
    }

    /*
    MODIFIES: this
    EFFECTS: moves the Sprite to the left the amount of speed
     */
    public void moveLeft() {
        this.xCoord -= speed;
    }

    /*
    MODIFIES: this
    EFFECTS: moves the Sprite up the amount of speed
   */
    public void moveUp() {
        this.yCoord -= speed;
    }

    /*
    MODIFIES: this
    EFFECTS: moves the Sprite down the amount of speed
   */
    public void moveDown() {
        this.yCoord += speed;
    }


}
