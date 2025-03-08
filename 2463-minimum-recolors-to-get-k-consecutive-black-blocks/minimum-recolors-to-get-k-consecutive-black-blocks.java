class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int w = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') w++;
        }
        
        int ans = w;
        for (int i = k; i < n; i++) {
            if (blocks.charAt(i) == 'W') w++;
            if (blocks.charAt(i - k) == 'W') w--;
            ans = Math.min(ans, w);
        }
        return ans;
    }
}