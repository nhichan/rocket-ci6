import base.GameObjectManager;
import game.background.Background;
import game.enemy.EnemySpawner;
import game.player.Player;
import game.star.StarSpawner;
import input.KeyboardInput;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {
    BufferedImage backBuffered;
    Graphics graphics;

    public Player player;

    public GameCanvas() {
        this.setSize(1024, 600);
        this.setupBackBuffered();
        this.setupCharacter();

        this.setVisible(true);
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupCharacter() {
        GameObjectManager.instance.add(new Background());
        this.setupPlayer();
        GameObjectManager.instance.add(new StarSpawner());
        GameObjectManager.instance.add(new EnemySpawner());
    }

    private void setupPlayer() {
        this.player = new Player();
        this.player.position.set(500, 300);
        this.player.playerMove.velocity.set(4, 0);
        GameObjectManager.instance.add(this.player);
    }

    @Override
    protected void paintComponent(Graphics g) {
        // lat backbuffered
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        GameObjectManager.instance.renderAll(this.graphics);
        this.repaint();
    }

    public void runAll() {
        GameObjectManager.instance.runAll();
        KeyboardInput.instance.reset();
    }
}
