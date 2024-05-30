package id.test.test;

import id.test.test.HomeScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DanaDarurat extends VBox {

    public DanaDarurat() {

        VBox vBox = new VBox();
        vBox.setSpacing(18);

        Label pengeluaran = new Label("Pengeluaran wajibmu setiap bulan");
        pengeluaran.setId("input");

        Label rp = new Label("Rp.");
        rp.setId("ket");

        TextField textField1 = new TextField();
        textField1.setId("field");

        HBox hBox1 = new HBox();
        hBox1.setId("hBoxinput");
        hBox1.getChildren().addAll(rp, textField1);

        Label tanggungan = new Label("Jumlah tanggunganmu");
        tanggungan.setId("input");

        TextField textField2 = new TextField();
        textField2.setId("field2");

        Label orang = new Label("Orang");
        orang.setId("ket");

        HBox hBox2 = new HBox();
        hBox2.setId("hBoxinput");
        hBox2.getChildren().addAll(textField2, orang);

        Label lamatarget = new Label("Berapa lama targetmu mengumpulkan dana darurat?");
        lamatarget.setId("input");

        TextField textField3 = new TextField();
        textField3.setId("field2");

        Label bulan = new Label("Bulan");
        bulan.setId("ket");

        HBox hBox3 = new HBox();
        hBox3.setId("hBoxinput");
        hBox3.getChildren().addAll(textField3, bulan);

        Label jumlah = new Label("Jumlah dana darurat yang kamu miliki saat ini");
        jumlah.setId("input");

        Label rp2 = new Label("Rp.");
        rp2.setId("ket");

        TextField textField4 = new TextField();
        textField4.setId("field");

        HBox hBox4 = new HBox();
        hBox4.setId("hBoxinput");
        hBox4.getChildren().addAll(rp2, textField4);

        Label target = new Label("Target investasi kamu setiap bulan");
        target.setId("input");

        Label rp3 = new Label("Rp.");
        rp3.setId("ket");

        TextField textField5 = new TextField();
        textField5.setId("field");

        HBox hBox5 = new HBox();
        hBox5.setId("hBoxinput");
        hBox5.getChildren().addAll(rp3, textField5);

        Label investasi = new Label("Kamu akan investasi di produk yang returnnya");
        investasi.setId("input");

        TextField textField6 = new TextField();
        textField6.setId("field");

        Label tahun = new Label("%/tahun");
        tahun.setId("ket");

        HBox hBox6 = new HBox();
        hBox6.setId("hBoxinput");
        hBox6.getChildren().addAll(textField6, tahun);

        vBox.getChildren().addAll(pengeluaran, hBox1, tanggungan, hBox2, lamatarget, hBox3, jumlah, hBox4, target,
                hBox5, investasi, hBox6);

        this.setAlignment(Pos.TOP_LEFT);
        this.setSpacing(20);
        this.setPadding(new Insets(20));
        this.getChildren().add(vBox);

        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        buttonBox.setPadding(new Insets(0, 50, 0, 20));
        Button hasilButton = new Button("Lihat hasil strategimu");
        hasilButton.setId("hasil");

        buttonBox.getChildren().add(hasilButton);

        this.getChildren().add(buttonBox);
    }
}