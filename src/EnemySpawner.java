import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemySpawner extends GameObject {

    private FrameCounter frameCounter;
    private Random random;
    public List<Enemy> enemies;

    public EnemySpawner() {
        this.enemies = new ArrayList<>();
        this.random = new Random();
        this.frameCounter = new FrameCounter(200);
    }

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run()) {
            // tao enemy
            Enemy enemy = new Enemy();
            enemy.position.set(this.random.nextInt(1024), this.random.nextInt(600));
            this.enemies.add(enemy);
            this.frameCounter.reset();
        }
        this.enemies.forEach(enemy -> enemy.run());
    }
}
