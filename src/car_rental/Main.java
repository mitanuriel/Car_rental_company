package car_rental;

import javax.swing.*;
import java.sql.Connection;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Menu.startApplication();

        MySQLConnection mysql = new MySQLConnection();
        mysql.createConnection();

    }
}

