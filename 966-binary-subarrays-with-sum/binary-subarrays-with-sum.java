class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return lessEqualToK(nums, goal) - lessEqualToK(nums, goal-1);
    }

    public int lessEqualToK(int nums[], int goal){
        if(goal < 0) return 0;
        int l=0, r=0, ans =0, sum=0;
        int n = nums.length;
        while(r < n){
            sum += nums[r];
            while(sum > goal){
                sum -= nums[l];
                l++;
            }
            ans += (r-l+1);
            r++;
        }
        return ans;
    }
}