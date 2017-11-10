package main;

import java.util.Arrays;

class DynamicProblemSolver {
    static int tripleStep(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        return tripleStep(n-1) + tripleStep(n-2) + tripleStep(n-3);
    }

    static int tripleStepMemo(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return tripleStepMemo(n, memo);
    }

    private static int tripleStepMemo(int n, int[] memo) {
        if (n < 0) return 0;
        if (n <= 1) return 1;
        if (memo[n] > -1) return memo[n];

        return tripleStepMemo(n-1, memo) + tripleStepMemo(n-2, memo)
                + tripleStepMemo(n-3, memo);
    }

}
