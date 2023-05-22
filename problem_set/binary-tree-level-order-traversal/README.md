
| [English](README_EN.md) | 简体中文 |

# [102. 二叉树的层序遍历](https://leetcode.cn//problems/binary-tree-level-order-traversal/)

## 题目描述

<p>给你二叉树的根节点 <code>root</code> ，返回其节点值的 <strong>层序遍历</strong> 。 （即逐层地，从左到右访问所有节点）。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/tree1.jpg" style="width: 277px; height: 302px;" />
<pre>
<strong>输入：</strong>root = [3,9,20,null,null,15,7]
<strong>输出：</strong>[[3],[9,20],[15,7]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>root = [1]
<strong>输出：</strong>[[1]]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>root = []
<strong>输出：</strong>[]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>树中节点数目在范围 <code>[0, 2000]</code> 内</li>
	<li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
</ul>


## 题解


### Java

```Java
// @Title: 二叉树的层序遍历 (Binary Tree Level Order Traversal)
// @Author: robert.sunq
// @Date: 2021-06-14 23:25:23
// @Runtime: 2 ms
// @Memory: 38.3 MB

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        List<Integer> temp;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        int n = 0;
        while(!qu.isEmpty()){
            n = qu.size();
            temp = new ArrayList<>();
            while(n>0){
                n--;
                TreeNode t = qu.poll();
                temp.add(t.val);
                if(t.left != null) qu.offer(t.left);
                if(t.right != null) qu.offer(t.right);
            }
            res.add(temp);
        }
        return res;
    }
}
```



## 相关话题

- [树](https://leetcode.cn//tag/tree)
- [广度优先搜索](https://leetcode.cn//tag/breadth-first-search)
- [二叉树](https://leetcode.cn//tag/binary-tree)

## 相似题目


- [二叉树的锯齿形层序遍历](../binary-tree-zigzag-level-order-traversal/README.md)
- [二叉树的层序遍历 II](../binary-tree-level-order-traversal-ii/README.md)
- [二叉树的最小深度](../minimum-depth-of-binary-tree/README.md)
- [二叉树的垂直遍历](../binary-tree-vertical-order-traversal/README.md)
- [二叉树的层平均值](../average-of-levels-in-binary-tree/README.md)
- [N 叉树的层序遍历](../n-ary-tree-level-order-traversal/README.md)
- [二叉树的堂兄弟节点](../cousins-in-binary-tree/README.md)
