
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> stack = new LinkedList<>();
        for(int i = 0; i < asteroids.length; i++) {
            if(asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i])) {
                    stack.pop();
                }
                if(!stack.isEmpty() && stack.peek() == Math.abs(asteroids[i])) {
                    stack.pop();
                } else {
                    if(stack.isEmpty() || stack.peek() < 0) {
                        stack.push(asteroids[i]);
                    }
                }
            }
        }
        int[] result = new int[stack.size()];
        for(int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
