class Solution {
    private static final int MOD = 1000000007;
    long[][][] dp = new long[100001][3][4];
    public int checkRecord(int n) {
        

        for (int ac = 0; ac <= 1; ac++) {
            for (int clc = 0; clc <= 2; clc++) {
                dp[0][ac][clc] = 1;
            }
        }

        for (int day = 1; day <= n; day++) {
            for (int ac = 0; ac <= 1; ac++) {
                for (int clc = 0; clc <= 2; clc++) {
                    dp[day][ac][clc] = (dp[day - 1][ac][0]) % MOD;
                    dp[day][ac][clc] = (dp[day][ac][clc] + dp[day - 1][ac + 1][0]) % MOD;
                    dp[day][ac][clc] = (dp[day][ac][clc] + dp[day - 1][ac][clc + 1]) % MOD;
                }
            }
        }
        return (int) dp[n][0][0];
    }
}