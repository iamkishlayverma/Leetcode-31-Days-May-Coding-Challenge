class StockSpanner {
    
    Stack<Integer> stack;
    List<Integer> arr;
    int count;
    
    public StockSpanner() {
        count = 0;
        arr = new ArrayList<>();
        stack = new Stack<>();
        stack.push(count);         
    }
    
    public int next(int price) {        
        if (arr.size() == 0) {
            arr.add(price);
            return 1;
        }
        count++;
        while (!stack.empty() && arr.get(stack.peek()) <= price)
            stack.pop();             
        int res = (stack.empty()) ? (count + 1) : (count - stack.peek());
        arr.add(price); 
        stack.push(count);
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
