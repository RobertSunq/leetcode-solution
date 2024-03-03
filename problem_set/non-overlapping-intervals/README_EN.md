
| English | [简体中文](README.md) |

# [435. Non-overlapping Intervals](https://leetcode.cn//problems/non-overlapping-intervals/)

## Description

<p>Given an array of intervals <code>intervals</code> where <code>intervals[i] = [start<sub>i</sub>, end<sub>i</sub>]</code>, return <em>the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> intervals = [[1,2],[2,3],[3,4],[1,3]]
<strong>Output:</strong> 1
<strong>Explanation:</strong> [1,3] can be removed and the rest of the intervals are non-overlapping.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> intervals = [[1,2],[1,2],[1,2]]
<strong>Output:</strong> 2
<strong>Explanation:</strong> You need to remove two [1,2] to make the rest of the intervals non-overlapping.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> intervals = [[1,2],[2,3]]
<strong>Output:</strong> 0
<strong>Explanation:</strong> You don&#39;t need to remove any of the intervals since they&#39;re already non-overlapping.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= intervals.length &lt;= 10<sup>5</sup></code></li>
	<li><code>intervals[i].length == 2</code></li>
	<li><code>-5 * 10<sup>4</sup> &lt;= start<sub>i</sub> &lt; end<sub>i</sub> &lt;= 5 * 10<sup>4</sup></code></li>
</ul>


## Solutions


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



## Related Topics

- [Greedy](https://leetcode.cn//tag/greedy)
- [Array](https://leetcode.cn//tag/array)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)
- [Sorting](https://leetcode.cn//tag/sorting)

## Similar Questions

- [Minimum Number of Arrows to Burst Balloons](../minimum-number-of-arrows-to-burst-balloons/README_EN.md)
