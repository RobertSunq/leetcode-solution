
```
// @Title: 数据流的第 K 大数值 (数据流的第 K 大数值)
// @Author: robert.sunq
// @Date: 2023-07-11 23:56:52
// @Runtime: 13 ms
// @Memory: 45.5 MB

class KthLargest {

    int k;
    PriorityQueue<Integer> q;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        // 大顶堆
        this.q = new PriorityQueue<>();
        for (int i : nums) {
            this.q.add(i);
        }
    }
    
    public int add(int val) {
        this.q.add(val);
        // 队列中数据 多于 k个，删除多于的小元素， 因为小于第k个大的元素都不用保留
        // 注意， 这里需要的时 第 k 个大的， 不是第 k 个小的
        // 所以，比 第 k 个大的元素小的值，不论什么时候录入，都不会被访问需求。
        // 同样录入一个比当前第k个大的， 则当前的第 k 个大的也将不会再被访问
        // 所以使用的小顶堆，每次只用保留的k个元素中最小的即可。
        while (this.q.size() > this.k) {
            this.q.remove();
        }
        
        // 此时，堆顶就是第k大的
        return this.q.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
