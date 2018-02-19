package hundreddoors;

import org.junit.*;
import static org.junit.Assert.*;

public class HundredDoorsTest {

    @Test
    public void testFirstDoorOpened() {
        boolean expected = true;
        boolean actual = HundredDoors.getTheDoorState(1);
        assertEquals(expected, actual);
    }

    @Test
    public void testSecondDoorClosed() {
        boolean expected = false;
        boolean actual = HundredDoors.getTheDoorState(2);
        assertEquals(expected, actual);
    }

    @Test
    public void testThirdDoorOpened() {
        boolean expected = false;
        boolean actual = HundredDoors.getTheDoorState(3);
        assertEquals(expected, actual);
    }

    @Test
    public void testFourthDoorOpened() {
        boolean expected = true;
        boolean actual = HundredDoors.getTheDoorState(4);
        assertEquals(expected, actual);
    }

    @Test
    public void testFifthDoorOpened() {
        boolean expected = false;
        boolean actual = HundredDoors.getTheDoorState(5);
        assertEquals(expected, actual);
    }
}
