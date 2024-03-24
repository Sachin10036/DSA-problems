class Solution {
    public int[] sumZero(int n) {
        int[] arr = new int[n];

        if (n == 1) {
            arr[0] = 0;
            return arr;
        }

        if (n % 2 != 0) {
            arr[0] = 0;
            for (int j = 1; j < n; j = j + 2) {
                arr[j] = j;
                arr[j + 1] = -j;
            }
        } else {
            for (int j = 0; j < n; j = j=j+2) {
                arr[j] = j+1;
                arr[j + 1] = -(j+1);
            }
        }
        return arr;
    }
}