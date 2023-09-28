package ConverterProjects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnitConverterApp {
    private JFrame frame;
    private JPanel panel;
    private JTextField inputField;
    private JComboBox<String> fromUnitComboBox;
    private JComboBox<String> toUnitComboBox;
    private JButton convertButton;
    private JLabel resultLabel;

    public UnitConverterApp() {
        frame = new JFrame("Unit Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        inputField = new JTextField(10);
        fromUnitComboBox = new JComboBox<>(
                new String[] { "Celsius", "Fahrenheit", "Kelvin", "Kilogram", "Gram", "Meter", "Feet", "Inch", "g/cm³",
                        "Kg/m³", "lb/ft³", "m/s", "Km/hr", "mph" });
        toUnitComboBox = new JComboBox<>(
                new String[] { "Celsius", "Fahrenheit", "Kelvin", "Kilogram", "Gram", "Meter", "Feet", "Inch", "g/cm³",
                        "Kg/m³", "lb/ft³", "m/s", "Km/hr", "mph" });
        convertButton = new JButton("Convert");
        resultLabel = new JLabel("");

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convert();
            }
        });

        panel.add(inputField);
        panel.add(fromUnitComboBox);
        panel.add(new JLabel("to"));
        panel.add(toUnitComboBox);
        panel.add(convertButton);
        panel.add(resultLabel);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void convert() {
        try {
            double inputValue = Double.parseDouble(inputField.getText());
            String fromUnit = (String) fromUnitComboBox.getSelectedItem();
            String toUnit = (String) toUnitComboBox.getSelectedItem();
            double result = 0.0;

            if (fromUnit.equals(toUnit)) {
                result = inputValue;
            } else {
                switch (fromUnit + "-" + toUnit) {
                    case "Celsius-Fahrenheit":
                        result = (inputValue * 1.8) + 32;
                        break;
                    case "Fahrenheit-Celsius":
                        result = (inputValue - 32) * 1.8;
                        break;
                    case "Celsius-Kelvin":
                        result = inputValue + 273.15;
                        break;
                    case "Kelvin-Celsius":
                        result = inputValue - 273.15;
                        break;
                    case "Fahrenheit-Kelvin":
                        result = (inputValue - 32) / 1.8 + 273.15;
                        break;
                    case "Kelvin-Fahrenheit":
                        result = (inputValue - 273.15) * 1.8 + 32;
                        break;
                    case "Kilogram-Gram":
                        result = inputValue * 1000;
                        break;
                    case "Gram-Kilogram":
                        result = inputValue / 1000;
                        break;
                    case "Meter-Feet":
                        result = inputValue * 3.28084;
                        break;
                    case "Feet-Meter":
                        result = inputValue / 3.28084;
                        break;
                    case "Meter-Inch":
                        result = inputValue * 39.3700787;
                        break;
                    case "Inch-Meter":
                        result = inputValue / 39.3700787;
                        break;
                    case "Feet-Inch":
                        result = inputValue * 12;
                        break;
                    case "Inch-Feet":
                        result = inputValue / 12;
                        break;
                    case "Kg/m³-lb/ft³":
                        result = inputValue * 0.06243;
                        break;
                    case "lb/ft³-Kg/m³":
                        result = inputValue / 0.06243;
                        break;
                    case "Kg/m³-g/cm³":
                        result = inputValue / 1000;
                        break;
                    case "g/cm³-Kg/m³":
                        result = inputValue * 1000;
                        break;
                    case "lb/ft³-g/cm³":
                        result = inputValue * 0.0160184634;
                        break;
                    case "g/cm³-lb/ft³":
                        result = inputValue / 0.0160184634;
                        break;
                    case "m/s-Km/hr":
                        result = inputValue * 3.6;
                        break;
                    case "Km/hr-m/s":
                        result = inputValue / 3.6;
                        break;
                    case "m/s-mph":
                        result = inputValue * 2.23693629;
                        break;
                    case "mph-m/s":
                        result = inputValue / 2.23693629;
                        break;
                    case "Km/hr-mph":
                        result = inputValue / 1.609344;
                        break;
                    case "mph-Km/hr":
                        result = inputValue * 1.609344;
                        break;
                }
            }

            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UnitConverterApp();
            }
        });
    }
}
