class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int prev[] = new int[amount+1];
        int cur[] = new int[amount+1];
        for(int t = 0; t <= amount; t++){
            if(t % coins[0] == 0){
                prev[t] = t / coins[0];
            }
            else prev[t] = (int) Math.pow(10, 9);
        }
        for(int ind = 1; ind <n; ind++){
            for(int t = 0; t<= amount; t++){
                int notTake = 0+prev[t];
                int take = (int) Math.pow(10, 9);
                if(coins[ind] <= t) take = 1+cur[t-coins[ind]];
                cur[t] = Math.min(take, notTake);
            }
            prev = cur;
        }
        int ans = prev[amount];
        if(ans >= (int) Math.pow(10, 9)) return -1;
        else return ans;
    }
}
