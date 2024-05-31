package id.test.test.Scenes;

import id.test.test.Database.DatabaseManager;
import id.test.test.Models.User;
import id.test.test.Utils.AlertHelper;
import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import javafx.scene.control.PasswordField;

public class MenuSignup {
    private VBox vBoxSignupWrapper;
    private TextField nameField;
    private TextField usernameField;
    private PasswordField passwordField;
    private MenuSignin menuSignin; // Reference to the sign-in menu

    public MenuSignup(MenuSignin menuSignin) { // Constructor accepts MenuSignin instance
        this.menuSignin = menuSignin;
        createMenu();
    }

    private void createMenu() {
        vBoxSignupWrapper = new VBox();
        vBoxSignupWrapper.setAlignment(Pos.CENTER);
        vBoxSignupWrapper.setVisible(false);
        vBoxSignupWrapper.setId("vBox");
        vBoxSignupWrapper.setMaxHeight(534);
        vBoxSignupWrapper.setMaxWidth(432);

        VBox signupTitleWrapper = new VBox();
        signupTitleWrapper.setId("startedWrapper");

        Label signupTitle = new Label("Welcome!");
        signupTitle.setId("started");
        signupTitleWrapper.getChildren().add(signupTitle);

        VBox signupFieldsWrapper = new VBox();
        signupFieldsWrapper.setId("buttonWrapper");
        signupFieldsWrapper.setAlignment(Pos.CENTER);
        signupFieldsWrapper.setSpacing(10);

        Label name = new Label("Name");
        name.setId("minibold");
        name.setPadding(new Insets(0, 260, 0, 0));
        nameField = new TextField();
        nameField.setPrefHeight(41);
        nameField.setMaxWidth(308);

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

        signupFieldsWrapper.getChildren().addAll(name, nameField, username, usernameField, password, passwordField);

        VBox buttonWrapper = new VBox();
        buttonWrapper.setAlignment(Pos.CENTER);

        Button signUpButton = new Button("Sign Up");
        signUpButton.setId("signup");

        signUpButton.setOnAction(e -> handleSignUp());

        buttonWrapper.getChildren().add(signUpButton);

        vBoxSignupWrapper.getChildren().addAll(signupTitleWrapper, signupFieldsWrapper);

        vBoxSignupWrapper.setSpacing(30);
        VBox.setMargin(signUpButton, new Insets(30, 0, 0, 0));
        vBoxSignupWrapper.getChildren().add(buttonWrapper);
    }

    private void handleSignUp() {
        String name = nameField.getText().trim();
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        if (name.isEmpty() || username.isEmpty() || password.isEmpty()) {
            AlertHelper.showErrorAlert("Name, username, and password cannot be empty or just spaces.");
            return;
        }

        User user = new User(name, username, password);

        if (DatabaseManager.signUp(user)) {
            AlertHelper.showInfoAlert("Sign up successful!");
            // Transition to the Sign-in menu
            nameField.clear();
            usernameField.clear();
            passwordField.clear();
            transitionToSignIn();
        } else {
            AlertHelper.showErrorAlert("Username already taken or error.");
        }
    }

    private void transitionToSignIn() {
        vBoxSignupWrapper.setVisible(false);
        menuSignin.getVBoxSigninWrapper().setVisible(true);

        // Add a fade transition to the sign-in menu
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), menuSignin.getVBoxSigninWrapper());
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.play();
    }

    public VBox getVBoxSignupWrapper() {
        return vBoxSignupWrapper;
    }
}
