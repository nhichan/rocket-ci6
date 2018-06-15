package game.player;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.bullet.Bullet;
import game.effect.Explosion;
import game.effect.ShieldEffect;
import game.effect.Smoke;
import game.enemy.Enemy;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;
import renderer.PolygonRenderer;

import java.awt.*;

public class Player extends GameObject implements PhysicBody {
    public PlayerMove playerMove;
    public PlayerShoot playerShoot;
    public BoxCollider boxCollider;
    private RunHitObject runHitObject;
    private FrameCounter frameCounter = new FrameCounter(10);

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
        this.runHitObject = new RunHitObject(
                Enemy.class
        );

        this.boxCollider = new BoxCollider(20, 20);
    }

    @Override
    public void run() {
        super.run();
        this.playerMove.run(this);
        this.playerShoot.run(this);
        this.boxCollider.position.set(this.position.x - 10, this.position.y - 10);
        ((PolygonRenderer) this.renderer).angle = this.playerMove.angle;
        this.createSmoke();
        this.runHitObject.run(this);
    }

    private void createSmoke() {
        if (this.frameCounter.run()) {
            Smoke smoke = GameObjectManager.instance.recycle(Smoke.class);
            smoke.renderer = new ImageRenderer("resources/images/circle.png", 15, 15, Color.CYAN);
            smoke.position.set(position);

            Vector2D rotate = this.playerMove.velocity.add(
                    (new Vector2D(1.5f, 0)).rotate(this.playerMove.angle)
            );

            smoke.velocity.set(rotate);
            this.frameCounter.reset();
        }
    }

    @Override
    public void getHit(GameObject gameObject) {
        Explosion exp3 = GameObjectManager.instance.recycle(Explosion.class);
        exp3.renderer = new ImageRenderer("resources/images/circle.png", 60, 60, Color.YELLOW);
        exp3.position.set(position);
        Explosion exp2 = GameObjectManager.instance.recycle(Explosion.class);
        exp2.renderer = new ImageRenderer("resources/images/circle.png", 40, 40, Color.ORANGE);
        exp2.position.set(position);
        Explosion exp1 = GameObjectManager.instance.recycle(Explosion.class);
        exp1.renderer = new ImageRenderer("resources/images/circle.png", 20, 20, Color.PINK);
        exp1.position.set(position);
        this.isAlive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
