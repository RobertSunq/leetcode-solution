
| [English](README_EN.md) | 简体中文 |

# [96. 不同的二叉搜索树](https://leetcode.cn//problems/unique-binary-search-trees/)

## 题目描述

<p>给你一个整数 <code>n</code> ，求恰由 <code>n</code> 个节点组成且节点值从 <code>1</code> 到 <code>n</code> 互不相同的 <strong>二叉搜索树</strong> 有多少种？返回满足题意的二叉搜索树的种数。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/uniquebstn3.jpg" style="width: 600px; height: 148px;" />
<pre>
<strong>输入：</strong>n = 3
<strong>输出：</strong>5
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 1
<strong>输出：</strong>1
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= n <= 19</code></li>
</ul>


## 题解


### Java

```Java
// @Title: 不同的二叉搜索树 (Unique Binary Search Trees)
// @Author: robert.sunq
// @Date: 2021-06-09 22:39:14
// @Runtime: 0 ms
// @Memory: 35.3 MB

class Solution {

    int[] dp;
    public int numTrees(int n) {
        int res = 0;
        dp = new int[n+1];
        dp[0] = 1; 
        dp[1] = 1;
        for(int i = 1; i<=n ;i++){
            int temp = 0;
            for(int j = 0;j<i;j++){
                // 左子树节点数量 j  右子树 节点数量 i - j -1
                temp = temp + (dp[j] * dp[i-j-1]);
            }
            dp[i] = temp;
        }
        return dp[n];
    }

}
```



## 相关话题

- [树](https://leetcode.cn//tag/tree)
- [二叉搜索树](https://leetcode.cn//tag/binary-search-tree)
- [数学](https://leetcode.cn//tag/math)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)
- [二叉树](https://leetcode.cn//tag/binary-tree)

## 相似题目


- [不同的二叉搜索树 II](../unique-binary-search-trees-ii/README.md)
