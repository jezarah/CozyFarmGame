package game.ui;

import java.awt.image.BufferedImage;

public abstract class UI {
    public int x, y, width, height;
    public BufferedImage image;


    UI (int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void update() {
    }
}
