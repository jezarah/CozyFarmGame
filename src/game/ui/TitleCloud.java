package game.ui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TitleCloud extends UI {
    int numFrames = 8;
    int temp = numFrames;
    final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;

    public TitleCloud(CloudType type, int x_coord, int y_coord, int w, int h) {
        super(w, h);
        x = x_coord;
        y = y_coord;
        setTypeProperties(type);
    }
    private void setTypeProperties(CloudType type) {
        try {
            File file;
            switch (type) {
                case ONE:
                    file = new File("src/res/ui/cloud1.png");
                    FileInputStream fis = new FileInputStream(file);
                    image = ImageIO.read(fis);
                    break;
                case TWO:
                    file = new File("src/res/ui/cloud2.png");
                    FileInputStream fis2 = new FileInputStream(file);
                    image = ImageIO.read(fis2);
                    break;
                case THREE:
                    file = new File("src/res/ui/cloud3.png");
                    FileInputStream fis3 = new FileInputStream(file);
                    image = ImageIO.read(fis3);
                    break;
                case FOUR:
                    file = new File("src/res/ui/cloud4.png");
                    FileInputStream fis4 = new FileInputStream(file);
                    image = ImageIO.read(fis4);
                    break;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void update() {
        if (x >= SCREEN_WIDTH) {
            x = -100;
        } else if (temp != 1) {
            temp--;
        } else {
            x++;
            temp = numFrames;
        }
    }
}
