
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 059. 数据流的第 K 大数值](https://leetcode.cn//problems/jBjn9C/)

## 题目描述

<p>设计一个找到数据流中第 <code>k</code> 大元素的类（class）。注意是排序后的第 <code>k</code> 大元素，不是第 <code>k</code> 个不同的元素。</p>

<p>请实现 <code>KthLargest</code>&nbsp;类：</p>

<ul>
	<li><code>KthLargest(int k, int[] nums)</code> 使用整数 <code>k</code> 和整数流 <code>nums</code> 初始化对象。</li>
	<li><code>int add(int val)</code> 将 <code>val</code> 插入数据流 <code>nums</code> 后，返回当前数据流中第 <code>k</code> 大的元素。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>
[&quot;KthLargest&quot;, &quot;add&quot;, &quot;add&quot;, &quot;add&quot;, &quot;add&quot;, &quot;add&quot;]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
<strong>输出：</strong>
[null, 4, 5, 5, 8, 8]

<strong>解释：</strong>
KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= k &lt;= 10<sup>4</sup></code></li>
	<li><code>0 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
	<li><code>-10<sup>4</sup> &lt;= val &lt;= 10<sup>4</sup></code></li>
	<li>最多调用 <code>add</code> 方法 <code>10<sup>4</sup></code> 次</li>
	<li>题目数据保证，在查找第 <code>k</code> 大元素时，数组中至少有 <code>k</code> 个元素</li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 703&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/">https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/</a></p>


## 题解


### Java

```Java
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
```



## 相关话题

- [树](https://leetcode.cn//tag/tree)
- [设计](https://leetcode.cn//tag/design)
- [二叉搜索树](https://leetcode.cn//tag/binary-search-tree)
- [二叉树](https://leetcode.cn//tag/binary-tree)
- [数据流](https://leetcode.cn//tag/data-stream)
- [堆（优先队列）](https://leetcode.cn//tag/heap-priority-queue)

## 相似题目



