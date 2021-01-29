import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    private Plane boeing;
    private Flight flight;
    private Passenger passenger;

    @Before
    public void before(){
        boeing = new Plane(PlaneType.BOEING747);
        flight = new Flight(boeing,"FR756", "GLA", "DUB", "12/25/21");
        passenger = new Passenger("Bob Loxley", 2);
    }

    @Test
    public void hasPlane(){
        assertEquals(boeing, flight.getPlane());
    }

    @Test
    public void hasFlightDes(){
        assertEquals("FR756", flight.getFlightDesignator());
    }

    @Test
    public void hasDestination(){
        assertEquals("GLA", flight.getDestinationAirport());
    }

    @Test
    public void hasDepartureAirport(){
        assertEquals("DUB", flight.getDepartureAirport());
    }

    @Test
    public void hasDepartureTime(){
        assertEquals("12/25/21", flight.getDepartureTime());
    }

    @Test
    public void canGetAvailableSeats(){
        assertEquals(140, flight.getAvailableSeats());
    }

    @Test
    public void canBookPassenger(){
        flight.bookPassenger(passenger);
        assertEquals(1, flight.getPassengers().size());
        assertEquals(139, flight.getAvailableSeats());
    }

}
