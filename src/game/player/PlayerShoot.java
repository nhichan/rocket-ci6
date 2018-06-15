package game.player;

import base.FrameCounter;
import base.GameObjectManager;
import base.Vector2D;
import game.bullet.Bullet;
import input.KeyboardInput;

public class PlayerShoot {
    private FrameCounter frameCounter;
    public Shoot shoot;
    public SingleShoot singleShoot;
    public TripleShoot tripleShoot;

    public PlayerShoot() {
        this.frameCounter = new FrameCounter(20);
        this.tripleShoot = new TripleShoot();
        this.shoot = this.tripleShoot;
    }

    public void run(Player player) {
        if (KeyboardInput.instance.spacePressed) {
            if (this.frameCounter.run()) {
                this.shoot.shoot(player);
                this.frameCounter.reset();
            }
        }

    }
}
