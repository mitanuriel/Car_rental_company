package car_rental;

import javax.swing.*;

public class Menu {

    public static void startApplication() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FirstPage(); // Initialize the first page to start the application.
            }
        });
    }

}
