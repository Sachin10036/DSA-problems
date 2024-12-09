class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] pref = new int[n];
        pref[0] = 1;
        for (int i = 1; i < n; i++) {
            if ((nums[i] & 1) != (nums[i - 1] & 1)) {
                pref[i] = pref[i - 1] + 1;
            } else {
                pref[i] = 1;
            }
        }
        boolean[] ans = new boolean[queries.length];
        int index = 0;
        for (int[] query : queries) {
            int s = query[0], e = query[1];
            int len = e - s + 1;
            if (pref[e] < len) {
                ans[index++] = false;
            } else {
                ans[index++] = true;
            }
        }
        return ans;
    }
}