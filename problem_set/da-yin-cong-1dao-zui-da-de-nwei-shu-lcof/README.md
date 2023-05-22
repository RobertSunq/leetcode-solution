
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 17. 打印从1到最大的n位数](https://leetcode.cn//problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/)

## 题目描述

<p>输入数字 <code>n</code>，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> n = 1
<strong>输出:</strong> [1,2,3,4,5,6,7,8,9]
</pre>

<p>&nbsp;</p>

<p>说明：</p>

<ul>
	<li>用返回一个整数列表来代替打印</li>
	<li>n 为正整数</li>
</ul>


## 题解


### Java

```Java
// @Title: 打印从1到最大的n位数 (打印从1到最大的n位数 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-25 23:15:10
// @Runtime: 1 ms
// @Memory: 46.3 MB

class Solution {
    public int[] printNumbers(int n) {
        if (n == 0) return new int[0];
        int num = (int)Math.pow(10,n);
        int[] dp = new int[num-1];
        for (int i=0;i<num-1;i++){
            dp[i] = i+1;
        }
        return dp;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [数学](https://leetcode.cn//tag/math)

## 相似题目



