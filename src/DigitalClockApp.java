import java.time.format.DateTimeFormatter
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.time.LocalTime;

public class DigitalClockApp extends Application {
    private Label timeLabel;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Digital Clock");

        timeLabel = new Label();
        timeLabel.setStyle("-fx-font-size: 24px;");

        StackPane root = new StackPane(timeLabel);
        Scene scene = new Scene(root, 200, 100);
        primaryStage.setScene(scene);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> updateTime()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        primaryStage.show();
    }

    private void updateTime() {
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = currentTime.format(formatter);
        timeLabel.setText(formattedTime);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
