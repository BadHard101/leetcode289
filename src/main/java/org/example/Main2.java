package org.example;

import java.util.Arrays;

public class Main2 {
    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = liveNeighbors(board, m, n, i, j);
            }
        }

        System.out.println(Arrays.deepToString(matrix));

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = query(matrix[i][j], board[i][j]);
            }
        }
    }

    private static int query(int count, int prev) {
        if (count < 2) return 0;
        if (count == 3) return 1;
        if (count > 3) return 0;
        return prev;
    }

    private static int liveNeighbors(int[][] board, int m, int n, int i, int j) {
        int lives = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                lives += board[x][y] & 1;
            }
        }
        lives -= board[i][j] & 1;
        return lives;
    }

    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }
}