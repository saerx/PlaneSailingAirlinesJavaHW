import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Flight {

    private ArrayList<Passenger> passengers;
    private Plane plane;
    private String flightDesignator;
    private String destinationAirport;
    private String departureAirport;
    private LocalDate departureTime;
    private Random rand;

    public Flight(Plane plane, String flightDesignator, String destinationAirport, String departureAirport, LocalDate departureTime) {
        this.plane = plane;
        this.flightDesignator = flightDesignator;
        this.destinationAirport = destinationAirport;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
        this.passengers = new ArrayList<>();

    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public Plane getPlane() {
        return plane;
    }

    public String getFlightDesignator() {
        return flightDesignator;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public LocalDate getDepartureTime() {
        return departureTime;
    }

    public int getAvailableSeats(){
        int availableSeats = this.plane.getPlaneType().getCapacity() - this.passengers.size();
        return availableSeats;
    }

    public void bookPassenger(Passenger passenger) {
        rand = new Random();
        int n = rand.nextInt(plane.getPlaneType().getCapacity()) + 1 ;
        passenger.setFlight(this.flightDesignator);
        for (Passenger otherPassenger : this.passengers) {
            if (otherPassenger.getSeatNumber() == n) {
                n = rand.nextInt(plane.getPlaneType().getCapacity()) + 1;
            }
        }
        passenger.setSeatNumber(n);
        this.passengers.add(passenger);
    }


    public void sortPassengers() {
        int n = this.passengers.size();
        for (int i = 0; i < n -1; i++) {
            for (int j = 0; j < n-i-1; j++){
                if (this.passengers.get(j).getSeatNumber() > this.passengers.get(j+1).getSeatNumber()) {
                    Passenger temp = this.passengers.get(j);
                    Passenger next = this.passengers.get(j+1);
                    this.passengers.set(j, next);
                    this.passengers.set(j+1, temp);
                }
            }
        }
    }

    public Passenger findBySeatNumber(int seatNumber) {
        int lowIndex = 0;
        int highIndex = this.passengers.size()-1;

        int passengerIndex = -1;
        Passenger passengerToReturn = null;

        while (lowIndex <= highIndex) {
            int midIndex = (lowIndex + highIndex) / 2;
            if (seatNumber == this.passengers.get(midIndex).getSeatNumber()) {
                passengerIndex = midIndex;
                break;
            } else if (seatNumber < this.passengers.get(midIndex).getSeatNumber()) {
                highIndex = midIndex-1;
            } else if (seatNumber > this.passengers.get(midIndex).getSeatNumber()) {
                lowIndex = midIndex+1;
            }
        }
        if (passengerIndex >= 0) {
            passengerToReturn = this.passengers.get(passengerIndex);
        }
        return passengerToReturn;
    }
}
