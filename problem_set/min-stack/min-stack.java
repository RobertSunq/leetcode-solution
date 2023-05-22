
```
// @Title: 最小栈 (Min Stack)
// @Author: robert.sunq
// @Date: 2021-06-14 21:50:01
// @Runtime: 7 ms
// @Memory: 40.2 MB

class MinStack {


    Stack<Integer> st ;
    Stack<Integer> minSt;
    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack<Integer>();
        minSt = new Stack<Integer>();
    }
    
    public void push(int val) {
        if(minSt.isEmpty()){
            minSt.push(val);
        }else{
            if(minSt.peek() >= val){
                minSt.push(val);
            }
        }
        st.push(val);
    }
    
    public void pop() {
        if(st.isEmpty()) return ;
        int temp = st.pop();
        if(!minSt.isEmpty() &&  temp == minSt.peek()){
            minSt.pop();
        }
    }
    
    public int top() {
        if(st.isEmpty()) return -1;
        int temp = st.peek();
        return temp;
    }
    
    public int getMin() {
        if(minSt.isEmpty()) return -1;
        return minSt.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
