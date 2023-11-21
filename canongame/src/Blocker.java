import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Blocker {
    private double x, y, speed;
    private double width, height;
    private Image image;

    public Blocker(double x, double y, double speed, Image image) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.image = image;
    }

    public void move() {
        y += speed;

        if (y <= 0 || y >= CannonGame.CANVAS_HEIGHT - height) {
            speed = -speed;
        }
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(image, x, y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}