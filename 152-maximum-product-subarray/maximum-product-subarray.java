class Solution {
    public int maxProduct(int[] nums) {
        int prefix=1;
        int suffix=1;
        int maxPro=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(prefix==0){
                prefix=1;
            }
            if(suffix==0){
                suffix=1;
            }
            prefix=prefix*nums[i];
            suffix*=nums[nums.length-1-i];
            
            int max=Math.max(prefix,suffix);
            maxPro=Math.max(maxPro,max);
        }
        return maxPro;
    }
}