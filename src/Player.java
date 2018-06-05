import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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
    }

    @Override
    public void run() {
        this.playerMove.run(this);
        this.playerShoot.run(this);
        this.playerShoot.bulletPlayers.forEach(bullet -> bullet.run());
        ((PolygonRenderer) this.renderer).angle = this.playerMove.angle;
    }

    @Override
    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
        this.playerShoot.bulletPlayers.forEach(bullet -> bullet.render(graphics));
    }
}
