package id.test.test;

import java.text.DecimalFormat;
import id.test.test.Barang.ValueSetter;
import javafx.scene.control.TextField;

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
}