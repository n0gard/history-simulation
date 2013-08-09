package org.dreaman.society;

public class Dice {

    public static boolean judge(double threshold) {
        return Math.random() > threshold;
    }

}
