package id.test.test;

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

        VBox vboxForTextAndButton = new VBox();
        vboxForTextAndButton.setAlignment(Pos.TOP_LEFT);
        vboxForTextAndButton.setSpacing(20);
        vboxForTextAndButton.setPadding(new Insets(20));
        vboxForTextAndButton.getChildren().addAll(mimpi, barang, danaDarurat, danaPensiun, pendidikanAnak, liburan, investasi, menikah, kendaraan);

        StackPane backgroundPane = new StackPane();
        backgroundPane.setPrefSize(955, 760);
        backgroundPane.setId("backgroundpane");
        StackPane.setAlignment(backgroundPane, Pos.TOP_RIGHT);
        StackPane.setMargin(backgroundPane, new Insets(30, 30, 20, 320));

        HBox hBox = new HBox();
        hBox.setId("hBox");
        hBox.setAlignment(Pos.TOP_LEFT);
        hBox.getChildren().addAll(vboxForTextAndButton, backgroundPane);

        StackPane wrapper = new StackPane(hBox);
        root.getChildren().add(wrapper);

        StackPane containerPane = new StackPane();
        containerPane.setAlignment(Pos.TOP_LEFT);

        containerPane.getChildren().addAll(hBox, backgroundPane);

        root.getChildren().add(containerPane);

        scene = new Scene(root, screenBounds.getWidth(), screenBounds.getHeight());
        scene.getStylesheets().add(getClass().getResource("/styles/style.css").toExternalForm());

        danaDarurat.setOnAction(e -> {
            backgroundPane.getChildren().clear(); 
            DanaDarurat danaDaruratPane = new DanaDarurat();
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

        stage.setScene(scene);
        stage.show();
    }

    public Scene getScene() {
        return scene;
    }
}

