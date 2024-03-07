package car_rental;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarRentalManager {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public List<Car> getAllAvailableCars(Connection connection) {
        List<Car> availableCars = new ArrayList<>();

        try {
            String query = "SELECT * FROM Cars WHERE plate_number NOT IN (SELECT car_plate_number FROM Rental)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String carBrand = resultSet.getString("car_brand");
                String carModel = resultSet.getString("car_model");
                String fuelType = resultSet.getString("fuel_type");
                String plateNum = resultSet.getString("plate_number");
                String registrationDate = resultSet.getString("registration");
                int mileageCounter = resultSet.getInt("mileage_counter");

                availableCars.add(new Car(id, carBrand, carModel, fuelType, plateNum, registrationDate, mileageCounter));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return availableCars;
    }

    public void rentCar(Connection connection, Customer customer, Car car, Date rentalFrom, Date rentalTo, int totalKm) {
        try {
            String insertRentalQuery = "INSERT INTO Rental (rental_from, rental_to, total_km, customer_id, car_plate_number) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement insertRentalStatement = connection.prepareStatement(insertRentalQuery);

            insertRentalStatement.setString(1, DATE_FORMAT.format(rentalFrom));
            insertRentalStatement.setString(2, DATE_FORMAT.format(rentalTo));
            insertRentalStatement.setInt(3, totalKm);
            insertRentalStatement.setInt(4, customer.getId());
            insertRentalStatement.setString(5, car.getPlateNum());

            insertRentalStatement.executeUpdate();
            System.out.println("Car rented successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void returnCar(Connection connection, Rental rental, int returnedKm) {
        try {
            String updateRentalQuery = "UPDATE Rental SET total_km = ?, rental_to = ? WHERE id = ?";
            PreparedStatement updateRentalStatement = connection.prepareStatement(updateRentalQuery);

            updateRentalStatement.setInt(1, returnedKm);
            updateRentalStatement.setString(2, DATE_FORMAT.format(new Date()));
            updateRentalStatement.setInt(3, rental.getId());

            updateRentalStatement.executeUpdate();
            System.out.println("Car returned successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
