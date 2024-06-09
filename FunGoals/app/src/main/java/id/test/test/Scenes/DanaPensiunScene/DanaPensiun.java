package id.test.test;

import javafx.scene.layout.Region;
import javafx.scene.layout.Priority;
import id.test.test.HomeScene;
import id.test.test.Models.DanaPensiunModel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DanaPensiun extends VBox implements Method {
    private VBox vBox;
    private DanaPensiunModel model = new DanaPensiunModel();

    public DanaPensiun() {

        vBox = new VBox();
        vBox.setSpacing(18);

        Label pengeluaran = new Label("Pengeluaran/bulan");
        pengeluaran.setId("input");

        Label rp = new Label("Rp.");
        rp.setId("ket");

        TextField textField1 = Method.createDoubleField(model::setPengeluaranPerBulan, "Masukkan nilai yang valid");
        textField1.setId("field");

        Label error1 = new Label();
        error1.setId("error");

        Label textField1Info = Method.makeTooltip(
                "Jumlah uang yang harus kamu keluarkan setiap bulannya untuk hidup. Termasuk biaya sewa/kos, makan, dll.");

        HBox hBox1 = new HBox();
        hBox1.setId("hBoxinput");
        hBox1.getChildren().addAll(rp, textField1, error1, textField1Info);

        Label pengeluaranPerTahun = new Label("Pengeluaran/tahun");
        pengeluaranPerTahun.setId("input");

        Label rp1 = new Label("Rp.");
        rp1.setId("ket");

        Label tahun = new Label();
        tahun.setId("tahun");
        tahun.setVisible(false);

        Label pengeluaranPerTahunInfo = Method
                .makeTooltip("Pengeluaranmu perbulan dikali 12.");

        HBox hBox2 = new HBox();
        hBox2.setId("hBoxinput");
        hBox2.getChildren().addAll(rp1, tahun, pengeluaranPerTahunInfo);

        Label usia = new Label("Usiamu sekarang");
        usia.setId("input");

        TextField textField2 = Method.createIntegerField(model::setUsiaSekarang, "Masukkan nilai yang valid");
        textField2.setId("field2");

        Label usiasekarang = new Label("tahun");
        usiasekarang.setId("ket");

        Label error2 = new Label();
        error2.setId("error");

        Label textField2Info = Method.makeTooltip("Usia saat kamu mengisi ini.");

        HBox hBox3 = new HBox();
        hBox3.setId("hBoxinput");
        hBox3.getChildren().addAll(textField2, usiasekarang, error2, textField2Info);

        textField2.setOnKeyReleased(e -> {
            try {
                if (!textField2.getText().isEmpty()) {
                    int textField2Value = Integer.parseInt(textField2.getText());
                    model.setUsiaSekarang(textField2Value);
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

        Label usia2 = new Label("Kamu ingin pensiun di usia");
        usia2.setId("input");

        TextField textField3 = Method.createIntegerField(model::setUsiaPensiun, "Masukkan nilai yang valid");
        textField3.setId("field2");

        Label usiapensiun = new Label("tahun");
        usiapensiun.setId("ket");

        Label error3 = new Label();
        error3.setId("error");

        Label textField3Info = Method.makeTooltip("Target usia kamu saat kamu sudah tidak lagi bekerja.");

        HBox hBox4 = new HBox();
        hBox4.setId("hBoxinput");
        hBox4.getChildren().addAll(textField3, usiapensiun, error3, textField3Info);

        textField3.setOnKeyReleased(e -> {
            try {
                if (!textField3.getText().isEmpty()) {
                    int textField3Value = Integer.parseInt(textField3.getText());
                    model.setUsiaPensiun(textField3Value);
                    if (model.getUsiaPensiun() < model.getUsiaSekarang() + 1) {
                        throw new IllegalStateException();
                    } else {
                        model.setLamaWaktuPensiun();
                    }
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
            } catch (IllegalStateException err) {
                textField3.clear();
                error3.setText("Usia pensiun harus lebih besar dari usia sekarang");
            }
        });

        Label inflasi = new Label("Asumsi inflasi tahunan");
        inflasi.setId("input");

        TextField textField4 = Method.createDoubleField(model::setAsumsiInflasiPerTahun, "Masukkan nilai yang valid");
        textField4.setId("field2");

        Label persen = new Label("%/tahun");
        persen.setId("ket");

        Label error4 = new Label();
        error4.setId("error");

        Label asumsiInflasiInfo = Method.makeTooltip(
                "Secara sederhana, inflasi dapat diartikan sebagai penurunan nilai mata uang. Artinya, dengan jumlah uang yang sama, kamu dapat membeli lebih sedikit barang atau jasa dibandingkan sebelumnya.\n\nKamu bisa mencari data asumsi inflasi tahunan di website resmi bank Indonesia atau sumber terpercaya lainnya.");

        HBox hBox5 = new HBox();
        hBox5.setId("hBoxinput");
        hBox5.getChildren().addAll(textField4, persen, error4, asumsiInflasiInfo);

        Label pengeluaranpensiun = new Label("Pengeluaran tahunan saat mulai pensiun nanti");
        pengeluaranpensiun.setId("input");

        Label rp2 = new Label("Rp.");
        rp2.setId("ket");

        Label pengeluarantahunan = new Label();
        pengeluarantahunan.setId("rp2");
        pengeluarantahunan.setVisible(false);

        Label pengeluarantahunanInfo = Method.makeTooltip("Jumlah pengeluaranmu tiap tahun setelah terkena inflasi.");

        HBox hBox6 = new HBox();
        hBox6.setId("hBoxinput");
        hBox6.getChildren().addAll(rp2, pengeluarantahunan, pengeluarantahunanInfo);

        vBox.getChildren().addAll(pengeluaran, hBox1, pengeluaranPerTahun, hBox2, usia, hBox3, usia2, hBox4, inflasi,
                hBox5, pengeluaranpensiun, hBox6);

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

        textField1.setOnKeyReleased(event -> {
            try {
                if (!textField1.getText().isEmpty()) {
                    double textField1Value = Double.parseDouble(textField1.getText());
                    model.setPengeluaranPerBulan(textField1Value);
                    error1.setText("");
                    tahun.setVisible(true);
                    updateTahunLabel();
                } else {
                    tahun.setVisible(false);
                    tahun.setText("");
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

        textField4.setOnKeyReleased(e -> {
            try {
                if (!textField4.getText().isEmpty()) {
                    double textField4Value = Double.parseDouble(textField4.getText());
                    model.setAsumsiInflasiPerTahun(textField4Value);
                    error4.setText("");
                    pengeluarantahunan.setVisible(true);
                    updateRp2Label();
                    model.setUangYangDibutuhkan();
                } else {
                    pengeluarantahunan.setVisible(false);
                    pengeluarantahunan.setText("");
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

        nextButton.setOnAction(event -> {

            vBox.getChildren().clear();

            Label pemasukan = new Label(
                    "Uang yang kamu butuhkan " + model.getLamaWaktuPensiun() + " tahun lagi berdasarkan 4% rule");
            pemasukan.setId("input");

            Label rp3 = new Label("Rp.");
            rp3.setId("ket");

            Label uangYangDibutuhkan = new Label(Method.formatNumber(model.getUangYangDibutuhkan()));
            uangYangDibutuhkan.setId("uangYangDibutuhkan");

            Label uangYangDibutuhkanInfo = Method.makeTooltip(
                    "Aturan 4% (4% Rule) adalah strategi penarikan dana pensiun yang populer yang merekomendasikan untuk menarik tidak lebih dari 4% dari total dana pensiun Anda di tahun pertama pensiun, dan kemudian menyesuaikan jumlah penarikan setiap tahun untuk inflasi.");

            HBox hBox7 = new HBox();
            hBox7.setId("hBoxinput");
            hBox7.getChildren().addAll(rp3, uangYangDibutuhkan, uangYangDibutuhkanInfo);

            Label dana = new Label("Dana pensiun yang telah tersedia sampai saat ini");
            dana.setId("input");

            Label rp4 = new Label("Rp.");
            rp4.setId("ket");

            TextField danaPensiun = Method.createDoubleField(model::setDanaPensiunSaatIni, "Masukkan nilai yang valid");
            danaPensiun.setId("field");

            Label error5 = new Label();
            error5.setId("error");

            Label danaPensiunInfo = Method.makeTooltip(
                    "Jumlah tabungan untuk dana pensiun yang sudah terkumpul sampai dengan saat kamu mengisi ini.");

            HBox hBox8 = new HBox();
            hBox8.setId("hBoxinput");
            hBox8.getChildren().addAll(rp4, danaPensiun, error5, danaPensiunInfo);

            danaPensiun.setOnKeyReleased(e -> {
                try {
                    if (!danaPensiun.getText().isEmpty()) {
                        double danaPensiunValue = Double.parseDouble(danaPensiun.getText());
                        model.setDanaPensiunSaatIni(danaPensiunValue);
                        error5.setText("");
                    } else {
                        error5.setText("");
                        if (danaPensiun != null) {
                            danaPensiun.setText("");
                        }
                    }
                } catch (NumberFormatException error) {
                    danaPensiun.clear();
                    error5.setText("Masukan nilai yang valid");
                }
            });

            Label target = new Label("Target investasimu tiap bulan");
            target.setId("input");

            Label rp5 = new Label("Rp.");
            rp5.setId("ket");

            TextField targetInvestasi = Method.createDoubleField(model::setTargetInvestasiTiapBulan,
                    "Masukkan nilai yang valid");
            targetInvestasi.setId("field");

            Label error6 = new Label();
            error6.setId("error");

            Label targetInvestasiInfo = Method.makeTooltip(
                    "Berapa banyak jumlah uang yang akan kamu tabung setiap bulannya untuk membeli barang ini.");

            HBox hBox9 = new HBox();
            hBox9.setId("hBoxinput");
            hBox9.getChildren().addAll(rp5, targetInvestasi, error6, targetInvestasiInfo);

            targetInvestasi.setOnKeyReleased(e -> {
                try {
                    if (!targetInvestasi.getText().isEmpty()) {
                        double targetInvestasiValue = Double.parseDouble(targetInvestasi.getText());
                        model.setTargetInvestasiTiapBulan(targetInvestasiValue);
                        error6.setText("");
                    } else {
                        error6.setText("");
                        if (targetInvestasi != null) {
                            targetInvestasi.setText("");
                        }
                    }
                } catch (NumberFormatException error) {
                    targetInvestasi.clear();
                    error6.setText("Masukan nilai yang valid");
                }
            });

            Label targetReturn = new Label("Target return investasi per tahun");
            targetReturn.setId("input");

            TextField returnInvestasi = Method.createDoubleField(model::setReturnInvestasiPerTahun,
                    "Masukkan nilai yang valid");
            returnInvestasi.setId("field2");

            Label persenTahun = new Label("%/tahun");
            persenTahun.setId("ket");

            Label error7 = new Label();
            error7.setId("error");

            Label returnInvestasiInfo = Method.makeTooltip(
                    "Dengan asumsi kamu akan menaruh uang tabunganmu pada instrumen investasi.\n\nContoh: Kamu ingin menaruh uangmu di Reksadana Pasar Uang pada sebuah aplikasi, dan disana diberikan keterangan bahwa return per-tahunnya adalah 5%, maka isikan angka 5 pada kolom di bawah.");

            HBox hBox10 = new HBox();
            hBox10.setId("hBoxinput");
            hBox10.getChildren().addAll(returnInvestasi, persenTahun, error7, returnInvestasiInfo);

            Label pensiun = new Label("Kamu akan pensiun dalam");
            pensiun.setId("input");

            Label masaPensiun = new Label();
            masaPensiun.setId("masaPensiun");

            Label tahunPensiun = new Label("Tahun");
            tahunPensiun.setId("ket");

            HBox hBox11 = new HBox();
            hBox11.setId("hBoxinput");
            hBox11.getChildren().addAll(masaPensiun, tahunPensiun);

            returnInvestasi.setOnKeyReleased(e -> {
                try {
                    if (!returnInvestasi.getText().isEmpty()) {
                        Double returnInvestasiValue = Double.parseDouble(returnInvestasi.getText());
                        model.setReturnInvestasiPerTahun(returnInvestasiValue);
                        error7.setText("");

                        masaPensiun.setText(String.valueOf(model.getLamaWaktuPensiun()));
                    } else {
                        error7.setText("");
                        if (returnInvestasi != null) {
                            returnInvestasi.setText("");
                        }
                    }
                } catch (NumberFormatException error) {
                    returnInvestasi.clear();
                    error7.setText("Masukan nilai yang valid");
                }
            });

            vBox.getChildren().addAll(pemasukan, hBox7, dana, hBox8, target, hBox9, targetReturn, hBox10, pensiun,
                    hBox11);

            buttonBox.getChildren().clear();
            Button hasilButton = new Button("Lihat hasil strategimu");
            hasilButton.setId("hasil");
            Button backButton = new Button("<< Back");
            backButton.setId("hasil");

            // Create a spacer
            Region spacer = new Region();
            HBox.setHgrow(spacer, Priority.ALWAYS);

            buttonBox.getChildren().addAll(backButton, spacer, hasilButton);
            hasilButton.setOnAction(e -> evaluatePlan(textField1, textField2, textField3, textField4, danaPensiun,
                    targetInvestasi, returnInvestasi));
            backButton.setOnAction(e -> {
                vBox.getChildren().clear();
                vBox.getChildren().addAll(pengeluaran, hBox1, pengeluaranPerTahun, hBox2, usia, hBox3, usia2, hBox4,
                        inflasi,
                        hBox5, pengeluaranpensiun, hBox6);
                buttonBox.getChildren().clear();
                buttonBox.getChildren().add(nextButton);

            });
        });
    }

    private void updateTahunLabel() {
        Label tahunValue = (Label) vBox.lookup("#tahun");
        if (tahunValue != null) {
            double tahun = model.getPengeluaranPerTahun();
            tahunValue.setText(Method.formatNumber(tahun));
        }
    }

    private void updateRp2Label() {
        Label rp2Label = (Label) vBox.lookup("#rp2");
        if (rp2Label != null) {
            double monthlyInflationRate = (model.getAsumsiInflasiPerTahun() / 100);
            double rp2Value = model.getPengeluaranPerTahun()
                    * Math.pow((1 + monthlyInflationRate), (model.getLamaWaktuPensiun()));

            model.setPengeluaranTahunanSaatPensiun(rp2Value);
            rp2Label.setText(Method.formatNumber(rp2Value));
        }

    }

    private void evaluatePlan(TextField textField1, TextField textField2, TextField textField3, TextField textField4,
            TextField textField5, TextField textField6, TextField textField7) {
        try {
            double pengeluaranPerBulan = Double.parseDouble(textField1.getText().replace(",", ""));
            int usiaSekarang = Integer.parseInt(textField2.getText());
            int usiaPensiun = Integer.parseInt(textField3.getText());
            double asumsiInflasiPerTahun = Double.parseDouble(textField4.getText().replace(",", ""));
            double danaPensiunSaatIni = Double.parseDouble(textField5.getText().replace(",", ""));
            double targetInvestasiPerBulan = Double.parseDouble(textField6.getText().replace(",", ""));
            double returnInvestasiPerTahun = Double.parseDouble(textField7.getText());

            model.hitungInvestasi();

            double hasilInvestasi = model.getHasilInvestasi();

            if (hasilInvestasi >= model.getUangYangDibutuhkan()) {
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
        tips.append("Total uang yang kamu butuhkan: Rp").append(Method.formatNumber(model.getUangYangDibutuhkan()))
                .append("\n");
        tips.append("\nStrategimu:\n");
        tips.append("- Uangmu saat ini: Rp").append(Method.formatNumber(model.getDanaPensiunSaatIni()))
                .append("\n");
        tips.append("- Jumlah investasi/bulan: Rp").append(Method.formatNumber(model.getTargetInvestasiTiapBulan()))
                .append("\n");
        tips.append("- Return investasi: ")
                .append(Method.formatDoubleToPercent(model.getReturnInvestasiPerTahun())).append("\n");
        tips.append("- Lama investasi: ").append(DanaPensiun.formatDouble(model.getLamaWaktuPensiun())).append("\n");
        tips.append("- Hasil investasi: Rp").append(Method.formatNumber(model.getHasilInvestasi())).append("\n");
        return tips.toString();
    }

    private String showInfoGagal() {
        StringBuilder tips = new StringBuilder();
        tips.append("Total uang yang kamu butuhkan: Rp").append(Method.formatNumber(model.getUangYangDibutuhkan()))
                .append("\n");
        tips.append("\nStrategimu:\n");
        tips.append("- Uangmu saat ini: Rp").append(Method.formatNumber(model.getDanaPensiunSaatIni()))
                .append("\n");
        tips.append("- Jumlah investasi/bulan: Rp").append(Method.formatNumber(model.getTargetInvestasiTiapBulan()))
                .append("\n");
        tips.append("- Return investasi: ")
                .append(Method.formatDoubleToPercent(model.getReturnInvestasiPerTahun())).append("\n");
        tips.append("- Lama investasi: ").append(DanaPensiun.formatDouble(model.getLamaWaktuPensiun())).append("\n");
        tips.append("- Hasil investasi: Rp").append(Method.formatNumber(model.getHasilInvestasi())).append(" (kurang ")
                .append(Method.formatNumber(model.getUangYangDibutuhkan() - model.getHasilInvestasi())).append(")\n");
        tips.append("\nTips agar rencana kamu lebih realistis:\n");
        tips.append("- Tingkatkan jumlah investasi bulanan.\n");
        tips.append("- Cari produk investasi dengan return yang lebih tinggi.\n");
        tips.append("- Tunda untuk pensiun.\n");
        return tips.toString();
    }

    // Overload
    public static String formatDouble(double value) {
        String stringValue = String.valueOf(value);
        String formattedValue = stringValue.replaceAll("\\.[0]*$", "") + " tahun";

        boolean isInteger = true;
        for (char c : formattedValue.toCharArray()) {
            if (!Character.isDigit(c)) {
                isInteger = false;
                break;
            }
        }

        if (isInteger) {
            formattedValue = formattedValue.substring(0, formattedValue.length() - 2);
        }

        return formattedValue;
    }
}