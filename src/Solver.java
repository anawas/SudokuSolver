public class Solver {

    private static final int SUDOKU_SIZE = 9;
    private static final int[][] grid = {{8, 3, 0, 0, 0, 0, 6, 9, 0},
            {0, 0, 5, 0, 6, 0, 2, 0, 0},
            {7, 4, 6, 1, 0, 9, 0, 3, 0},
            {0, 0, 9, 0, 0, 1, 0, 5, 0},
            {2, 7, 4, 0, 0, 0, 0, 0, 0},
            {5, 8, 0, 3, 4, 0, 9, 0, 6},
            {6, 0, 0, 0, 0, 0, 0, 0, 2},
            {0, 0, 0, 7, 5, 0, 1, 6, 9},
            {0, 0, 0, 6, 0, 0, 7, 0, 5}};

    public static void main(String[] args) {


    }

    private static boolean isAvailableInRow(int number, int row) {
        for (int i = 0; i < SUDOKU_SIZE; i++) {
            if (grid[row][i] == number) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAvailableInColumn(int number, int col) {
        for (int i = 0; i < SUDOKU_SIZE; i++) {
            if (grid[i][col] == number) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAvailableInSquare(int number, int row, int col) {
        int topLeftRow = row - row % 3;
        int topLeftCol = col - col % 3;

        for (int i = topLeftRow; i < topLeftRow + 3; i++) {
            for (int j = topLeftCol; j < topLeftCol + 3; j++) {
                if (grid[i][j] == number) {
                    return false;
                }
            }
        }
        return true;
    }
}
