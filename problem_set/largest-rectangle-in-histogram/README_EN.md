
| English | [简体中文](README.md) |

# [84. Largest Rectangle in Histogram](https://leetcode.cn//problems/largest-rectangle-in-histogram/)

## Description

<p>Given an array of integers <code>heights</code> representing the histogram&#39;s bar height where the width of each bar is <code>1</code>, return <em>the area of the largest rectangle in the histogram</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/histogram.jpg" style="width: 522px; height: 242px;" />
<pre>
<strong>Input:</strong> heights = [2,1,5,6,2,3]
<strong>Output:</strong> 10
<strong>Explanation:</strong> The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/histogram-1.jpg" style="width: 202px; height: 362px;" />
<pre>
<strong>Input:</strong> heights = [2,4]
<strong>Output:</strong> 4
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= heights.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= heights[i] &lt;= 10<sup>4</sup></code></li>
</ul>


## Solutions


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



## Related Topics

- [Stack](https://leetcode.cn//tag/stack)
- [Array](https://leetcode.cn//tag/array)
- [Monotonic Stack](https://leetcode.cn//tag/monotonic-stack)

## Similar Questions

- [Maximal Rectangle](../maximal-rectangle/README_EN.md)
