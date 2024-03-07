package car_rental;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public static Date parseDate(String dateString) {
        try {
            return DATE_FORMAT.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String formatDate(Date date) {
        return DATE_FORMAT.format(date);
    }
}
