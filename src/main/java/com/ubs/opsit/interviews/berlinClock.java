package com.ubs.opsit.interviews;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.PrimitiveIterator;
/**
 * Created by Sazed on 9/9/2015.
 */
public class berlinClock extends variables implements convertTime {

    @Override
    public String [] getTime(String time) {
        if (!time.matches("\\d\\d:\\d\\d:\\d\\d")) {
            throw new IllegalArgumentException("Accepted time format HH:MM:SS");
        }
        String[] timeElements = time.split(":");

        int hours = Integer.parseInt(timeElements[0]);
        int minutes = Integer.parseInt(timeElements[1]);
        int seconds = Integer.parseInt(timeElements[2]);
        return new String[] {getSecondsLight(seconds), getFiveHoursLights(hours), getOneHoursLights(hours), getFiveMinuteLights(minutes), getOneminuteLights(minutes)};
    }
}
