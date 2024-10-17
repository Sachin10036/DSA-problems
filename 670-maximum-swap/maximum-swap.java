class Solution {
    public int maximumSwap(int num) {
        String str = Integer.toString(num);
        StringBuilder s = new StringBuilder(str);
        int n = s.length();
        int maxRight[] = new int[n];
        maxRight[n-1] = n-1;
        for(int i=n-2; i>= 0; i--){
            int maxRIdx = maxRight[i+1];
            char maxREle = s.charAt(maxRIdx);
            maxRight[i] = (s.charAt(i) > maxREle) ? i : maxRIdx;
        }
        for(int i=0; i<n; i++){
            int maxRIdx = maxRight[i];
            if(s.charAt(i) < s.charAt(maxRIdx)){
                char temp = s.charAt(i);
                s.setCharAt(i, s.charAt(maxRIdx));
                s.setCharAt(maxRIdx, temp);
                return Integer.parseInt(s.toString());
            }
        }
        return num;
    }
}