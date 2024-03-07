package car_rental;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarRentalManager {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/carRental";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123";

    public List<Car> getAllAvailableCars() {
        List<Car> availableCars = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Cars WHERE plate_number NOT IN (SELECT car_plate_number FROM Rental)");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                availableCars.add(mapResultSetToCar(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return availableCars;
    }
    public void rentCar(Customer customer, Car car, Date rentalFrom, Date rentalTo, int totalKm) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
             PreparedStatement insertRentalStatement = connection.prepareStatement(
                     "INSERT INTO Rental (rental_from, rental_to, total_km, customer_id, car_plate_number) VALUES (?, ?, ?, ?, ?)")) {

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

    public void returnCar(Rental rental, int returnedKm) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
             PreparedStatement updateRentalStatement = connection.prepareStatement(
                     "UPDATE Rental SET total_km = ?, rental_to = ? WHERE id = ?")) {

            updateRentalStatement.setInt(1, returnedKm);
            updateRentalStatement.setString(2, DATE_FORMAT.format(new Date()));
            updateRentalStatement.setInt(3, rental.getId());

            updateRentalStatement.executeUpdate();
            System.out.println("Car returned successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Car mapResultSetToCar(ResultSet resultSet) throws SQLException {
        return new Car(
                resultSet.getInt("id"),
                resultSet.getString("car_brand"),
                resultSet.getString("car_model"),
                resultSet.getString("fuel_type"),
                resultSet.getString("plate_number"),
                resultSet.getString("registration"),
                resultSet.getInt("mileage_counter")
        );
    }

}
