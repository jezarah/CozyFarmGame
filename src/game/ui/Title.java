package game.ui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Title extends UI {
    final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    public Title(int w, int h) {
        super(w,h);
        x = SCREEN_WIDTH/2 - w/2;
        y = SCREEN_HEIGHT/3 - h/2;
        try {
            File file = new File("src/res/ui/title.png");
            FileInputStream fis = new FileInputStream(file);
            image = ImageIO.read(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }}
