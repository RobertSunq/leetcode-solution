
| English | [简体中文](README.md) |

# [221. Maximal Square](https://leetcode.cn//problems/maximal-square/)

## Description

<p>Given an <code>m x n</code> binary <code>matrix</code> filled with <code>0</code>&#39;s and <code>1</code>&#39;s, <em>find the largest square containing only</em> <code>1</code>&#39;s <em>and return its area</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/26/max1grid.jpg" style="width: 400px; height: 319px;" />
<pre>
<strong>Input:</strong> matrix = [[&quot;1&quot;,&quot;0&quot;,&quot;1&quot;,&quot;0&quot;,&quot;0&quot;],[&quot;1&quot;,&quot;0&quot;,&quot;1&quot;,&quot;1&quot;,&quot;1&quot;],[&quot;1&quot;,&quot;1&quot;,&quot;1&quot;,&quot;1&quot;,&quot;1&quot;],[&quot;1&quot;,&quot;0&quot;,&quot;0&quot;,&quot;1&quot;,&quot;0&quot;]]
<strong>Output:</strong> 4
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/26/max2grid.jpg" style="width: 165px; height: 165px;" />
<pre>
<strong>Input:</strong> matrix = [[&quot;0&quot;,&quot;1&quot;],[&quot;1&quot;,&quot;0&quot;]]
<strong>Output:</strong> 1
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> matrix = [[&quot;0&quot;]]
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == matrix.length</code></li>
	<li><code>n == matrix[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 300</code></li>
	<li><code>matrix[i][j]</code> is <code>&#39;0&#39;</code> or <code>&#39;1&#39;</code>.</li>
</ul>


## Solutions


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



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)
- [Matrix](https://leetcode.cn//tag/matrix)

## Similar Questions

- [Maximal Rectangle](../maximal-rectangle/README_EN.md)
- [Largest Plus Sign](../largest-plus-sign/README_EN.md)
