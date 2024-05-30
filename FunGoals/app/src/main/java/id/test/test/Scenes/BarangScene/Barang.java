package id.test.test;

import java.text.DecimalFormat;
import id.test.test.Models.BarangModel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Barang extends VBox {
    private VBox vBox;
    private BarangModel model;

    public Barang() {
        model = new BarangModel();
        vBox = new VBox();
        vBox.setSpacing(18);

        Label capaiMimpi = new Label("Kamu ingin mencapai mimpi kamu");
        capaiMimpi.setId("input");

        TextField textField1 = createIntegerField(model::setBulanLagi, "Masukan nilai yang valid");
        Label bulan = new Label("Bulan lagi");
        bulan.setId("ket");

        HBox hBox1 = new HBox();
        hBox1.setId("hBoxinput");
        hBox1.getChildren().addAll(textField1, bulan);

        Label harga = new Label("Harga barang impianmu saat ini");
        harga.setId("input");

        Label rp1 = new Label("Rp.");
        rp1.setId("ket");

        Label error = new Label("");
        error.setId("ket");

        TextField hargaBarang = new TextField();
        hargaBarang.setId("field");
        hargaBarang.setOnKeyReleased(event -> handleHargaBarangInput(hargaBarang, error));

        HBox hBox2 = new HBox();
        hBox2.setId("hBoxinput");
        hBox2.getChildren().addAll(rp1, hargaBarang, error);

        Label dp = new Label("% DP (Down Payment) yang ingin kamu bayarkan sebesar");
        dp.setId("input");

        Label error2 = new Label();
        error2.setId("ket");

        TextField downPayment = new TextField();
        downPayment.setId("field2");

        Label persen = new Label("%");
        persen.setId("ket");

        HBox hBox3 = new HBox();
        hBox3.setId("hBoxinput");
        hBox3.getChildren().addAll(downPayment, persen, error2);

        Label dpKamu = new Label("DP kamu setara dengan");
        dpKamu.setId("input");

        Label rp2 = new Label("Rp.");
        rp2.setId("ket");

        Label besarDp = new Label();
        besarDp.setId("besardp");

        HBox hBox4 = new HBox();
        hBox4.setId("hBoxinput");
        hBox4.getChildren().addAll(rp2, besarDp);

        Label pinjaman = new Label("% Pinjaman kamu");
        pinjaman.setId("input");

        Label pinjamanMu = new Label();
        pinjamanMu.setId("pinjamanMu");

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
        pokokUtang.setId("pokokUtang");

        HBox hBox6 = new HBox();
        hBox6.setId("hBoxinput");
        hBox6.getChildren().addAll(rp3, pokokUtang);

        downPayment.setOnKeyReleased(
                event -> handleDownPaymentInput(downPayment, error2, besarDp, pinjamanMu, pokokUtang));
        hargaBarang.setOnKeyReleased(event -> handleHargaBarangInput(hargaBarang, error));

        vBox.getChildren().addAll(capaiMimpi, hBox1, harga, hBox2, dp, hBox3, dpKamu, hBox4, pinjaman, hBox5, utang,
                hBox6);

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

        nextButton.setOnAction(event -> switchToSecondForm(buttonBox));
    }

    private TextField createIntegerField(ValueSetter<Integer> setter, String errorMessage) {
        TextField textField = new TextField();
        textField.setId("field2");
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                setter.setValue(Integer.parseInt(newValue));
            } catch (NumberFormatException e) {
                setter.setValue(0);
            }
        });
        return textField;
    }

    private void handleHargaBarangInput(TextField hargaBarang, Label error) {
        try {
            if (!hargaBarang.getText().isEmpty()) {
                error.setText("");
                double hargaBarangValue = Double.parseDouble(hargaBarang.getText());
                model.setHargaBarang(hargaBarangValue);
                updateDpLabel();
                updatePinjamanMuLabel();
                updatePokokUtangLabel();
            } else {
                error.setText("");
                clearCalculatedFields();
            }
        } catch (NumberFormatException e) {
            hargaBarang.clear();
            error.setText("Masukan nilai yang valid");
        }
    }

    private void handleDownPaymentInput(TextField downPayment, Label error2, Label besarDp, Label pinjamanMu,
            Label pokokUtang) {
        try {
            if (!downPayment.getText().isEmpty()) {
                error2.setText("");
                double downPaymentValue = Double.parseDouble(downPayment.getText());
                model.setDownPaymentPercentage(downPaymentValue);
                updateDpLabel();
                updatePinjamanMuLabel();
                updatePokokUtangLabel();
            } else {
                error2.setText("");
                clearCalculatedFields();
            }
        } catch (NumberFormatException e) {
            downPayment.clear();
            error2.setText("Masukan nilai yang valid");
        }
    }

    private void clearCalculatedFields() {
        Label besarDp = (Label) vBox.lookup("#besardp");
        Label pinjamanMu = (Label) vBox.lookup("#pinjamanMu");
        Label pokokUtang = (Label) vBox.lookup("#pokokUtang");

        if (besarDp != null)
            besarDp.setText("");
        if (pinjamanMu != null)
            pinjamanMu.setText("");
        if (pokokUtang != null)
            pokokUtang.setText("");
    }

    private void updateDpLabel() {
        Label besarDp = (Label) vBox.lookup("#besardp");
        if (besarDp != null) {
            double hargaBarang = model.getHargaBarang();
            double downPaymentPercentage = model.getDownPaymentPercentage();

            double hasilDp = hargaBarang * (downPaymentPercentage / 100);
            model.setBesarDp(hasilDp);

            DecimalFormat df = new DecimalFormat("###,###,###.00");
            String formattedDp = df.format(model.getBesarDp());

            besarDp.setText(formattedDp);
        }
    }

    private void updatePinjamanMuLabel() {
        Label pinjamanMuLabel = (Label) vBox.lookup("#pinjamanMu");
        if (pinjamanMuLabel != null) {
            double persentasiPinjaman = 100 - model.getDownPaymentPercentage();
            pinjamanMuLabel.setText(String.format("%.2f", persentasiPinjaman));
        }
    }

    private void updatePokokUtangLabel() {
        Label pokokUtangLabel = (Label) vBox.lookup("#pokokUtang");
        if (pokokUtangLabel != null) {
            double pokokUtangValue = model.getHargaBarang() - model.getBesarDp();

            DecimalFormat df = new DecimalFormat("###,###,###.00");
            String formattedPokokUtang = df.format(pokokUtangValue);
            pokokUtangLabel.setText(formattedPokokUtang);
        }
    }

    private void switchToSecondForm(HBox buttonBox) {
        vBox.getChildren().clear();

        Label asumsi = new Label("Asumsi inflasi harga");
        asumsi.setId("input");

        TextField asumsiInflasi = createDoubleField(model::setAsumsiInflasi, "Masukan nilai yang valid");
        Label persenTahun = new Label("%/tahun");
        persenTahun.setId("ket");

        Label error3 = new Label("");
        error3.setId("ket");
        asumsiInflasi.setOnKeyReleased(event -> handleRp4(asumsiInflasi, error3));

        HBox hBox7 = new HBox();
        hBox7.setId("hBoxinput");
        hBox7.getChildren().addAll(asumsiInflasi, persenTahun, error3);

        Label total = new Label("Total uang yang kamu perlukan " + model.getBulanLagi() + " lagi untuk bayar DP");
        total.setId("input");

        Label rp4 = new Label("Rp.");
        rp4.setId("ket");

        Label totalUang = new Label();
        totalUang.setId("rp4");

        HBox hBox8 = new HBox();
        hBox8.setId("hBoxinput");
        hBox8.getChildren().addAll(rp4, totalUang);

        Label uang = new Label("Uang yang kamu miliki saat ini untuk beli barang sebesar");
        uang.setId("input");

        Label rp5 = new Label("Rp.");
        rp5.setId("ket");

        TextField uangSaatIni = createDoubleField(model::setUangSaatIni, "Masukan nilai yang valid");
        uangSaatIni.setId("uangSaatIni");

        HBox hBox9 = new HBox();
        hBox9.setId("hBoxinput");
        hBox9.getChildren().addAll(rp5, uangSaatIni);

        Label targetInvestasi = new Label("Target investasimu tiap bulan");
        targetInvestasi.setId("input");

        Label rp6 = new Label("Rp.");
        rp6.setId("ket");

        TextField target = createDoubleField(model::setTargetInvestasiBulanan, "Masukan nilai yang valid");
        target.setId("uangSaatIni");

        HBox hBox10 = new HBox();
        hBox10.setId("hBoxinput");
        hBox10.getChildren().addAll(rp6, target);

        Label invest = new Label("Kamu akan investasi di produk yang return-nya");
        invest.setId("input");

        TextField lnvestProduk = createDoubleField(model::setReturnInvestasiTahunan, "Masukan nilai yang valid");
        Label investasi = new Label("%/tahun");
        investasi.setId("ket");

        HBox hBox11 = new HBox();
        hBox11.setId("hBoxinput");
        hBox11.getChildren().addAll(lnvestProduk, investasi);

        Label berinvestasi = new Label("Kamu akan rutin berinvestasi selama");
        berinvestasi.setId("input");

        Label rutin = new Label();
        rutin.setId("rutin");

        lnvestProduk.setOnKeyReleased(event -> handleRutin(lnvestProduk));

        Label berinvest = new Label("Bulan");
        berinvest.setId("ket");

        HBox hBox12 = new HBox();
        hBox12.setId("hBoxinput");
        hBox12.getChildren().addAll(rutin, berinvest);

        vBox.getChildren().addAll(asumsi, hBox7, total, hBox8, uang, hBox9, targetInvestasi, hBox10, invest, hBox11,
                berinvestasi, hBox12);

        buttonBox.getChildren().clear();
        Button hasilButton = new Button("Lihat hasil strategimu");
        hasilButton.setId("hasil");
        buttonBox.getChildren().add(hasilButton);

        hasilButton.setOnAction(event -> evaluatePlan(totalUang, uangSaatIni, target, lnvestProduk, rutin));
    }

    private void updateRp4Label() {
        Label besarRp4 = (Label) vBox.lookup("#rp4");
        if (besarRp4 != null) {
            double monthlyInflationRate = (model.getAsumsiInflasi() / 100) / 12;
            double rp4Value = model.getBesarDp() * Math.pow((1 + monthlyInflationRate), model.getBulanLagi());

            DecimalFormat df = new DecimalFormat("###,###,###.00");
            String formattedDp = df.format(rp4Value);

            besarRp4.setText(formattedDp);
        }
    }

    private void handleRp4(TextField asumsiInflasi, Label error3) {
        try {
            if (!asumsiInflasi.getText().isEmpty()) {
                int asumsiInflasiValue = Integer.parseInt(asumsiInflasi.getText());
                model.setAsumsiInflasi(asumsiInflasiValue);
                error3.setText("");
                updateRp4Label();
            } else {
                error3.setText("");
                clearCalculatedFields();
            }
        } catch (NumberFormatException e) {
            asumsiInflasi.clear();
            error3.setText("Masukan nilai yang valid");
        }
    }

    private void updateRutinLabel() {
        Label rutinValue = (Label) vBox.lookup("#rutin");
        if (rutinValue != null) {
            int bulan = model.getBulanLagi();
            rutinValue.setText(String.valueOf(bulan));
        }
    }

    private void handleRutin(TextField investProduct) {
        try {
            if (!investProduct.getText().isEmpty()) {
                updateRutinLabel();
            } else {
                clearCalculatedFields();
            }
        } catch (NumberFormatException e) {
            investProduct.clear();
        }
    }

    private TextField createDoubleField(ValueSetter<Double> setter, String errorMessage) {
        TextField textField = new TextField();
        textField.setId("field2");
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                setter.setValue(Double.parseDouble(newValue));
            } catch (NumberFormatException e) {
                setter.setValue(0.0);
            }
        });
        return textField;
    }

    @FunctionalInterface
    interface ValueSetter<T> {
        void setValue(T value);
    }

    private void evaluatePlan(Label totalUang, TextField uangSaatIni, TextField target, TextField lnvestProduk,
            Label rutin) {
        try {
            double totalUangDiperlukan = Double.parseDouble(totalUang.getText().replace(",", ""));
            double uangSaatIniValue = Double.parseDouble(uangSaatIni.getText());
            double targetInvestasiBulanan = Double.parseDouble(target.getText());
            double returnInvestasiTahunan = Double.parseDouble(lnvestProduk.getText());
            int bulanLagi = model.getBulanLagi();

            double monthlyReturnRate = Math.pow((1 + returnInvestasiTahunan / 100), 1.0 / 12) - 1;
            double totalInvestasi = uangSaatIniValue;

            for (int i = 0; i < bulanLagi; i++) {
                totalInvestasi += targetInvestasiBulanan;
                totalInvestasi *= (1 + monthlyReturnRate);
            }

            if (totalInvestasi >= totalUangDiperlukan) {
                showResultScene("Rencana kamu realistis!",
                        "Kamu akan mencapai tujuanmu dengan investasi bulanan yang direncanakan.");
            } else {
                showResultScene("Rencana kamu belum realistis", getTips(totalUangDiperlukan, totalInvestasi));
            }
        } catch (NumberFormatException e) {
            showResultScene("Kesalahan", "Masukkan semua nilai yang valid untuk evaluasi.");
        }
    }

    private void showResultScene(String title, String message) {
        Stage resultStage = new Stage();
        VBox resultVBox = new VBox();
        resultVBox.setSpacing(20);
        resultVBox.setPadding(new Insets(20));

        Label titleLabel = new Label(title);
        titleLabel.setId("resultTitle");
        Label messageLabel = new Label(message);
        messageLabel.setId("resultMessage");
        messageLabel.setWrapText(true); // Membuat teks dapat menyesuaikan lebar label

        resultVBox.getChildren().addAll(titleLabel, messageLabel);

        Scene resultScene = new Scene(resultVBox, 400, 300); // Ukuran scene baru
        resultStage.setScene(resultScene);
        resultStage.setTitle("Hasil Evaluasi Rencana");
        resultStage.show();
    }

    private String getTips(double totalUangDiperlukan, double totalInvestasi) {
        StringBuilder tips = new StringBuilder();
        tips.append("Total uang yang diperlukan: Rp. ").append(formatNumber(totalUangDiperlukan)).append("\n");
        tips.append("Total uang yang akan terkumpul: Rp. ").append(formatNumber(totalInvestasi)).append("\n");
        tips.append("Tips agar rencana kamu lebih realistis:\n");
        tips.append("- Tingkatkan jumlah investasi bulanan.\n");
        tips.append("- Cari produk investasi dengan return yang lebih tinggi.\n");
        tips.append("- Kurangi target harga barang atau DP yang diinginkan.\n");
        tips.append("- Tambahkan waktu untuk mencapai targetmu.\n");
        return tips.toString();
    }

    private String formatNumber(double number) {
        DecimalFormat df = new DecimalFormat("###,###,###.00");
        return df.format(number);
    }
}
