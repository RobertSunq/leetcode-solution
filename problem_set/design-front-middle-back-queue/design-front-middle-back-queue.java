
```
// @Title: 设计前中后队列 (Design Front Middle Back Queue)
// @Author: robert.sunq
// @Date: 2023-11-28 22:13:54
// @Runtime: 7 ms
// @Memory: 43.5 MB

class FrontMiddleBackQueue {
    
    // 保证左侧大于右侧， 即左侧的大小 等于右侧，或者比右侧多一个。  如果超过一个就需要触发平衡。
    Deque<Integer> left;
    Deque<Integer> right;

    public FrontMiddleBackQueue() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
    }
    
    public void pushFront(int val) {
        left.offerFirst(val);
 
        if (left.size() == right.size() + 2) {
            right.offerFirst(left.pollLast());
        }
    }
    
    public void pushMiddle(int val) {
        if (left.size() == right.size() + 1) {
            right.offerFirst(left.pollLast());
        }
        left.offerLast(val);
    }
    
    public void pushBack(int val) {
        right.offerLast(val);
        if (left.size() + 1 == right.size()) {
            left.offerLast(right.pollFirst());
        }
    }
    
    public int popFront() {
        if (left.isEmpty()) {
            return -1;
        }
        int val = left.pollFirst();
        if (left.size() + 1 == right.size()) {
            left.offerLast(right.pollFirst());
        }

        return val;
    }
    
    public int popMiddle() {
        if (left.isEmpty()) {
            return -1;
        }
        int val = left.pollLast();
        if (left.size() + 1 == right.size()) {
            left.offerLast(right.pollFirst());
        }

        return val;
    }
    
    public int popBack() {
        if (left.isEmpty()) {
            return -1;
        }
        int val = 0;
        if (right.isEmpty()) {
            val = left.pollLast();
        } else {
            val = right.pollLast();
            if (left.size() == right.size() + 2) {
                right.offerFirst(left.pollLast());
            }
        }

        return val;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
