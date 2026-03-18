// Name Fnu Hasham

public double calculateParkingFee(int hours) {
    return hours * 3.0;
}

public boolean canFitInCompactSpot() {
    return true;
}

public void displayParkingMessage() {
    System.out.println("Motorcycle is parked successfully.");
}

public void printReceipt(int hours) {
    double fee = calculateParkingFee(hours);
    System.out.println("Motorcycle parking fee: $" + fee);
}