package game.ui;

import game.Game;
import game.GamePanel;

import java.awt.*;
import java.util.ArrayList;

public class TitleMenu {
    ArrayList<UI> titleMenu = new ArrayList<>();

    public TitleMenu(GamePanel gp, Game g) {
        titleMenu.add(new TitleCloud(CloudType.ONE, gp.SCREEN_WIDTH/10, gp.SCREEN_HEIGHT/7, (int) (gp.tileSize*4.5), (int) (gp.tileSize*1.5)));
        titleMenu.add(new TitleCloud(CloudType.TWO, gp.SCREEN_WIDTH*7/10, gp.SCREEN_HEIGHT/3, (int) (gp.tileSize*4.5), (int) (gp.tileSize*1.5)));
        titleMenu.add(new TitleCloud(CloudType.THREE, gp.SCREEN_WIDTH*4/10, gp.SCREEN_HEIGHT*7/10, gp.tileSize*6, (int)(gp.tileSize * 1.5)));
        titleMenu.add(new TitleCloud(CloudType.FOUR, gp.SCREEN_WIDTH*3/10, gp.SCREEN_HEIGHT*4/5, (int) (gp.tileSize*4.5), (int) (gp.tileSize*1.5)));
        titleMenu.add(new Title(gp.tileSize*8, gp.tileSize*6));
        titleMenu.add(new Button(ButtonType.START, (gp.tileSize*4), gp.tileSize*3, g));
        titleMenu.add(new Button(ButtonType.EXIT, gp.tileSize*4, gp.tileSize*3, g));
    }

    // draw the Title Menu
    public void draw(Graphics2D g2) {
        for (UI item : titleMenu) {
            g2.drawImage(item.image, item.x, item.y, item.width, item.height, null);
        }
    }

    public void update() {
        for (UI item : titleMenu) {
            item.update();
        }
    }
}
