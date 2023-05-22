
| [English](README_EN.md) | 简体中文 |

# [221. 最大正方形](https://leetcode.cn//problems/maximal-square/)

## 题目描述

<p>在一个由 <code>'0'</code> 和 <code>'1'</code> 组成的二维矩阵内，找到只包含 <code>'1'</code> 的最大正方形，并返回其面积。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/26/max1grid.jpg" style="width: 400px; height: 319px;" />
<pre>
<strong>输入：</strong>matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
<strong>输出：</strong>4
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/26/max2grid.jpg" style="width: 165px; height: 165px;" />
<pre>
<strong>输入：</strong>matrix = [["0","1"],["1","0"]]
<strong>输出：</strong>1
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>matrix = [["0"]]
<strong>输出：</strong>0
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == matrix.length</code></li>
	<li><code>n == matrix[i].length</code></li>
	<li><code>1 <= m, n <= 300</code></li>
	<li><code>matrix[i][j]</code> 为 <code>'0'</code> 或 <code>'1'</code></li>
</ul>


## 题解


### Java

```Java
// @Title: 最大正方形 (Maximal Square)
// @Author: robert.sunq
// @Date: 2021-06-17 00:51:36
// @Runtime: 10 ms
// @Memory: 41.5 MB

class Solution {
    public int maximalSquare(char[][] matrix) {
        int[] hight = new int[matrix[0].length];
        int res = 0;
        for(int i=0;i<matrix.length;i++){
            // 记录该位置的柱状图 高度
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == '1'){
                    hight[j] = hight[j]+1;
                }else{
                    hight[j] = 0;
                }
            }
            res = Math.max(res,recur(hight));
        }
        return res;
    }

    int recur(int[] hight){
        int len = hight.length;
        if(len == 0) return 0;
        if(len == 1) return Math.min(hight[0],1);
        int res = 0;
        // 递减栈
        Stack<Integer> st = new Stack<>();
        // 放入起点
        st.push(0);
        for(int i=0;i<hight.length;i++){
            // 栈顶大于当前值，则栈顶的元素 左边界为其在栈的下一个  右边界为当前元素位置
            while(!st.isEmpty() && hight[i] < hight[st.peek()]){
                int h = hight[st.pop()];
                int row = 0;
                if(st.isEmpty()){
                    // 表示到 I 位置，不包含hight[i] 当前位置的 最小值
                    row = i; 
                }else{
                    row = i-st.peek()-1;
                }
                // 即正方形最小面积  是在长方形中 长宽中最小值
                int temp = Math.min(h,row) * Math.min(h,row);
                res = Math.max(res,temp);
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int h = hight[st.pop()];
            int row = 0;
            if(st.isEmpty()){
                // 即此时元素 为整个列表中最小值
                row = len; 
            }else{
                // 此时是栈中所有的元素 向左均可以连续到边界
                row = len-st.peek()-1;
            }
            // 即正方形最小面积  是在长方形中 长宽中最小值
            int temp = Math.min(h,row) * Math.min(h,row);
            res = Math.max(res,temp);            
        }

        return res;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)
- [矩阵](https://leetcode.cn//tag/matrix)

## 相似题目


- [最大矩形](../maximal-rectangle/README.md)
- [最大加号标志](../largest-plus-sign/README.md)
