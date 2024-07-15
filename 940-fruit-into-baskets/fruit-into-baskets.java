import java.util.HashMap;

class Solution {
    public int totalFruit(int[] fruits) {
        int l = 0, r = 0, maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (r < fruits.length) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            if (map.size() > 2) {
                int val = map.get(fruits[l]);
                map.put(fruits[l], val-1);
                if (map.getOrDefault(fruits[l], 0) == 0) {
                    map.remove(fruits[l]);
                }
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }

}
