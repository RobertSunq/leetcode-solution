
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 046. 二叉树的右侧视图](https://leetcode.cn//problems/WNC0Lk/)

## 题目描述

<p>给定一个二叉树的 <strong>根节点</strong> <code>root</code>，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2021/02/14/tree.jpg" style="width: 270px; " /></p>

<pre>
<strong>输入:</strong>&nbsp;[1,2,3,null,5,null,4]
<strong>输出:</strong>&nbsp;[1,3,4]
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong>&nbsp;[1,null,3]
<strong>输出:</strong>&nbsp;[1,3]
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入:</strong>&nbsp;[]
<strong>输出:</strong>&nbsp;[]
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li>二叉树的节点个数的范围是 <code>[0,100]</code></li>
	<li><meta charset="UTF-8" /><code>-100&nbsp;&lt;= Node.val &lt;= 100</code>&nbsp;</li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 199&nbsp;题相同：<a href="https://leetcode-cn.com/problems/binary-tree-right-side-view/">https://leetcode-cn.com/problems/binary-tree-right-side-view/</a></p>


## 题解


### Java

```Java
// @Title: 二叉树的右侧视图 (二叉树的右侧视图)
// @Author: robert.sunq
// @Date: 2023-07-05 21:42:18
// @Runtime: 1 ms
// @Memory: 40.2 MB

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
    public List<Integer> rightSideView(TreeNode root) {
        TreeNode left, right, p;
        Queue<TreeNode> q = new ArrayDeque<>();

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        q.offer(root);
        int size = 0;
        while (!q.isEmpty()) {
            size = q.size();
            result.add(q.peek().val);
            while (size-- > 0) {
                p = q.poll();
                // 先放右侧节点， 就是从右往左的广度遍历
                if (p.right != null) {
                    q.offer(p.right);
                }
                if (p.left != null) {
                    q.offer(p.left);
                }
            }
        }

        return result;
    }
}
```



## 相关话题

- [树](https://leetcode.cn//tag/tree)
- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [广度优先搜索](https://leetcode.cn//tag/breadth-first-search)
- [二叉树](https://leetcode.cn//tag/binary-tree)

## 相似题目



