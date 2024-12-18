import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class StartScreen extends JPanel {
    private BufferedImage backgroundImage;

    public StartScreen() {
        try {
            backgroundImage = ImageIO.read(new File("data/fon_start.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setPreferredSize(new Dimension(1280, 720));
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                openMainGame();
            }
        });
    }

    private void openMainGame() {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.dispose();

        JFrame gameFrame = new JFrame("Main Game");
        MainGame gamePanel = new MainGame();
        gameFrame.add(gamePanel);
        gameFrame.pack();
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
        }
    }
}
