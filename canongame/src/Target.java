import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Target {
    private double x;
    private double y;
    private double speed;
    private Image image;
    private boolean destroyed;

    public Target(double x, double y, double speed, Image image) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.image = image;
        this.destroyed = false;
    }

    public void move() {
        y += speed;

        if (y <= 0 || y + image.getHeight() >= Constants.CANVAS_HEIGHT) {
            speed *= -1;
        }
    }

    public boolean isCollidingWith(Cannonball cannonball) {
        if (!destroyed && x < cannonball.getX() + Constants.CANNONBALL_SIZE &&
                x + image.getWidth() > cannonball.getX() &&
                y < cannonball.getY() + Constants.CANNONBALL_SIZE &&
                y + image.getHeight() > cannonball.getY()) {
            destroyed = true;
            return true;
        }
        return false;
    }

    public void draw(GraphicsContext gc) {
        if (!destroyed) {
            gc.drawImage(image, x, y);
        }
    }
}