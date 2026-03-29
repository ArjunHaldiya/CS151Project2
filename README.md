# Parking Garage Management System
CS 151 Spring 2026 — Project 2

## Overview
A Java-based Parking Garage Management System that models vehicles, parking spots, tickets, and payments using object-oriented principles including abstract classes, interfaces, inheritance, and custom exception handling.

## Design

### Class Hierarchy
```
Vehicle (abstract)
├── Car          implements Parkable  — $5/hr
├── Motorcycle   implements Parkable  — $3/hr
├── PickupTruck  implements Parkable  — $8/hr
└── ElectricVehicle implements Parkable — $4/hr

Parkable (interface)
├── parkVehicle(ParkingSpot)
├── leaveSpot(ParkingSpot)
└── calculateParkingFee(int hours)  — minimum 1 hour billed
```

### Supporting Classes
- **ParkingSpot** — tracks occupancy, throws `SpotOccupiedException` if already occupied
- **Ticket** — records entry/exit hours, calculates fee, tracks paid status
- **PaymentSystem** — processes payments, generates receipts, throws `InvalidPaymentException`
- **ParkingGarage** — central manager (max 100 spots), throws `VehicleNotFoundException`

### Custom Exceptions
| Exception | Thrown When |
|---|---|
| `SpotOccupiedException` | Parking in an already-occupied spot |
| `InvalidPaymentException` | Processing an invalid or duplicate payment |
| `VehicleNotFoundException` | Looking up a ticket ID that does not exist |

## Installation & Compilation

### Requirements
- Java 11+
- JUnit 5 (for running tests)

### Compile
```bash
cd src
javac *.java
```

### Run
```bash
java Main
```

### Run Tests (with JUnit 5 on classpath)
```bash
javac -cp .:junit-platform-console-standalone.jar *.java
java -cp .:junit-platform-console-standalone.jar org.junit.platform.console.ConsoleLauncher --scan-classpath
```

## Usage
The interactive menu supports the following operations:
1. **Add Car** — enter vehicle details and park immediately
2. **Add Motorcycle** — enter vehicle details and park immediately
3. **Add Pickup Truck** — enter vehicle details and park immediately
4. **Add Electric Vehicle** — enter vehicle details and park immediately
5. **View Available Spots** — list all unoccupied spots
6. **Park Vehicle** — see active vehicles in garage
7. **Calculate Fee and Pay** — select a ticket, enter exit hour and payment method
8. **View Active Tickets** — display all open tickets
9. **View Garage Status** — summary of occupancy
10. **Exit**

> Type `EXIT` at any prompt to quit immediately.

## Team Contributions
| Member | Classes |
|---|---|
| Arjun Haldiya | `PickupTruck`, `Ticket`, `Tests` |
| Fnu Hasham | `ParkingGarage`, `PaymentSystem`, `ParkingGarageTest` |
| Gunraj | `Car`, `Motorcycle`, `ElectricVehicle`, `ParkingSpot`, `Main` |
| All | `Vehicle` (abstract), `Parkable` (interface), Exception classes |