package car_rental;

import car_rental.SecondPage;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class FirstPage extends JFrame {
    JFormattedTextField startDay, startTime, endDay, endTime;
    JButton continueButton;

    public FirstPage() {
        setTitle("Car Rental - Start");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout()); // Use GridBagLayout for flexibility
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Each component in its own row
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); // Margins for components

        // Create a panel that will contain everything
        JPanel panel = new JPanel(new GridBagLayout());

        // Adding labels and fields
        addFieldWithLabel(panel, "Start Day (dd-MM-yyyy):", createMaskedField("##-##-####"));
        addFieldWithLabel(panel, "Start Time (HH:mm):", createMaskedField("##:##"));
        addFieldWithLabel(panel, "End Day (dd-MM-yyyy):", createMaskedField("##-##-####"));
        addFieldWithLabel(panel, "End Time (HH:mm):", createMaskedField("##:##"));

        continueButton = new JButton("Continue");
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hide the current window
                setVisible(false);
                dispose(); // Properly dispose the window

                // Open the SecondPage window
                new SecondPage().setVisible(true);
            }
        });
        panel.add(continueButton, gbc);

        // Centering the panel in the frame
        add(panel, gbc);

        pack(); // Adjust the window size based on its contents
        setLocationRelativeTo(null); // Center on screen
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize window
        setVisible(true);
    }

    private JFormattedTextField createMaskedField(String mask) {
        try {
            MaskFormatter formatter = new MaskFormatter(mask);
            formatter.setPlaceholderCharacter('_');
            return new JFormattedTextField(formatter);
        } catch (ParseException e) {
            e.printStackTrace();
            return new JFormattedTextField();
        }
    }

    private void addFieldWithLabel(JPanel panel, String labelText, JFormattedTextField field) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Each component in its own row
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(2, 2, 2, 2); // Margins for components within the panel

        panel.add(new JLabel(labelText), gbc);
        panel.add(field, gbc);
    }
}