
| English | [简体中文](README.md) |

# [2661. First Completely Painted Row or Column](https://leetcode.cn//problems/first-completely-painted-row-or-column/)

## Description

<p>You are given a <strong>0-indexed</strong> integer array <code>arr</code>, and an <code>m x n</code> integer <strong>matrix</strong> <code>mat</code>. <code>arr</code> and <code>mat</code> both contain <strong>all</strong> the integers in the range <code>[1, m * n]</code>.</p>

<p>Go through each index <code>i</code> in <code>arr</code> starting from index <code>0</code> and paint the cell in <code>mat</code> containing the integer <code>arr[i]</code>.</p>

<p>Return <em>the smallest index</em> <code>i</code> <em>at which either a row or a column will be completely painted in</em> <code>mat</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="image explanation for example 1" /><img alt="image explanation for example 1" src="https://assets.leetcode.com/uploads/2023/01/18/grid1.jpg" style="width: 321px; height: 81px;" />
<pre>
<strong>Input:</strong> arr = [1,3,4,2], mat = [[1,4],[2,3]]
<strong>Output:</strong> 2
<strong>Explanation:</strong> The moves are shown in order, and both the first row and second column of the matrix become fully painted at arr[2].
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="image explanation for example 2" src="https://assets.leetcode.com/uploads/2023/01/18/grid2.jpg" style="width: 601px; height: 121px;" />
<pre>
<strong>Input:</strong> arr = [2,8,7,4,1,3,5,6,9], mat = [[3,2,5],[1,4,6],[8,7,9]]
<strong>Output:</strong> 3
<strong>Explanation:</strong> The second column becomes fully painted at arr[3].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == mat.length</code></li>
	<li><code>n = mat[i].length</code></li>
	<li><code>arr.length == m * n</code></li>
	<li><code>1 &lt;= m, n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= m * n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= arr[i], mat[r][c] &lt;= m * n</code></li>
	<li>All the integers of <code>arr</code> are <strong>unique</strong>.</li>
	<li>All the integers of <code>mat</code> are <strong>unique</strong>.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 找出叠涂元素 (First Completely Painted Row or Column)
// @Author: robert.sunq
// @Date: 2023-12-01 22:13:48
// @Runtime: 24 ms
// @Memory: 61 MB

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map.put(mat[i][j], new int[] {i, j});
            }
        }

        // 统计染色的点，所在的 行 和 列 的个数
        int[] rowCount = new int[n];
        int[] colCount = new int[m];

        for (int i = 0; i < arr.length; i++) {
            int[] v = map.get(arr[i]);
            rowCount[v[0]] = rowCount[v[0]] + 1;

            // 第一个满足就返回，此时就是下标最小的，因为从 0 开始遍历的
            // 个数与列相等，则表示这样一行已经满了。
            if (rowCount[v[0]] == m) {
                return i;
            }
            // 个数与行相等，则表示这样一列已经满了。
            colCount[v[1]] = colCount[v[1]] + 1;
            if (colCount[v[1]] == n) {
                return i;
            }
        }

        return -1;
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Hash Table](https://leetcode.cn//tag/hash-table)
- [Matrix](https://leetcode.cn//tag/matrix)

## Similar Questions


