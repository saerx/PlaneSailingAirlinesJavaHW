import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    private Plane plane;

    @Before
    public void before(){
        plane = new Plane(PlaneType.BOEING747);
    }

    @Test
    public void hasPlane(){
        assertEquals(PlaneType.BOEING747, plane.getPlane());
    }

    @Test
    public void planeHasCapacity(){
        PlaneType boeing = plane.getPlane();
        assertEquals(140, boeing.getCapacity());
    }

    @Test
    public void planeHasTotalWeight(){
        PlaneType boeing = plane.getPlane();
        assertEquals(40_000, boeing.getTotalWeight());
    }
}
