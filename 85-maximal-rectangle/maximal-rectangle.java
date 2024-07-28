class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int pSum[][] = new int[n][m];
        int maxArea = 0;
        for(int j=0; j<m; j++){
            int sum =0;
            for(int i=0; i<n; i++){
                if(matrix[i][j] == '1'){
                    sum++;
                }
                else{
                    sum = 0;
                }
                pSum[i][j] = sum;
            }
        }
        for(int i=0; i<n; i++){
            maxArea = Math.max(maxArea, lHist(pSum[i]));
        }
        return maxArea;
    }
    public int lHist(int arr[]){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                int element = st.peek();
                st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(maxArea, arr[element]*(nse - pse -1));
            }
            st.push(i);
        }
        while(!st.isEmpty()){
                int nse = n;
                int element = st.peek();
                st.pop();
                int pse = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(maxArea, arr[element]*(nse - pse -1));
        }
        return maxArea;
    }
}