class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev2 = 0;
        int prev = 0;
        for(int i=2; i<=n; i++){
            int fs = prev + cost[i-1];
            int ss = prev2 + cost[i-2];
            int curi = Math.min(fs, ss);
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }
}