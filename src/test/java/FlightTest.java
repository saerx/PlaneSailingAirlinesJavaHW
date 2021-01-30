import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class FlightTest {

    private Plane boeing;
    private Flight flight;
    private Passenger passenger;
    private Passenger passenger2;
    private LocalDate xmasDay;

    @Before
    public void before(){
        boeing = new Plane(PlaneType.BOEING747);
        xmasDay = LocalDate.of(2021, 12, 25);
        flight = new Flight(boeing,"FR756", "GLA", "DUB", xmasDay);
        passenger = new Passenger("Bob Loxley", 2);
        passenger2 = new Passenger("Rob Thomas", 3);
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
        assertEquals(xmasDay, flight.getDepartureTime());
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
        assertEquals("FR756", passenger.getFlight());
        assertNotNull(passenger.getSeatNumber());
    }

    @Test
    public void passengersGetUniqueSeatNumbers(){
        flight.bookPassenger(passenger);
        flight.bookPassenger(passenger2);
        assertNotEquals(passenger.getSeatNumber(), passenger2.getSeatNumber());
    }

}
