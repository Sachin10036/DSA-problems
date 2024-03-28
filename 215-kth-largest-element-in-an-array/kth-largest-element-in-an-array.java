class Solution {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> numLst = new ArrayList<>();
        for(int n: nums) numLst.add(n);
        return quickSort(numLst, k);
    }
    private int quickSort(List<Integer> nums, int k){
        
        int pivot = nums.get((int)(Math.random() * nums.size()));
        List<Integer> greaterThan = new ArrayList<>();
        int equalTo = 0;
        List<Integer> lessThan = new ArrayList<>();
        for(int n: nums){
            if(n == pivot) equalTo++;
            else if(n < pivot) lessThan.add(n);
            else greaterThan.add(n);
        }
        if(greaterThan.size() >= k) return quickSort(greaterThan, k);
        else if(greaterThan.size() + equalTo >= k) return pivot;
        return quickSort(lessThan, k - greaterThan.size() - equalTo);
    }
}