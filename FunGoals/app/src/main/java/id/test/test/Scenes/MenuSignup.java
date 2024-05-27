package id.test.test.Scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class MenuSignup {
    private VBox vBoxSignupWrapper;

    public MenuSignup() {
        createMenu();
    }

    private void createMenu() {
        vBoxSignupWrapper = new VBox();
        vBoxSignupWrapper.setAlignment(Pos.CENTER);
        vBoxSignupWrapper.setVisible(false); // Awalnya tidak terlihat
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
        // signupFieldsWrapper.setSpacing(5);

        Label name = new Label("Name");
        name.setId("minibold");
        name.setPadding(new Insets(0, 260, 0, 0));
        TextField nameField = new TextField();
        nameField.setPrefHeight(41);
        nameField.setMaxWidth(308);

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

        signupFieldsWrapper.getChildren().addAll(name, nameField, username, usernameField, password, passwordField);
        // Menambahkan jarak antara Label dan TextField di signupFieldsWrapper
        signupFieldsWrapper.setSpacing(10);

        VBox buttonWrapper = new VBox();
        buttonWrapper.setAlignment(Pos.CENTER);

        Button signUpButton = new Button("Sign Up");
        signUpButton.setId("signup");

        buttonWrapper.getChildren().add(signUpButton);

        // Add some spacing below the signupFieldsWrapper before adding buttonWrapper
        vBoxSignupWrapper.getChildren().addAll(signupTitleWrapper, signupFieldsWrapper);
        vBoxSignupWrapper.setSpacing(30); // Adjust spacing here if needed
        VBox.setMargin(signUpButton, new Insets(30, 0, 0, 0));
        vBoxSignupWrapper.getChildren().add(buttonWrapper); // Add buttonWrapper after spacing
    }

    public VBox getVBoxSignupWrapper() {
        return vBoxSignupWrapper;
    }
}