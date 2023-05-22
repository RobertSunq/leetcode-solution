
| English | [简体中文](README.md) |

# [739. Daily Temperatures](https://leetcode.cn//problems/daily-temperatures/)

## Description

<p>Given an array of integers <code>temperatures</code> represents the daily temperatures, return <em>an array</em> <code>answer</code> <em>such that</em> <code>answer[i]</code> <em>is the number of days you have to wait after the</em> <code>i<sup>th</sup></code> <em>day to get a warmer temperature</em>. If there is no future day for which this is possible, keep <code>answer[i] == 0</code> instead.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> temperatures = [73,74,75,71,69,72,76,73]
<strong>Output:</strong> [1,1,4,2,1,1,0,0]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> temperatures = [30,40,50,60]
<strong>Output:</strong> [1,1,1,0]
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> temperatures = [30,60,90]
<strong>Output:</strong> [1,1,0]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;=&nbsp;temperatures.length &lt;= 10<sup>5</sup></code></li>
	<li><code>30 &lt;=&nbsp;temperatures[i] &lt;= 100</code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 每日温度 (Daily Temperatures)
// @Author: robert.sunq
// @Date: 2021-06-23 00:34:55
// @Runtime: 65 ms
// @Memory: 47.6 MB

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // 栈中保存暂时无法确认等待天数的下标
        Stack<Integer> st = new Stack<>();

        int[] dp = new int[temperatures.length];
        for(int i =0 ;i<temperatures.length;i++){
            // 栈中所有小于当前元素的值，其最近更高的气温就是当前天数
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                dp[st.peek()] = i - st.peek();
                // 栈中天数的最近高温已找到，出栈
                st.pop();
            }
            // 当前元素入栈， 即当前元素的高温在之后
            st.push(i);
        }
        // 因为数组初始化默认值都是 0 所以，站内留着的元素不需要再特殊处理
        return dp;
    }
}
```



## Related Topics

- [Stack](https://leetcode.cn//tag/stack)
- [Array](https://leetcode.cn//tag/array)
- [Monotonic Stack](https://leetcode.cn//tag/monotonic-stack)

## Similar Questions

- [Next Greater Element I](../next-greater-element-i/README_EN.md)
