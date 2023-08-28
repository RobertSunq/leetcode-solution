
| [English](README_EN.md) | 简体中文 |

# [1732. 找到最高海拔](https://leetcode.cn//problems/find-the-highest-altitude/)

## 题目描述

<p>有一个自行车手打算进行一场公路骑行，这条路线总共由 <code>n + 1</code> 个不同海拔的点组成。自行车手从海拔为 <code>0</code> 的点 <code>0</code> 开始骑行。</p>

<p>给你一个长度为 <code>n</code> 的整数数组 <code>gain</code> ，其中 <code>gain[i]</code> 是点 <code>i</code> 和点 <code>i + 1</code> 的 <strong>净海拔高度差</strong>（<code>0 <= i < n</code>）。请你返回 <strong>最高点的海拔</strong> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<b>输入：</b>gain = [-5,1,5,0,-7]
<b>输出：</b>1
<b>解释：</b>海拔高度依次为 [0,-5,-4,1,1,-6] 。最高海拔为 1 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<b>输入：</b>gain = [-4,-3,-2,-1,4,3,2]
<b>输出：</b>0
<b>解释：</b>海拔高度依次为 [0,-4,-7,-9,-10,-6,-3,-1] 。最高海拔为 0 。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == gain.length</code></li>
	<li><code>1 <= n <= 100</code></li>
	<li><code>-100 <= gain[i] <= 100</code></li>
</ul>


## 题解


### Java

```Java
// @Title: 找到最高海拔 (Find the Highest Altitude)
// @Author: robert.sunq
// @Date: 2023-08-20 22:59:24
// @Runtime: 0 ms
// @Memory: 39 MB

class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0;
        int hight = 0;
        int n = gain.length;
        for (int i = 0; i < n ; i++) {
            hight = hight + gain[i];
            ans = Math.max(ans, hight);
        }

        return ans;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [前缀和](https://leetcode.cn//tag/prefix-sum)

## 相似题目



