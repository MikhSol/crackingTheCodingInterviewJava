package main;

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
}
