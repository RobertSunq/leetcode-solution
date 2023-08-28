
```
// @Title: 最近的请求次数 (Number of Recent Calls)
// @Author: robert.sunq
// @Date: 2023-08-27 20:08:14
// @Runtime: 19 ms
// @Memory: 54.4 MB

class RecentCounter {
    Queue<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<>();
    }
    
    public int ping(int t) {
        queue.offer(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }

        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
