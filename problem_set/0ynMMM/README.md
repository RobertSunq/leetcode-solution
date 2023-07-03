
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 039. 直方图最大矩形面积](https://leetcode.cn//problems/0ynMMM/)

## 题目描述

<p>给定非负整数数组 <code>heights</code>&nbsp;，数组中的数字用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 <code>1</code> 。</p>

<p>求在该柱状图中，能够勾勒出来的矩形的最大面积。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2021/01/04/histogram.jpg" /></p>

<pre>
<strong>输入：</strong>heights = [2,1,5,6,2,3]
<strong>输出：</strong>10
<strong>解释：</strong>最大的矩形为图中红色区域，面积为 10
</pre>

<p><strong>示例 2：</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2021/01/04/histogram-1.jpg" /></p>

<pre>
<strong>输入：</strong> heights = [2,4]
<b>输出：</b> 4</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= heights.length &lt;=10<sup>5</sup></code></li>
	<li><code>0 &lt;= heights[i] &lt;= 10<sup>4</sup></code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 84&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/largest-rectangle-in-histogram/">https://leetcode-cn.com/problems/largest-rectangle-in-histogram/</a></p>


## 题解


### Java

```Java
// @Title: 直方图最大矩形面积 (直方图最大矩形面积)
// @Author: robert.sunq
// @Date: 2023-07-03 23:11:49
// @Runtime: 11 ms
// @Memory: 53.4 MB

class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        int n = heights.length;
        // 记录 左侧第一个小于当前 heights[i] 的索引 - 1
        int[] leftMinIndex = new int[n];
        // 记录 右侧第一个大于当前 heights[i] 的索引 + 1
        int[] rightMinIndex = new int[n];

        for (int i = 0; i < n; i++) {
            int index = i - 1;
            int a = heights[i];
            int b = -1;;
            while (index >= 0) {
                b = heights[index];
                if (b < a) {
                    leftMinIndex[i] = index;
                    break;
                }
                // 当 h[j] > h[i] 可以根据 j 所在的 leftMinIndex 快速跳跃
                index = leftMinIndex[index];
                b = -1;
            }
            if (b == -1) {
                leftMinIndex[i] = index;
            }
        }


        for (int i = n - 1; i >= 0; i--) {
            int index = i + 1;
            int a = heights[i];
            int b = -1;;
            while (index < n) {
                b = heights[index];
                if (b < a) {
                    rightMinIndex[i] = index;
                    break;
                }
                // 当 h[j] > h[i] 可以根据 j 所在的 rightMinIndex 快速跳跃
                index = rightMinIndex[index];
                b = -1;
            }
            if (b == -1) {
                rightMinIndex[i] = index;
            }
        }

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (rightMinIndex[i] - leftMinIndex[i] - 1) * heights[i]);
        }
        return ans;
    }
}
```



## 相关话题

- [栈](https://leetcode.cn//tag/stack)
- [数组](https://leetcode.cn//tag/array)
- [单调栈](https://leetcode.cn//tag/monotonic-stack)

## 相似题目



