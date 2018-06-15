package game.player;

import base.GameObjectManager;
import base.Vector2D;
import game.bullet.Bullet;

public class TripleShoot implements Shoot {
    @Override
    public void shoot(Player player) {
        for (double alpha = 0.0; alpha <= 360.0; alpha += 120.0) {
            Bullet bulletPlayer = new Bullet();
            bulletPlayer.position.set(player.position);

            Vector2D rotate = player.playerMove.velocity.add(
                    (new Vector2D(2, 0)).rotate(player.playerMove.angle)
            ).rotate(alpha);

            bulletPlayer.velocity.set(rotate);
            GameObjectManager.instance.add(bulletPlayer);
        }
    }
}
