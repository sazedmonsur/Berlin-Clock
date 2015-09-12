package com.ubs.opsit.interviews;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Sazed on 9/9/2015.
 */
public class berlinClockTest {

    berlinClock bc = new berlinClock();
    //Berlin Clock should take valid time and return array of lights accordingly
    @Test
    public void testShouldReturnEntireBerlinClockTime() {
        assertArrayEquals((new String[]{"Y", "OOOO", "OOOO", "OOOOOOOOOOO", "OOOO"}), bc.getTime("00:00:00"));
        assertArrayEquals((new String[]{"Y", "RRRR", "RRRR", "OOOOOOOOOOO", "OOOO"}), bc.getTime("24:00:00"));
        assertArrayEquals((new String[]{"O", "RRRR", "RRRO", "YYRYYRYYRYY", "YYYY"}), bc.getTime("23:59:59"));
        assertArrayEquals((new String[]{"O", "RRRO", "OOOO", "YYRYYROOOOO", "YOOO"}), bc.getTime("15:31:09"));
    }

    //Berlin clock should throw exception for illegal  arguments

    @Test
    public void testShouldThrowExceptionForIllegalArgument() {
        boolean thrown = false;

        try {
            bc.getTime("-20:LK:12");
        } catch (IllegalArgumentException e) {
            thrown = true;
        }

        assertTrue(thrown);
    }

    //Top yellow light should be On in Even seconds and Off in Odd seconds
    @Test
    public void testTopYellowLightShouldBeOnInEvenSecondsAndOffInOddSeconds(){
        assertEquals("Y", berlinClock.getSecondsLight(20));
        assertEquals("O", berlinClock.getSecondsLight(31));
    }

    //Should return five hours light correctly
    @Test
    public void testShouldReturnFiveHoursRow() {
        assertEquals("OOOO",berlinClock.getFiveHoursLights(0));
        assertEquals("ROOO",berlinClock.getFiveHoursLights(9));
        assertEquals("RRRO",berlinClock.getFiveHoursLights(15));
        assertEquals("RRRR",berlinClock.getFiveHoursLights(21));

    }

    //Should return one hours light correctly
    @Test
    public void testShouldReturnOneHoursRow() {
        assertEquals("RRRO",berlinClock.getOneHoursLights(3));
        assertEquals("RRRR",berlinClock.getOneHoursLights(9));
        assertEquals("OOOO",berlinClock.getOneHoursLights(15));
        assertEquals("RRRO",berlinClock.getOneHoursLights(23));
    }

    //Should return five minutes light correctly
    @Test
    public void testShouldReturnFiveMinutesRow() {
        assertEquals("YYROOOOOOOO",berlinClock.getFiveMinuteLights(15));
        assertEquals("YYRYYRYOOOO",berlinClock.getFiveMinuteLights(37));
        assertEquals("YYRYYRYYROO",berlinClock.getFiveMinuteLights(45));
        assertEquals("YYRYYRYYRYY",berlinClock.getFiveMinuteLights(59));
    }

    //Should return one minutes light correctly
    @Test
    public void testShouldReturnOneMinutesRow() {
        assertEquals("YYYY",berlinClock.getOneminuteLights(9));
        assertEquals("OOOO",berlinClock.getOneminuteLights(45));
        assertEquals("YOOO",berlinClock.getOneminuteLights(51));
        assertEquals("YYYY",berlinClock.getOneminuteLights(59));
    }

    //Top and bottom hours should have four lights
    @Test
    public void testTopAndBottomHoursShouldHaveFourLights() {
        assertEquals(4,berlinClock.getFiveHoursLights(0).length());
        assertEquals(4,berlinClock.getOneHoursLights(3).length());
    }

    //Top minutes should have eleven lights
    @Test
    public void testTopMinutesShouldHaveElevenLights() {
        assertEquals(11,berlinClock.getFiveMinuteLights(15).length());
    }

    //Bottom minutes should have four lights
    @Test
    public void testBottomMinutesShouldHaveFourLights() {
        assertEquals(4,berlinClock.getOneminuteLights(45).length());
    }

    //Berlin clock should take time and return a array of 5 elements
    @Test
    public void testBerlinClockShouldReturnFiveElements() {
        assertEquals(5, bc.getTime("12:12:12").length);
    }

}

