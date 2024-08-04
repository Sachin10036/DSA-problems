class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        final int MOD = 1000000007;
        
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                minHeap.offer(prefix[i] - prefix[j]);
            }
        }
        
        long result = 0;
        for (int i = 1; i <= right; i++) {
            int sum_value = minHeap.poll();
            if (i >= left) {
                result = (result + sum_value) % MOD;
            }
        }
        
        return (int) result;
    }
}