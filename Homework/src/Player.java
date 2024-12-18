import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {
    private int x, y, width = 200, height = 40;
    private BufferedImage image;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        loadImage();
    }

    private void loadImage() {
        try {
            image = ImageIO.read(new File("data/player.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void moveLeft() {
        if (x > 0) x -= 15;
    }

    public void moveRight() {
        if (x < 1280 - width) x += 15;
    }

    public void update(boolean leftPressed, boolean rightPressed) {
        if (leftPressed) {
            moveLeft();
        }
        if (rightPressed) {
            moveRight();
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void draw(Graphics g) {
        g.drawImage(image, x, y, width, height, null);
    }
}