package id.test.test.Scenes;

import id.test.test.App;
import id.test.test.HomeScene;
import id.test.test.Database.DatabaseManager;
import id.test.test.Models.User;
import id.test.test.Utils.AlertHelper;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.control.PasswordField;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuSignin {
    private VBox vBoxSigninWrapper;
    private TextField usernameField;
    private PasswordField passwordField;
    private Stage stage;
    private Scene scene;

    public MenuSignin(Stage stage) {
        this.stage = stage;
        createMenu();
    }

    private void createMenu() {
        vBoxSigninWrapper = new VBox();
        vBoxSigninWrapper.setAlignment(Pos.CENTER);
        vBoxSigninWrapper.setSpacing(30);
        // vBoxSigninWrapper.setVisible(false);
        vBoxSigninWrapper.setMaxHeight(534);
        vBoxSigninWrapper.setMaxWidth(432);
        vBoxSigninWrapper.setId("vBox");

        VBox welcomeBackWrapper = new VBox();
        welcomeBackWrapper.setAlignment(Pos.CENTER);
        welcomeBackWrapper.setPadding(new Insets(0, 0, 0, 0));

        Label signinTitle = new Label("Welcome Back!");
        signinTitle.setId("started");
        welcomeBackWrapper.getChildren().add(signinTitle);

        VBox signinFieldsWrapper = new VBox();
        signinFieldsWrapper.setAlignment(Pos.CENTER);
        signinFieldsWrapper.setSpacing(10);

        Label username = new Label("Username");
        username.setId("minibold");
        username.setPadding(new Insets(0, 230, 0, 0));
        usernameField = new TextField();
        usernameField.setPrefHeight(41);
        usernameField.setMaxWidth(308);

        Label password = new Label("Password");
        password.setId("minibold");
        password.setPadding(new Insets(0, 230, 0, 0));
        passwordField = new PasswordField();
        passwordField.setPrefHeight(41);
        passwordField.setMaxWidth(308);

        signinFieldsWrapper.getChildren().addAll(username, usernameField, password, passwordField);

        VBox buttonWrapper = new VBox();
        buttonWrapper.setAlignment(Pos.CENTER);

        Button loginButton = new Button("Sign In");
        loginButton.setId("signin");

        loginButton.setOnAction(e -> handleSignIn());

        buttonWrapper.getChildren().add(loginButton);

        vBoxSigninWrapper.getChildren().addAll(welcomeBackWrapper, signinFieldsWrapper, buttonWrapper);
    }

    private void handleSignIn() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            AlertHelper.showErrorAlert("Username and password cannot be empty or just spaces.");
            return;
        }

        User user = new User("", username, password);

        if (DatabaseManager.signIn(user)) {
            AlertHelper.showInfoAlert("Sign in successful!");
            usernameField.clear();
            passwordField.clear();

            HomeScene homeScene = new HomeScene(stage);
            stage.setScene(homeScene.getScene());
        } else {
            AlertHelper.showErrorAlert("Invalid username or password.");
        }
    }

    public VBox getVBoxSigninWrapper() {
        return vBoxSigninWrapper;
    }

    public void setBackButtonAction(Runnable action) {
        Button backButton = (Button) vBoxSigninWrapper.lookup("#backButton");
        backButton.setOnAction(e -> action.run());
    }
}
