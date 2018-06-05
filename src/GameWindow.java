import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {

    GameCanvas gameCanvas;
    public long lastTime = 0;

    public GameWindow() {
        this.setSize(1024, 600); // set size window

        this.setupGameCanvas();
        this.event();

        this.setVisible(true);
    }

    private void setupGameCanvas() {
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
    }

    private void event() {
        this.keyboardEvent();
        this.windowEvent();
    }

    private void keyboardEvent() {
        this.addKeyListener(new KeyListener() {

            private Vector2D NORMAL = new Vector2D(3.5f, 0);
            private Vector2D HIGH = new Vector2D(10, 0);

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                Vector2D velocity = NORMAL.copy();
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    gameCanvas.player.playerMove.angle += 5.0;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    gameCanvas.player.playerMove.angle -= 5.0;
                }

                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    velocity = HIGH.copy();
                }

                Vector2D rotate = velocity.rotate(gameCanvas.player.playerMove.angle);
                gameCanvas.player.playerMove.velocity.set(rotate);

            }

            @Override
            public void keyReleased(KeyEvent e) {
                Vector2D velocity = NORMAL.copy();
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    velocity = NORMAL.copy();
                }
                Vector2D rotate = velocity.rotate(gameCanvas.player.playerMove.angle);
                gameCanvas.player.playerMove.velocity.set(rotate);
            }
        });
    }

    private void windowEvent() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }

    public void gameLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - this.lastTime >= 17_000_000) {
                this.gameCanvas.runAll();
                this.gameCanvas.renderAll();
                this.lastTime = currentTime;
            }

        }
    }

}
