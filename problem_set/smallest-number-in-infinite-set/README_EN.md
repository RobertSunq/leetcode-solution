
| English | [简体中文](README.md) |

# [2336. Smallest Number in Infinite Set](https://leetcode.cn//problems/smallest-number-in-infinite-set/)

## Description

<p>You have a set which contains all positive integers <code>[1, 2, 3, 4, 5, ...]</code>.</p>

<p>Implement the <code>SmallestInfiniteSet</code> class:</p>

<ul>
	<li><code>SmallestInfiniteSet()</code> Initializes the <strong>SmallestInfiniteSet</strong> object to contain <strong>all</strong> positive integers.</li>
	<li><code>int popSmallest()</code> <strong>Removes</strong> and returns the smallest integer contained in the infinite set.</li>
	<li><code>void addBack(int num)</code> <strong>Adds</strong> a positive integer <code>num</code> back into the infinite set, if it is <strong>not</strong> already in the infinite set.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input</strong>
[&quot;SmallestInfiniteSet&quot;, &quot;addBack&quot;, &quot;popSmallest&quot;, &quot;popSmallest&quot;, &quot;popSmallest&quot;, &quot;addBack&quot;, &quot;popSmallest&quot;, &quot;popSmallest&quot;, &quot;popSmallest&quot;]
[[], [2], [], [], [], [1], [], [], []]
<strong>Output</strong>
[null, null, 1, 2, 3, null, 1, 4, 5]

<strong>Explanation</strong>
SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
smallestInfiniteSet.addBack(2);    // 2 is already in the set, so no change is made.
smallestInfiniteSet.popSmallest(); // return 1, since 1 is the smallest number, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 2, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 3, and remove it from the set.
smallestInfiniteSet.addBack(1);    // 1 is added back to the set.
smallestInfiniteSet.popSmallest(); // return 1, since 1 was added back to the set and
                                   // is the smallest number, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 4, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 5, and remove it from the set.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= num &lt;= 1000</code></li>
	<li>At most <code>1000</code> calls will be made <strong>in total</strong> to <code>popSmallest</code> and <code>addBack</code>.</li>
</ul>


## Solutions


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



## Related Topics

- [Design](https://leetcode.cn//tag/design)
- [Hash Table](https://leetcode.cn//tag/hash-table)
- [Heap (Priority Queue)](https://leetcode.cn//tag/heap-priority-queue)

## Similar Questions


