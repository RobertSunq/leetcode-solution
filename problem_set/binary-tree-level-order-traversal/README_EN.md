
| English | [简体中文](README.md) |

# [102. Binary Tree Level Order Traversal](https://leetcode.cn//problems/binary-tree-level-order-traversal/)

## Description

<p>Given the <code>root</code> of a binary tree, return <em>the level order traversal of its nodes&#39; values</em>. (i.e., from left to right, level by level).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/tree1.jpg" style="width: 277px; height: 302px;" />
<pre>
<strong>Input:</strong> root = [3,9,20,null,null,15,7]
<strong>Output:</strong> [[3],[9,20],[15,7]]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = [1]
<strong>Output:</strong> [[1]]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> root = []
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[0, 2000]</code>.</li>
	<li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
</ul>


## Solutions


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



## Related Topics

- [Tree](https://leetcode.cn//tag/tree)
- [Breadth-First Search](https://leetcode.cn//tag/breadth-first-search)
- [Binary Tree](https://leetcode.cn//tag/binary-tree)

## Similar Questions

- [Binary Tree Zigzag Level Order Traversal](../binary-tree-zigzag-level-order-traversal/README_EN.md)
- [Binary Tree Level Order Traversal II](../binary-tree-level-order-traversal-ii/README_EN.md)
- [Minimum Depth of Binary Tree](../minimum-depth-of-binary-tree/README_EN.md)
- [Binary Tree Vertical Order Traversal](../binary-tree-vertical-order-traversal/README_EN.md)
- [Average of Levels in Binary Tree](../average-of-levels-in-binary-tree/README_EN.md)
- [N-ary Tree Level Order Traversal](../n-ary-tree-level-order-traversal/README_EN.md)
- [Cousins in Binary Tree](../cousins-in-binary-tree/README_EN.md)
