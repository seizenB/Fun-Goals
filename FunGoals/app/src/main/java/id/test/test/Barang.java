package id.test.test;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Barang extends VBox {
    private VBox vBox;

    public Barang() {

        vBox = new VBox();
        vBox.setSpacing(18);

        Label capaiMimpi = new Label("Kamu ingin mencapai mimpi kamu");
        capaiMimpi.setId("input");

        TextField textField1 = new TextField();
        textField1.setId("field2");
        
        Label bulan = new Label("Bulan lagi");
        bulan.setId("ket");

        HBox hBox1 = new HBox();
        hBox1.setId("hBoxinput");
        hBox1.getChildren().addAll(textField1, bulan);

        Label harga = new Label("Harga barang impianmu saat ini");
        harga.setId("input");

        Label rp1 = new Label("Rp.");
        rp1.setId("ket");

        TextField hargaBarang = new TextField();
        hargaBarang.setId("field");

        HBox hBox2 = new HBox();
        hBox2.setId("hBoxinput");
        hBox2.getChildren().addAll(rp1, hargaBarang);

        Label dp = new Label("% DP (Down Payment) yang ingin kamu bayarkan sebesar");
        dp.setId("input");

        TextField downPayment = new TextField();
        downPayment.setId("field2");

        Label persen = new Label("%");
        persen.setId("ket");

        HBox hBox3 = new HBox();
        hBox3.setId("hBoxinput");
        hBox3.getChildren().addAll(downPayment, persen);

        Label dpKamu = new Label("DP kamu setara dengan");
        dpKamu.setId("input");

        Label rp2 = new Label("Rp.");
        rp2.setId("ket");

        Label besarDp = new Label();
        besarDp.setId("field2");

        HBox hBox4 = new HBox();
        hBox4.setId("hBoxinput");
        hBox4.getChildren().addAll(rp2, besarDp);

        Label pinjaman = new Label("% Pinjaman kamu");
        pinjaman.setId("input");

        Label pinjamanMu = new Label();
        pinjamanMu.setId("field2");

        Label pinjamanKamu = new Label("%");
        pinjamanKamu.setId("ket");

        HBox hBox5 = new HBox();
        hBox5.setId("hBoxinput");
        hBox5.getChildren().addAll(pinjamanMu, pinjamanKamu);

        Label utang = new Label("Pokok utang kamu setara dengan");
        utang.setId("input");

        Label rp3 = new Label("Rp.");
        rp3.setId("ket");

        Label pokokUtang = new Label();
        pokokUtang.setId("field");

        HBox hBox6 = new HBox();
        hBox6.setId("hBoxinput");
        hBox6.getChildren().addAll(rp2, pokokUtang);

        vBox.getChildren().addAll(capaiMimpi, hBox1, harga, hBox2, dp, hBox3, dpKamu, hBox4, pinjaman, hBox5, utang, hBox6);

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

        nextButton.setOnAction(event -> {

            vBox.getChildren().clear();

            Label asumsi = new Label("Asumsi inflasi harga");
            asumsi.setId("input");
            
            TextField asumsiInflasi = new TextField();
            asumsiInflasi.setId("field2");
            
            Label persenTahun = new Label("Rp.");
            persenTahun.setId("ket");

            HBox hBox7 = new HBox();
            hBox7.setId("hBoxinput");
            hBox7.getChildren().addAll(asumsiInflasi, persenTahun);

            Label total = new Label("Total uang yang kamu perlukan");
            total.setId("input");

            Label rp4 = new Label("Rp.");
            rp4.setId("ket");

            Label totalUang = new Label();
            totalUang.setId("field");

            HBox hBox8 = new HBox();
            hBox8.setId("hBoxinput");
            hBox8.getChildren().addAll(rp4, totalUang);

            Label uang = new Label("Uang yang kamu miliki saat ini untuk beli barang sebesar");
            uang.setId("input");

            Label rp5 = new Label("Rp.");
            rp5.setId("ket");

            TextField uangSaatIni = new TextField();
            uangSaatIni.setId("field");

            HBox hBox9 = new HBox();
            hBox9.setId("hBoxinput");
            hBox9.getChildren().addAll(rp5, uangSaatIni);

            Label targetInvestasi = new Label("Target investasimu tiap bulan");
            targetInvestasi.setId("input");

            Label rp6 = new Label("Rp.");
            rp6.setId("ket");

            TextField target = new TextField();
            target.setId("field");

            HBox hBox10 = new HBox();
            hBox10.setId("hBoxinput");
            hBox10.getChildren().addAll(rp6, target);

            Label invest = new Label("Kamu akan investasi di produk yang return-nya");
            invest.setId("input");

            TextField lnvestProduk = new TextField();
            lnvestProduk.setId("field2");

            Label investasi = new Label("%/tahun");
            investasi.setId("ket");

            HBox hBox11 = new HBox();
            hBox11.setId("hBoxinput");
            hBox11.getChildren().addAll(lnvestProduk, investasi);

            Label berinvestasi = new Label("Kamu akan rutin berinvestasi selama");
            berinvestasi.setId("input");

            Label rutin = new Label();
            rutin.setId("field2");

            Label berinvest = new Label("Bulan");
            berinvest.setId("ket");

            HBox hBox12 = new HBox();
            hBox12.setId("hBoxinput");
            hBox12.getChildren().addAll(rutin,berinvest);

            vBox.getChildren().addAll(asumsi, hBox7, total, hBox8, uang, hBox9, targetInvestasi, hBox10, invest, hBox11, berinvestasi, hBox12);

            // Menghapus tombol "next" dan menambahkan tombol baru ke buttonBox
            buttonBox.getChildren().clear();
            Button hasilButton = new Button("Lihat hasil strategimu");
            hasilButton.setId("hasil");
            buttonBox.getChildren().add(hasilButton);
        });
    }
}

