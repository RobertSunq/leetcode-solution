
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 41. 数据流中的中位数](https://leetcode.cn//problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/)

## 题目描述

<p>如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。</p>

<p>例如，</p>

<p>[2,3,4]&nbsp;的中位数是 3</p>

<p>[2,3] 的中位数是 (2 + 3) / 2 = 2.5</p>

<p>设计一个支持以下两种操作的数据结构：</p>

<ul>
	<li>void addNum(int num) - 从数据流中添加一个整数到数据结构中。</li>
	<li>double findMedian() - 返回目前所有元素的中位数。</li>
</ul>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：
</strong>[&quot;MedianFinder&quot;,&quot;addNum&quot;,&quot;addNum&quot;,&quot;findMedian&quot;,&quot;addNum&quot;,&quot;findMedian&quot;]
[[],[1],[2],[],[3],[]]
<strong>输出：</strong>[null,null,null,1.50000,null,2.00000]
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：
</strong>[&quot;MedianFinder&quot;,&quot;addNum&quot;,&quot;findMedian&quot;,&quot;addNum&quot;,&quot;findMedian&quot;]
[[],[2],[],[3],[]]
<strong>输出：</strong>[null,null,2.00000,null,2.50000]</pre>

<p>&nbsp;</p>

<p><strong>限制：</strong></p>

<ul>
	<li>最多会对&nbsp;<code>addNum、findMedian</code> 进行&nbsp;<code>50000</code>&nbsp;次调用。</li>
</ul>

<p>注意：本题与主站 295 题相同：<a href="https://leetcode-cn.com/problems/find-median-from-data-stream/">https://leetcode-cn.com/problems/find-median-from-data-stream/</a></p>


## 题解


### Java

```Java
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
```



## 相关话题

- [设计](https://leetcode.cn//tag/design)
- [双指针](https://leetcode.cn//tag/two-pointers)
- [数据流](https://leetcode.cn//tag/data-stream)
- [排序](https://leetcode.cn//tag/sorting)
- [堆（优先队列）](https://leetcode.cn//tag/heap-priority-queue)

## 相似题目



