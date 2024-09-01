class Solution {
    public int[][] construct2DArray(int[] arr1D, int rows, int cols) {
      
        if (rows * cols != arr1D.length) {
            return new int[0][0]; 
        }

        int[][] arr2D = new int[rows][cols];
        for (int i = 0; i < rows * cols; i++) {
            arr2D[i / cols][i % cols] = arr1D[i];
        }
        return arr2D;
    }
}