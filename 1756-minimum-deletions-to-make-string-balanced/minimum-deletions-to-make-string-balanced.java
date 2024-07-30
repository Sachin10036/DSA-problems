class Solution {
    public int minimumDeletions(String s) {
        int ans = 0;
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == 'b'){
                cnt++;
            }
            else if(cnt > 0){
                ans++;
                cnt--;
            }
        }
        return ans;
    }
}