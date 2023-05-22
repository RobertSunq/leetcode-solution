
```
// @Title: 队列的最大值 (队列的最大值 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 21:57:06
// @Runtime: 41 ms
// @Memory: 46.3 MB

class MaxQueue {
    Queue<Integer> A ;
    LinkedList<Integer> maxA;
    public MaxQueue() {
        A = new LinkedList<Integer>();
        maxA = new LinkedList<Integer>();
    }
    
    public int max_value() {
        if(maxA.isEmpty()) return -1;
        return maxA.getFirst();
    }
    
    public void push_back(int value) {
        A.offer(value);
        while(!maxA.isEmpty() && maxA.getLast() < value) maxA.removeLast();
        maxA.addLast(value);
    }
    
    public int pop_front() {
        if(A.isEmpty()) return -1;
        int temp = A.poll();
        if(temp == maxA.getFirst()) maxA.removeFirst();
        return temp;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
