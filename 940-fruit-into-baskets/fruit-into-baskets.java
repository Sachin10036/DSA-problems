import java.util.HashMap;

class Solution {
    public int totalFruit(int[] fruits) {
        int l = 0, r = 0, maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (r < fruits.length) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            if (map.size() > 2) {
                reduceFrequency(map, fruits[l]);
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

    public static void reduceFrequency(HashMap<Integer, Integer> map, int key) {
        map.computeIfPresent(key, (k, v) -> v > 1 ? v - 1 : null);
    }
}
