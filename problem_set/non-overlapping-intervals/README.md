
| [English](README_EN.md) | 简体中文 |

# [435. 无重叠区间](https://leetcode.cn//problems/non-overlapping-intervals/)

## 题目描述

<p>给定一个区间的集合&nbsp;<code>intervals</code>&nbsp;，其中 <code>intervals[i] = [start<sub>i</sub>, end<sub>i</sub>]</code>&nbsp;。返回 <em>需要移除区间的最小数量，使剩余区间互不重叠&nbsp;</em>。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> intervals = [[1,2],[2,3],[3,4],[1,3]]
<strong>输出:</strong> 1
<strong>解释:</strong> 移除 [1,3] 后，剩下的区间没有重叠。
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> intervals = [ [1,2], [1,2], [1,2] ]
<strong>输出:</strong> 2
<strong>解释:</strong> 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入:</strong> intervals = [ [1,2], [2,3] ]
<strong>输出:</strong> 0
<strong>解释:</strong> 你不需要移除任何区间，因为它们已经是无重叠的了。
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>1 &lt;= intervals.length &lt;= 10<sup>5</sup></code></li>
	<li><code>intervals[i].length == 2</code></li>
	<li><code>-5 * 10<sup>4</sup>&nbsp;&lt;= start<sub>i</sub>&nbsp;&lt; end<sub>i</sub>&nbsp;&lt;= 5 * 10<sup>4</sup></code></li>
</ul>


## 题解


### Java

```Java
// @Title: 无重叠区间 (Non-overlapping Intervals)
// @Author: robert.sunq
// @Date: 2023-09-28 22:25:23
// @Runtime: 47 ms
// @Memory: 94.1 MB

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        // 按照 右节点升序
        Arrays.sort(intervals, new Comparator<int[]>() {

            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];
            }
        });

        int n = intervals.length;

        // 首个最左侧区间的右节点
        int right = intervals[0][1];

        int ans = 1;
        for (int i = 1; i < n; i++) {
            // 区间不重复，就是剩余所有区间中的 最左侧区间
            if (intervals[i][0] >= right) {
                ans++;
                right = intervals[i][1];
            }
        }

        // 总个数减去需要去掉的个数，就是结果
        return n - ans;
    }
}
```



## 相关话题

- [贪心](https://leetcode.cn//tag/greedy)
- [数组](https://leetcode.cn//tag/array)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)
- [排序](https://leetcode.cn//tag/sorting)

## 相似题目


- [用最少数量的箭引爆气球](../minimum-number-of-arrows-to-burst-balloons/README.md)
