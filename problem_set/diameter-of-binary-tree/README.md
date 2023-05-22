
| [English](README_EN.md) | 简体中文 |

# [543. 二叉树的直径](https://leetcode.cn//problems/diameter-of-binary-tree/)

## 题目描述

<p>给你一棵二叉树的根节点，返回该树的 <strong>直径</strong> 。</p>

<p>二叉树的 <strong>直径</strong> 是指树中任意两个节点之间最长路径的 <strong>长度</strong> 。这条路径可能经过也可能不经过根节点 <code>root</code> 。</p>

<p>两节点之间路径的 <strong>长度</strong> 由它们之间边数表示。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/06/diamtree.jpg" style="width: 292px; height: 302px;" />
<pre>
<strong>输入：</strong>root = [1,2,3,4,5]
<strong>输出：</strong>3
<strong>解释：</strong>3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<strong>输入：</strong>root = [1,2]
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>树中节点数目在范围 <code>[1, 10<sup>4</sup>]</code> 内</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
</ul>


## 题解


### Java

```Java
// @Title: 二叉树的直径 (Diameter of Binary Tree)
// @Author: robert.sunq
// @Date: 2021-06-21 23:45:06
// @Runtime: 26 ms
// @Memory: 38.2 MB

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
    int deep = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        // recur(root);
        // return deep;

        //  这种方法的弊端是进行了多次重复计算，可以将子树的计算放入迭代中，将最大值设置为类变量即可
        // 左子树中的路径
        int left = diameterOfBinaryTree(root.left);
        // 右子树中的路径
        int right = diameterOfBinaryTree(root.right);
        // 和穿过根的路径最大值， 不加一，是因为路径，是节点数 -1
        return Math.max(recur(root.left) + recur(root.right) , Math.max(left,right)) ;
    }

    int recur(TreeNode root){
        if(root == null) return 0;
        // 左右子树中的最深度
        int left = recur(root.left);
        int right = recur(root.right);
        // deep 保存迭代中遇到的树的 最大路径
        deep = Math.max(deep,left+right);
        // 返回树的深度
        return Math.max(left, right) +1;
    }
}
```



## 相关话题

- [树](https://leetcode.cn//tag/tree)
- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [二叉树](https://leetcode.cn//tag/binary-tree)

## 相似题目



