
```
// @Title: 无限集中的最小数字 (Smallest Number in Infinite Set)
// @Author: robert.sunq
// @Date: 2023-11-29 21:27:33
// @Runtime: 10 ms
// @Memory: 43.4 MB

class SmallestInfiniteSet {
    // 没有插入数值的时候，用一个变量来记录最小值
    // 插入值时，如果比最小值大， 则其还未被弹出（因为每次弹出按顺序虽小的值）
    //           如果比最小值小，则用小根堆记录，时新的最小值，在下次弹出

    private int min;
    private PriorityQueue<Integer> q;

    public SmallestInfiniteSet() {
        min = 1;
        q = new PriorityQueue<>();
    }
    
    public int popSmallest() {
        // 小根堆有数值，则弹出小根堆中数值， 它比记录 Min 小
        if (!q.isEmpty()) {
            return q.poll();
        }
        return min++;
    }
    
    public void addBack(int num) {
        // 注意小根堆中不要保存重复值
        // 注意，要保存到堆中的是，小于当前遍历到的最小值的，才是需要额外保存的，
        // 大于的因为不是最小值，且会被后续遍历到，无需保存
        if (num < min && !q.contains(num)) {
            q.offer(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
