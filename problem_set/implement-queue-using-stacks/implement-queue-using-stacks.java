
```
// @Title: 用栈实现队列 (Implement Queue using Stacks)
// @Author: robert.sunq
// @Date: 2021-07-11 22:05:32
// @Runtime: 0 ms
// @Memory: 36.1 MB

class MyQueue {
    Stack<Integer> A;
    Stack<Integer> B;
    /** Initialize your data structure here. */
    public MyQueue() {
        A = new Stack<>();
        B = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        A.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(A.isEmpty() && B.isEmpty()) return -1;
        if(B.isEmpty()){
            while(!A.isEmpty()){
                B.push(A.pop());
            }
        }
        return B.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(A.isEmpty() && B.isEmpty()) return -1;
        if(B.isEmpty()){
            while(!A.isEmpty()){
                B.push(A.pop());
            }
        }
        return B.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
