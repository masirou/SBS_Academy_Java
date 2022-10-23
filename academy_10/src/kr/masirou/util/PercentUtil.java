package kr.masirou.util;

import java.util.Random;

public class PercentUtil {

    private static Random random;

    public static boolean isSuccess(double percent) {
        if (random == null) random = new Random();

        double p = percent/100.0;
        if (p >= 1.0) return true;
        else if (p <= 0.0) return false;
        else {
            return random.nextDouble() < p;
        }

    }
}
