package lamagotchi.userinterface;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Properties;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import lamagotchi.dao.FileUserDao;
import lamagotchi.domain.LamagotchiService;

/**
 * Luokka vastaa käyttöliittymästä
 *
 * @author piikkila
 */
public class UserInterface extends Application {

    // private Lamagotchi activeLama;
    private LamagotchiService activeLama;
    private Scene gameScene;
    private Scene loginScene;
    private Scene newUserScene;
    private Scene endScene;
    private Scene newLamagotchiScene;

    private Label menuLabel = new Label();

    /**
     * Metodi alustaa käyttöliittymäluokan luomalla sen käyttämiä olioita
     *
     * @throws Exception
     */
    @Override
    public void init() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("config.properties"));

        String userFile = properties.getProperty("userFile");

        FileUserDao userDao = new FileUserDao(userFile);
        this.activeLama = new LamagotchiService(userDao);
        this.activeLama.createNewLama("Lama");

    }

    /**
     * Metodi toimii pääkäyttöliittymänä, jossa kirjaudutaan sisään, luodaan
     * uusi käyttäjä ja hallinnoidaan peliä
     *
     * @param stage
     */
    @Override
    public void start(Stage stage) {

        //login scene
        VBox loginPane = new VBox(10);
        HBox loginInputPane = new HBox(10);
        HBox passwordInputPane = new HBox(10);
        loginPane.setPadding(new Insets(10));
        Label loginLabel = new Label("username");
        TextField usernameInput = new TextField();

        Label password = new Label("password");
        TextField passwordInput = new TextField();

        loginInputPane.getChildren().addAll(loginLabel, usernameInput);
        passwordInputPane.getChildren().addAll(password, passwordInput);
        Label loginMessage = new Label();

        Button loginButton = new Button("login");
        Button createButton = new Button("new user");
        loginButton.setOnAction(e -> {
            String name = usernameInput.getText();
            String pw = passwordInput.getText();
            menuLabel.setText(name + " logged in...");

            if (activeLama.login(name, pw)) {
                loginMessage.setText("");
                stage.setScene(gameScene);
                usernameInput.setText("");
                passwordInput.setText("");
            } else {
                loginMessage.setText("user or password wrong");
            }
        });

        loginPane.getChildren().addAll(loginMessage, loginInputPane, passwordInputPane, loginButton, createButton);
        loginScene = new Scene(loginPane, 300, 250);

        createButton.setOnAction(e -> {
            usernameInput.setText("");
            stage.setScene(newUserScene);
        });

        //new user scene
        VBox newUserPane = new VBox(10);
        HBox newUsernamePane = new HBox(10);
        newUsernamePane.setPadding(new Insets(10));
        TextField newUsernameInput = new TextField();
        Label newUsernameLabel = new Label("name");
        newUsernameLabel.setPrefWidth(100);
        newUsernamePane.getChildren().addAll(newUsernameLabel, newUsernameInput);

        HBox newpasswordPane = new HBox(10);
        newpasswordPane.setPadding(new Insets(10));
        TextField newPasswordInput = new TextField();
        Label newPasswordLabel = new Label("password");
        newPasswordLabel.setPrefWidth(100);
        newpasswordPane.getChildren().addAll(newPasswordLabel, newPasswordInput);

        Label userCreationMessage = new Label();

        Button createNewUserButton = new Button("create");
        createNewUserButton.setPadding(new Insets(10));

        createNewUserButton.setOnAction(e -> {
            String name = newUsernameInput.getText();
            String pw = newPasswordInput.getText();

            if (name.length() < 3) {
                userCreationMessage.setText("  name too short");
                userCreationMessage.setTextFill(Color.RED);
            } else if (activeLama.createNewUser(name, pw)) {
                userCreationMessage.setText("new user created!");
                loginMessage.setText("new user created");
                loginMessage.setTextFill(Color.GREEN);
                newUsernameInput.setText("");
                newPasswordInput.setText("");
                stage.setScene(loginScene);
            } else {
                userCreationMessage.setText("username has to be unique");
                userCreationMessage.setTextFill(Color.RED);
            }

        });

        newUserPane.getChildren().addAll(userCreationMessage, newUsernamePane, newpasswordPane, createNewUserButton);
        newUserScene = new Scene(newUserPane, 300, 300);

        // game scene 
        stage.setTitle("Lamagotchi");
        Button feed = new Button("Syötä");
        Button sleep = new Button("Nuku");
        Button play = new Button("Leiki");
        Button wash = new Button("Pese");

        HBox buttons = new HBox();
        buttons.setSpacing(65);
        buttons.getChildren().add(feed);
        buttons.getChildren().add(play);
        buttons.getChildren().add(sleep);
        buttons.getChildren().add(wash);

        ProgressBar hunger = new ProgressBar(0);
        ProgressBar happiness = new ProgressBar(0);
        ProgressBar energy = new ProgressBar(0);
        ProgressBar cleanliness = new ProgressBar(0);

        HBox progressBars = new HBox();
        progressBars.getChildren().add(hunger);
        progressBars.getChildren().add(happiness);
        progressBars.getChildren().add(energy);
        progressBars.getChildren().add(cleanliness);

        Label nameLabel = new Label(activeLama.getName());

        Label ageLabel = new Label(Double.toString(activeLama.getAge()));

        feed.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                activeLama.feedLama();
                hunger.setProgress(activeLama.getHunger());
            }
        });

        play.setOnAction(new EventHandler<ActionEvent>() {
            @Override

            public void handle(ActionEvent event) {
                activeLama.playWithLama();
                happiness.setProgress(activeLama.getHappiness());

            }
        });

        sleep.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                activeLama.sleepLama();
                energy.setProgress(activeLama.getEnergy());

            }
        });
        wash.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                activeLama.washLama();
                cleanliness.setProgress(activeLama.getDirty());

            }
        });

        Canvas canvas = new Canvas(300, 270);
        GraphicsContext drawing = canvas.getGraphicsContext2D();
        Image lamaRight = new Image("File:/home/piikkila/Desktop/otm-harjoitustyo/src/main/java/lamagotchi/userinterface/lamaright.png");
        Image lamaLeft = new Image("File:/home/piikkila/Desktop/otm-harjoitustyo/src/main/java/lamagotchi/userinterface/lamaleft.png");
        drawing.drawImage(lamaRight, 60, 20);

        final long startNanoTime = System.nanoTime();

        AnimatedImage animatedLama = new AnimatedImage();
        Image[] imageArray = new Image[2];
        imageArray[0] = lamaLeft;
        imageArray[1] = lamaRight;
        animatedLama.frames = imageArray;
        animatedLama.duration = 1.00;

        Label lamasThoughts = new Label("Kaikki on hyvin :)");
        lamasThoughts.setPadding(new Insets(15));

        new AnimationTimer() {
            long previous = 0;

            @Override
            public void handle(long currentNanoTime) {
                double t = (currentNanoTime - startNanoTime) / 10000000000.0;

                drawing.drawImage(animatedLama.getFrame(t), 60, 20);
                activeLama.timePasses();
                cleanliness.setProgress(activeLama.getDirty());
                energy.setProgress(activeLama.getEnergy());
                hunger.setProgress(activeLama.getHunger());
                happiness.setProgress(activeLama.getHappiness());
                ageLabel.setText(Double.toString((int) activeLama.getAge()));

                if (activeLama.getHappiness() < 0.01) {
                    lamasThoughts.setText("Onpa tylsää :(. Leikitäänkö?");
                } else if (activeLama.getHunger() < 0.5 && activeLama.getHunger() > 0.2) {
                    lamasThoughts.setText("Nälkä! Anna ruokaa!");
                } else if (activeLama.getHunger() < 0.2) {
                    lamasThoughts.setText("Kuolen pian nälkään ;__;");
                } else if (activeLama.getEnergy() < 0.2) {
                    lamasThoughts.setText("Väsyttää, voisin nukkua vuoden...");
                } else if (activeLama.getDirty() < 0.1) {
                    lamasThoughts.setText("Täällä haisee. Olenko se minä?");
                } else {
                    lamasThoughts.setText("");
                }

                if (activeLama.getHunger() < 0.001) {

                    stage.setScene(endScene);
                }
            }

        }.start();

        VBox centerPane = new VBox(10);
        centerPane.setPadding(new Insets(10));
        centerPane.getChildren().addAll(canvas, lamasThoughts, nameLabel, ageLabel);

        BorderPane setup = new BorderPane();
        setup.setCenter(centerPane);
        setup.setBottom(buttons);
        setup.setTop(progressBars);

        this.gameScene = new Scene(setup);

        // end scene
        VBox endBox = new VBox(10);
        Label endMessage = new Label("Lamagotchisi menehtyi. Pidä siitä parempaa huolta ensi kerralla!");
        endMessage.setPadding(new Insets(50));
        endBox.getChildren().add(endMessage);
        this.endScene = new Scene(endBox);

        stage.setScene(loginScene);

        stage.show();
    }

    /**
     * Metodi toimii pelianimaation taustametodina
     */
    public class AnimatedImage {

        public Image[] frames;
        public double duration;

        public Image getFrame(double time) {
            int index = (int) ((time % (frames.length * duration)) / duration);
            return frames[index];
        }
    }

    /**
     * Ohjelman käynnistävä main-metodi
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

}
