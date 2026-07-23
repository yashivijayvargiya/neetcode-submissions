class MinStack {
    Stack<Integer> st;

    public MinStack() {
        st = new Stack<>();
        
    }
    
    public void push(int val) {
        st.push(val);
        
    }
    
    public void pop() {
        st.pop();
        
    }
    
    public int top() {
        return st.peek();
        
    }
    
    public int getMin() {
        int min = st.peek();
        for(int i =0;i<st.size();i++){
            if(st.get(i)<min){
                min = st.get(i);
            }
        }
                    return min;

        
    }
}
