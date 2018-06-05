import java.util.ArrayList;
import java.util.List;

public class EnemyShoot {
    public List<Bullet> bulletEnemies;

    private int count = 0;

    public EnemyShoot() {
        this.bulletEnemies = new ArrayList<>();
    }

    public void run(Enemy enemy) {
        // create bullet
        if (this.count == 50) {
            for (double angle = 0.0; angle <= 360.0; angle += 15.0) {
                Bullet bulletEnemy = new Bullet();
                bulletEnemy.position.set(enemy.position);
                bulletEnemy.velocity.set((new Vector2D(3, 0)).rotate(angle));
                this.bulletEnemies.add(bulletEnemy);
            }
            this.count = 0;
        }  else {
            this.count += 1;
        }


    }
}
