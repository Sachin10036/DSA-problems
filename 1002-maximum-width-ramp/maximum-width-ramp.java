class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int maxToR[] = new int[n];
        maxToR[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--){
            maxToR[i] = Math.max(maxToR[i+1], nums[i]);
        }

        int ramp = 0;
        int i=0;
        int j=0;
        while(j < n){
            while(i < j && nums[i] > maxToR[j]){
                i++;
            }
            ramp = Math.max(ramp, j-i);
            j++;
        }
        return ramp;
    }
}