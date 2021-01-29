import java.util.ArrayList;

public class FlightManager {

    public FlightManager(){

    }

    public int weightForBags(Flight flight){
        return flight.getPlane().getPlaneType().getTotalWeight() / 2;
    }

    public int reserveBaggagePerPerson(Flight flight){
        int weightForBags = this.weightForBags(flight);
        int weightPerPerson = weightForBags / flight.getPlane().getPlaneType().getCapacity();
        return weightPerPerson;
    }


    public int calculateBaggageBooked(Flight flight) {
        int baggageBooked = 0;
        ArrayList<Passenger> passengers = flight.getPassengers();
        for (Passenger passenger : passengers){
            baggageBooked += passenger.getBags() * 30;
        }
        return baggageBooked;
    }

    public int baggageRemaining(Flight flight) {
        int weightForBags = this.weightForBags(flight);
        int baggageBooked = this.calculateBaggageBooked(flight);
        return weightForBags - baggageBooked;
    }
}
