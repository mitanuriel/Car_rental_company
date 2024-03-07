package car_rental;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Menu.startApplication();

        MySQLConnection mysql = new MySQLConnection();
        mysql.createConnection();

        CarRentalManager manager = new CarRentalManager();
        List<Car> availableCars = manager.getAllAvailableCars();

        if (!availableCars.isEmpty()) {
        System.out.println("Available Cars:");
        for (Car car : availableCars) {
            System.out.println(car);
        }

        Connection connection = null;
        Customer customer = new Customer('1', "John Doe", "123 Main St", 12345, "Cityville", "555-1234","djdjj@d77d.tu", "ABC789","2020-01-15");
        Car carToRent = availableCars.get(0);
        Date rentalFrom;
        rentalFrom = new Date(2022, 06, 20);
        Date rentalTo = new Date(2022,06, 30);
        int totalKm = 600;

        manager.rentCar(customer, carToRent, rentalFrom, rentalTo, totalKm);

        Rental rental = new Rental(3,2,"2022-06-20 11:00:00","2022-06-30 20:45:00", 600, "DEF456");
        int returnedKm = 600;

        manager.returnCar(rental, returnedKm);
        } else {
            System.out.println("No available cars.");
        }



    }
}

