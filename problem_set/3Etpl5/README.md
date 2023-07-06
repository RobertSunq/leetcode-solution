
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 049. 从根节点到叶节点的路径数字之和](https://leetcode.cn//problems/3Etpl5/)

## 题目描述

<p>给定一个二叉树的根节点 <code>root</code> ，树中每个节点都存放有一个 <code>0</code> 到 <code>9</code> 之间的数字。</p>

<div class="original__bRMd">
<div>
<p>每条从根节点到叶节点的路径都代表一个数字：</p>

<ul>
	<li>例如，从根节点到叶节点的路径 <code>1 -&gt; 2 -&gt; 3</code> 表示数字 <code>123</code> 。</li>
</ul>

<p>计算从根节点到叶节点生成的 <strong>所有数字之和</strong> 。</p>

<p><strong>叶节点</strong> 是指没有子节点的节点。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/num1tree.jpg" style="width: 212px; height: 182px;" />
<pre>
<strong>输入：</strong>root = [1,2,3]
<strong>输出：</strong>25
<strong>解释：</strong>
从根到叶子节点路径 <code>1-&gt;2</code> 代表数字 <code>12</code>
从根到叶子节点路径 <code>1-&gt;3</code> 代表数字 <code>13</code>
因此，数字总和 = 12 + 13 = <code>25</code></pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/num2tree.jpg" style="width: 292px; height: 302px;" />
<pre>
<strong>输入：</strong>root = [4,9,0,5,1]
<strong>输出：</strong>1026
<strong>解释：</strong>
从根到叶子节点路径 <code>4-&gt;9-&gt;5</code> 代表数字 495
从根到叶子节点路径 <code>4-&gt;9-&gt;1</code> 代表数字 491
从根到叶子节点路径 <code>4-&gt;0</code> 代表数字 40
因此，数字总和 = 495 + 491 + 40 = <code>1026</code>
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>树中节点的数目在范围 <code>[1, 1000]</code> 内</li>
	<li><code>0 &lt;= Node.val &lt;= 9</code></li>
	<li>树的深度不超过 <code>10</code></li>
</ul>
</div>
</div>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 129&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/">https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/</a></p>


## 题解


### Java

```Java
// @Title: 从根节点到叶节点的路径数字之和 (从根节点到叶节点的路径数字之和)
// @Author: robert.sunq
// @Date: 2023-07-06 22:37:45
// @Runtime: 0 ms
// @Memory: 38.9 MB

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

    int number = 0;
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return sum;
        }

        // 注意，当为叶子节点的时候，就可以求和了
        // 当前叶子节点没有放入列表
        if (root.left == null && root.right == null) {
            sum = sum + number * 10 + root.val;
            return sum;
        }

        // 非叶子节点，放入列表投入计算
        number = number * 10 + root.val;

        // 如果左子树不为空，则取dfs 左子树, 因为叶子节点不会放入缓存列表，所以不用担心节点上的数值被多次计算 
        if (root.left != null) {
            sumNumbers(root.left);
        }
        if (root.right != null) {
            sumNumbers(root.right);
        }

        // 左右子树递归完成， 要删除数值最后一位，就是从缓存中删除当前节点
        number = number / 10;
        return sum;
    }
}
```



## 相关话题

- [树](https://leetcode.cn//tag/tree)
- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [二叉树](https://leetcode.cn//tag/binary-tree)

## 相似题目



