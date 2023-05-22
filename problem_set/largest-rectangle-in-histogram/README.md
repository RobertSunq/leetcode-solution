
| [English](README_EN.md) | 简体中文 |

# [84. 柱状图中最大的矩形](https://leetcode.cn//problems/largest-rectangle-in-histogram/)

## 题目描述

<p>给定 <em>n</em> 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。</p>

<p>求在该柱状图中，能够勾勒出来的矩形的最大面积。</p>

<p> </p>

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

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= heights.length <=10<sup>5</sup></code></li>
	<li><code>0 <= heights[i] <= 10<sup>4</sup></code></li>
</ul>


## 题解


### Java

```Java
// @Title: 柱状图中最大的矩形 (Largest Rectangle in Histogram)
// @Author: robert.sunq
// @Date: 2021-06-08 23:27:12
// @Runtime: 44 ms
// @Memory: 48.4 MB

class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if(len <= 0) return 0;
        if(len == 1) return heights[0];
        int res = 0;
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i = 1;i<heights.length;++i){
            while(!st.isEmpty() && heights[i] < heights[st.peek()]){
                int height = heights[st.pop()];
                // 及此时栈空了，表示刚刚出栈的为 0————i之间最小的数，所以此时出栈位置元素的最大面积极为，高*当前长度
                if(st.isEmpty()){
                    res = Math.max(res,i*height);
                }else{
                    int right = st.peek();
                    res = Math.max(res,(i-right-1) * height);
                }
                
            }
            st.push(i);
        }
        while(!st.isEmpty()){
                int height = heights[st.pop()];
                if(st.isEmpty()){
                    res = Math.max(res,len*height);
                }else{
                    int right = st.peek();
                    res = Math.max(res,(len-right-1) * height);
                }
            }
        return res;
    }
}
```



## 相关话题

- [栈](https://leetcode.cn//tag/stack)
- [数组](https://leetcode.cn//tag/array)
- [单调栈](https://leetcode.cn//tag/monotonic-stack)

## 相似题目


- [最大矩形](../maximal-rectangle/README.md)
