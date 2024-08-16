class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int i=0; i<n; i++){
            totalSum += nums[i];
        }
        if(totalSum % 2 != 0) return false;
        int sum = totalSum / 2;
        return subSetSumToK(n, sum, nums);
    }

    public boolean subSetSumToK(int n, int k, int nums[]){
        boolean dp[][] = new boolean[n][k+1];
        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }
        if(nums[0] <= k){
            dp[0][nums[0]] = true;
        }
        for(int ind = 1; ind<n; ind++){
            for(int target =1; target<=k; target++){
                boolean notTake = dp[ind-1][target];
                boolean take = false;
                if(nums[ind] <= target){
                    take = dp[ind-1][target-nums[ind]];
                }
                dp[ind][target] = notTake || take;
            }
        }
        return dp[n-1][k];
    }
}