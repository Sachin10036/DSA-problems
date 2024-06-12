/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findPeak(MountainArray mountainArr){
        int left = 0;
        int right = mountainArr.length()-1;
        while(left < right){
            int mid = left+(right-left)/2;
            if(mountainArr.get(mid) >= mountainArr.get(mid+1)){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        int peak = left;
        return peak;
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr);
        int left = 0;
        int right = peak;
        while(left <= right){
            int mid = left+(right-left)/2;
            int curr = mountainArr.get(mid);
            if(curr == target) return mid;
            else if(curr > target){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        left = peak+1;
        right = mountainArr.length()-1;
        while(left <= right){
            int mid = left+(right-left)/2;
            int curr = mountainArr.get(mid);
            if(curr == target) return mid;
            else if(curr > target) left = mid+1;
            else right = mid-1;
        }
        return -1;
    }
}