
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int nse[] = findNse(arr);
        int psee[] = findPsee(arr);
        long total = 0;
        int mod = 1000000007;

        for (int i = 0; i < n; i++) {
            int left = i - psee[i];
            int right = nse[i] - i;
            total = (total + (long) arr[i] * left * right % mod) % mod;
        }

        return (int) total;
    }

    private int[] findNse(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        return nse;
    }

    private int[] findPsee(int[] arr) {
        int n = arr.length;
        int[] psee = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            psee[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return psee;
    }

}
