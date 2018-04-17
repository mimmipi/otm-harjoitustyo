package userinterface;


import javafx.animation.AnimationTimer;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class UserInterface extends Application {


    @Override
    public void start(Stage stage) {
        stage.setTitle("Lamagotchi");
        Button feed = new Button("Syötä");
        Button sleep = new Button("Nuku");
        Button play = new Button("Leiki");
        Button wash = new Button("Pese");

        HBox buttons = new HBox();
        buttons.setSpacing(32);
        buttons.getChildren().add(feed);
        buttons.getChildren().add(sleep);
        buttons.getChildren().add(play);
        buttons.getChildren().add(wash);

        ProgressBar energy = new ProgressBar(0.8);
        ProgressBar cleanliness = new ProgressBar(0.3);
        ProgressBar happiness = new ProgressBar(0.1);
        ProgressBar hunger = new ProgressBar(0.5);

        HBox progressBars = new HBox();
        progressBars.getChildren().add(energy);
        progressBars.getChildren().add(cleanliness);
        progressBars.getChildren().add(happiness);
        progressBars.getChildren().add(hunger);

        feed.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                hunger.setProgress(1);

            }
        });

        play.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                happiness.setProgress(1);

            }
        });

        sleep.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                energy.setProgress(1);

            }
        });
        wash.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cleanliness.setProgress(1);

            }
        });

        Canvas canvas = new Canvas(300, 300);
        GraphicsContext drawing = canvas.getGraphicsContext2D();
        drawing.setFill(Color.AQUA);
        drawing.fillOval(90, 90, 120, 120);
        drawing.setFill(Color.BLACK);
        drawing.fillOval(110, 120, 20, 20);
        drawing.fillOval(140, 120, 20, 20);
        
//        Timeline timeline = new Timeline(
//        new Keyframe(Duration.seconds(3), new KeyValue())
//        );
//
//        new AnimationTimer() {
//            long previous = 0;
//
//            @Override
//            public void handle(long now) {
//                if (now - previous < 100000000) {
//                    return;
//                }
//
//                drawing.fillOval(150, 120, 20, 20);
//                drawing.fillOval(180, 120, 20, 20);
//                this.previous = now;
//            }
//
//        }.start();

        BorderPane setup = new BorderPane();
        setup.setCenter(canvas);
        setup.setBottom(buttons);
        setup.setTop(progressBars);

        Scene scene = new Scene(setup);

        stage.setScene(scene);
        stage.show();
    }

    public void main(String[] args) {
        launch(UserInterface.class);
    }

}
