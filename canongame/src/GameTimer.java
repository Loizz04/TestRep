import javafx.animation.AnimationTimer;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class GameTimer {
    private final int MAX_TIME = 10; // Maximum game time in seconds
    private int remainingTime = MAX_TIME; // Remaining game time in seconds
    private AnimationTimer timer;
    private CannonGame game; // Reference to the main game instance
    
    public GameTimer(CannonGame game) {
        this.game = game;
        timer = new AnimationTimer() {
            private long startTime = System.nanoTime();
            
            @Override
            public void handle(long now) {
                // Calculate elapsed time since the timer started
                double elapsedTime = (now - startTime) / 1_000_000_000.0;
                startTime = now;
                
                // Update remaining game time
                remainingTime = Math.max(0, remainingTime - (int) elapsedTime);
                
                // Update timer display in the game
                game.updateTimerDisplay(remainingTime);
                
                // Check if the game has ended
                if (remainingTime == 0) {
                    stop();
                    endGame(false);
                }
            }
        };
    }
    
    public void start() {
        timer.start();
    }
    
    public void stop() {
        timer.stop();
    }
    
    public void addTimeBonus(int bonusSeconds) {
        remainingTime += bonusSeconds;
    }
    
    public void subtractTimePenalty(int penaltySeconds) {
        remainingTime = Math.max(0, remainingTime - penaltySeconds);
    }
    
    private void endGame(boolean won) {
        // Create and show the end-of-game dialog
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText(won ? "You won!" : "You lost.");
        alert.showAndWait();
        
        // Stop the game
        try {
			game.stop();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
