class Solution {

    public int totalNQueens(int n) {

        boolean[][] board = new boolean[n][n];

        return solve(board, 0, n);
    }

    public int solve(boolean[][] board, int row, int n) {

        // All queens are placed
        if (row == n) {
            return 1;
        }

        int count = 0;

        for (int col = 0; col < n; col++) {

            if (isSafe(board, row, col, n)) {

                // Place queen
                board[row][col] = true;

                // Move to next row
                count += solve(board, row + 1, n);

                // Backtrack
                board[row][col] = false;
            }
        }

        return count;
    }

    public boolean isSafe(
            boolean[][] board,
            int row,
            int col,
            int n) {

        // Check column
        for (int i = 0; i < row; i++) {

            if (board[i][col]) {
                return false;
            }
        }

        // Check upper-left diagonal
        int i = row - 1;
        int j = col - 1;

        while (i >= 0 && j >= 0) {

            if (board[i][j]) {
                return false;
            }

            i--;
            j--;
        }

        // Check upper-right diagonal
        i = row - 1;
        j = col + 1;

        while (i >= 0 && j < n) {

            if (board[i][j]) {
                return false;
            }

            i--;
            j++;
        }

        return true;
    }
}