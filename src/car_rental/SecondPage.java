package car_rental;

import javax.swing.*;

public class SecondPage extends JFrame {
    JComboBox<String> typeOfCar, carMileage, carBrand, fuelType;
    JButton continueButton;

    public SecondPage() {
        setTitle("Car Specifications");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        typeOfCar = new JComboBox<>(new String[]{"Family", "Luxury", "Sport"});
        add(new JLabel("Type of Car:"));
        add(typeOfCar);

        carMileage = new JComboBox<>(new String[]{"100-1000km", "1000-10000km", "10000-50000km"});
        add(new JLabel("Car Mileage:"));
        add(carMileage);

        carBrand = new JComboBox<>(new String[]{"Mercedes", "Volkswagen", "Renault", "Porsche", "Tesla"});
        add(new JLabel("Car Brand:"));
        add(carBrand);

        fuelType = new JComboBox<>(new String[]{"Electric", "Diesel", "Petrol"});
        add(new JLabel("Fuel Type:"));
        add(fuelType);

        continueButton = new JButton("Continue");
        continueButton.addActionListener(e -> {
            setVisible(false);
            new ThirdPage();
        });
        add(continueButton);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}