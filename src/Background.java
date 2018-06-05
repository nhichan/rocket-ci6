import java.awt.*;

public class Background {
    public Vector2D position;
    public Renderer renderer;


    public Background() {
        this.position = new Vector2D();
        this.renderer = new BackgroundRenderer(1024, 600, Color.BLACK);
    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
    }
}
