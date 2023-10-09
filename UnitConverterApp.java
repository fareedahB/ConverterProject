package ConverterProjects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnitConverterApp{
    private JFrame frame;
    private JPanel panel;
    private JTextField inputField;
    private JComboBox<String> choiceComboBox;
    private JComboBox<String> fromUnitComboBox;
    private JComboBox<String> toUnitComboBox;
    private JButton convertButton;
    private JLabel resultLabel;

    public UnitConverterApp() {

        frame = new JFrame("Unit Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        inputField = new JTextField(10);

        choiceComboBox = new JComboBox<>(new String[] { " -Choose- ","Temperature", "Weight", "Length", "Density", "Speed" });
        choiceComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateUnitComboBoxes();
            }
        });

        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fromUnitComboBox = new JComboBox<>();

        toUnitComboBox = new JComboBox<>();

        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        convertButton = new JButton("Convert");

        resultLabel = new JLabel("");

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convert();
            }
        });

        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);
        panel2.add(inputField);
        panel2.add(choiceComboBox);
        panel3.add(fromUnitComboBox);
        panel3.add(new JLabel("to"));
        panel3.add(toUnitComboBox);
        panel4.add(convertButton);
        panel4.add(resultLabel);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void updateUnitComboBoxes() {
        String choice = (String) choiceComboBox.getSelectedItem();
        String[] units = getUnitsForChoice(choice);

        DefaultComboBoxModel<String> fromUnitModel = new DefaultComboBoxModel<>(units);
        fromUnitComboBox.setModel(fromUnitModel);

        DefaultComboBoxModel<String> toUnitModel = new DefaultComboBoxModel<>(units);
        toUnitComboBox.setModel(toUnitModel);
    }

    private String[] getUnitsForChoice(String choice) {
        switch (choice) {
            case "Temperature":
                return new String[] { "Celsius", "Fahrenheit", "Kelvin" };
            case "Weight":
                return new String[] { "Kilogram", "Gram" };
            case "Length":
                return new String[] { "Meter", "Feet", "Inch" };
            case "Density":
                return new String[] { "g/cm³", "Kg/m³", "lb/ft³" };
            case "Speed":
                return new String[] { "m/s", "Km/hr", "mph" };
            default:
                return new String[0];
        }
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