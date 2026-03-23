public class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private int entryHour;
    private int exitHour;
    private double totalFee;
    private boolean isPaid;

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    /**
     * Creates a new Ticket for a vehicle assigned to a specific parking spot.
     *
     * @param ticketId    unique identifier for this ticket
     * @param vehicle     the vehicle being parked
     * @param parkingSpot the spot assigned to the vehicle
     * @param entryHour   the hour (0–23) the vehicle entered the garage
     */
    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot parkingSpot, int entryHour) {
        if (ticketId == null || ticketId.isBlank()) {
            throw new IllegalArgumentException("Ticket ID cannot be null or blank.");
        }
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null.");
        }
        if (parkingSpot == null) {
            throw new IllegalArgumentException("Parking spot cannot be null.");
        }
        if (entryHour < 0 || entryHour > 23) {
            throw new IllegalArgumentException("Entry hour must be between 0 and 23.");
        }

        this.ticketId    = ticketId;
        this.vehicle     = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryHour   = entryHour;
        this.exitHour    = -1;      // -1 means the vehicle has not exited yet
        this.totalFee    = 0.0;
        this.isPaid      = false;
    }

    /**
     * Prints a summary of the ticket at the moment of garage entry.
     * Called right after a ticket is created so the driver has a record.
     */
    public void generateTicket() {
        System.out.println("========================================");
        System.out.println("         PARKING TICKET ISSUED          ");
        System.out.println("========================================");
        System.out.println("Ticket ID   : " + ticketId);
        System.out.println("Vehicle     : " + vehicle.getLicensePlate()
                + " (" + vehicle.getOwnerName() + ")");
        System.out.println("Spot        : " + parkingSpot.getSpotLabel());
        System.out.println("Entry Hour  : " + entryHour + ":00");
        System.out.println("Status      : Active - vehicle is parked");
        System.out.println("========================================");
    }

    /**
     * Calculates the total parking fee based on hours parked. (use Parkable interface)
     * Sets exitHour to the provided value and delegates fee
     * 
     */
    public double calculateParkingFee(int exitHour) {
        if (exitHour < 0 || exitHour > 23) {
            throw new IllegalArgumentException("Exit hour must be between 0 and 23.");
        }
        if (exitHour < entryHour) {
            throw new IllegalArgumentException(
                    "Exit hour (" + exitHour + ") cannot be before entry hour (" + entryHour + ").");
        }

        this.exitHour = exitHour;
        int hoursParked = exitHour - entryHour;

        // Minimum charge of 1 hour so a parking is never free
        if (hoursParked == 0) {
            hoursParked = 1;
        }

        // (Car = $5/hr, Motorcycle = $3/hr) (use calculateParkingFee from Parkable)
        this.totalFee = vehicle.calculateParkingFee(hoursParked);
        return this.totalFee;
    }

   
}