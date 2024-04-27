class Solution {
    public int findRotateSteps(String ring, String key) {
        final int n = ring.length();
        final int k = key.length();
        final int[][] memo = new int[k][n];
        final byte[] keyc = new byte[k];
        key.getBytes(0, k, keyc, 0);
        
        final int[] letterCounts = new int[26];
        final int[][] positions = new int[26][n + 1];
        for (int i = 0; i < n; i++) {
            int c = ring.charAt(i) - 'a';
            positions[c][letterCounts[c]++] = i;
        }
        for (int c = 0; c < 26; c++)
            positions[c][letterCounts[c]] = -1;
        
        return findMinSteps(positions, keyc, memo, n, 0, 0);
    }
    
    private int findMinSteps(int[][] positions, byte[] keyc, int[][] memo,
                                int n, int atTop, int keyIdx) {
        if (keyIdx >= keyc.length)  return 0;
        int c = keyc[keyIdx] - 'a';
        if (memo[keyIdx][atTop] != 0)  return memo[keyIdx][atTop];
        
        int[] pos = positions[c];
        int minSteps = Integer.MAX_VALUE;
        for (int p : pos) {
            if (p < 0)  break;
            int dist = ((atTop + n) - p) % n;
            dist = Math.min(dist, n - dist);
            minSteps = Math.min(minSteps, dist + findMinSteps(positions, 
                                       keyc, memo, n, p, keyIdx + 1));
        }
        return memo[keyIdx][atTop] = minSteps + 1;
    }
}