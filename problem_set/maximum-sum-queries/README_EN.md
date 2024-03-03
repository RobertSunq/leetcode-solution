
| English | [简体中文](README.md) |

# [2736. Maximum Sum Queries](https://leetcode.cn//problems/maximum-sum-queries/)

## Description

<p>You are given two <strong>0-indexed</strong> integer arrays <code>nums1</code> and <code>nums2</code>, each of length <code>n</code>, and a <strong>1-indexed 2D array</strong> <code>queries</code> where <code>queries[i] = [x<sub>i</sub>, y<sub>i</sub>]</code>.</p>

<p>For the <code>i<sup>th</sup></code> query, find the <strong>maximum value</strong> of <code>nums1[j] + nums2[j]</code> among all indices <code>j</code> <code>(0 &lt;= j &lt; n)</code>, where <code>nums1[j] &gt;= x<sub>i</sub></code> and <code>nums2[j] &gt;= y<sub>i</sub></code>, or <strong>-1</strong> if there is no <code>j</code> satisfying the constraints.</p>

<p>Return <em>an array </em><code>answer</code><em> where </em><code>answer[i]</code><em> is the answer to the </em><code>i<sup>th</sup></code><em> query.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [4,3,1,2], nums2 = [2,4,9,5], queries = [[4,1],[1,3],[2,5]]
<strong>Output:</strong> [6,10,7]
<strong>Explanation:</strong> 
For the 1st query <code node="[object Object]">x<sub>i</sub> = 4</code>&nbsp;and&nbsp;<code node="[object Object]">y<sub>i</sub> = 1</code>, we can select index&nbsp;<code node="[object Object]">j = 0</code>&nbsp;since&nbsp;<code node="[object Object]">nums1[j] &gt;= 4</code>&nbsp;and&nbsp;<code node="[object Object]">nums2[j] &gt;= 1</code>. The sum&nbsp;<code node="[object Object]">nums1[j] + nums2[j]</code>&nbsp;is 6, and we can show that 6 is the maximum we can obtain.

For the 2nd query <code node="[object Object]">x<sub>i</sub> = 1</code>&nbsp;and&nbsp;<code node="[object Object]">y<sub>i</sub> = 3</code>, we can select index&nbsp;<code node="[object Object]">j = 2</code>&nbsp;since&nbsp;<code node="[object Object]">nums1[j] &gt;= 1</code>&nbsp;and&nbsp;<code node="[object Object]">nums2[j] &gt;= 3</code>. The sum&nbsp;<code node="[object Object]">nums1[j] + nums2[j]</code>&nbsp;is 10, and we can show that 10 is the maximum we can obtain. 

For the 3rd query <code node="[object Object]">x<sub>i</sub> = 2</code>&nbsp;and&nbsp;<code node="[object Object]">y<sub>i</sub> = 5</code>, we can select index&nbsp;<code node="[object Object]">j = 3</code>&nbsp;since&nbsp;<code node="[object Object]">nums1[j] &gt;= 2</code>&nbsp;and&nbsp;<code node="[object Object]">nums2[j] &gt;= 5</code>. The sum&nbsp;<code node="[object Object]">nums1[j] + nums2[j]</code>&nbsp;is 7, and we can show that 7 is the maximum we can obtain.

