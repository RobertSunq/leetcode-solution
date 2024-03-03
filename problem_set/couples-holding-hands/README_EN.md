
| English | [简体中文](README.md) |

# [765. Couples Holding Hands](https://leetcode.cn//problems/couples-holding-hands/)

## Description

<p>There are <code>n</code> couples sitting in <code>2n</code> seats arranged in a row and want to hold hands.</p>

<p>The people and seats are represented by an integer array <code>row</code> where <code>row[i]</code> is the ID of the person sitting in the <code>i<sup>th</sup></code> seat. The couples are numbered in order, the first couple being <code>(0, 1)</code>, the second couple being <code>(2, 3)</code>, and so on with the last couple being <code>(2n - 2, 2n - 1)</code>.</p>

<p>Return <em>the minimum number of swaps so that every couple is sitting side by side</em>. A swap consists of choosing any two people, then they stand up and switch seats.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> row = [0,2,1,3]
<strong>Output:</strong> 1
<strong>Explanation:</strong> We only need to swap the second (row[1]) and third (row[2]) person.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> row = [3,2,0,1]
<strong>Output:</strong> 0
<strong>Explanation:</strong> All couples are already seated side by side.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2n == row.length</code></li>
	<li><code>2 &lt;= n &lt;= 30</code></li>
	<li><code>n</code> is even.</li>
	<li><code>0 &lt;= row[i] &lt; 2n</code></li>
	<li>All the elements of <code>row</code> are <strong>unique</strong>.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 情侣牵手 (Couples Holding Hands)
// @Author: robert.sunq
// @Date: 2023-11-11 21:58:34
// @Runtime: 1 ms
// @Memory: 39.1 MB

class Solution {

    // 贪心模拟出来就是正确结果了，也就是只要每次交换都保证会拉近一对情侣，交换次数就是最少的
    
    // 假如存在一次交换是拉近了两对情侣（正好这两个位置交换后都牵手了），但是这个时候用贪心只拉近了一对情侣，那交换次数不就变多了吗？
    // 这种情况其实只能选择拉近他们这两对，因为只有一种配对方法，答案这个 n-1 就是最后一次一定是满足两队的
    public int minSwapsCouples(int[] row) {
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        int n = row.length;
        for (int i = 0; i < n; i+=2) {
            map.put(row[i], i);
            map.put(row[i + 1], i + 1);
        }

        for (int i = 0; i < n; i+=2) {
            int friend = getFriend(row[i]);
            if (row[i+1] == friend) {
                continue;
            }
            int move = map.get(friend);
            row[move] = row[i+1];
            map.put(row[i+1], move);
            row[i+1] = friend;
            map.put(friend, i + 1);
            count++;
        }

        return count;
    }

    public int getFriend(int i) {
        return (i / 2) * 2 == i ? i + 1 : i - 1;
    }
}
```



## Related Topics

- [Greedy](https://leetcode.cn//tag/greedy)
- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Breadth-First Search](https://leetcode.cn//tag/breadth-first-search)
- [Union Find](https://leetcode.cn//tag/union-find)
- [Graph](https://leetcode.cn//tag/graph)

## Similar Questions

- [First Missing Positive](../first-missing-positive/README_EN.md)
- [Missing Number](../missing-number/README_EN.md)
- [K-Similar Strings](../k-similar-strings/README_EN.md)
