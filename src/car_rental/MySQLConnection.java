package car_rental;

import java.sql.*;

public class MySQLConnection {

    String query = "SELECT * FROM Cars";
    String database = "jdbc:mysql://localhost:3306/carRental";
    String username = "admin";
    String password = "admin123";
    String connection = null;

    public Connection createConnection(){
        if(connection != null)
            return null;
        try {
            // Class.forName ("com.mysql.jdbc.Driver")
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection(database, username, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next())
                System.out.println(rs.getString("car_brand") + ":" + rs.getString("car_model"));
            con.close();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }


        return null;
    }




}



