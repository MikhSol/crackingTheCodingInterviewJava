package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MatrixTransformation {
    static int[][] rotateTo90Degrees(int[][] matrix) {
        int n = matrix.length;
        if (n == 0 || n != matrix[0].length) return matrix;
        for (int layer = 0; layer < n/2; layer++) {
            rotateLayer(layer, matrix);
        }
        return matrix;
    }

    private static void rotateLayer(int firstLayer, int[][] matrix) {
        int n = matrix.length;
        int lastLayer = n - 1 - firstLayer;
        for (int i = firstLayer; i < lastLayer; i++) {
            rotateElement(firstLayer, i, lastLayer, matrix);
        }
    }

    private static void rotateElement(int firstLayer, int currentLayer, int lastLayer, int[][] matrix) {
        int offset = currentLayer - firstLayer;
        int tmp = matrix[firstLayer][currentLayer];
        matrix[firstLayer][currentLayer] = matrix[lastLayer - offset][firstLayer];
        matrix[lastLayer - offset][firstLayer] = matrix[lastLayer][lastLayer - offset];
        matrix[lastLayer][lastLayer - offset] = matrix[currentLayer][lastLayer];
        matrix[currentLayer][lastLayer] = tmp;
    }

    static int[][] zeroefyMatrix(int[][] matrix) {
        List<List<Integer>> zeroes = findZeroes(matrix);
        zeroefyRows(matrix, zeroes.get(0));
        zeroefyCols(matrix, zeroes.get(1));
        return matrix;
    }

    private static void zeroefyCols(int[][] matrix, List<Integer> columns) {
        for (Integer col : columns) {
            for (int i = 0; i < matrix.length; i++)
                matrix[i][col] = 0;
        }
    }

    private static void zeroefyRows(int[][] matrix, List<Integer> rows) {
        for (Integer row : rows) {
            for (int i = 0; i < matrix[0].length; i++)
                matrix[row][i] = 0;
        }
    }

    private static List<List<Integer>> findZeroes(int[][] matrix) {
        List<List<Integer>> zeroes = new ArrayList<>();
        Collections.addAll(zeroes, new ArrayList<>(), new ArrayList<>());
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroes.get(0).add(i);
                    zeroes.get(1).add(j);
                }
            }
        }
        return zeroes;
    }
}
