package org.example;

import java.util.Arrays;

public class Main {
    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = countLiveNeighbors(board, i, j);
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

    private static int countLiveNeighbors(int[][] board, int x, int y) {
        int m = board.length;
        int n = board[0].length;
        int ans = 0;

        if (x+1 < m)
            ans += board[x+1][y];
        if (x-1 >= 0)
            ans += board[x-1][y];

        if (y+1 < n)
            ans += board[x][y+1];
        if (y-1 >= 0)
            ans += board[x][y-1];

        if (x+1 < m && y+1 < n)
            ans += board[x+1][y+1];
        if (x+1 < m && y-1 >= 0)
            ans += board[x+1][y-1];

        if (x-1 >= 0 && y+1 < n)
            ans += board[x-1][y+1];
        if (x-1 >= 0 && y-1 >= 0)
            ans += board[x-1][y-1];

        return ans;
    }

    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }
}