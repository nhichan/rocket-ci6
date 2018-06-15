package game.effect;

import base.FrameCounter;
import base.GameObject;
import base.Vector2D;
import renderer.ImageRenderer;

public class Explosion extends GameObject {

    public Vector2D velocity;
    private FrameCounter frameCounter = new FrameCounter(2);
    private int increaseCounter = 0;

    public Explosion() {
        this.velocity = new Vector2D();
    }

    @Override
    public void run() {
        super.run();
        this.position.subtractBy(this.velocity);
        if (!this.frameCounter.run()) return;
        ImageRenderer imageRenderer = (ImageRenderer) this.renderer;
        if (imageRenderer != null) {
            imageRenderer.width += 1;
            imageRenderer.height += 1;
            increaseCounter++;
            if (increaseCounter == 30) {
                this.isAlive = false;
            }
        }
        this.frameCounter.reset();
    }
}
