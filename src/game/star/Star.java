package game.star;

import base.GameObject;
import base.Vector2D;
import renderer.ImageRenderer;

import java.awt.*;

public class Star extends GameObject {
    public Vector2D velocity;

    public Star() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/star.png", 5, 5, Color.WHITE);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
    }

}
