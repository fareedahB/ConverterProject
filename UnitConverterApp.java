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
        panel.setLayout(new FlowLayout());

        inputField = new JTextField(10);
        fromUnitComboBox = new JComboBox<>(new String[] { "Celsius", "Fahrenheit", "Kilogram", "Gram", "Meter", "Feet",
                "Kg/m³", "lb/ft³", "m/s", "Km/hr" });
        toUnitComboBox = new JComboBox<>(new String[] { "Celsius", "Fahrenheit", "Kilogram", "Gram", "Meter", "Feet",
                "Kg/m³", "lb/ft³", "m/s", "Km/hr" });
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
                result = inputValue; // No conversion needed if the units are the same.
            } else {
                // Implementation of conversion logic for the different units.
                switch (fromUnit + "-" + toUnit) {
                    case "Celsius-Fahrenheit":
                        result = (inputValue * 9 / 5) + 32;
                        break;
                    case "Fahrenheit-Celsius":
                        result = (inputValue - 32) * 5 / 9;
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
                    case "Kg/m³-lb/ft³":
                        result = inputValue * 0.06243;
                        break;
                    case "lb/ft³-Kg/m³":
                        result = inputValue / 0.06243;
                        break;
                    case "m/s-Km/hr":
                        result = inputValue * 3.6;
                        break;
                    case "Km/hr-m/s":
                        result = inputValue / 3.6;
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
