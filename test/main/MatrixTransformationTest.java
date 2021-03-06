package main;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MatrixTransformationTest {
    @Test
    void rotateTo90Degrees() throws Exception {
        int[][] matrix = new int[][] {
                {0, 0, 0, 0},
                {1, 1, 1, 1},
                {2, 2, 2, 2},
                {3, 3, 3, 3}
        };
        int[][] result = new int[][] {
                {3, 2, 1, 0},
                {3, 2, 1, 0},
                {3, 2, 1, 0},
                {3, 2, 1, 0}
        };
        assertArrayEquals(result, MatrixTransformation.rotateTo90Degrees(matrix));
    }

    @Test
    void zeroefyMatrix() throws Exception {
        int[][] matrix = new int[][] {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1}
        };
        int[][] result = new int[][] {
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}
        };
        assertArrayEquals(result, MatrixTransformation.zeroefyMatrix(matrix));
    }
}
