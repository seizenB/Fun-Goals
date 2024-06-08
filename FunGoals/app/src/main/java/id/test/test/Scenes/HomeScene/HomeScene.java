package id.test.test;

import id.test.test.Utils.AlertHelper;
import id.test.test.Scenes.LoginScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.util.Optional;

public class HomeScene {
    private Stage stage;
    private Scene scene;

    public HomeScene(Stage stage) {
        this.stage = stage;
        createScene();
    }

    public void createScene() {
        StackPane root = new StackPane();
        root.setId("root");

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        Label mimpi = new Label("Apa Mimpimu?");
        mimpi.setId("started");

        Button pendidikanAnak = new Button("Pendidikan Anak");
        pendidikanAnak.setId("pendidikanAnak");
        pendidikanAnak.getStyleClass().add("dream");

        Button danaDarurat = new Button("Dana Darurat");
        danaDarurat.setId("danaDarurat");
        danaDarurat.getStyleClass().add("dream");

        Button liburan = new Button("Liburan");
        liburan.setId("liburan");
        liburan.getStyleClass().add("dream");

        Button investasi = new Button("Investasi");
        investasi.setId("investasi");
        investasi.getStyleClass().add("dream");

        Button danaPensiun = new Button("Dana Pensiun");
        danaPensiun.setId("pensiun");
        danaPensiun.getStyleClass().add("dream");

        Button barang = new Button("Barang");
        barang.setId("barang");
        barang.getStyleClass().add("dream");

        Button menikah = new Button("Menikah");
        menikah.setId("menikah");
        menikah.getStyleClass().add("dream");

        Button kendaraan = new Button("Kendaraan");
        kendaraan.setId("kendaraan");
        kendaraan.getStyleClass().add("dream");

        Button logoutButton = new Button();
        logoutButton.setId("logoutButton");

        Image logoutIcon = new Image(getClass().getResourceAsStream("/img/Logout.png"));
        ImageView logoutImageView = new ImageView(logoutIcon);

        logoutImageView.setFitWidth(50);
        logoutImageView.setFitHeight(40);

        logoutButton.setGraphic(logoutImageView);

        logoutButton.setOnAction(e -> showLogoutConfirmation());

        VBox vboxForTextAndButton = new VBox();
        vboxForTextAndButton.setAlignment(Pos.TOP_LEFT);
        vboxForTextAndButton.setSpacing(20);
        vboxForTextAndButton.setPadding(new Insets(20));
        vboxForTextAndButton.getChildren().addAll(mimpi, barang, danaDarurat, danaPensiun, pendidikanAnak, liburan,
                investasi, menikah, kendaraan);

        StackPane backgroundPane = new StackPane();
        backgroundPane.setPrefSize(970, 760);
        backgroundPane.setId("backgroundpane");

        VBox vboxForBackgroundPane = new VBox(backgroundPane);
        vboxForBackgroundPane.setAlignment(Pos.CENTER);
        vboxForBackgroundPane.setPadding(new Insets(20, 0, 20, 0));

        HBox hBox = new HBox();
        hBox.setId("hBox");
        hBox.setAlignment(Pos.TOP_LEFT);
        hBox.getChildren().addAll(vboxForTextAndButton, vboxForBackgroundPane);

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.TOP_RIGHT);
        vBox.getChildren().addAll(logoutButton, hBox);

        StackPane wrapper = new StackPane(vBox);
        root.getChildren().add(wrapper);

        scene = new Scene(root, screenBounds.getWidth(), screenBounds.getHeight());
        scene.getStylesheets().add(getClass().getResource("/styles/style.css").toExternalForm());

        danaDarurat.setOnAction(e -> {
            backgroundPane.getChildren().clear();
            DanaDarurat danaDaruratPane = new DanaDarurat(backgroundPane);
            StackPane.setAlignment(danaDaruratPane, Pos.CENTER);
            backgroundPane.getChildren().add(danaDaruratPane);
        });

        danaPensiun.setOnAction(e -> {
            backgroundPane.getChildren().clear();
            DanaPensiun danaPensiunPane = new DanaPensiun();
            StackPane.setAlignment(danaPensiunPane, Pos.CENTER);
            backgroundPane.getChildren().add(danaPensiunPane);
        });

        barang.setOnAction(e -> {
            backgroundPane.getChildren().clear();
            Barang barangPane = new Barang();
            StackPane.setAlignment(barangPane, Pos.CENTER);
            backgroundPane.getChildren().add(barangPane);
        });

        pendidikanAnak.setOnAction(e -> {
            showComingSoonAlert();
        });

        liburan.setOnAction(e -> {
            showComingSoonAlert();
        });

        investasi.setOnAction(e -> {
            showComingSoonAlert();
        });

        menikah.setOnAction(e -> {
            showComingSoonAlert();
        });

        kendaraan.setOnAction(e -> {
            showComingSoonAlert();
        });
    }

    public Scene getScene() {
        return scene;
    }

    public static void showComingSoonAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Coming Soon");
        alert.setContentText("This feature is coming soon. Stay tuned!");
        alert.getDialogPane().setId("alert");

        // Tambahkan file CSS ke alert (jika ada)
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        alert.getDialogPane().getStylesheets().add(
                AlertHelper.class.getResource("/styles/style.css").toExternalForm());

        alert.showAndWait();
    }

    private void showLogoutConfirmation() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout Confirmation");
        alert.setHeaderText("Are you sure you want to logout?");
        alert.setContentText("Press OK to confirm or Cancel to stay.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            LoginScene loginScene = new LoginScene(stage);
            stage.setScene(loginScene.getScene());
        }
    }
}
