public class ParkingSpot {
    private String spotId;
    private String spotType;
    private Vehicle vehicle;

    public ParkingSpot(String spotId, String spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.vehicle = null;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public boolean assignVehicle(Vehicle vehicle) {
        if (this.vehicle != null) {
            System.out.println("Spot is already occupied.");
            return false;
        }

        this.vehicle = vehicle;
        System.out.println("Vehicle assigned to spot " + spotId);
        return true;
    }

    public void removeVehicle() {
        if (vehicle == null) {
            System.out.println("No vehicle to remove.");
        } else {
            System.out.println("Vehicle removed from spot " + spotId);
            vehicle = null;
        }
    }

    public void displaySpotInfo() {
        System.out.println("Spot ID: " + spotId);
        System.out.println("Spot Type: " + spotType);
        System.out.println("Occupied: " + (vehicle != null));
    }
}