package com.alcano.outlaws.util;

public final class Random {

    private static final java.util.Random rand = new java.util.Random();

    public static float value() {
        return (float) Math.random();
    }

    public static int range(int min, int max) {
        if (min > max) throw new IllegalArgumentException("Min value greater than max value");

        return rand.nextInt((max - min) + 1) + min;
    }

    public static float range(float min, float max) {
        if (min > max) throw new IllegalArgumentException("Min value greater than max value");

        return min + value() * (max - min);
    }

}
