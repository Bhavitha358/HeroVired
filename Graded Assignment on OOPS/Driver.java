import java.util.ArrayList;
import java.util.List;

class Driver {
    private String carModel;
    private double rating;
    private double distanceFromCustomer;
    private String predestination;

    public Driver(String carModel, double rating, double distanceFromCustomer, String predestination) {
        this.carModel = carModel;
        this.rating = rating;
        this.distanceFromCustomer = distanceFromCustomer;
        this.predestination = predestination;
    }

    public String getCarModel() {
        return carModel;
    }

    public double getRating() {
        return rating;
    }

    public double getDistanceFromCustomer() {
        return distanceFromCustomer;
    }

    public String getPredestination() {
        return predestination;
    }
}
