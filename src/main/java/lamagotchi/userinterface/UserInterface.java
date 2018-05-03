package lamagotchi.userinterface;

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import lamagotchi.domain.LamagotchiService;
/**
 * Luokka vastaa käyttöliittymästä
 * @author piikkila
 */
public class UserInterface extends Application {

  // private Lamagotchi activeLama;
    private LamagotchiService activeLama;
    private Scene gameScene;
    private Scene loginScene;
    private Scene newUserScene;

    @Override
    public void start(Stage stage) {
        this.activeLama = new LamagotchiService();
        this.activeLama.createNewLama("Lama");
        
        
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

        ProgressBar energy = new ProgressBar(0);
        ProgressBar cleanliness = new ProgressBar(0);
        ProgressBar happiness = new ProgressBar(activeLama.getHappiness());
        ProgressBar hunger = new ProgressBar(0);

        HBox progressBars = new HBox();
        progressBars.getChildren().add(energy);
        progressBars.getChildren().add(cleanliness);
        progressBars.getChildren().add(happiness);
        progressBars.getChildren().add(hunger);

        feed.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                hunger.setProgress(1);
                activeLama.feedLama();
            }
        });

        play.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                happiness.setProgress(activeLama.getHappiness()+0.5);
                activeLama.playWithLama();

            }
        });

        sleep.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                energy.setProgress(0.5);
                activeLama.sleepLama();

            }
        });
        wash.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cleanliness.setProgress(1);
                activeLama.washLama();

            }
        });

        Canvas canvas = new Canvas(300, 300);
        GraphicsContext drawing = canvas.getGraphicsContext2D();
        Image lamaRight = new Image("File:/home/piikkila/Desktop/otm-harjoitustyo/src/main/java/lamaright.png");
        Image lamaLeft = new Image("File:/home/piikkila/Desktop/otm-harjoitustyo/src/main/java/lamaleft.png");
        drawing.drawImage(lamaRight, 20, 20);

        final long startNanoTime = System.nanoTime();

        AnimatedImage animatedLama = new AnimatedImage();
        Image[] imageArray = new Image[2];
        imageArray[0] = lamaLeft;
        imageArray[1] = lamaRight;
        animatedLama.frames = imageArray;
        animatedLama.duration = 1.00;

        new AnimationTimer() {
            long previous = 0;

            @Override
            public void handle(long currentNanoTime) {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;

                drawing.drawImage(animatedLama.getFrame(t), 20, 20);

            }

        }.start();

        BorderPane setup = new BorderPane();
        setup.setCenter(canvas);
        setup.setBottom(buttons);
        setup.setTop(progressBars);

        this.gameScene = new Scene(setup);

        stage.setScene(this.gameScene);
        stage.show();
    }

    public class AnimatedImage {

        public Image[] frames;
        public double duration;

        public Image getFrame(double time) {
            int index = (int) ((time % (frames.length * duration)) / duration);
            return frames[index];
        }
    }

    public void main(String[] args) {
        launch(UserInterface.class);
    }

}
