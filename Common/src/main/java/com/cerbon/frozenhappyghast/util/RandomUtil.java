package com.cerbon.frozenhappyghast.util;

import java.util.Random;

public class RandomUtil {
    private static final Random rand = new Random();

    public static int range(int min, int max) {
        if (min > max) throw new IllegalArgumentException("Minimum is greater than maximum");
        int range = max - min;
        return min + rand.nextInt(range);
    }
}
