package game.ui;

import game.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Button extends UI {
    protected boolean hasFocus;
    protected boolean isPressed;
    private final Game game;
    private final ButtonType type;

    public Button(ButtonType buttonType, int w, int h, Game g) {
        super(w, h);
        this.game = g;
        this.type = buttonType;
        setTypeProperties(buttonType, g);
    }

    private void setTypeProperties(ButtonType type, Game g) {
        try {
            File file;
            switch (type) {
                case START:
                    file = new File("src/res/ui/start.png");
                    FileInputStream fis = new FileInputStream(file);
                    image = ImageIO.read(fis);
                    x = g.gamePanel.SCREEN_WIDTH/2 - width - width/2;
                    y = g.gamePanel.SCREEN_HEIGHT/2;
                    break;
                case EXIT:
                    file = new File("src/res/ui/exit.png");
                    FileInputStream fis2 = new FileInputStream(file);
                    image = ImageIO.read(fis2);
                    x = g.gamePanel.SCREEN_WIDTH/2 + width - width/2;
                    y = g.gamePanel.SCREEN_HEIGHT/2;
                    break;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void update() {
        if (buttonClicked(this.game)) {
            switch (type) {
                case START:
                    this.game.gameStarted = true;
                    break;
                case EXIT:
                    System.exit(0);
                    break;
            }
        }
    }

    private boolean buttonClicked(Game g) {
        Point mp = g.getMousePosition();
        hasFocus = getBounds().contains(mp);
        isPressed = hasFocus && g.isMousePressed();
        return isPressed;
    }

    private Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
