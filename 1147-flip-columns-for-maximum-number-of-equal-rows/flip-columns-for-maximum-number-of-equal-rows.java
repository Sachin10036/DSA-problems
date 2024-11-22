class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        HashMap<String, Integer> map = new HashMap<>();

        for (int[] row : matrix) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < m; j++) {
                temp.append(row[j] == row[0] ? '1' : '0');
            }
            String pattern = temp.toString();
            map.put(pattern, map.getOrDefault(pattern, 0) + 1);
        }

        int maxi = 0;
        for (int count : map.values()) {
            maxi = Math.max(maxi, count);
        }

        return maxi;
    }
}