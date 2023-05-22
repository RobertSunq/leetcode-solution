
```
// @Title: 包含min函数的栈 (包含min函数的栈 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-26 23:50:41
// @Runtime: 22 ms
// @Memory: 40.1 MB

class MinStack {

    LinkedList<Integer> st;
    LinkedList<Integer> minSt = new LinkedList<Integer>();
    /** initialize your data structure here. */
    public MinStack() {
        st = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        st.addLast(x);
        // 维护最小值栈，为非严格递减
        if(minSt.isEmpty() || x<= minSt.getLast()) minSt.addLast(x);
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        int temp = st.removeLast();
        if(temp == minSt.getLast()) minSt.removeLast();
    }
    
    public int top() {
        if(st.isEmpty()) return -1;
        return st.getLast();
    }
    
    public int min() {
        if(minSt.isEmpty()) return -1;
        return minSt.getLast();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
