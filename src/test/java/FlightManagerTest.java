import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    private FlightManager flightManager;
    private Plane boeing;
    private Flight flight;
    private Passenger passenger;
    private Passenger passenger2;
    private LocalDate departureTime;

    @Before
    public void before(){
        flightManager = new FlightManager();
        boeing = new Plane(PlaneType.BOEING747);
        departureTime = LocalDate.of(2021, 12, 25);
        flight = new Flight(boeing,"FR756", "GLA", "DUB", departureTime);
        passenger = new Passenger("Bob Loxley", 2);
        passenger2 = new Passenger("Rob Thomas", 3);
        flight.bookPassenger(passenger);
        flight.bookPassenger(passenger2);
    }

    @Test
    public void canCalculateReserveBaggage(){
        assertEquals(120, flightManager.reserveBaggagePerPerson(flight));
    }

    @Test
    public void canCalculateBaggageBooked(){
        assertEquals(150, flightManager.calculateBaggageBooked(flight));
    }

    @Test
    public void canCalculateBaggageWeightRemaining(){
        assertEquals(16650, flightManager.baggageRemaining(flight));
    }




}
