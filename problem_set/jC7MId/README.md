
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 051. 节点之和最大的路径](https://leetcode.cn//problems/jC7MId/)

## 题目描述

<p><strong>路径</strong> 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 <strong>至多出现一次</strong> 。该路径<strong> 至少包含一个 </strong>节点，且不一定经过根节点。</p>

<p><strong>路径和</strong> 是路径中各节点值的总和。</p>

<p>给定一个二叉树的根节点 <code>root</code> ，返回其 <strong>最大路径和</strong>，即所有路径上节点值之和的最大值。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/10/13/exx1.jpg" style="width: 322px; height: 182px;" /></p>

<pre>
<strong>输入：</strong>root = [1,2,3]
<strong>输出：</strong>6
<strong>解释：</strong>最优路径是 2 -&gt; 1 -&gt; 3 ，路径和为 2 + 1 + 3 = 6</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/10/13/exx2.jpg" /></p>

<pre>
<strong>输入：</strong>root = [-10,9,20,null,null,15,7]
<strong>输出：</strong>42
<strong>解释：</strong>最优路径是 15 -&gt; 20 -&gt; 7 ，路径和为 15 + 20 + 7 = 42
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>树中节点数目范围是 <code>[1, 3 * 10<sup>4</sup>]</code></li>
	<li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 124&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/">https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/</a></p>


## 题解


### Java

```Java
// @Title: 节点之和最大的路径 (节点之和最大的路径)
// @Author: robert.sunq
// @Date: 2023-07-09 22:30:39
// @Runtime: 1 ms
// @Memory: 42 MB

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

    // 记录和
    private int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return sum;
    }


    // 返回以当前节点  包含当前节点的  包含左右子树中一棵或者都不包含的最大值
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 遍历左子树，返回其单支最大值
        int left = dfs(root.left);
        // 遍历右子树， 返回其单只最大值
        int right = dfs(root.right);

        // 当前树中的最大路径和
        // 左右子树已经计算过最大值了，不用单独计算

        // 包含根节点和左右子树的最大值
        sum = Math.max(sum, left + right + root.val);
        // 左边树最大值
        sum = Math.max(sum, left + root.val);
        // 右边树最大值
        sum = Math.max(sum, right + root.val);
        // 或者只有当前节点
        sum = Math.max(sum, root.val);

        int rightSum = right + root.val;
        int leftSum = left + root.val;

        // 根节点的值 大于 从根节点到左右树某节点的最大值，则返回根节点值，为当前树的单支最大值
        if (root.val >= rightSum && root.val >= leftSum) {
            return root.val;
        }
        // 否则，返回包含根节点的左右子树之一
        return Math.max(rightSum, leftSum);
    }
}
```



## 相关话题

- [树](https://leetcode.cn//tag/tree)
- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)
- [二叉树](https://leetcode.cn//tag/binary-tree)

## 相似题目



