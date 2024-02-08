// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.ca/all/348.html

// Video Solution: https://youtu.be/eaBYb0uSfBM

**************** Java Solution ***********************


public class TicTacToe {
    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;
    private int size;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        size = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int playerValue = (player == 1) ? 1 : -1;
        
        // Update the row, column, and possibly diagonals
        rows[row] += playerValue;
        cols[col] += playerValue;
        
        // Check if the move is on the main diagonal
        if (row == col) {
            diagonal += playerValue;
        }
        
        // Check if the move is on the anti-diagonal
        if (row + col == size - 1) {
            antiDiagonal += playerValue;
        }
        
        // Check if this move wins the game
        if (Math.abs(rows[row]) == size ||
            Math.abs(cols[col]) == size ||
            Math.abs(diagonal) == size ||
            Math.abs(antiDiagonal) == size) {
            return player;
        }
        
        // No one wins yet
        return 0;
    }
}
