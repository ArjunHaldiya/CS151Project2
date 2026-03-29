# Parking Garage Management System
CS 151 Spring 2026 — Project 2

## Overview
A Java-based Parking Garage Management System that models vehicles, typed parking spots, tickets, and payments using object-oriented principles including abstract classes, interfaces, inheritance, polymorphism, and custom exception handling.

## Design

### Class Hierarchy
```
Vehicle (abstract)
├── Car             implements Parkable  — $5/hr,  prefers STANDARD spot
├── Motorcycle      implements Parkable  — $3/hr,  prefers STANDARD spot
├── PickupTruck     implements Parkable  — $8/hr,  prefers LARGE spot
└── ElectricVehicle implements Parkable  — $4/hr,  prefers EV spot

Parkable (interface)
├── parkVehicle(spot: ParkingSpot): void
├── leaveSpot(spot: ParkingSpot): void
├── calculateParkingFee(hours: int): double   — minimum 1 hour billed
└── getPreferredSpotType(): String            — returns "STANDARD", "EV", or "LARGE"
```

### Supporting Classes

| Class | Responsibility |
|---|---|
| **ParkingSpot** | Tracks spot ID, spot type (STANDARD/EV/LARGE), and occupancy. Throws `SpotOccupiedException` if a vehicle is assigned to an occupied spot. |
| **Ticket** | Records entry/exit hours, calculates fee by casting to `Parkable`, tracks paid status. |
| **PaymentSystem** | Processes payments (overloaded: by amount or by Ticket), generates receipts, throws `InvalidPaymentException`. |
| **ParkingGarage** | Central manager: maintains lists of spots, tickets, and vehicles (max 100 spots). Routes vehicles to typed spots via `getPreferredSpotType()` with fallback to any available spot. Throws `VehicleNotFoundException`. |
| **Main** | Interactive menu driver. Pre-loads 9 typed spots (5 STANDARD, 2 EV, 2 LARGE). |

### Spot Types
| Type | Tag in Grid | Used By |
|---|---|---|
| `STANDARD` | `[STD]` | Car, Motorcycle |
| `EV` | `[EV]` | ElectricVehicle |
| `LARGE` | `[LG]` | PickupTruck |

If a vehicle's preferred spot type is full, it automatically falls back to any available spot.

### Custom Exceptions
| Exception | Extends | Thrown By | Thrown When |
|---|---|---|---|
| `SpotOccupiedException` | `RuntimeException` | `ParkingSpot` | Assigning a vehicle to an already-occupied spot |
| `InvalidPaymentException` | `RuntimeException` | `PaymentSystem` | Payment amount is invalid or ticket already paid |
| `VehicleNotFoundException` | `RuntimeException` | `ParkingGarage` | Looking up a ticket ID that does not exist |
| `InvalidLicensePlateException` | `RuntimeException` | `Vehicle`, `Main` | License plate is blank or under 5 characters |

## Installation & Compilation

### Requirements
- Java 11+

### Compile
```bash
javac src/*.java
```

### Run
```bash
java -cp src Main
```

## Usage
The interactive menu supports the following operations:

1. **Add Vehicle** — choose vehicle type (Car / Motorcycle / Pickup Truck / Electric Vehicle), enter details, and park immediately
2. **View Available Spots** — list all unoccupied spots with their type (STANDARD / EV / LARGE)
3. **Calculate Fee and Pay** — select an active ticket, enter exit hour and payment method (Cash/Card)
4. **View Tickets** — display all open tickets with full details
5. **Manage Parked Vehicle** — select a parked vehicle to:
   - View vehicle details (subclass-specific fields; EV shows battery status and charging request)
   - Update license plate (validated: min 5 characters)
   - Update owner name
6. **View Garage Status** — 2D grid showing spot types and occupancy, plus full garage summary
7. **Exit**

> Type `EXIT` at any prompt to quit immediately.

## Team Contributions
| Member | Classes |
|---|---|
| Arjun Haldiya | `ParkingGarage`, `PickupTruck`, `Ticket`, `Parkable` (interface) |
| Fnu Hasham | `PaymentSystem`, `Motorcycle` |
| Gunraj | `Vehicle` (abstract), `Car`, `ElectricVehicle`, `ParkingSpot` |
| All | Exception classes (`SpotOccupiedException`, `InvalidPaymentException`, `VehicleNotFoundException`, `InvalidLicensePlateException`), `Main`, `Tests`|