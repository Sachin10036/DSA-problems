class StockSpanner {

    static class Pair<U, V> {
        public final U first;
        public final V second;
        public Pair(U first, V second){
            this.first = first;
            this.second = second;
        }
    }

    Stack<Pair<Integer, Integer>> st = new Stack<>();
    int ind = -1;
    public StockSpanner() {
        ind = -1;
        st.clear();
    }
    
    public int next(int price) {
        ind++;
        while(!st.isEmpty() && st.peek().first <= price){
            st.pop();
        }
        int ans = ind - (st.isEmpty() ? -1 : st.peek().second);
        st.push(new Pair<>(price, ind));
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */