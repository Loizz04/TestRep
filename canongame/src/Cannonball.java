import javafx.geometry.Bounds;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Cannonball {

    private static final double SPEED = 10.0; // adjust as needed
    private static final double SIZE = 20.0; // adjust as needed
    private static final Image IMAGE = new Image("path/to/cannonball.png"); // replace with actual image

    private double x;
    private double y;
    private double angle;
    private double dx;
    private double dy;
    private boolean isMoving;

    public Cannonball(double x, double y, double angle) {
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.dx = SPEED * Math.cos(Math.toRadians(angle));
        this.dy = -SPEED * Math.sin(Math.toRadians(angle));
        this.isMoving = true;
    }

    public void move() {
        if (isMoving) {
            x += dx;
            y += dy;
        }
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(IMAGE, x, y, SIZE, SIZE);
    }

    public Bounds getBounds() {
        return IMAGE.getBoundsInLocal().interpolate(x, y, 1, 1);
    }

    public void stop() {
        isMoving = false;
    }

    public boolean isMoving() {
        return isMoving;
    }

}