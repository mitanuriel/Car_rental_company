package car_rental;

public class Customer {
    private final int id;
    private final String customerName;
    private String address;
    private int postal_code;
    private String city;
    private String phone_number;
    private String email;
    private String license_number;
    private String license_issue_date;

    public Customer(int id, String customerName, String address, int postalCode, String city,
                    String phone_number, String email, String license_number,
                    String license_issue_date) {
        this.id = id;
        this.customerName = customerName;
        this.address = address;
        this.postal_code = postalCode;
        this.city = city;
        this.phone_number = phone_number;
        this.email = email;
        this.license_number = license_number;
        this.license_issue_date = license_issue_date;
    }

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAddress() {
        return address;
    }

    public int getPostal_code() {
        return postal_code;
    }

    public String getCity() {
        return city;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getEmail() {
        return email;
    }

    public String getLicense_number() {
        return license_number;
    }

    public String getLicense_issue_date() {
        return license_issue_date;
    }

    public String toString() {
        return this.customerName;
    }
}
