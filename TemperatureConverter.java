import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter extends JFrame {
    private JTextField celsiusField;
    private JTextField fahrenheitField;

    public TemperatureConverter() {
        super("Temperature Converter");

        // Create components
        JLabel celsiusLabel = new JLabel("Celsius:");
        JLabel fahrenheitLabel = new JLabel("Fahrenheit:");
        celsiusField = new JTextField(10);
        fahrenheitField = new JTextField(10);
        JButton celsiusToFahrenheitButton = new JButton("Convert to Fahrenheit");
        JButton fahrenheitToCelsiusButton = new JButton("Convert to Celsius");

        // Create layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(celsiusLabel);
        panel.add(celsiusField);
        panel.add(fahrenheitLabel);
        panel.add(fahrenheitField);
        panel.add(celsiusToFahrenheitButton);
        panel.add(fahrenheitToCelsiusButton);

        // Add action listeners
        celsiusToFahrenheitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertCelsiusToFahrenheit();
            }
        });
        fahrenheitToCelsiusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertFahrenheitToCelsius();
            }
        });

        // Add the panel to the frame
        add(panel);

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void convertCelsiusToFahrenheit() {
        try {
            double celsius = Double.parseDouble(celsiusField.getText());
            double fahrenheit = (celsius * 9 / 5) + 32;
            fahrenheitField.setText(String.format("%.2f", fahrenheit));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number.");
        }
    }

    private void convertFahrenheitToCelsius() {
        try {
            double fahrenheit = Double.parseDouble(fahrenheitField.getText());
            double celsius = (fahrenheit - 32) * 5 / 9;
            celsiusField.setText(String.format("%.2f", celsius));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TemperatureConverter());
    }
}
