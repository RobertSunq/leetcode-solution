
```
// @Title: 用两个栈实现队列 (用两个栈实现队列 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-24 22:52:14
// @Runtime: 270 ms
// @Memory: 47.7 MB

class CQueue {

    LinkedList<Integer> A, B;

    public CQueue() {
        A = new LinkedList<Integer>();
        B = new LinkedList<Integer>();
    }
    
    public void appendTail(int value) {
        if(A.isEmpty()) {
           A.addLast(value); 
           return;
        }
        do{
            B.addLast(A.removeLast());
        }while(!A.isEmpty());
        A.addLast(value);
        do{
            A.addLast(B.removeLast());
        }while(!B.isEmpty());
    }
    
    public int deleteHead() {
        if (A.size() < 1 ) return -1;
        return A.removeLast();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
