package game.player;

import base.GameObjectManager;
import base.Vector2D;
import game.bullet.Bullet;

public class SingleShoot implements Shoot {
    @Override
    public void shoot(Player player) {
        // 1 duong dan
        Bullet bulletPlayer = new Bullet();
        bulletPlayer.position.set(player.position);

        Vector2D rotate = player.playerMove.velocity.add(
                (new Vector2D(2, 0)).rotate(player.playerMove.angle)
        );

        bulletPlayer.velocity.set(rotate);
        GameObjectManager.instance.add(bulletPlayer);
    }
}
