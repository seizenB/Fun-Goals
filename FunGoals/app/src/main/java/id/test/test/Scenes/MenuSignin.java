package id.test.test.Scenes;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class MenuSignin {
    private VBox vBoxSigninWrapper;
    private VBox vBoxSignin;
    private TextField usernameField;
    private TextField passwordField;
    private Node vBoxWrapper;
    private Node vBox2;

    public MenuSignin() {
        createMenu();
    }

    private void createMenu() {
        vBoxSigninWrapper = new VBox();
        vBoxSigninWrapper.setAlignment(Pos.CENTER);
        vBoxSigninWrapper.setSpacing(30);
        vBoxSigninWrapper.setVisible(false); // Awalnya tidak terlihat

        vBoxSigninWrapper.setMaxHeight(534);
        vBoxSigninWrapper.setMaxWidth(432);

        vBoxSigninWrapper.setId("vBox");

        // Tambahkan spasi atas pada welcomeBackWrapper
        VBox welcomeBackWrapper = new VBox();
        welcomeBackWrapper.setAlignment(Pos.CENTER);
        welcomeBackWrapper.setPadding(new Insets(0, 0, 0, 0)); // Tambahkan spasi atas

        Label signinTitle = new Label("Welcome Back!");
        signinTitle.setId("started");
        welcomeBackWrapper.getChildren().add(signinTitle);

        VBox signinFieldsWrapper = new VBox();
        signinFieldsWrapper.setAlignment(Pos.CENTER);
        signinFieldsWrapper.setSpacing(10);

        Label username = new Label("Username");
        username.setId("minibold");
        username.setPadding(new Insets(0, 230, 0, 0));
        TextField usernameField = new TextField();
        usernameField.setPrefHeight(41);
        usernameField.setMaxWidth(308); // Atur lebar maksimum TextField

        Label password = new Label("Password");
        password.setId("minibold");
        password.setPadding(new Insets(0, 230, 0, 0));
        TextField passwordField = new TextField();
        passwordField.setPrefHeight(41);
        passwordField.setMaxWidth(308); // Atur lebar maksimum TextField

        signinFieldsWrapper.getChildren().addAll(username, usernameField, password, passwordField);

        VBox buttonWrapper = new VBox();
        buttonWrapper.setAlignment(Pos.CENTER);

        Button loginButton = new Button("Sign In");
        loginButton.setId("signin");

        buttonWrapper.getChildren().add(loginButton);

        vBoxSigninWrapper.getChildren().addAll(welcomeBackWrapper, signinFieldsWrapper, buttonWrapper);
    }

    public VBox getVBoxSigninWrapper() {
        return vBoxSigninWrapper;
    }

    public void setBackButtonAction(Runnable action) {
        Button backButton = (Button) vBoxSigninWrapper.lookup("#backButton");
        backButton.setOnAction(e -> action.run());
    }
}