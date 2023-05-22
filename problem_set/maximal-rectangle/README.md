
| [English](README_EN.md) | 简体中文 |

# [85. 最大矩形](https://leetcode.cn//problems/maximal-rectangle/)

## 题目描述

<p>给定一个仅包含&nbsp;<code>0</code> 和 <code>1</code> 、大小为 <code>rows x cols</code> 的二维二进制矩阵，找出只包含 <code>1</code> 的最大矩形，并返回其面积。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/14/maximal.jpg" style="width: 402px; height: 322px;" />
<pre>
<strong>输入：</strong>matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
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
<strong>输入：</strong>matrix = [["0"]]
<strong>输出：</strong>0
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>matrix = [["1"]]
<strong>输出：</strong>1
</pre>

<p><strong>示例 5：</strong></p>

<pre>
<strong>输入：</strong>matrix = [["0","0"]]
<strong>输出：</strong>0
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>rows == matrix.length</code></li>
	<li><code>cols == matrix[0].length</code></li>
	<li><code>1 &lt;= row, cols &lt;= 200</code></li>
	<li><code>matrix[i][j]</code> 为 <code>'0'</code> 或 <code>'1'</code></li>
</ul>


## 题解


### Java

```Java
// @Title: 最大矩形 (Maximal Rectangle)
// @Author: robert.sunq
// @Date: 2021-06-09 00:14:28
// @Runtime: 9 ms
// @Memory: 41.3 MB

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length <= 0) return 0;
        // 保存每一行的 第I列 所组成的连续矩形最长高度
        int[] hight = new int[matrix[0].length];
        int res = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == '1'){
                    hight[j] = hight[j] + 1;
                }else{
                    hight[j] = 0;
                }
            }
            res = Math.max(res,recur(hight));
        }
        return res;
    }

    // 第84题的逻辑，每一行中的柱状图中最大的巨星
    int recur(int[] matrix){
        int len = matrix.length;
        if(len <= 0) return 0;
        if(len == 1) return matrix[0];
        Stack<Integer> st = new Stack<>();
        int res = 0;
        st.push(0);
        for(int i = 1;i<len;i++){
            while(!st.isEmpty() && matrix[i] < matrix[st.peek()]){
                int hight = matrix[st.pop()];
                if(st.isEmpty()){
                    res = Math.max(res,i*hight);
                }else{
                    res = Math.max(res,(i - st.peek() - 1) * hight);
                }
            }
            st.push(i);
        }
        // 栈不为空，则表示剩余的每一个小矩形，都可以到最左侧
        while(!st.isEmpty()){
            int hight = matrix[st.pop()];
            if(st.isEmpty()){
                res = Math.max(res,len*hight);
            }else{
                res = Math.max(res,(len - st.peek() - 1) * hight);
            }
        }
        return res;
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


- [柱状图中最大的矩形](../largest-rectangle-in-histogram/README.md)
- [最大正方形](../maximal-square/README.md)