Therefore, we return&nbsp;<code node="[object Object]">[6,10,7]</code>.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [3,2,5], nums2 = [2,3,4], queries = [[4,4],[3,2],[1,1]]
<strong>Output:</strong> [9,9,9]
<strong>Explanation:</strong> For this example, we can use index&nbsp;<code node="[object Object]">j = 2</code>&nbsp;for all the queries since it satisfies the constraints for each query.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [2,1], nums2 = [2,3], queries = [[3,3]]
<strong>Output:</strong> [-1]
<strong>Explanation:</strong> There is one query in this example with <code node="[object Object]">x<sub>i</sub></code> = 3 and <code node="[object Object]">y<sub>i</sub></code> = 3. For every index, j, either nums1[j] &lt; <code node="[object Object]">x<sub>i</sub></code> or nums2[j] &lt; <code node="[object Object]">y<sub>i</sub></code>. Hence, there is no solution. 
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>nums1.length == nums2.length</code>&nbsp;</li>
	<li><code>n ==&nbsp;nums1.length&nbsp;</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums1[i], nums2[i] &lt;= 10<sup>9</sup>&nbsp;</code></li>
	<li><code>1 &lt;= queries.length &lt;= 10<sup>5</sup></code></li>
	<li><code>queries[i].length ==&nbsp;2</code></li>
	<li><code>x<sub>i</sub>&nbsp;== queries[i][1]</code></li>
	<li><code>y<sub>i</sub> == queries[i][2]</code></li>
	<li><code>1 &lt;= x<sub>i</sub>, y<sub>i</sub> &lt;= 10<sup>9</sup></code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 最大和查询 (Maximum Sum Queries)
// @Author: robert.sunq
// @Date: 2023-11-17 23:38:17
// @Runtime: 60 ms
// @Memory: 89.5 MB

class Solution {
    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length;
        int[][] sortedNums = new int[n][2];

        for (int i = 0; i < n; i++) {
            sortedNums[i][0] = nums1[i];
            sortedNums[i][1] = nums2[i];
        }

        Arrays.sort(sortedNums, (a, b) -> b[0] - a[0]);
        int q = queries.length;
        int[][] sortedQueries = new int[q][3];
        for (int i = 0; i < q; i++) {
            sortedQueries[i][0] = i;
            sortedQueries[i][1] = queries[i][0];
            sortedQueries[i][2] = queries[i][1];
        }

        Arrays.sort(sortedQueries, (a, b) -> b[1] - a[1]);
        List<int[]> stack = new ArrayList<>();
        int[] ans = new int[q];

        Arrays.fill(ans, -1);

        int j = 0;
        for (int[] query : sortedQueries) {
            int i = query[0], x = query[1], y = query[2];
            // 因为 sortedNums 是根据 x1 降序的， sortedQueries 也是 x 降序的
            // 所以可以保留 j 的索引，来找到 比 x 大的 x1, 然后再找y
            while (j < n && sortedNums[j][0] >= x) {
                int[] pair = sortedNums[j];
                int num1 = pair[0], num2 = pair[1];
                // 移除 已经访问过的 x2 + y2 <= 当前 x1 + y1 的值，因为这些都不满足最大的条件。
                while (!stack.isEmpty() && stack.get(stack.size() - 1)[1] <= num1 + num2) {
                    stack.remove(stack.size() - 1);
                }
                
                //保存符合题意的结果
                if(stack.isEmpty() || stack.get(stack.size() - 1)[0] < num2) {
                    stack.add(new int[]{num2, num1 + num2});
                }
                j++;
            }
            // 二分法查找结果的索引
            int k = binarySearch(stack, y);
            if (k < stack.size()) {
                ans[i] = stack.get(k)[1];
            }
        }
        return ans;

    }

    private int binarySearch(List<int[]> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            // 注意 y1 是递增的
            if (list.get(mid)[0] >= target) {
                high = mid;
            } else {
                // x1 + y1 是递减的
                low = mid + 1;
            }
        }

        return low;
    }


}
```



## Related Topics

- [Stack](https://leetcode.cn//tag/stack)
- [Binary Indexed Tree](https://leetcode.cn//tag/binary-indexed-tree)
- [Segment Tree](https://leetcode.cn//tag/segment-tree)
- [Array](https://leetcode.cn//tag/array)
- [Binary Search](https://leetcode.cn//tag/binary-search)
- [Sorting](https://leetcode.cn//tag/sorting)
- [Monotonic Stack](https://leetcode.cn//tag/monotonic-stack)

## Similar Questions


