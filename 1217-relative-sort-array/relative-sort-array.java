class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> remaining = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        // Initialize count map with relative order elements
        for (int num : arr2) {
            countMap.put(num, 0);
        }

        // Count occurrences of elements in target array
        for (int num : arr1) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                remaining.add(num);
            }
        }

        // Sort the remaining elements
        Collections.sort(remaining);

        // Add elements as per relative order
        for (int num : arr2) {
            for (int j = 0; j < countMap.get(num); j++) {
                result.add(num);
            }
        }

        result.addAll(remaining);

        // Convert List<Integer> to int[]
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}