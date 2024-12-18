import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MainGame extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private Ball ball;
    private Player player;
    private ArrayList<Block> blocks;
    private int score = 0;
    public int lives = 3;
    private BufferedImage backgroundImage;
    private long startTime;

    private boolean leftPressed = false;
    private boolean rightPressed = false;

    public MainGame() {
        setPreferredSize(new Dimension(1280, 720));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        timer = new Timer(50, this);
        timer.start();

        ball = new Ball(620, 600, this);
        player = new Player(512, 680);
        blocks = new ArrayList<>();
        initializeBlocks();
        loadBackgroundImage();

        startTime = System.currentTimeMillis();
    }

    private void loadBackgroundImage() {
        try {
            backgroundImage = ImageIO.read(new File("data/fon.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeBlocks() {
        for (int i = 0; i < 1280; i += 128) {
            blocks.add(new Block(i, 0, "data/block_green.png"));
            blocks.add(new Block(i, 64, "data/block_red.png"));
            blocks.add(new Block(i, 128, "data/block_blue.png"));
        }
    }

    public void actionPerformed(ActionEvent e) {
        ball.move();
        player.update(leftPressed, rightPressed);
        checkCollisions();
        repaint();
    }

    private void checkCollisions() {
        for (Block block : blocks) {
            if (ball.getBounds().intersects(block.getBounds())) {
                blocks.remove(block);
                ball.reverseY();
                score += 10;
                break;
            }
        }

        if (ball.getBounds().intersects(player.getBounds())) {
            ball.reverseY();
        }

        if (blocks.isEmpty()) {
            winGame();
        }
    }

    public void endGame() {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.dispose();

        JFrame gameOverFrame = new JFrame("Game Over");
        JPanel panel = new JPanel() {
            private BufferedImage backgroundImage;

            {
                try {
                    backgroundImage = ImageIO.read(new File("data/fon_end.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
                }
                g.setColor(Color.WHITE);
                g.drawString("Score: " + score, 640, 660);
                long elapsedTime = System.currentTimeMillis() - startTime;
                long seconds = (elapsedTime / 1000) % 60;
                long minutes = (elapsedTime / 1000) / 60;
                g.drawString(String.format("Time: %02d:%02d", minutes, seconds), 640, 700);
            }
        };

        panel.setPreferredSize(new Dimension(1280, 720));
        gameOverFrame.add(panel);
        gameOverFrame.pack();
        gameOverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameOverFrame.setVisible(true);
    }

    private void winGame() {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.dispose();

        JFrame winFrame = new JFrame("You Win!");
        JPanel panel = new JPanel() {
            private BufferedImage backgroundImage;

            {
                try {
                    backgroundImage = ImageIO.read(new File("data/fon_win.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
                }
                g.setColor(Color.WHITE);
                g.drawString("Score: " + score, 640, 660);
                g.drawString("Lives: " + lives, 640, 680);

                long elapsedTime = System.currentTimeMillis() - startTime;
                long seconds = (elapsedTime / 1000) % 60;
                long minutes = (elapsedTime / 1000) / 60;
                g.drawString(String.format("Time: %02d:%02d", minutes, seconds), 640, 700);
            }
        };

        panel.setPreferredSize(new Dimension(1280, 720));
        winFrame.add(panel);
        winFrame.pack();
        winFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        winFrame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
        }
        ball.draw(g);
        player.draw(g);
        for (Block block : blocks) {
            block.draw(g);
        }
        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, 1170, 660);
        g.drawString("Lives: " + lives, 1170, 680);

        long elapsedTime = System.currentTimeMillis() - startTime;
        long seconds = (elapsedTime / 1000) % 60;
        long minutes = (elapsedTime / 1000) / 60;
        g.drawString(String.format("Time: %02d:%02d", minutes, seconds), 1170, 700);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Start Screen");
        StartScreen startScreen = new StartScreen();
        frame.add(startScreen);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}