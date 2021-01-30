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
}
