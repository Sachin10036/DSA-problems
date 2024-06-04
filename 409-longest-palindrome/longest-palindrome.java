class Solution {
    public int longestPalindrome(String s) {
        int[] counts = new int[128];
        for(char c : s.toCharArray()){
            counts[c]++;
        } 

        int result = 0;
        for(int count : counts){
            result += count / 2 * 2;
            if(result % 2 == 0 && count % 2 == 1){
                result += 1;
            }
        }

        return result;
    }
}