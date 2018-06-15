package game.enemy;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;

import java.awt.*;

public class Enemy extends GameObject implements PhysicBody {

    public Vector2D velocity;
    public BoxCollider boxCollider;
    private EnemyShoot enemyShoot;

    public Enemy() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 20, 20, Color.YELLOW);
        this.enemyShoot = new EnemyShoot();
        this.boxCollider = new BoxCollider(20, 20);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.enemyShoot.run(this);
        this.boxCollider.position.set(this.position.x - 10, this.position.y - 10);
        Player player = GameObjectManager.instance.findPlayer();
        if (player != null) {
            this.velocity.set(
                    player.position
                            .subtract(this.position)
                            .normalize()
                            .multiply(2.0f)
            );
        }
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
