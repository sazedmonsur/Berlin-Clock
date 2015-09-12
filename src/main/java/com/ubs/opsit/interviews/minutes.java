package com.ubs.opsit.interviews;

/**
 * Created by Sazed on 9/11/2015.
 */
public class minutes extends seconds {
    //Determines how many top 5 minute's lights are on and off
    public static String getFiveMinuteLights(int minutes) {

        StringBuilder lights = new StringBuilder(variables.elevenlights);

        for (int i = 0; i < (minutes-(minutes% 5)) /5 ; i++) {
            if ((i+1) % 3 == 0) {
                lights.replace(i, i + 1, variables.redLight);
            } else {
                lights.replace(i, i + 1, variables.yellowLight);
            }
        }
        return lights.toString();

    }

    //Determines how many bottom 1 minute's lights are on and off
    public static String getOneminuteLights(int minutes) {

        StringBuilder lights = new StringBuilder(variables.fourlights);

        for (int i = 0; i < (minutes % 5); i++) {
            lights.replace(i, i + 1, variables.yellowLight);
        }
        return lights.toString();

    }
}
