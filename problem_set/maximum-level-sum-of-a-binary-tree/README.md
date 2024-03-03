
| [English](README_EN.md) | 简体中文 |

# [1161. 最大层内元素和](https://leetcode.cn//problems/maximum-level-sum-of-a-binary-tree/)

## 题目描述

<p>给你一个二叉树的根节点&nbsp;<code>root</code>。设根节点位于二叉树的第 <code>1</code> 层，而根节点的子节点位于第 <code>2</code> 层，依此类推。</p>

<p>请返回层内元素之和 <strong>最大</strong> 的那几层（可能只有一层）的层号，并返回其中&nbsp;<strong>最小</strong> 的那个。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/08/17/capture.jpeg" style="height: 175px; width: 200px;" /></strong></p>

<pre>
<strong>输入：</strong>root = [1,7,0,7,-8,null,null]
<strong>输出：</strong>2
<strong>解释：</strong>
第 1 层各元素之和为 1，
第 2 层各元素之和为 7 + 0 = 7，
第 3 层各元素之和为 7 + -8 = -1，
所以我们返回第 2 层的层号，它的层内元素之和最大。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>root = [989,null,10250,98693,-89388,null,null,null,-32127]
<strong>输出：</strong>2
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>树中的节点数在<meta charset="UTF-8" />&nbsp;<code>[1, 10<sup>4</sup>]</code>范围内<meta charset="UTF-8" /></li>
	<li><code>-10<sup>5</sup>&nbsp;&lt;= Node.val &lt;= 10<sup>5</sup></code></li>
</ul>


## 题解


### Java

```Java
// @Title: 最大层内元素和 (Maximum Level Sum of a Binary Tree)
// @Author: robert.sunq
// @Date: 2023-09-06 21:52:27
// @Runtime: 9 ms
// @Memory: 45.1 MB

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
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int layout = 1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int ans = 0;
        long max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int i = queue.size();
            long tmp = 0;
            while (i-->0) {
                TreeNode p = queue.poll();
                tmp = tmp + p.val;
                if (p.left != null) {
                    queue.add(p.left);
                }
                if (p.right != null) {
                    queue.add(p.right);
                }
            }

            if (tmp > max) {
                ans = layout;
                max = tmp;
            }
            layout++;
        }

        return ans;
    }
}
```



## 相关话题

- [树](https://leetcode.cn//tag/tree)
- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [广度优先搜索](https://leetcode.cn//tag/breadth-first-search)
- [二叉树](https://leetcode.cn//tag/binary-tree)

## 相似题目



