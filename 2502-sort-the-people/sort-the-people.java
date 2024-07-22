class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = heights.length;
        HashMap<Integer, String> map = new HashMap<>();
        for(int i=0; i<heights.length; i++){
            map.put(heights[i], names[i]);

        }
        Arrays.sort(heights);
        for(int i=0; i<n/2; i++){
            int temp = heights[i];
            heights[i] = heights[n-i-1];
            heights[n-i-1] = temp;
        }
        for(int i=0;i<heights.length; i++){
            names[i] = map.get(heights[i]);
        }
        return names;
    }
}