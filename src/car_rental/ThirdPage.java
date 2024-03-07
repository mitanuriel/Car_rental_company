package car_rental;

import javax.swing.*;

public class ThirdPage extends JFrame {
    JTextField id, name, address, postalCode, city, phoneNumber, email, licenseNumber, licenseIssueDate;
    JButton submitButton;

    public ThirdPage() {
        setTitle("Personal Information");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(new JLabel("ID:"));
        id = new JTextField();
        add(id);

        add(new JLabel("Name:"));
        name = new JTextField();
        add(name);

        add(new JLabel("Address:"));
        address = new JTextField();
        add(address);

        add(new JLabel("Postal Code:"));
        postalCode = new JTextField();
        add(postalCode);

        add(new JLabel("City:"));
        city = new JTextField();
        add(city);

        add(new JLabel("Phone Number:"));
        phoneNumber = new JTextField();
        add(phoneNumber);

        add(new JLabel("Email:"));
        email = new JTextField();
        add(email);

        add(new JLabel("License Number:"));
        licenseNumber = new JTextField();
        add(licenseNumber);

        add(new JLabel("License Issue Date:"));
        licenseIssueDate = new JTextField();
        add(licenseIssueDate);

        submitButton = new JButton("Submit");
        // Here, implement action listener to process or store the form data
        add(submitButton);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}