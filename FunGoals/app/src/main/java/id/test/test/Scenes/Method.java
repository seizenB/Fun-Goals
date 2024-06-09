package id.test.test;

import java.text.DecimalFormat;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Optional;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import id.test.test.Barang.ValueSetter;

public interface Method {
    public static String formatDouble(double value) {
        String stringValue = String.valueOf(value);
        String formattedValue = stringValue.replaceAll("\\.[0]*$", "") + " bulan";

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

    public static String formatNumber(double number) {
        DecimalFormat df = new DecimalFormat("###,###,###.00");
        return df.format(number);
    }

    public static String formatDoubleToPercent(double value) {
        String stringValue = String.valueOf(value);
        String formattedValue = stringValue.replaceAll("\\.[0]*$", "") + "%";

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

    public static TextField createDoubleField(ValueSetter<Double> setter, String errorMessage) {
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

    public static TextField createIntegerField(ValueSetter<Integer> setter, String errorMessage) {
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

    public static Label makeTooltip(String message) {
        Image info = new Image(Method.class.getResourceAsStream("/img/info.png"));
        ImageView infoView = new ImageView(info);

        infoView.setFitWidth(20);
        infoView.setFitHeight(20);

        Tooltip textFieldtooltip = new Tooltip(message);
        textFieldtooltip.setMaxWidth(300);
        textFieldtooltip.setId("custom-tooltip");

        // Menggunakan Label untuk mendukung Tooltip
        Label infoLabel = new Label("", infoView);
        Tooltip.install(infoLabel, textFieldtooltip);

        infoLabel.setOnMouseClicked(event -> {
            if (textFieldtooltip.isShowing()) {
                textFieldtooltip.hide();
            } else {
                textFieldtooltip.show(infoLabel, event.getScreenX(), event.getScreenY() + 10);
            }
        });
        return infoLabel;
    }
}