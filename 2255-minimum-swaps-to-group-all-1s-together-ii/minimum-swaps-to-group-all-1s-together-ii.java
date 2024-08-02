class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int totalOnes = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == 1){
                totalOnes++;
            }
        }
        int maxCount = 0;
        int currCount = 0;
        int i = 0;
        int j = 0;
        while(j < 2*n){
            if(nums[j%n] == 1){
                currCount++;
            }
            if(j-i+1 > totalOnes){
                currCount -= nums[i%n];
                i++;
            }
            maxCount = Math.max(maxCount, currCount);
            j++;
        }
        return totalOnes - maxCount;
    }
}