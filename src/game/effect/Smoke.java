package game.effect;

import base.FrameCounter;
import base.GameObject;
import base.Vector2D;
import renderer.ImageRenderer;

import java.awt.*;

public class Smoke extends GameObject {

    public Vector2D velocity;
    private FrameCounter frameCounter = new FrameCounter(2);

    public Smoke() {
        this.velocity = new Vector2D();
    }

    @Override
    public void run() {
        super.run();
        this.position.subtractBy(this.velocity);
        if (!this.frameCounter.run()) return;
        ImageRenderer imageRenderer = (ImageRenderer) this.renderer;
        if (imageRenderer != null) {
            imageRenderer.width -= 1;
            imageRenderer.height -= 1;
            if (imageRenderer.width == 0 || imageRenderer.height == 0) {
                this.isAlive = false;
            }
        }
        this.frameCounter.reset();
    }
}
