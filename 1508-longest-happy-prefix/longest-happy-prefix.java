class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        if(n == 0) return "";
        int arr[] = new int[n];
        int max =0;
        int i =1;
        while(i < n){
            if(s.charAt(i) == s.charAt(max)){
                max++;
                arr[i] = max;
                i++;
            }
            else{
                if(max != 0){
                    max = arr[max-1];
                }
                else {
                    arr[i] =0;
                    i++;
                }
            }
        }
        return s.substring(0, arr[n-1]);
    }
}