
| [English](README_EN.md) | 简体中文 |

# [2336. 无限集中的最小数字](https://leetcode.cn//problems/smallest-number-in-infinite-set/)

## 题目描述

<p>现有一个包含所有正整数的集合 <code>[1, 2, 3, 4, 5, ...]</code> 。</p>

<p>实现 <code>SmallestInfiniteSet</code> 类：</p>

<ul>
	<li><code>SmallestInfiniteSet()</code> 初始化 <strong>SmallestInfiniteSet</strong> 对象以包含 <strong>所有</strong> 正整数。</li>
	<li><code>int popSmallest()</code> <strong>移除</strong> 并返回该无限集中的最小整数。</li>
	<li><code>void addBack(int num)</code> 如果正整数 <code>num</code> <strong>不</strong> 存在于无限集中，则将一个 <code>num</code> <strong>添加</strong> 到该无限集最后。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入</strong>
["SmallestInfiniteSet", "addBack", "popSmallest", "popSmallest", "popSmallest", "addBack", "popSmallest", "popSmallest", "popSmallest"]
[[], [2], [], [], [], [1], [], [], []]
<strong>输出</strong>
[null, null, 1, 2, 3, null, 1, 4, 5]

<strong>解释</strong>
SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
smallestInfiniteSet.addBack(2);    // 2 已经在集合中，所以不做任何变更。
smallestInfiniteSet.popSmallest(); // 返回 1 ，因为 1 是最小的整数，并将其从集合中移除。
smallestInfiniteSet.popSmallest(); // 返回 2 ，并将其从集合中移除。
smallestInfiniteSet.popSmallest(); // 返回 3 ，并将其从集合中移除。
smallestInfiniteSet.addBack(1);    // 将 1 添加到该集合中。
smallestInfiniteSet.popSmallest(); // 返回 1 ，因为 1 在上一步中被添加到集合中，
                                   // 且 1 是最小的整数，并将其从集合中移除。
smallestInfiniteSet.popSmallest(); // 返回 4 ，并将其从集合中移除。
smallestInfiniteSet.popSmallest(); // 返回 5 ，并将其从集合中移除。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= num &lt;= 1000</code></li>
	<li>最多调用 <code>popSmallest</code> 和 <code>addBack</code> 方法 <strong>共计</strong> <code>1000</code> 次</li>
</ul>


## 题解


### Java

```Java
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
```



## 相关话题

- [设计](https://leetcode.cn//tag/design)
- [哈希表](https://leetcode.cn//tag/hash-table)
- [堆（优先队列）](https://leetcode.cn//tag/heap-priority-queue)

## 相似题目



