
```
// @Title: 数据流中的中位数 (数据流中的中位数  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-28 23:48:11
// @Runtime: 81 ms
// @Memory: 49.7 MB

class MedianFinder {
    Queue<Integer> A,B;
    // A 小顶堆，B 大顶堆
    /** initialize your data structure here. */
    public MedianFinder() {
        A = new PriorityQueue<>(); // 小顶堆 保存大的一部分 ， 对顶为中位数中大的哪个
        B = new PriorityQueue<>((x,y) -> (y-x)); // 大顶堆 保存小的一部分 对顶为中位数小的哪个
    }
    
    public void addNum(int num) {
        // 如果两个堆大小相等，默认放到大顶堆中 , 可知 在整个过程中，B中的数多
        if(A.size() == B.size()){
            // 此过程 A++， A--, B++
            A.add(num);
            // 将A中最小的放到B中
            B.add(A.poll());
        }else{
            // 不相等时，B中多，所以将元素最终放到 A中
            // 此过程 B++,B--,A++
            B.add(num);
            // 将B中的最大值放到A中
            A.add(B.poll());
        }

    }
    
    public double findMedian() {
        return A.size() == B.size() ? (A.peek() + B.peek())/2.0 : B.peek();
    }
}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
