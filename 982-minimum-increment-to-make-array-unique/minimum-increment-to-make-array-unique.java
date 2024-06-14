class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int nextUnique = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nextUnique) {
                count += nextUnique - nums[i];
            } else {
                nextUnique = nums[i];
            }
            nextUnique++;
        }

        return count;
    }
}