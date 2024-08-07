import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> ansList = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0, j = 0;
        
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                ansList.add(nums1[i]);
                i++;
                j++;
            }
        }
        
        int[] ansArray = new int[ansList.size()];
        for (int k = 0; k < ansList.size(); k++) {
            ansArray[k] = ansList.get(k);
        }
        
        return ansArray;
    }
}
