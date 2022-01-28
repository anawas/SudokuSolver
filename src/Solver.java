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
        printSudoku();
        if (solve()) {
            System.out.println("Solved successfully");
            System.out.println();
            printSudoku();
        } else {
            System.out.println("No solution found");
        }
    }

    private static boolean solve() {
        for (int row = 0; row < SUDOKU_SIZE; row++) {
            for (int col = 0; col < SUDOKU_SIZE; col++) {
                if (grid[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValidLocation(num, row, col)) {
                            grid[row][col] = num;
                            if (solve()) {
                                return true;
                            } else {
                                grid[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidLocation(int number, int row, int col) {
        return isAvailableInColumn(number, col)
                && isAvailableInRow(number, row)
                && isAvailableInSquare(number, row, col);
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

    private static void printSudoku() {
        for (int i = 0; i < SUDOKU_SIZE; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("-".repeat(21));
            }
            for (int j = 0; j < SUDOKU_SIZE; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                if (grid[i][j] == 0) {
                    System.out.print(". ");
                } else {
                    System.out.print(grid[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
