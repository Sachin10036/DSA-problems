class Solution {
    public int maximumGain(String s, int x, int y) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != 'a' && s.charAt(i) != 'b') continue;
            int j = i;
            StringBuilder t = new StringBuilder();
            while (j < n && (s.charAt(j) == 'a' || s.charAt(j) == 'b')) {
                t.append(s.charAt(j));
                j++;
            }
            ans += Math.max(processAB(t.toString(), x, y), processBA(t.toString(), x, y));
            i = j - 1;
        }
        return ans;
    }
    
    public int processAB(String s, int x, int y) {
        Stack<Character> stk = new Stack<>();
        int ans = 0;
        for (char c : s.toCharArray()) {
            if (!stk.isEmpty() && stk.peek() == 'a' && c == 'b') {
                stk.pop();
                ans += x;
            } else {
                stk.push(c);
            }
        }
        int a = 0, b = 0;
        for (char c : stk) {
            if (c == 'a') a++;
            else b++;
        }
        return Math.min(a, b) * y + ans;
    }
    
    public int processBA(String s, int x, int y) {
        Stack<Character> stk = new Stack<>();
        int ans = 0;
        for (char c : s.toCharArray()) {
            if (!stk.isEmpty() && stk.peek() == 'b' && c == 'a') {
                stk.pop();
                ans += y;
            } else {
                stk.push(c);
            }
        }
        int a = 0, b = 0;
        for (char c : stk) {
            if (c == 'a') a++;
            else b++;
        }
        return Math.min(a, b) * x + ans;
    }
}