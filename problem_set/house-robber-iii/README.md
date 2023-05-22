
| [English](README_EN.md) | 简体中文 |

# [337. 打家劫舍 III](https://leetcode.cn//problems/house-robber-iii/)

## 题目描述

<p>小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为<meta charset="UTF-8" />&nbsp;<code>root</code>&nbsp;。</p>

<p>除了<meta charset="UTF-8" />&nbsp;<code>root</code>&nbsp;之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 <strong>两个直接相连的房子在同一天晚上被打劫</strong> ，房屋将自动报警。</p>

<p>给定二叉树的&nbsp;<code>root</code>&nbsp;。返回&nbsp;<em><strong>在不触动警报的情况下</strong>&nbsp;，小偷能够盗取的最高金额</em>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/03/10/rob1-tree.jpg" /></p>

<pre>
<strong>输入: </strong>root = [3,2,3,null,3,null,1]
<strong>输出:</strong> 7 
<strong>解释:</strong>&nbsp;小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7</pre>

<p><strong>示例 2:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/03/10/rob2-tree.jpg" /></p>

<pre>
<strong>输入: </strong>root = [3,4,5,1,3,null,1]
<strong>输出:</strong> 9
<strong>解释:</strong>&nbsp;小偷一晚能够盗取的最高金额 4 + 5 = 9
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<p><meta charset="UTF-8" /></p>

<ul>
	<li>树的节点数在&nbsp;<code>[1, 10<sup>4</sup>]</code> 范围内</li>
	<li><code>0 &lt;= Node.val &lt;= 10<sup>4</sup></code></li>
</ul>


## 题解


### Java

```Java
// @Title: 打家劫舍 III (House Robber III)
// @Author: robert.sunq
// @Date: 2021-06-20 00:02:32
// @Runtime: 0 ms
// @Memory: 37.8 MB

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
    public int rob(TreeNode root) {
        int[] res = recur(root);
        return Math.max(res[0],res[1]);
    }

    // [0] 当前节点不偷
    // [1] 当前节点偷
    int[] recur(TreeNode root){
        if(root == null) return new int[2];

        // 左右节点偷到的数值
        int[] left = recur(root.left);
        int[] right = recur(root.right);

        int[] res = new int[2];
        // 当前节点选择不偷的时候
        // 即 左右偷的最大值 要大于当前节点 (下一个节点偷不偷均无影响，所以是其中的最大值)
        res[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        // 偷当前节点的时候
        // 当前的金额 加上  左右子树中 不偷盗的金额
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}
```



## 相关话题

- [树](https://leetcode.cn//tag/tree)
- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)
- [二叉树](https://leetcode.cn//tag/binary-tree)

## 相似题目


- [打家劫舍](../house-robber/README.md)
- [打家劫舍 II](../house-robber-ii/README.md)
