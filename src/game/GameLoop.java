package game;

public class GameLoop implements Runnable {
    public static final int UPDATES_PER_SECOND = 60;

    private final Game game;
    private final GamePanel gp;
    private Thread gameThread;

    int drawCount = 0;

    public GameLoop(Game game, GamePanel gp) {
        this.gp = gp;
        this.game = game;
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        long currentTime;
        double drawInterval = (double) 1000000000/UPDATES_PER_SECOND;
        double nextDrawTime = System.nanoTime() + drawInterval;
        long timer = 0;

        while(gameThread != null) {

            // adding timer and displaying FPS
            currentTime = System.nanoTime();
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            // 1 UPDATE
            game.update();

            // 2 DRAW
            gp.repaint();
            drawCount++;

            try{
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if (remainingTime < 0) remainingTime = 0;

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                System.out.println("Game thread interrupted: " + e.getMessage());
            }

            if (timer >= 1000000000) {
                game.fps = drawCount;
                drawCount = 0;
                timer = 0;
            }
        }
    }
}
