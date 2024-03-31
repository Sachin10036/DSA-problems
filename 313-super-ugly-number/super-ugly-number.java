class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] dp=new long[n];
        dp[0]=1;
        int[] indexArr=new int[primes.length];
        for(int i=1; i<n; i++){
            long minValue=Long.MAX_VALUE;
            for(int j=0; j<primes.length; j++){
                minValue=Math.min(minValue,dp[indexArr[j]]*primes[j]);
            }
            dp[i]=minValue;
            for(int j=0; j<primes.length; j++){
                if(dp[i]==dp[indexArr[j]]*primes[j]){
                    indexArr[j]++;
                }
            }
        }
        return (int)dp[n-1];
    }
}