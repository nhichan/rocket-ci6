import java.util.Random;

public class PlayerMove {

    public Vector2D velocity;
    private Random random;
    public double angle = 0.0;

    public PlayerMove() {
        this.random = new Random();
        this.velocity = new Vector2D();
    }

    public void run(Player player) {
        player.position.addUp(this.velocity);
        this.backToScreen(player);
    }

    private void backToScreen(Player player) {
        if (player.position.x > 1024) {
            player.position.set(0, this.random.nextInt(600));
        }
        if (player.position.x < 0) {
            player.position.set(1024, this.random.nextInt(600));
        }
        if (player.position.y > 600) {
            player.position.set(this.random.nextInt(1024), 0);
        }
        if (player.position.y < 0) {
            player.position.set(this.random.nextInt(1024), 600);
        }
    }
}
