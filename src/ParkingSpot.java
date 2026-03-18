// Name: Fnu Hasham

public boolean isAvailable() {
    return vehicle == null;
}

public void assignVehicle(Vehicle vehicle) {
    if (this.vehicle == null) {
        this.vehicle = vehicle;
    }
}

public void removeVehicle() {
    this.vehicle = null;
}

public void displaySpotInfo() {
    System.out.println("Spot ID: " + spotId);
    System.out.println("Occupied: " + (vehicle != null));
}