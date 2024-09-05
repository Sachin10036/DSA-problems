class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int ans[] = new int[n];
        int m = rolls.length;
        int sum = 0;
        for(int i=0; i<m; i++){
            sum += rolls[i];
        }
        int totalSum = (m + n) * mean;
        int sumDiff = totalSum - sum;

        int q = sumDiff / n;
        int r = sumDiff % n;

        if(q <= 0 || q > 6 || (q == 6 && r > 0)){
            return new int[]{};
        }
        
        int result[] = new int[n];
        Arrays.fill(result, q);
        for(int i=0; i<r; i++){
            result[i]++;
        }
        return result;
    }
}