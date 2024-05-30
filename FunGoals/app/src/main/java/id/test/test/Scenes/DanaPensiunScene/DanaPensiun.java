package id.test.test;

import id.test.test.HomeScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DanaPensiun extends VBox {
    private VBox vBox;

    public DanaPensiun() {

        vBox = new VBox();
        vBox.setSpacing(18);

        Label pengeluaran = new Label("Pengeluaran/bulan");
        pengeluaran.setId("input");

        Label rp = new Label("Rp.");
        rp.setId("ket");

        TextField textField1 = new TextField();
        textField1.setId("field");

        HBox hBox1 = new HBox();
        hBox1.setId("hBoxinput");
        hBox1.getChildren().addAll(rp, textField1);

        Label pengeluaranPerTahun = new Label("Pengeluaran/tahun");
        pengeluaranPerTahun.setId("input");
        pengeluaranPerTahun.setVisible(false);

        Label rp1 = new Label("Rp.");
        rp1.setId("ket");
        rp1.setVisible(false);

        Label tahun = new Label();
        tahun.setId("field");
        tahun.setVisible(false);

        HBox hBox2 = new HBox();
        hBox2.setId("hBoxinput");
        hBox2.getChildren().addAll(rp1, tahun);

        Label usia = new Label("Usiamu sekarang");
        usia.setId("input");

        TextField textField2 = new TextField();
        textField2.setId("field2");

        Label usiasekarang = new Label("tahun");
        usiasekarang.setId("ket");

        HBox hBox3 = new HBox();
        hBox3.setId("hBoxinput");
        hBox3.getChildren().addAll(textField2, usiasekarang);

        Label usia2 = new Label("Kamu ingin pensiun di usia");
        usia2.setId("input");

        TextField textField3 = new TextField();
        textField3.setId("field2");

        Label usiapensiun = new Label("tahun");
        usiapensiun.setId("ket");

        HBox hBox4 = new HBox();
        hBox4.setId("hBoxinput");
        hBox4.getChildren().addAll(textField3, usiapensiun);

        Label inflasi = new Label("Asumsi inflasi tahunan");
        inflasi.setId("input");

        TextField textField4 = new TextField();
        textField4.setId("field2");

        Label persen = new Label("%/tahun");
        persen.setId("ket");

        HBox hBox5 = new HBox();
        hBox5.setId("hBoxinput");
        hBox5.getChildren().addAll(textField4, persen);

        Label pengeluaranpensiun = new Label("Pengeluaran tahunan saat mulai pensiun nanti");
        pengeluaranpensiun.setId("input");
        pengeluaranpensiun.setVisible(false);

        Label rp2 = new Label("Rp.");
        rp2.setId("ket");
        rp2.setVisible(false);

        Label pengeluarantahunan = new Label();
        pengeluarantahunan.setId("field");
        pengeluarantahunan.setVisible(false);

        HBox hBox6 = new HBox();
        hBox6.setId("hBoxinput");
        hBox6.getChildren().addAll(rp2, pengeluarantahunan);

        vBox.getChildren().addAll(pengeluaran, hBox1, pengeluaranPerTahun, hBox2, usia, hBox3, usia2, hBox4, inflasi,
                hBox5, pengeluaranpensiun, hBox6);

        this.setAlignment(Pos.TOP_LEFT);
        this.setSpacing(20);
        this.setPadding(new Insets(20));
        this.getChildren().add(vBox);

        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        buttonBox.setPadding(new Insets(0, 50, 0, 20));
        Button nextButton = new Button("next >>");
        nextButton.setId("hasil");

        buttonBox.getChildren().add(nextButton);

        this.getChildren().add(buttonBox);

        textField1.setOnKeyReleased(event -> {
            if (!textField1.getText().isEmpty()) {
                pengeluaranPerTahun.setVisible(true);
                rp1.setVisible(true);
                tahun.setVisible(true);
            }
        });

        textField4.setOnKeyReleased(event -> {
            if (!textField4.getText().isEmpty()) {
                pengeluaranpensiun.setVisible(true);
                rp2.setVisible(true);
                pengeluarantahunan.setVisible(true);
            }
        });

        nextButton.setOnAction(event -> {

            vBox.getChildren().clear();

            Label pemasukan = new Label("Uang yang kamu butuhkan");
            pemasukan.setId("input");

            Label rp3 = new Label("Rp.");
            rp3.setId("ket");

            Label uangYangDibutuhkan = new Label();
            uangYangDibutuhkan.setId("field");

            HBox hBox7 = new HBox();
            hBox7.setId("hBoxinput");
            hBox7.getChildren().addAll(rp3, uangYangDibutuhkan);

            Label dana = new Label("Dana pensiun yang telah tersedia sampai saat ini");
            dana.setId("input");

            Label rp4 = new Label("Rp.");
            rp4.setId("ket");

            TextField danaPensiun = new TextField();
            danaPensiun.setId("field");

            HBox hBox8 = new HBox();
            hBox8.setId("hBoxinput");
            hBox8.getChildren().addAll(rp4, danaPensiun);

            Label target = new Label("Target investasimu tiap bulan");
            target.setId("input");

            Label rp5 = new Label("Rp.");
            rp5.setId("ket");

            TextField targetInvestasi = new TextField();
            targetInvestasi.setId("field");

            HBox hBox9 = new HBox();
            hBox9.setId("hBoxinput");
            hBox9.getChildren().addAll(rp5, targetInvestasi);

            Label targetReturn = new Label("Target return investasi per tahun");
            targetReturn.setId("input");

            TextField returnInvestasi = new TextField();
            returnInvestasi.setId("field2");

            Label persenTahun = new Label("%/tahun");
            persenTahun.setId("ket");

            HBox hBox10 = new HBox();
            hBox10.setId("hBoxinput");
            hBox10.getChildren().addAll(returnInvestasi, persenTahun);

            Label pensiun = new Label("Kamu akan pensiun dalam");
            pensiun.setId("input");

            Label masaPensiun = new Label();
            masaPensiun.setId("field2");

            Label tahunPensiun = new Label("Tahun");
            tahunPensiun.setId("ket");

            HBox hBox11 = new HBox();
            hBox11.setId("hBoxinput");
            hBox11.getChildren().addAll(masaPensiun, tahunPensiun);

            vBox.getChildren().addAll(pemasukan, hBox7, dana, hBox8, target, hBox9, targetReturn, hBox10, pensiun,
                    hBox11);

            buttonBox.getChildren().clear();
            Button hasilButton = new Button("Lihat hasil strategimu");
            hasilButton.setId("hasil");
            buttonBox.getChildren().add(hasilButton);
        });
    }
}
