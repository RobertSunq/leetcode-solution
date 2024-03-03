
| English | [简体中文](README.md) |

# [1372. Longest ZigZag Path in a Binary Tree](https://leetcode.cn//problems/longest-zigzag-path-in-a-binary-tree/)

## Description

<p>You are given the <code>root</code> of a binary tree.</p>

<p>A ZigZag path for a binary tree is defined as follow:</p>

<ul>
	<li>Choose <strong>any </strong>node in the binary tree and a direction (right or left).</li>
	<li>If the current direction is right, move to the right child of the current node; otherwise, move to the left child.</li>
	<li>Change the direction from right to left or from left to right.</li>
	<li>Repeat the second and third steps until you can&#39;t move in the tree.</li>
</ul>

<p>Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).</p>

<p>Return <em>the longest <strong>ZigZag</strong> path contained in that tree</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/01/22/sample_1_1702.png" style="width: 221px; height: 383px;" />
<pre>
<strong>Input:</strong> root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1]
<strong>Output:</strong> 3
<strong>Explanation:</strong> Longest ZigZag path in blue nodes (right -&gt; left -&gt; right).
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/01/22/sample_2_1702.png" style="width: 157px; height: 329px;" />
<pre>
<strong>Input:</strong> root = [1,1,1,null,1,null,null,1,1,null,1]
<strong>Output:</strong> 4
<strong>Explanation:</strong> Longest ZigZag path in blue nodes (left -&gt; right -&gt; left -&gt; right).
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> root = [1]
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[1, 5 * 10<sup>4</sup>]</code>.</li>
	<li><code>1 &lt;= Node.val &lt;= 100</code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 二叉树中的最长交错路径 (Longest ZigZag Path in a Binary Tree)
// @Author: robert.sunq
// @Date: 2023-09-05 22:48:54
// @Runtime: 6 ms
// @Memory: 51.9 MB

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ans = 0;
        ans = Math.max(ans, dfs(root.left, 1, true));
        ans = Math.max(ans, dfs(root.right, 1, false));

        return ans;
    }


    public int dfs(TreeNode root, int count, boolean isLeftChild) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        // 当前节点的交错长度，是上一个发下来的长度 + 1
        ans = Math.max(ans, count);

        // 是上一个左子树，则当前节点的下一个交错节点是当前的右
        if (isLeftChild) {
            ans = Math.max(ans, dfs(root.left, 1, true));
            ans = Math.max(ans, dfs(root.right, count + 1, false));
        } else {
            ans = Math.max(ans, dfs(root.left, count + 1, true));
            ans = Math.max(ans, dfs(root.right, 1, false));
        }

        return ans;
    }
}
```



## Related Topics

- [Tree](https://leetcode.cn//tag/tree)
- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)
- [Binary Tree](https://leetcode.cn//tag/binary-tree)

## Similar Questions


