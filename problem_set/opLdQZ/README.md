
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 056. 二叉搜索树中两个节点之和](https://leetcode.cn//problems/opLdQZ/)

## 题目描述

<p>给定一个二叉搜索树的 <strong>根节点</strong> <code>root</code>&nbsp;和一个整数 <code>k</code> , 请判断该二叉搜索树中是否存在两个节点它们的值之和等于 <code>k</code> 。假设二叉搜索树中节点的值均唯一。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入: </strong>root =<strong> </strong>[8,6,10,5,7,9,11], k = 12
<strong>输出: </strong>true
<strong>解释: </strong>节点 5 和节点 7 之和等于 12
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入: </strong>root =<strong> </strong>[8,6,10,5,7,9,11], k = 22
<strong>输出: </strong>false
<strong>解释: </strong>不存在两个节点值之和为 22 的节点
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>二叉树的节点个数的范围是&nbsp;&nbsp;<code>[1, 10<sup>4</sup>]</code>.</li>
	<li><code>-10<sup>4</sup>&nbsp;&lt;= Node.val &lt;= 10<sup>4</sup></code></li>
	<li><code>root</code>&nbsp;为二叉搜索树</li>
	<li><code>-10<sup>5</sup>&nbsp;&lt;= k &lt;= 10<sup>5</sup></code></li>
</ul>

<p>&nbsp;</p>

<p>注意：本题与主站 653 题相同：&nbsp;<a href="https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/">https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/</a></p>


## 题解


### Java

```Java
// @Title: 二叉搜索树中两个节点之和 (二叉搜索树中两个节点之和)
// @Author: robert.sunq
// @Date: 2023-07-10 23:22:18
// @Runtime: 7 ms
// @Memory: 42.6 MB

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
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        List<Integer> list = new ArrayList<>();

        TreeNode cur = root;
        Stack<TreeNode> st = new Stack<>();
        while (cur != null || !st.isEmpty()) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        int i = 0;
        int j = list.size() - 1;
        int tmp;
        while (i < j) {
            tmp = list.get(i) + list.get(j);
            if (tmp == k) {
                return true;
            } else if (tmp > k) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
```



## 相关话题

- [树](https://leetcode.cn//tag/tree)
- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [广度优先搜索](https://leetcode.cn//tag/breadth-first-search)
- [二叉搜索树](https://leetcode.cn//tag/binary-search-tree)
- [哈希表](https://leetcode.cn//tag/hash-table)
- [双指针](https://leetcode.cn//tag/two-pointers)
- [二叉树](https://leetcode.cn//tag/binary-tree)

## 相似题目



