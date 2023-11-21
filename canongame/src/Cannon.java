
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Cannon {
    private static final double ROTATE_SPEED = 3.0; // Degrees per frame
    private static final double BARREL_LENGTH = 40.0;
    private static final Image CANNON_IMAGE = new Image("cannon.png");
    private static final Image BARREL_IMAGE = new Image("cannon-barrel.png");

    private Point2D position; // Center point of the cannon
    private double angle; // Angle of the cannon barrel

    public Cannon(Point2D position) {
        this.position = position;
        this.angle = 0.0;
    }

    public void rotateLeft() {
        angle -= ROTATE_SPEED;
    }

    public void rotateRight() {
        angle += ROTATE_SPEED;
    }

    public void fire() {
        // TODO: Fire the cannon and create a new CannonBall object
    }

    public void draw(GraphicsContext gc) {
        // Draw the cannon base
        gc.drawImage(CANNON_IMAGE, position.getX() - CANNON_IMAGE.getWidth() / 2.0, position.getY() - CANNON_IMAGE.getHeight() / 2.0);

        // Draw the cannon barrel
        gc.save(); // Save the current graphics context state (translation, rotation, etc.)
        gc.translate(position.getX(), position.getY());
        gc.rotate(angle);

        // The barrel image is centered at the end of the cannon base
        gc.drawImage(BARREL_IMAGE, -BARREL_IMAGE.getWidth() / 2.0, -CANNON_IMAGE.getHeight() / 2.0 - BARREL_LENGTH);

        gc.restore(); // Restore the previous graphics context state
    }

    public Point2D getBarrelEnd() {
        // Calculate the end point of the cannon barrel based on the angle and length
        double x = position.getX() + BARREL_LENGTH * Math.sin(Math.toRadians(angle));
        double y = position.getY() - BARREL_LENGTH * Math.cos(Math.toRadians(angle));
        return new Point2D(x, y);
    }

    public double getAngle() {
        return angle;
    }
}
