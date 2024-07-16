class Solution {
    public int numberOfSubstrings(String s) {
        int lastSeen[] = {-1, -1, -1};
        int cnt = 0;
        int n = s.length();
        for(int i=0; i<n; i++){
            lastSeen[s.charAt(i) -'a'] = i;
            if(lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1){
                cnt += (1 + Math.min(Math.min(lastSeen[0], lastSeen[1]), lastSeen[2]));
            }
        }
        return cnt;
    }
}