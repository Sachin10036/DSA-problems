class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;
        for(int i=1; i<n; i++){
            int rob = nums[i];
            if(i > 1) rob += prev2;
            int nonRob = 0 + prev;
            int curi = Math.max(rob, nonRob);
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }
}