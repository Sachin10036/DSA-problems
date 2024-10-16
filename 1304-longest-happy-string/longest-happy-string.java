class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        if(a > 0) pq.offer(new int[] {a, 'a'});
        if(b > 0) pq.offer(new int[] {b, 'b'});
        if(c > 0) pq.offer(new int[] {c, 'c'});
        
        StringBuilder result = new StringBuilder();
        
        while(!pq.isEmpty()) {
            int first[] = pq.poll();
            int currCount = first[0];
            char currChar = (char) first[1];
            
            if(result.length() >= 2 && result.charAt(result.length() - 1) == currChar && result.charAt(result.length() - 2) == currChar) {
                if(pq.isEmpty()) {
                    break;
                }
                
                int second[] = pq.poll();
                int nextCount = second[0];
                char nextChar = (char) second[1];
                result.append(nextChar);
                nextCount--;
                
                if(nextCount > 0) {
                    pq.offer(new int[] {nextCount, nextChar});
                }
                
                pq.offer(first);
            } else {
                result.append(currChar);
                currCount--;
                
                if(currCount > 0) {
                    pq.offer(new int[] {currCount, currChar});
                }
            }
        }
        
        return result.toString();
    }
}
