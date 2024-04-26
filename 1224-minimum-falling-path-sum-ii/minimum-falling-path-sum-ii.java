class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int best = Integer.MAX_VALUE;

                for (int k = 0; k < n; k++) {
                    if (k != j) {
                        best = Math.min(best, grid[i - 1][k]);
                    }
                }

                grid[i][j] += best;
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.min(result, grid[n - 1][i]);
        }

        return result;
    }
}