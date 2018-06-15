package game.enemy;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class EnemySpawner extends GameObject {

    private FrameCounter frameCounter;
    private Random random;

    public EnemySpawner() {
        this.random = new Random();
        this.frameCounter = new FrameCounter(200);
    }

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run()) {
            Enemy enemy = GameObjectManager.instance.recycle(Enemy.class);
            enemy.position.set(this.random.nextInt(1024), this.random.nextInt(600));
            this.frameCounter.reset();
        }
    }
}
