package id.test.test;

import java.text.DecimalFormat;
import javafx.scene.layout.Region;
import javafx.scene.layout.Priority;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Barang extends VBox implements Method {
    private VBox vBox;
    private BarangModel model;

    public Barang() {
        model = new BarangModel();
        vBox = new VBox();
        vBox.setSpacing(18);

        Label capaiMimpi = new Label("Kamu ingin mencapai mimpi kamu");
        capaiMimpi.setId("input");

        TextField textField1 = Method.createIntegerField(model::setBulanLagi, "Masukan nilai yang valid");
        Label bulan = new Label("Bulan lagi");
        bulan.setId("ket");

        Label error1 = new Label("");
        error1.setId("error");

        Label textField1Info = Method.makeTooltip(
                "Berapa lama lagi kamu ingin membeli barang impianmu.\n\nContoh: saat ini tahun 2024, dan kamu ingin membeli barang tersebut tahun 2029 maka 2029-2024 = 5 tahun. Lalu dikalikan dengan 12 menjadi 60 bulan. Maka yang dimasukkan adalah 60 bulan.");

        HBox hBox1 = new HBox();
        hBox1.setId("hBoxinput");
        hBox1.getChildren().addAll(textField1, bulan, error1, textField1Info);

        textField1.setOnKeyReleased(e -> {
            try {
                if (!textField1.getText().isEmpty()) {
                    error1.setText("");
                    int bulanLagi = Integer.parseInt(textField1.getText());
                    model.setBulanLagi(bulanLagi);
                } else {
                    error1.setText("");
                    if (textField1 != null) {
                        textField1.setText("");
                    }
                }
            } catch (NumberFormatException error) {
                textField1.clear();
                error1.setText("Masukan nilai yang valid");
            }
        });

        Label harga = new Label("Harga barang impianmu saat ini");
        harga.setId("input");

        Label rp1 = new Label("Rp.");
        rp1.setId("ket");

        Label error = new Label("");
        error.setId("error");

        TextField hargaBarang = new TextField();
        hargaBarang.setId("field");
        hargaBarang.setOnKeyReleased(event -> handleHargaBarangInput(hargaBarang, error));

        Label hargaBarangInfo = Method.makeTooltip("Harga barang yang ingin kamu beli saat mengisi ini");

        HBox hBox2 = new HBox();
        hBox2.setId("hBoxinput");
        hBox2.getChildren().addAll(rp1, hargaBarang, error, hargaBarangInfo);

        Label dp = new Label("% DP (Down Payment) yang ingin kamu bayarkan sebesar");
        dp.setId("input");

        Label error2 = new Label();
        error2.setId("error");

        TextField downPayment = new TextField();
        downPayment.setId("field2");

        Label persen = new Label("%");
        persen.setId("ket");

        Label dpInfo = Method.makeTooltip(
                "Down Payment (DP) atau Uang Muka.\n\nKalau kamu berencana membeli barang dengan sistem kredit, maka ada biaya awal yang harus kamu bayarkan, besaran DP biasanya berkisar antara 10-50%.\n\nKalau kamu berencana membeli barang secara cash, isi kolom dengan angka 100");

        HBox hBox3 = new HBox();
        hBox3.setId("hBoxinput");
        hBox3.getChildren().addAll(downPayment, persen, error2, dpInfo);

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

        Label pokokUtangInfo = Method.makeTooltip(
                "Kalau kamu membeli barang dengan sistem kredit, maka besaran biaya yang dibayarkan oleh peminjam akan diitung sebagai utang.\n\nContoh: harga barangmu 200.000.000 dan kamu ingin membayar DP-nya sebesar 10% yaitu 20.000.000 maka pokok utang kamu adalah 180.000.000");

        HBox hBox6 = new HBox();
        hBox6.setId("hBoxinput");
        hBox6.getChildren().addAll(rp3, pokokUtang, pokokUtangInfo);

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

        Button nextButton = new Button("Next >>");
        nextButton.setId("hasil");

        buttonBox.getChildren().add(nextButton);

        this.getChildren().add(buttonBox);

        nextButton.setOnAction(event -> switchToSecondForm(buttonBox, capaiMimpi, hBox1, harga, hBox2, dp, hBox3,
                dpKamu, hBox4, pinjaman, hBox5, utang,
                hBox6, nextButton));
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

    private void switchToSecondForm(HBox buttonBox, Label capaiMimpi, HBox hBox1, Label harga, HBox hBox2, Label dp,
            HBox hBox3, Label dpKamu, HBox hBox4, Label pinjaman, HBox hBox5, Label utang,
            HBox hBox6, Button nextButton) {
        vBox.getChildren().clear();

        Label asumsi = new Label("Asumsi inflasi harga");
        asumsi.setId("input");

        TextField asumsiInflasi = Method.createDoubleField(model::setAsumsiInflasi, "Masukan nilai yang valid");
        Label persenTahun = new Label("%/tahun");
        persenTahun.setId("ket");

        Label error3 = new Label("");
        error3.setId("error");
        asumsiInflasi.setOnKeyReleased(event -> handleRp4(asumsiInflasi, error3));

        Label asumsiInflasiInfo = Method.makeTooltip(
                "Secara sederhana, inflasi dapat diartikan sebagai penurunan nilai mata uang. Artinya, dengan jumlah uang yang sama, kamu dapat membeli lebih sedikit barang atau jasa dibandingkan sebelumnya.\n\nKamu bisa mencari data asumsi inflasi tahunan di website resmi bank Indonesia atau sumber terpercaya lainnya.");

        HBox hBox7 = new HBox();
        hBox7.setId("hBoxinput");
        hBox7.getChildren().addAll(asumsiInflasi, persenTahun, error3, asumsiInflasiInfo);

        Label total = new Label("Total uang yang kamu perlukan " + model.getBulanLagi() + " bulan lagi untuk bayar DP");
        total.setId("input");

        Label rp4 = new Label("Rp.");
        rp4.setId("ket");

        Label totalUang = new Label();
        totalUang.setId("rp4");

        Label totalInfo = Method.makeTooltip(
                "Dikarenakan inflasi setiap tahunnya, maka ini berpengaruh pada harga barang impianmu.\n\nContoh: pada tahun 2022 kamu ingin membeli barang seharga 10juta, tapi kamu baru bisa mengumpulkan uang untuk membayar DP di tahun 2027, dengan asumsi inflasi sebesar 5% / tahun, maka setiap tahun dari tahun 2022 - 2027, jumlah 10jt yang mau kamu akan bayarkan akan bertambah 5%, maka pada tahun 2027, jumlah yang harus kamu bayarkan menjadi sekitar 12jt.\n\nIni adalah total uang yang kamu perlukan untuk bayar DP.\n\nJika kamu memilih untuk bayar cash maka ini adalah total uang yang kamu perlukan untuk membayar harga barangmu sepenuhnya.");

        HBox hBox8 = new HBox();
        hBox8.setId("hBoxinput");
        hBox8.getChildren().addAll(rp4, totalUang, totalInfo);

        Label uang = new Label("Uang yang kamu miliki saat ini untuk beli barang sebesar");
        uang.setId("input");

        Label rp5 = new Label("Rp.");
        rp5.setId("ket");

        TextField uangSaatIni = Method.createDoubleField(model::setUangSaatIni, "Masukan nilai yang valid");
        uangSaatIni.setId("uangSaatIni");

        Label error4 = new Label();
        error4.setId("error");

        Label uangSaatIniInfo = Method.makeTooltip(
                "Uang yang sudah kamu tabung saat ini untuk membeli barang yang kamu inginkan.\n\nContoh: jika uangmu saat ini berjumlah 10.000.000 tapi uang yang kamu sisihkan untuk membeli barang impianmu hanya 2.000.000 maka isi 2.000.000 pada kolom.");

        HBox hBox9 = new HBox();
        hBox9.setId("hBoxinput");
        hBox9.getChildren().addAll(rp5, uangSaatIni, error4, uangSaatIniInfo);

        uangSaatIni.setOnKeyReleased(e -> {
            try {
                if (!uangSaatIni.getText().isEmpty()) {
                    error4.setText("");
                    double uangSaatIniValue = Double.parseDouble(uangSaatIni.getText());
                    model.setUangSaatIni(uangSaatIniValue);
                } else {
                    error4.setText("");
                    if (uangSaatIni != null) {
                        uangSaatIni.setText("");
                    }
                }
            } catch (NumberFormatException error) {
                uangSaatIni.clear();
                error4.setText("Masukan nilai yang valid");
            }
        });

        Label targetInvestasi = new Label("Target investasimu tiap bulan");
        targetInvestasi.setId("input");

        Label rp6 = new Label("Rp.");
        rp6.setId("ket");

        TextField target = Method.createDoubleField(model::setTargetInvestasiBulanan, "Masukan nilai yang valid");
        target.setId("uangSaatIni");

        Label error5 = new Label();
        error5.setId("error");

        Label targetInfo = Method.makeTooltip(
                "Berapa banyak jumlah uang yang akan kamu tabung setiap bulannya untuk membeli barang ini.");

        HBox hBox10 = new HBox();
        hBox10.setId("hBoxinput");
        hBox10.getChildren().addAll(rp6, target, error5, targetInfo);

        target.setOnKeyReleased(e -> {
            try {
                if (!target.getText().isEmpty()) {
                    double targetValue = Double.parseDouble(target.getText());
                    model.setReturnInvestasiTahunan(targetValue);
                    handleRutin(target);
                    error5.setText("");
                } else {
                    error5.setText("");
                    if (target != null) {
                        target.setText("");
                    }
                }
            } catch (NumberFormatException error) {
                target.clear();
                error5.setText("Masukan nilai yang valid");
            }
        });

        Label invest = new Label("Kamu akan investasi di produk yang return-nya");
        invest.setId("input");

        TextField lnvestProduk = Method.createDoubleField(model::setReturnInvestasiTahunan, "Masukan nilai yang valid");
        Label investasi = new Label("%/tahun");
        investasi.setId("ket");

        Label error6 = new Label();
        error6.setId("error");

        Label lnvestProdukInfo = Method.makeTooltip(
                "Dengan asumsi kamu akan menaruh uang tabunganmu pada instrumen investasi.\n\nContoh: Kamu ingin menaruh uangmu di Reksadana Pasar Uang pada sebuah aplikasi, dan disana diberikan keterangan bahwa return per-tahunnya adalah 5%, maka isikan angka 5 pada kolom di bawah.");

        HBox hBox11 = new HBox();
        hBox11.setId("hBoxinput");
        hBox11.getChildren().addAll(lnvestProduk, investasi, error6, lnvestProdukInfo);

        Label berinvestasi = new Label("Kamu akan rutin berinvestasi selama");
        berinvestasi.setId("input");

        Label rutin = new Label();
        rutin.setId("rutin");

        lnvestProduk.setOnKeyReleased(e -> {
            try {
                if (!lnvestProduk.getText().isEmpty()) {
                    double lnvestProdukValue = Double.parseDouble(lnvestProduk.getText());
                    model.setReturnInvestasiTahunan(lnvestProdukValue);
                    handleRutin(lnvestProduk);
                    error6.setText("");
                } else {
                    error6.setText("");
                    if (lnvestProduk != null) {
                        lnvestProduk.setText("");
                    }
                }
            } catch (NumberFormatException error) {
                lnvestProduk.clear();
                error6.setText("Masukan nilai yang valid");
            }
        });

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
        Button backButton = new Button("<< Back");
        backButton.setId("hasil");

        // Create a spacer
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        buttonBox.getChildren().addAll(backButton, spacer, hasilButton);

        hasilButton.setOnAction(event -> evaluatePlan(totalUang, uangSaatIni, target, lnvestProduk, rutin));
        backButton.setOnAction(event -> {
            vBox.getChildren().clear();
            vBox.getChildren().addAll(capaiMimpi, hBox1, harga, hBox2, dp, hBox3, dpKamu, hBox4, pinjaman, hBox5, utang,
                    hBox6);
            buttonBox.getChildren().clear();
            buttonBox.getChildren().add(nextButton);
        });
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
                double asumsiInflasiValue = Double.parseDouble(asumsiInflasi.getText());
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
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Evaluasi Rencana");
        alert.setHeaderText(title);
        alert.setContentText(message.toString());
        alert.getDialogPane().setId("alert");

        // Tambahkan file CSS ke alert
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        Scene scene = stage.getScene();
        scene.getStylesheets().add(getClass().getResource("/styles/style.css").toExternalForm());

        alert.showAndWait();
    }

    private String getTips(double totalUangDiperlukan, double totalInvestasi) {
        StringBuilder tips = new StringBuilder();
        tips.append("Total uang yang diperlukan: Rp. ").append(Method.formatNumber(totalUangDiperlukan)).append("\n");
        tips.append("Total uang yang akan terkumpul: Rp. ").append(Method.formatNumber(totalInvestasi)).append("\n");
        tips.append("\nTips agar rencana kamu lebih realistis:\n");
        tips.append("- Tingkatkan jumlah investasi bulanan.\n");
        tips.append("- Cari produk investasi dengan return yang lebih tinggi.\n");
        tips.append("- Kurangi target harga barang atau DP yang diinginkan.\n");
        tips.append("- Tambahkan waktu untuk mencapai targetmu.\n");
        return tips.toString();
    }
}
