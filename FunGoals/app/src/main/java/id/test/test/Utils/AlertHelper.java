package id.test.test.Utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertHelper {
    public static void showAlert(AlertType alertType, String title, String header, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static void showInfoAlert(String content) {
        showAlert(AlertType.INFORMATION, "Information", null, content);
    }

    public static void showErrorAlert(String content) {
        showAlert(AlertType.ERROR, "Error", null, content);
    }
}
