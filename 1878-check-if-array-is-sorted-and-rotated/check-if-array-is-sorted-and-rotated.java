class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int peak = 0;
        for(int i=0; i<n; i++){
            if(nums[i] > nums[(i+1)%n]){
                peak++;
            }
        }
        return peak <= 1;
    }
}