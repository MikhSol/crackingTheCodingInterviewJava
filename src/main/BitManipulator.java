package main;

class BitManipulator {
    static int insertBitsToPosition(int n, int m, int i, int j) {
        return (n & ((~0 << j) | ((1 << i-1) - 1))) | (m << i-1);
    }
}
