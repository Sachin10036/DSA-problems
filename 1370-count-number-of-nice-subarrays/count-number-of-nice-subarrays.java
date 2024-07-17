class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return lessOrEqualToK(nums, k) - lessOrEqualToK(nums, k-1);
    }
    public int lessOrEqualToK(int nums[], int k){
        int l=0, r=0, ans=0, sum=0;
        int n = nums.length;
        while(r < n){
            sum += nums[r] % 2;
            while(sum > k){
                sum -= nums[l] % 2;
                l++;
            }
            ans += (r-l+1);
            r++;
        }
        return ans;
    }
}