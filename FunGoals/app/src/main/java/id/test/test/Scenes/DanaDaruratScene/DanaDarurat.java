package id.test.test;

import java.text.DecimalFormat;

import id.test.test.Barang.ValueSetter;
import id.test.test.Models.DanaDaruratModel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DanaDarurat extends VBox implements Method {
    private StackPane backgroundPane;
    private DanaDaruratModel model = new DanaDaruratModel();

    public DanaDarurat(StackPane backgroundPane) {
        this.backgroundPane = backgroundPane;
        createScene();
    }

    public void createScene() {
        VBox vBox = new VBox();
        vBox.setSpacing(18);

        Label pengeluaran = new Label("Pengeluaran wajibmu setiap bulan");
        pengeluaran.setId("input");

        Label rp = new Label("Rp.");
        rp.setId("ket");

        TextField textField1 = Method.createDoubleField(model::setPengeluaranWajibTiapBulan,
                "Masukan nilai yang valid");
        textField1.setId("field");

        Label error1 = new Label();
        error1.setId("error");

        Label textField1Info = Method.makeTooltip(
                "Hitung besarnya pengeluaran pokok bulanan mu. Pengeluaran untuk nongkrong dan lain lain tidak termasuk.\n\nContoh : Bayar kos 2,5jt, listrik 500k, pulsa 150k, transport 1jt. Berarti kolom ini diisi 3,250,000.");

        HBox hBox1 = new HBox();
        hBox1.setId("hBoxinput");
        hBox1.getChildren().addAll(rp, textField1, error1, textField1Info);

        textField1.setOnKeyReleased(e -> {
            try {
                if (!textField1.getText().isEmpty()) {
                    double textField1Value = Double.parseDouble(textField1.getText());
                    model.setPengeluaranWajibTiapBulan(textField1Value);
                    error1.setText("");
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

        Label tanggungan = new Label("Jumlah tanggunganmu");
        tanggungan.setId("input");

        TextField textField2 = Method.createIntegerField(model::setJumlahTanggungan, "Masukkan nilai yang valid");
        textField2.setId("field2");

        Label orang = new Label("Orang");
        orang.setId("ket");

        Label error2 = new Label();
        error2.setId("error");

        Label textField2Info = Method.makeTooltip(
                "Banyaknya orang yang bergantung pada penghasilanmu.\n\nContoh: orang tua, anak/istri, saudara, tetangga, istri tetangga, dll.");

        HBox hBox2 = new HBox();
        hBox2.setId("hBoxinput");
        hBox2.getChildren().addAll(textField2, orang, error2, textField2Info);

        textField2.setOnKeyReleased(e -> {
            try {
                if (!textField2.getText().isEmpty()) {
                    int textField2Value = Integer.parseInt(textField2.getText());
                    model.setJumlahTanggungan(textField2Value);
                    error2.setText("");
                } else {
                    error2.setText("");
                    if (textField2 != null) {
                        textField2.setText("");
                    }
                }
            } catch (NumberFormatException error) {
                textField2.clear();
                error2.setText("Masukan nilai yang valid");
            }
        });

        Label lamatarget = new Label("Berapa lama targetmu mengumpulkan dana darurat?");
        lamatarget.setId("input");

        TextField textField3 = Method.createDoubleField(model::setLamaTargetMengumpulkan, "Masukkan nilai yang valid");
        textField3.setId("field2");

        Label bulan = new Label("Bulan");
        bulan.setId("ket");

        Label error3 = new Label();
        error3.setId("error");

        Label textField3Info = Method.makeTooltip("Berapa lama targetmu sampai dana daruratmu terkumpul sepenuhnya?");

        HBox hBox3 = new HBox();
        hBox3.setId("hBoxinput");
        hBox3.getChildren().addAll(textField3, bulan, error3, textField3Info);

        textField3.setOnKeyReleased(e -> {
            try {
                if (!textField3.getText().isEmpty()) {
                    double textField3Value = Double.parseDouble(textField3.getText());
                    model.setLamaTargetMengumpulkan(textField3Value);
                    error3.setText("");
                } else {
                    error3.setText("");
                    if (textField3 != null) {
                        textField3.setText("");
                    }
                }
            } catch (NumberFormatException error) {
                textField3.clear();
                error3.setText("Masukan nilai yang valid");
            }
        });

        Label jumlah = new Label("Jumlah dana darurat yang kamu miliki saat ini.");
        jumlah.setId("input");

        Label rp2 = new Label("Rp.");
        rp2.setId("ket");

        TextField textField4 = Method.createDoubleField(model::setDanaDaruratSaatIni, "Masukkan nilai yang valid");
        textField4.setId("field");

        Label error4 = new Label();
        error4.setId("error");

        Label textField4Info = Method.makeTooltip(
                "Berapa jumlah dana darurat yang telah kamu kumpulkan saat ini?\n\nContoh: uang kamu saat ini adalah 10.000.000, namun uang yang kamu sisihkan khusus untuk dana darurat hanya 1.000.000 maka isi 1.000.000 pada kolom.");

        HBox hBox4 = new HBox();
        hBox4.setId("hBoxinput");
        hBox4.getChildren().addAll(rp2, textField4, error4, textField4Info);

        textField4.setOnKeyReleased(e -> {
            try {
                if (!textField4.getText().isEmpty()) {
                    double textField4Value = Double.parseDouble(textField4.getText());
                    model.setDanaDaruratSaatIni(textField4Value);
                    error4.setText("");
                } else {
                    error4.setText("");
                    if (textField4 != null) {
                        textField4.setText("");
                    }
                }
            } catch (NumberFormatException error) {
                textField4.clear();
                error4.setText("Masukan nilai yang valid");
            }
        });

        Label target = new Label("Target investasi kamu setiap bulan");
        target.setId("input");

        Label rp3 = new Label("Rp.");
        rp3.setId("ket");

        TextField textField5 = Method.createDoubleField(model::setTargetInvestasiTiapBulan,
                "Masukkan nilai yang valid");
        textField5.setId("field");

        Label error5 = new Label();
        error5.setId("error");

        Label textField5Info = Method.makeTooltip(
                "Jumlah uang yang akan kamu tabung khusus unutuk dana darurat.\n\nContoh: memiliki penghasilan 5.000.000/bulan dan kamu menyisihkan 500.000 untuk dana pernikahan dan 500.000 untuk dana darurat. Maka kamu harus mengisi 500.000 pada kolom.");

        HBox hBox5 = new HBox();
        hBox5.setId("hBoxinput");
        hBox5.getChildren().addAll(rp3, textField5, error5, textField5Info);

        textField5.setOnKeyReleased(e -> {
            try {
                if (!textField5.getText().isEmpty()) {
                    double textField5Value = Double.parseDouble(textField5.getText());
                    model.setTargetInvestasiTiapBulan(textField5Value);
                    error5.setText("");
                } else {
                    error5.setText("");
                    if (textField5 != null) {
                        textField5.setText("");
                    }
                }
            } catch (NumberFormatException error) {
                textField5.clear();
                error5.setText("Masukan nilai yang valid");
            }
        });

        Label investasi = new Label("Kamu akan investasi di produk yang returnnya");
        investasi.setId("input");

        TextField textField6 = Method.createDoubleField(model::setReturnInvestasiPerTahun, "Masukkan nilai yang valid");
        textField6.setId("field2");

        Label tahun = new Label("%/tahun");
        tahun.setId("ket");

        Label error6 = new Label();
        error6.setId("error");

        Label textField6Info = Method.makeTooltip(
                "Jika kamu akan menaruh dana darurat pada instrumen investasi, masukkan perkiraan return tahunannya. Disarankan aset yang lebih rendah risiko, dengan return maksimal ~10% per tahun.\n\nKamu boleh masukkan data desimal dengan menggunakan titik, misal 5.75% atau 10.5%.");

        HBox hBox6 = new HBox();
        hBox6.setId("hBoxinput");
        hBox6.getChildren().addAll(textField6, tahun, error6, textField6Info);

        textField6.setOnKeyReleased(e -> {
            try {
                if (!textField6.getText().isEmpty()) {
                    double textField6Value = Double.parseDouble(textField6.getText());
                    model.setReturnInvestasiPerTahun(textField6Value);
                    error6.setText("");
                } else {
                    error6.setText("");
                    if (textField6 != null) {
                        textField6.setText("");
                    }
                }
            } catch (NumberFormatException error) {
                textField6.clear();
                error6.setText("Masukan nilai yang valid");
            }
        });

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

        hasilButton
                .setOnAction(e -> evaluatePlan(textField1, textField2, textField3, textField4, textField5, textField6));
    }

    private void evaluatePlan(TextField textField1, TextField textField2, TextField textField3, TextField textField4,
            TextField textField5, TextField textField6) {
        try {
            double pengeluaranWajibTiapBulan = Double.parseDouble(textField1.getText().replace(",", ""));
            int jumlahTanggungan = Integer.parseInt(textField2.getText());
            double lamaTargetMengumpulkan = Double.parseDouble(textField3.getText());
            double danaDaruratSaatIni = Double.parseDouble(textField4.getText().replace(",", ""));
            double targetInvestasiBulan = Double.parseDouble(textField5.getText().replace(",", ""));
            double returnInvestasiTahun = Double.parseDouble(textField6.getText());

            model.hitungInvestasi();
            model.setHasilDanaDarurat();

            double hasilInvestasi = model.getHasilInvestasi();

            if (hasilInvestasi >= model.getHasilDanaDarurat()) {
                showResultScene(
                        "Rencana kamu realistis!\nKamu akan mencapai tujuanmu dengan investasi bulanan yang direncanakan.",
                        showInfoBerhasil());
            } else {
                showResultScene("Rencana kamu belum realistis!\nPeriksa kembali strategi investasimu.",
                        showInfoGagal());
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

    private String showInfoBerhasil() {
        StringBuilder tips = new StringBuilder();
        tips.append("Dana darurat yang kamu butuhkan: Rp").append(Method.formatNumber(model.getHasilDanaDarurat()))
                .append("\n");
        tips.append("Rekomendasi alokasi dana darurat: Rp")
                .append(Method.formatNumber(model.getHasilDanaDarurat() * 0.50)).append(" untuk tabungan dan ")
                .append(Method.formatNumber(model.getHasilDanaDarurat() * 0.50)).append(" untuk instrumen investasi\n");
        tips.append("\nStrategimu:\n");
        tips.append("- Dana daruratmu saat ini: Rp").append(Method.formatNumber(model.getDanaDaruratSaatIni()))
                .append("\n");
        tips.append("- Jumlah investasi/bulan: Rp").append(Method.formatNumber(model.getTargetInvestasiTiapBulan()))
                .append("\n");
        tips.append("- Return investasi: ")
                .append(Method.formatDoubleToPercent(model.getReturnInvestasiPerTahun())).append("\n");
        tips.append("- Lama investasi: ").append(Method.formatDouble(model.getLamaTargetMengumpulkan())).append("\n");
        tips.append("- Hasil investasi: Rp").append(Method.formatNumber(model.getHasilInvestasi())).append("\n");
        return tips.toString();
    }

    private String showInfoGagal() {
        StringBuilder tips = new StringBuilder();
        tips.append("Dana darurat yang kamu butuhkan: Rp").append(Method.formatNumber(model.getHasilDanaDarurat()))
                .append("\n");
        tips.append("Rekomendasi alokasi dana darurat: Rp")
                .append(Method.formatNumber(model.getHasilDanaDarurat() * 0.50)).append(" untuk tabungan dan ")
                .append(Method.formatNumber(model.getHasilDanaDarurat() * 0.50)).append(" untuk instrumen investasi\n");
        tips.append("\nStrategimu:\n");
        tips.append("- Dana daruratmu saat ini: Rp").append(Method.formatNumber(model.getDanaDaruratSaatIni()))
                .append("\n");
        tips.append("- Jumlah investasi/bulan: Rp").append(Method.formatNumber(model.getTargetInvestasiTiapBulan()))
                .append("\n");
        tips.append("- Return investasi: ")
                .append(Method.formatDoubleToPercent(model.getReturnInvestasiPerTahun())).append("\n");
        tips.append("- Lama investasi: ").append(Method.formatDouble(model.getLamaTargetMengumpulkan())).append("\n");
        tips.append("- Hasil investasi: Rp").append(Method.formatNumber(model.getHasilInvestasi())).append(" (kurang ")
                .append(Method.formatNumber(model.getHasilDanaDarurat() - model.getHasilInvestasi())).append(")\n");
        tips.append("\nTips agar rencana kamu lebih realistis:\n");
        tips.append("- Tingkatkan jumlah investasi bulanan.\n");
        tips.append("- Cari produk investasi dengan return yang lebih tinggi.\n");
        tips.append("- Tambahkan waktu untuk mencapai targetmu.\n");
        return tips.toString();
    }
}
