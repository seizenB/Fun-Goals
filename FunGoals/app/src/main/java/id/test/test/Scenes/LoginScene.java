package id.test.test.Scenes;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LoginScene {
    private Stage stage;
    private Scene scene;

    public LoginScene(Stage stage) {
        this.stage = stage;
        createScene();
    }

    public void createScene() {
        StackPane root = new StackPane();
        root.setId("root");

        VBox vBoxWrapper = new VBox();
        vBoxWrapper.setAlignment(Pos.CENTER);
        vBoxWrapper.setId("vBox-wrapper");

        VBox vBox = new VBox();
        vBox.setPrefWidth(406);
        vBox.setPrefHeight(446);
        vBox.setId("vBox");

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        VBox startedWrapper = new VBox();
        startedWrapper.setId("startedWrapper");

        Label started = new Label("Let's get started");
        started.setId("started");
        startedWrapper.getChildren().addAll(started);

        VBox buttonWrapper = new VBox();
        buttonWrapper.setId("buttonWrapper");

        Button signin = new Button("Sign In");
        signin.setId("signin");

        Button signup = new Button("Sign Up");
        signup.setId("signup");

        buttonWrapper.getChildren().addAll(signin, signup);
        buttonWrapper.setSpacing(35);

        vBox.getChildren().addAll(startedWrapper, buttonWrapper);
        vBox.setSpacing(150);
        vBoxWrapper.getChildren().addAll(vBox);

        VBox vBox2 = new VBox();
        vBox2.setId("vBox2");

        Label hello = new Label("Hello,");
        hello.setId("hello");

        Label welcome = new Label("Welcome to FunGoals!");
        welcome.setId("welcome");

        Label desc = new Label("Manage Your Money,\nAchieve Your Dreams.");
        desc.setId("desc");

        vBox2.getChildren().addAll(hello, welcome, desc);

        HBox hBox = new HBox();
        hBox.setId("hBox");

        StackPane wrapper = new StackPane(hBox);

        hBox.getChildren().addAll(vBox2, vBoxWrapper);
        root.getChildren().add(wrapper);

        VBox.setMargin(started, new Insets(85, 0, 0, 0));
        VBox.setMargin(buttonWrapper, new Insets(0, 0, 85, 0));

        TranslateTransition translateTransitionVBox2 = new TranslateTransition(Duration.seconds(1), vBox2);
        translateTransitionVBox2.setToY(screenBounds.getHeight() + vBox2.getPrefHeight());

        FadeTransition fadeTransitionVBox2 = new FadeTransition(Duration.seconds(1), vBox2);
        fadeTransitionVBox2.setFromValue(1.0);
        fadeTransitionVBox2.setToValue(0.0);

        ParallelTransition parallelTransitionVBox2 = new ParallelTransition(translateTransitionVBox2,
                fadeTransitionVBox2);

        signin.setOnAction(e -> {
            parallelTransitionVBox2.play();
        });

        scene = new Scene(root, screenBounds.getWidth(), screenBounds.getHeight());
        scene.getStylesheets().add(getClass().getResource("/styles/style.css").toExternalForm());
    }

    public Scene getScene() {
        return scene;
    }
}
