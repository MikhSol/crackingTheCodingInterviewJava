package main;

import static java.lang.Math.pow;

class BitManipulator {
    static int insertBitsToPosition(int n, int m, int i, int j) {
        return (n & ((~0 << j) | ((1 << i-1) - 1))) | (m << i-1);
    }

    static String doubleAsBinString(double in) {
        if (in >= 1 || in <= 0) return "Error";
        StringBuilder result = new StringBuilder();
        result.append(".");
        int power = -1;
        while (in > 0) {
            if (result.length() > 32) return "Error";
            double residual = in - pow(2, power);
            if (residual > 0) {
                in = residual;
                result.append("1");
            } else if (residual == 0) {
                result.append("1");
                break;
            } else if (residual < 0) {
                result.append("0");
                power--;
                continue;
            }
            power--;
        }
        return result.toString();
    }
}
