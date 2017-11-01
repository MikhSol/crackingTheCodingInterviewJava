package main;

class BitManipulator {
    static int insertBitsToPosition(int n, int m, int i, int j) {
        int left = ~0 << j;
        int right = (1 << i-1) - 1;
        int mask = left | right;
        int nCleared = n & mask;
        int mShifted = m << i-1;
        return nCleared | mShifted;
    }
}
