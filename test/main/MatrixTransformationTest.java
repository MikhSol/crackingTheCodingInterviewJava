package main;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MatrixTransformationTest {
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
}
