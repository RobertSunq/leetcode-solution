
| English | [简体中文](README.md) |

# [96. Unique Binary Search Trees](https://leetcode.cn//problems/unique-binary-search-trees/)

## Description

<p>Given an integer <code>n</code>, return <em>the number of structurally unique <strong>BST&#39;</strong>s (binary search trees) which has exactly </em><code>n</code><em> nodes of unique values from</em> <code>1</code> <em>to</em> <code>n</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/uniquebstn3.jpg" style="width: 600px; height: 148px;" />
<pre>
<strong>Input:</strong> n = 3
<strong>Output:</strong> 5
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 1
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 19</code></li>
</ul>


## Solutions


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



## Related Topics

- [Tree](https://leetcode.cn//tag/tree)
- [Binary Search Tree](https://leetcode.cn//tag/binary-search-tree)
- [Math](https://leetcode.cn//tag/math)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)
- [Binary Tree](https://leetcode.cn//tag/binary-tree)

## Similar Questions

- [Unique Binary Search Trees II](../unique-binary-search-trees-ii/README_EN.md)
