package game.player;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.Enemy;
import physic.BoxCollider;
import renderer.PolygonRenderer;

import javax.swing.*;
import java.awt.*;

public class Player extends GameObject {
    public PlayerMove playerMove;
    public PlayerShoot playerShoot;

    public Player() {
        this.position = new Vector2D();
        this.renderer = new PolygonRenderer(
                Color.RED,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.playerMove = new PlayerMove();
        this.playerShoot = new PlayerShoot();
        this.boxCollider = new BoxCollider(6, 6);
    }

    @Override
    public void run() {
        super.run();
        this.playerMove.run(this);
        this.playerShoot.run(this);
        ((PolygonRenderer) this.renderer).angle = this.playerMove.angle;

        this.boxCollider.position.set(this.position.x - 3, this.position.y - 3);
        Enemy enemy = GameObjectManager.instance.checkCollision(this);
        if (enemy != null) {
            System.out.println("player hit");
            JOptionPane.showMessageDialog(null, "You lose");
            System.exit(0);
        }
    }
}
