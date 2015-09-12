package com.ubs.opsit.interviews;

/**
 * Created by Sazed on 9/11/2015.
 */
public class hours extends minutes {
    //Determines how many top 5 hour's lights are on and off
    public static String getFiveHoursLights(int hours) {

        StringBuilder lights = new StringBuilder(variables.fourlights);

        for (int i = 0; i < (hours- (hours% 5)) / 5; i++) {
            lights.replace(i, i + 1, variables.redLight);
        }
        return lights.toString();

    }

    //Determines how many bottom 1 hour's lights are on and off
    public static String getOneHoursLights(int hours) {

        StringBuilder lights = new StringBuilder(variables.fourlights);


        for (int i = 0; i < (hours % 5); i++) {
            lights.replace(i, i + 1, variables.redLight);
        }
        return lights.toString();

    }
}
