import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Block {
    private int x, y, width = 128, height = 64;
    private BufferedImage image;

    public Block(int x, int y, String imagePath) {
        this.x = x;
        this.y = y;
        loadImage(imagePath);
    }

    private void loadImage(String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void draw(Graphics g) {
        g.drawImage(image, x, y, width, height, null);
    }
}