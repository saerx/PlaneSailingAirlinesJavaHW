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
        assertEquals(PlaneType.BOEING747, plane.getPlaneType());
    }

    @Test
    public void planeHasCapacity(){
        PlaneType boeing = plane.getPlaneType();
        assertEquals(140, boeing.getCapacity());
    }

    @Test
    public void planeHasTotalWeight(){
        PlaneType boeing = plane.getPlaneType();
        assertEquals(33_600, boeing.getTotalWeight());
    }
}
