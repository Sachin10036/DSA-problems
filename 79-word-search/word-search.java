class Solution {
    int[] dr1 = {1, -1, 0, 0};
    int[] dr2 = {0, 0, 1, -1};

    public boolean solve(char[][] board, int row, int col, int i, int j, String word, int ind, int n) {
        if (ind == n - 1 && word.charAt(ind) == board[i][j]) return true;
        for (int d = 0; d < 4; d++) {
            int x = i + dr1[d], y = j + dr2[d];
            if (x >= 0 && x < row && y >= 0 && y < col && board[x][y] != '.' && board[x][y] == word.charAt(ind)) {
                char ch = board[x][y];
                board[x][y] = '.';
                if (ind == n - 1) return true;
                if (solve(board, row, col, x, y, word, ind + 1, n)) return true;
                board[x][y] = ch;
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int row = board.length, col = board[0].length, n = word.length();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (solve(board, row, col, i, j, word, 0, n)) return true;
            }
        }
        return false;
    }
}