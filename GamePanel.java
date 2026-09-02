import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel implements Runnable {

    // Screen Settings
    private final int originalTileSize = 16; // 16x16 pixels
    private final int scale = 3;             // Scale up for modern monitors
    private final int tileSize = originalTileSize * scale; // 48x48 pixel tiles
    
    private final int maxScreenCol = 16;
    private final int maxScreenRow = 12;
    private final int screenWidth = tileSize * maxScreenCol;   // 768 pixels
    private final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    // Game Core
    private Thread gameThread;
    private final int FPS = 60;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); // Improves rendering performance
        this.setFocusable(true);      // Allows the panel to receive key inputs
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start(); // Implicitly calls the run() method below
    }

    @Override
    public void run() {
        // Core game loop time intervals
        double drawInterval = 1000000000.0 / FPS; 
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                // 1: Update game variables (e.g., player position)
                update();
                // 2: Draw the screen with the updated data
                repaint(); 
                delta--;
            }
        }
    }

    private void update() {
        // Insert game update logic here (e.g., mechanics, inputs)
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Visual Placeholder: Draw a test white box
        g2.setColor(Color.WHITE);
        g2.fillRect(100, 100, tileSize, tileSize);

        g2.dispose(); // Housekeeping to save system memory
    }
}
