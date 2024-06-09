package id.test.test.Utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class AlertHelper {
    public static void showAlert(AlertType alertType, String title, String header, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
        alert.getDialogPane().setPrefWidth(1000);
    }

    public static void showInfoAlert(String content) {
        showAlert(AlertType.INFORMATION, "Information", null, content);
    }

    public static void showErrorAlert(String content) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.getDialogPane().setId("alert");

        // Tambahkan file CSS ke alert
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        Scene scene = stage.getScene();
        scene.getStylesheets().add(AlertHelper.class.getResource("/styles/style.css").toExternalForm());

        alert.showAndWait();
    }
}
