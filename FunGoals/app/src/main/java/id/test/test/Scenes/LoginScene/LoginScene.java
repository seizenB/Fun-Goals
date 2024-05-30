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
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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

    private void createScene() {
        stage.setTitle("FunGoals");

        StackPane root = new StackPane();
        root.setId("root");

        VBox vBoxWrapper = createVBoxWrapper();
        VBox vBox = createMainVBox();
        vBoxWrapper.getChildren().add(vBox);

        VBox vBox2 = createWelcomeVBox();
        HBox hBox = new HBox(vBox2, vBoxWrapper);
        hBox.setId("hBox");

        StackPane wrapper = new StackPane(hBox);
        root.getChildren().add(wrapper);

        // Membuat objek MenuSignin dan MenuSignup
        MenuSignin menuSignin = new MenuSignin(stage);
        VBox vBoxSigninWrapper = menuSignin.getVBoxSigninWrapper();
        vBoxSigninWrapper.setOpacity(0.0);
        root.getChildren().add(vBoxSigninWrapper);

        MenuSignup menuSignup = new MenuSignup(menuSignin);
        VBox vBoxSignupWrapper = menuSignup.getVBoxSignupWrapper();
        vBoxSignupWrapper.setOpacity(0.0);
        root.getChildren().add(vBoxSignupWrapper);

        addMarginToElements(vBox);

        // Animasi untuk transisi
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        ParallelTransition toSigninTransition = createTransition(vBox2, vBoxWrapper, vBoxSigninWrapper, screenBounds);
        ParallelTransition toSignupTransition = createTransition(vBox2, vBoxWrapper, vBoxSignupWrapper, screenBounds);

        // Tombol aksi signin dan signup
        Button signin = (Button) vBox.lookup("#signin");
        signin.setOnAction(e -> {
            vBoxSigninWrapper.setVisible(true);
            toSigninTransition.play();
        });

        Button signup = (Button) vBox.lookup("#signup");
        signup.setOnAction(e -> {
            vBoxSignupWrapper.setVisible(true);
            toSignupTransition.play();
        });

        // Tambahkan tombol "Back" ke buttonWrapper di vBoxSigninWrapper dan
        // vBoxSignupWrapper
        addBackButtonToWrapper(vBoxSigninWrapper);
        addBackButtonToWrapper(vBoxSignupWrapper);

        scene = new Scene(root, screenBounds.getWidth(), screenBounds.getHeight());
        scene.getStylesheets().add(getClass().getResource("/styles/style.css").toExternalForm());
    }

    private VBox createVBoxWrapper() {
        VBox vBoxWrapper = new VBox();
        vBoxWrapper.setAlignment(Pos.CENTER);
        vBoxWrapper.setPadding(new Insets(0, 0, 0, 50));
        vBoxWrapper.setId("vBox-wrapper");
        return vBoxWrapper;
    }

    private VBox createMainVBox() {
        VBox vBox = new VBox();
        vBox.setPrefWidth(406);
        vBox.setPrefHeight(446);
        vBox.setMaxWidth(406);
        vBox.setMaxHeight(446);
        vBox.setId("vBox");

        VBox startedWrapper = new VBox();
        startedWrapper.setId("startedWrapper");
        Label started = new Label("Let's get started");
        started.setId("started");
        startedWrapper.getChildren().add(started);

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

        return vBox;
    }

    private VBox createWelcomeVBox() {
        VBox vBox2 = new VBox();
        vBox2.setId("vBox2");
        Label hello = new Label("Hello,");
        hello.setId("hello");
        Label welcome = new Label("Welcome to FunGoals!");
        welcome.setId("welcome");
        Label desc = new Label("Manage Your Money,\nAchieve Your Dreams.");
        desc.setId("desc");
        vBox2.getChildren().addAll(hello, welcome, desc);
        return vBox2;
    }

    private void addMarginToElements(VBox vBox) {
        VBox startedWrapper = (VBox) vBox.lookup("#startedWrapper");
        VBox buttonWrapper = (VBox) vBox.lookup("#buttonWrapper");

        VBox.setMargin(startedWrapper, new Insets(85, 0, 0, 0));
        VBox.setMargin(buttonWrapper, new Insets(0, 0, 85, 0));
    }

    private ParallelTransition createTransition(VBox vBox2, VBox vBoxWrapper, VBox targetWrapper,
            Rectangle2D screenBounds) {
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), vBox2);
        translateTransition.setToY(screenBounds.getHeight() + vBox2.getPrefHeight());

        FadeTransition fadeOutVBox2 = new FadeTransition(Duration.seconds(1), vBox2);
        fadeOutVBox2.setFromValue(1.0);
        fadeOutVBox2.setToValue(0.0);

        FadeTransition fadeOutVBoxWrapper = new FadeTransition(Duration.seconds(1), vBoxWrapper);
        fadeOutVBoxWrapper.setFromValue(1.0);
        fadeOutVBoxWrapper.setToValue(0.0);

        FadeTransition fadeInTarget = new FadeTransition(Duration.seconds(1), targetWrapper);
        fadeInTarget.setFromValue(0.0);
        fadeInTarget.setToValue(1.0);

        ParallelTransition parallelTransition = new ParallelTransition(translateTransition, fadeOutVBox2,
                fadeOutVBoxWrapper);
        parallelTransition.setOnFinished(event -> fadeInTarget.play());

        return parallelTransition;
    }

    private void addBackButtonToWrapper(VBox targetWrapper) {
        Button backButton = createBackButton("Back", targetWrapper);
        // Ganti ID dengan ID unik untuk setiap tombol "Back"
        backButton.setId("back-" + targetWrapper.getId());

        // Dapatkan VBox buttonWrapper yang sudah ada, jika tidak ada buat yang baru
        VBox buttonWrapper = (VBox) targetWrapper.lookup("#buttonWrapper");
        if (buttonWrapper == null) {
            buttonWrapper = new VBox();
            buttonWrapper.setId("buttonWrapper");
            targetWrapper.getChildren().add(buttonWrapper);
        }

        // Temukan tombol "Sign In" atau "Sign Up" yang ada dalam targetWrapper
        Button signinOrSignupButton = (Button) targetWrapper.lookup("#signin");
        if (signinOrSignupButton == null) {
            signinOrSignupButton = (Button) targetWrapper.lookup("#signup");
        }

        // Tambahkan tombol "Back" setelah tombol "Sign In" atau "Sign Up" dalam VBox
        // buttonWrapper
        backButton.setId("signin");
        buttonWrapper.getChildren().addAll(signinOrSignupButton, backButton);
        buttonWrapper.setSpacing(10);

    }

    private Button createBackButton(String text, VBox targetWrapper) {
        Button backButton = new Button(text);
        // Ganti ID dengan ID unik untuk setiap tombol "Back"
        backButton.setId("back-" + targetWrapper.getId());
        backButton.setOnAction(e -> {
            FadeTransition fadeOutTarget = new FadeTransition(Duration.seconds(1), targetWrapper);
            fadeOutTarget.setFromValue(1.0);
            fadeOutTarget.setToValue(0.0);

            fadeOutTarget.setOnFinished(evt -> {
                targetWrapper.setVisible(false);

                VBox vBox2 = (VBox) targetWrapper.getParent().lookup("#vBox2");
                VBox vBoxWrapper = (VBox) targetWrapper.getParent().lookup("#vBox-wrapper");

                TranslateTransition reverseTranslateTransition = new TranslateTransition(Duration.seconds(1), vBox2);
                reverseTranslateTransition.setToY(0);

                FadeTransition fadeInVBox2 = new FadeTransition(Duration.seconds(1), vBox2);
                fadeInVBox2.setFromValue(0.0);
                fadeInVBox2.setToValue(1.0);

                FadeTransition fadeInVBoxWrapper = new FadeTransition(Duration.seconds(1), vBoxWrapper);
                fadeInVBoxWrapper.setFromValue(0.0);
                fadeInVBoxWrapper.setToValue(1.0);

                ParallelTransition parallelTransition = new ParallelTransition(reverseTranslateTransition, fadeInVBox2,
                        fadeInVBoxWrapper);
                parallelTransition.play();
            });

            fadeOutTarget.play();
        });

        return backButton;
    }

    public Scene getScene() {
        return scene;
    }
}