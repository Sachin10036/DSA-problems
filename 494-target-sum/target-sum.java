class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totSum = 0;
        int d = target;
        int n = nums.length;
        for(int i =0; i<n; i++){
            totSum += nums[i];
        }
        if(totSum - d < 0 || (totSum - d) % 2 != 0) return 0;
        return f(nums, (totSum-d) / 2);
    }

    public int f(int arr[], int sum){
        int n = arr.length;
        int dp[][] = new int[n][sum+1];
        if(arr[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;
        if(arr[0] != 0 &&  arr[0] <= sum) dp[0][arr[0]] = 1;
        for(int ind=1; ind<n; ind++){
            for(int target = 0; target <= sum; target++){
                int notPick = dp[ind-1][target];
                int pick = 0;
                if(arr[ind] <= target) pick = dp[ind-1][target-arr[ind]];
                dp[ind][target] = (notPick + pick);
            }
        }
        return dp[n-1][sum];
    }
}