
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 040. 矩阵中最大的矩形](https://leetcode.cn//problems/PLYXKQ/)

## 题目描述

<p>给定一个由&nbsp;<code>0</code> 和 <code>1</code>&nbsp;组成的矩阵 <code>matrix</code>&nbsp;，找出只包含 <code>1</code> 的最大矩形，并返回其面积。</p>

<p><strong>注意：</strong>此题 <code>matrix</code>&nbsp;输入格式为一维 <code>01</code> 字符串数组。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/09/14/maximal.jpg" style="width: 402px; height: 322px;" /></p>

<pre>
<strong>输入：</strong>matrix = ["10100","10111","11111","10010"]
<strong>输出：</strong>6
<strong>解释：</strong>最大矩形如上图所示。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>matrix = []
<strong>输出：</strong>0
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>matrix = ["0"]
<strong>输出：</strong>0
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>matrix = ["1"]
<strong>输出：</strong>1
</pre>

<p><strong>示例 5：</strong></p>

<pre>
<strong>输入：</strong>matrix = ["00"]
<strong>输出：</strong>0
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>rows == matrix.length</code></li>
	<li><code>cols == matrix[0].length</code></li>
	<li><code>0 &lt;= row, cols &lt;= 200</code></li>
	<li><code>matrix[i][j]</code> 为 <code>'0'</code> 或 <code>'1'</code></li>
</ul>

<p>&nbsp;</p>

<p>注意：本题与主站 85 题相同（输入参数格式不同）：&nbsp;<a href="https://leetcode-cn.com/problems/maximal-rectangle/">https://leetcode-cn.com/problems/maximal-rectangle/</a></p>


## 题解


### Java

```Java
// @Title: 矩阵中最大的矩形 (矩阵中最大的矩形)
// @Author: robert.sunq
// @Date: 2023-07-03 23:30:56
// @Runtime: 52 ms
// @Memory: 41.9 MB

class Solution {
    public int maximalRectangle(String[] matrix) {
        int n = matrix.length;
        if (n < 1) {
            return 0;
        }
        int m = matrix[0].length();

        int[] heights = new int[m];

        int ans = 0;
        // 类似于题 https://leetcode.cn/problems/0ynMMM/description/， 将每一行作为低，抽象为一个柱状图
        for (int i = 0; i < n; i++) {
            for (int j = 0 ; j < m; j++) {
                if (matrix[i].charAt(j) == '1') {
                    heights[j] = heights[j] + 1;
                } else {
                    heights[j] = 0;
                }
            }
            // 计算每一行的最大面积， 柱状图中的最大面积
            ans = Math.max(ans, largestRectangleArea(heights));
        }

        return ans;
    }


    /**
     *
     */
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        int n = heights.length;
        // 记录 左侧第一个小于当前 heights[i] 的索引 - 1
        int[] leftMinIndex = new int[n];
        // 记录 右侧第一个大于当前 heights[i] 的索引 + 1
        int[] rightMinIndex = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            // 单调栈的形式，找到左侧第一个小于当前元素的索引
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            leftMinIndex[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();


        for (int i = n - 1; i >= 0; i--) {
            // 单调栈的形式，找到右侧第一个小于当前元素的索引
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            rightMinIndex[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
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
- [动态规划](https://leetcode.cn//tag/dynamic-programming)
- [矩阵](https://leetcode.cn//tag/matrix)
- [单调栈](https://leetcode.cn//tag/monotonic-stack)

## 相似题目



