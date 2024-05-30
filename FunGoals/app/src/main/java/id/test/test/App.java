/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package id.test.test;

import id.test.test.Scenes.LoginScene;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class App extends Application {
    // Metode utama untuk meluncurkan aplikasi JavaFX
    public static void main(String[] args) {
        launch(args);
    }

    // Metode start adalah titik masuk untuk aplikasi JavaFX
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Mendapatkan batas visual dari layar utama
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();


        // Membuat instance dari LoginScene, dan melewatkan primary stage
        LoginScene loginScene = new LoginScene(primaryStage);


        // Mengatur scene dari primary stage ke login scene
        primaryStage.setScene(loginScene.getScene());


        // Mengatur lebar dan tinggi dari primary stage agar sesuai dengan batas layar
        primaryStage.setWidth(screenBounds.getWidth());
        primaryStage.setHeight(screenBounds.getHeight());

        // Memaksimalkan primary stage agar mengambil seluruh layar
        primaryStage.setMaximized(true);
        
        primaryStage.show();
    }

}