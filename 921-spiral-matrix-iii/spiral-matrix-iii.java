class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        List<int[]> result = new ArrayList<>();
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int steps = 1;
        int d = 0;
        int r = rStart, c = cStart;
        result.add(new int[]{r, c});

        while (result.size() < rows * cols) {
            for (int i = 0; i < 2; ++i) {
                for (int j = 0; j < steps; ++j) {
                    r += directions[d][0];
                    c += directions[d][1];
                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        result.add(new int[]{r, c});
                    }
                }
                d = (d + 1) % 4;
            }
            ++steps;
        }

        return result.toArray(new int[result.size()][]);
    }
}