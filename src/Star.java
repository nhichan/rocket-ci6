import java.awt.*;
import java.lang.annotation.Inherited;

public class Star extends GameObject {
    public Vector2D velocity;
    public Star() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/star.png", 5, 5);
    }

    @Override
    public void run() {
        this.position.addUp(this.velocity);
    }

    @Override
    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
    }
}
