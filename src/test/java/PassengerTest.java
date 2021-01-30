import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PassengerTest {

    private Passenger passenger;

    @Before
    public void before(){
        passenger = new Passenger("Bob Loxley", 2);
    }

    @Test
    public void hasName(){
        assertEquals("Bob Loxley", passenger.getName());
    }

    @Test
    public void hasBags(){
        assertEquals(2, passenger.getBags());
    }

    @Test
    public void flightStartsNull(){
        assertNull(passenger.getFlight());
    }

    @Test
    public void seatNumberStartsNull(){
        assertNull(passenger.getSeatNumber());
    }

}
