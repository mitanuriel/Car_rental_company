package car_rental;

public class Car {


    private final int id;
    private String carBrand;
    private String carModel;
    private String fuelType;
    private String plateNum;
    private String registrationDate;
    private int mileageCounter;


    Car(int id, String carBrand, String carModel,
        String fuelType, String plateNum, String registrationDate,
        int mileageCounter) {
        this.id = id;
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.fuelType = fuelType;
        this.plateNum = plateNum;
        this.registrationDate = registrationDate;
        this.mileageCounter = mileageCounter;
    }

    public Car(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public String getCarModel() {
        return carModel;
    }


    public String getFuelType() {
        return fuelType;
    }

    public String getPlateNum() {
        return plateNum;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public int getMileageCounter() {
        return mileageCounter;
    }

    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carBrand='" + carBrand + '\'' +
                ", carModel='" + carModel + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", plateNum='" + plateNum + '\'' +
                ", registDate='" + registrationDate + '\'' +
                ", mileageCounter=" + mileageCounter +
                '}';
    }

}
