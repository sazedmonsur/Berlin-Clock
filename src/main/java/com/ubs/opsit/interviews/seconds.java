package com.ubs.opsit.interviews;

/**
 * Created by Sazed on 9/11/2015.
 */
public class seconds {
    public static String getSecondsLight(int seconds) {
        if (seconds % 2 == 0) {
            return variables.yellowLight;
        }
        else
        return variables.singleLight;
    }
}
