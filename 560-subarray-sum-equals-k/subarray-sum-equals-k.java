class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length; 
        HashMap<Integer, Integer> map = new HashMap<>();
        int preSum = 0, cnt = 0;

        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            preSum += nums[i];
            
            int remove = preSum - k;

            cnt += map.getOrDefault(remove, 0);

            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return cnt;
    }
}