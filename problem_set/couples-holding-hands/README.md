
| [English](README_EN.md) | 简体中文 |

# [765. 情侣牵手](https://leetcode.cn//problems/couples-holding-hands/)

## 题目描述

<p><code>n</code> 对情侣坐在连续排列的 <code>2n</code>&nbsp;个座位上，想要牵到对方的手。</p>

<p>人和座位由一个整数数组 <code>row</code> 表示，其中 <code>row[i]</code> 是坐在第 <code>i </code>个座位上的人的 <strong>ID</strong>。情侣们按顺序编号，第一对是&nbsp;<code>(0, 1)</code>，第二对是&nbsp;<code>(2, 3)</code>，以此类推，最后一对是&nbsp;<code>(2n-2, 2n-1)</code>。</p>

<p>返回 <em>最少交换座位的次数，以便每对情侣可以并肩坐在一起</em>。 <i>每次</i>交换可选择任意两人，让他们站起来交换座位。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> row = [0,2,1,3]
<strong>输出:</strong> 1
<strong>解释:</strong> 只需要交换row[1]和row[2]的位置即可。
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> row = [3,2,0,1]
<strong>输出:</strong> 0
<strong>解释:</strong> 无需交换座位，所有的情侣都已经可以手牵手了。
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>2n == row.length</code></li>
	<li><code>2 &lt;= n &lt;= 30</code></li>
	<li><code>n</code>&nbsp;是偶数</li>
	<li><code>0 &lt;= row[i] &lt; 2n</code></li>
	<li><code>row</code>&nbsp;中所有元素均<strong>无重复</strong></li>
</ul>


## 题解


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



## 相关话题

- [贪心](https://leetcode.cn//tag/greedy)
- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [广度优先搜索](https://leetcode.cn//tag/breadth-first-search)
- [并查集](https://leetcode.cn//tag/union-find)
- [图](https://leetcode.cn//tag/graph)

## 相似题目


- [缺失的第一个正数](../first-missing-positive/README.md)
- [丢失的数字](../missing-number/README.md)
- [相似度为 K 的字符串](../k-similar-strings/README.md)
