class Main {
    private static final double CHARGE_PER_KM = 8;

    public static void main(String[] args) {
        // Sample input
        double rideDistance = 43;
        String carRequested = "Sedan";

        List<Driver> drivers = new ArrayList<>();
        drivers.add(new Driver("Sedan", 4.0, 500, "Gurgaon, Noida, Delhi"));
        drivers.add(new Driver("Hatchback", 4.3, 1000, "Gurgaon"));
        drivers.add(new Driver("5-Seater", 4.8, 200, "Noida"));
        drivers.add(new Driver("Sedan", 4.1, 700, "Noida"));
        drivers.add(new Driver("Hatchback", 4.7, 430, "Delhi"));

        // Find the suitable driver
        Driver suitableDriver = findSuitableDriver(rideDistance, carRequested, drivers);

        if (suitableDriver != null) {
            System.out.println("Driver " + suitableDriver.getCarModel() + " will get you to the destination.");
            double totalCharge = rideDistance * CHARGE_PER_KM;
            System.out.println("Your charge will be Rs " + totalCharge);
        } else {
            System.out.println("No suitable driver found for the requested car.");
        }
    }

    private static Driver findSuitableDriver(double rideDistance, String carRequested, List<Driver> drivers) {
        Driver suitableDriver = null;
        double minDistance = Double.MAX_VALUE;

        for (Driver driver : drivers) {
            if (driver.getCarModel().equals(carRequested) && driver.getRating() >= 4.0) {
                if (driver.getDistanceFromCustomer() < minDistance) {
                    minDistance = driver.getDistanceFromCustomer();
                    suitableDriver = driver;
                }
            }
        }

        return suitableDriver;
    }
}
