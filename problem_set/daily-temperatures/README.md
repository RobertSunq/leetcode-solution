
| [English](README_EN.md) | 简体中文 |

# [739. 每日温度](https://leetcode.cn//problems/daily-temperatures/)

## 题目描述

<p>给定一个整数数组&nbsp;<code>temperatures</code>&nbsp;，表示每天的温度，返回一个数组&nbsp;<code>answer</code>&nbsp;，其中&nbsp;<code>answer[i]</code>&nbsp;是指对于第 <code>i</code> 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用&nbsp;<code>0</code> 来代替。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> <code>temperatures</code> = [73,74,75,71,69,72,76,73]
<strong>输出:</strong>&nbsp;[1,1,4,2,1,1,0,0]
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> temperatures = [30,40,50,60]
<strong>输出:</strong>&nbsp;[1,1,1,0]
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入:</strong> temperatures = [30,60,90]
<strong>输出: </strong>[1,1,0]</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;=&nbsp;temperatures.length &lt;= 10<sup>5</sup></code></li>
	<li><code>30 &lt;=&nbsp;temperatures[i]&nbsp;&lt;= 100</code></li>
</ul>


## 题解


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



## 相关话题

- [栈](https://leetcode.cn//tag/stack)
- [数组](https://leetcode.cn//tag/array)
- [单调栈](https://leetcode.cn//tag/monotonic-stack)

## 相似题目


- [下一个更大元素 I](../next-greater-element-i/README.md)
