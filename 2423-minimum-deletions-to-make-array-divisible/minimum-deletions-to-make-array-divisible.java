class Solution {
    public int findGCD(int numsDivide[]){
        int gcd = numsDivide[0];
        for(int i=0; i<numsDivide.length; i++){
            int num = numsDivide[i];
            while(num != 0){
                int temp = num;
                num = gcd%num;
                gcd = temp;
            }
            if(gcd == 1) break;
        }
        return gcd;
    }
    public int minOperations(int[] nums, int[] numsDivide) {
        int gcd = findGCD(numsDivide);
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(gcd % nums[i] == 0){
                return i;
            }
        }
        return -1;
    }
}