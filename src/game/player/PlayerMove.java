package game.player;

import base.Vector2D;
import input.KeyboardInput;

import java.util.Random;

public class PlayerMove {

    public Vector2D velocity;
    private Random random;
    private Vector2D NORMAL = new Vector2D(3.5f, 0);
    private Vector2D HIGH = new Vector2D(10, 0);
    public double angle = 0.0;

    public PlayerMove() {
        this.random = new Random();
        this.velocity = new Vector2D();
    }

    public void run(Player player) {

        Vector2D velocity = NORMAL.copy();
        if (KeyboardInput.instance.leftPressed) {
            this.angle += 5.0;
        }
        if (KeyboardInput.instance.rightPressed) {
            this.angle -= 5.0;
        }
        if (KeyboardInput.instance.upPressed) {
            velocity = HIGH.copy();
        }
        if (KeyboardInput.instance.upReleased) {
            velocity = NORMAL.copy();
        }

        Vector2D rotate = velocity.rotate(angle);
        this.velocity.set(rotate);

        player.position.addUp(this.velocity);
        this.backToScreen(player);
    }

    private void backToScreen(Player player) {
        if (player.position.x > 1024) {
            player.position.set(0, this.random.nextInt(600));
        }
        if (player.position.x < 0) {
            player.position.set(1024, this.random.nextInt(600));
        }
        if (player.position.y > 600) {
            player.position.set(this.random.nextInt(1024), 0);
        }
        if (player.position.y < 0) {
            player.position.set(this.random.nextInt(1024), 600);
        }
    }
}
