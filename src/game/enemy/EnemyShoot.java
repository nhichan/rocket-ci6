package game.enemy;

import base.FrameCounter;
import base.GameObjectManager;
import base.Vector2D;
import game.bullet.Bullet;

public class EnemyShoot {
    private FrameCounter frameCounter;

    public EnemyShoot() {
        this.frameCounter = new FrameCounter(50);
    }

    public void run(Enemy enemy) {
        // create bullet
        if (this.frameCounter.run()) {
//            for (double angle = 0.0; angle <= 360.0; angle += 15.0) {
//                Bullet bulletEnemy = new Bullet();
//                bulletEnemy.position.set(enemy.position);
//                bulletEnemy.velocity.set((new Vector2D(3, 0)).rotate(angle));
//                GameObjectManager.instance.add(bulletEnemy);
//            }
            this.frameCounter.reset();
        }


    }
}
