class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int front[] = new int[n];
        for(int j=0; j<n; j++){
            front[j] = triangle.get(n-1).get(j);
        }
        for(int i=n-2; i>=0; i--){
            int cur[] = new int[n];
            for(int j=i; j>=0; j--){
                int d = triangle.get(i).get(j) + front[j];
                int dg = triangle.get(i).get(j) + front[j+1];
                cur[j] = Math.min(d, dg);
            }
            front = cur;
        }
        return front[0];
    }
}