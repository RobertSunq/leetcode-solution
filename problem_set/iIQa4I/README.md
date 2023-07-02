
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 038. 每日温度](https://leetcode.cn//problems/iIQa4I/)

## 题目描述

<p>请根据每日 <code>气温</code> 列表 <code>temperatures</code>&nbsp;，重新生成一个列表，要求其对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用&nbsp;<code>0</code> 来代替。</p>

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

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 739&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/daily-temperatures/">https://leetcode-cn.com/problems/daily-temperatures/</a></p>


## 题解


### Java

```Java
// @Title: 每日温度 (每日温度)
// @Author: robert.sunq
// @Date: 2023-07-02 22:10:08
// @Runtime: 1141 ms
// @Memory: 55.4 MB

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        ans[n - 1] = 0;
        if (n <2) {
            return ans;
        }
        for (int i = n - 2; i>= 0; i--) {
            if (temperatures[i] < temperatures[i+1]) {
                ans[i] = ans[i] + 1;
            } else {
                int j = i+1;
                while (j < n ) {
                    if (temperatures[i] < temperatures[j]) {
                        ans[i] = j - i;
                        break; 
                    }
                    j++;
                }
                if (j == n) {
                    ans[i] = 0;
                }
            }
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



