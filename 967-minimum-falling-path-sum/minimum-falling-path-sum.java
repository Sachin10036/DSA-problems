class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int prev[] = new int[m];
        for(int j = 0; j< m; j++){
            prev[j] = matrix[0][j];
        }
        for(int i = 1; i<n; i++){
            int cur[] = new int[m];
            for(int j = 0; j<m; j++){
                int up = matrix[i][j] + prev[j];
                int ld = matrix[i][j];
                if(j - 1 >= 0) ld += prev[j-1];
                else ld += 1e9;
                int rd = matrix[i][j];
                if(j+1 < m) rd += prev[j+1];
                else rd += 1e9;
                cur[j] = Math.min(up, Math.min(ld, rd));
            }
            prev = cur;
        }
        int mini = prev[0];
        for(int j = 0; j< m; j++){
            mini = Math.min(mini, prev[j]);
        }
        return mini;
    }
}