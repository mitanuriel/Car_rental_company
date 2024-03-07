package car_rental;

public class Rental {

    private int id;
    private int customer_id;
    private String rental_from;
    private String rental_to;
    private int total_km;
    private String car_plate_num;

    Rental(int id, int customer_id, String rental_from,
           String rental_to, int total_km, String car_plate_num) {
        this.id = id;
        this.customer_id = customer_id;
        this.rental_from = rental_from;
        this.rental_to = rental_to;
        this.total_km = total_km;
        this.car_plate_num = car_plate_num;
    }

    public int getId() {
        return id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public String getRental_from() {
        return rental_from;
    }

    public String getRental_to() {
        return rental_to;
    }

    public int getTotal_km() {
        return total_km;
    }

    public String getCar_plate_num() {
        return car_plate_num;
    }

    public String toString() {
        return String.valueOf(this.id);
    }
}
