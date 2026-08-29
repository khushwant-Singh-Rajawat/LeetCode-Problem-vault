class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int rows = mat.length;
        int cols = mat[0].length;

        // Check if reshape is possible
        if (rows * cols != r * c) {
            return mat;
        }

        int[][] result = new int[r][c];

        int k = 0;

        // Put all elements into new matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                result[k / c][k % c] = mat[i][j];
                k++;
            }
        }

        return result;
    }
}