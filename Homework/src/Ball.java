import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Ball {
    private int x, y, diameter = 30;
    private int dx = 12, dy = -12;
    private BufferedImage image;
    private MainGame mainGame;

    public Ball(int x, int y, MainGame mainGame) {
        this.x = x;
        this.y = y;
        this.mainGame = mainGame;
        loadImage();
    }

    private void loadImage() {
        try {
            image = ImageIO.read(new File("data/ball.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void move() {
        x += dx;
        y += dy;

        if (x < 0 || x > 1280 - diameter) {
            dx = -dx;
        }
        if (y < 0) {
            dy = -dy;
        }
        if (y > 720 - diameter) {
            y = 720 - diameter;
            dy = -dy;
            mainGame.lives--;
            if (mainGame.lives <= 0) {
                mainGame.endGame();
            }
        }
    }

    public void reverseY() {
        dy = -dy;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, diameter, diameter);
    }

    public void draw(Graphics g) {
        g.drawImage(image, x, y, diameter, diameter, null);
    }
}
