
| English | [简体中文](README.md) |

# [105. Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.cn//problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

## Description

<p>Given two integer arrays <code>preorder</code> and <code>inorder</code> where <code>preorder</code> is the preorder traversal of a binary tree and <code>inorder</code> is the inorder traversal of the same tree, construct and return <em>the binary tree</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/tree.jpg" style="width: 277px; height: 302px;" />
<pre>
<strong>Input:</strong> preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
<strong>Output:</strong> [3,9,20,null,null,15,7]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> preorder = [-1], inorder = [-1]
<strong>Output:</strong> [-1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= preorder.length &lt;= 3000</code></li>
	<li><code>inorder.length == preorder.length</code></li>
	<li><code>-3000 &lt;= preorder[i], inorder[i] &lt;= 3000</code></li>
	<li><code>preorder</code> and <code>inorder</code> consist of <strong>unique</strong> values.</li>
	<li>Each value of <code>inorder</code> also appears in <code>preorder</code>.</li>
	<li><code>preorder</code> is <strong>guaranteed</strong> to be the preorder traversal of the tree.</li>
	<li><code>inorder</code> is <strong>guaranteed</strong> to be the inorder traversal of the tree.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 从前序与中序遍历序列构造二叉树 (Construct Binary Tree from Preorder and Inorder Traversal)
// @Author: robert.sunq
// @Date: 2021-06-14 23:58:26
// @Runtime: 3 ms
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

    Map<Integer,Integer> mp = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode();
        if(preorder.length <=0) return null;
        // 创造数值与坐标的映射关系，因为不存在相同元素，若存在可以在迭代中查找
        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        return recur(preorder,inorder,0,0,inorder.length-1);

    }

    /**
    * rootIndex   中序遍历中 根节点位置
    * inorStart   前序遍历中 当前子树起点
    * inorEnd     前序遍历中 前端子树终点
     */
    TreeNode recur(int[] preorder,int[] inorder, int rootIndex,int inorStart,int inorEnd){
        if(rootIndex >= preorder.length || inorStart > inorEnd) return null;
        // 当前的根节点
        TreeNode root = new TreeNode(preorder[rootIndex]);
        // 前序中根节点 在中序中的位置
        int inorIndex = mp.get(preorder[rootIndex]);
        // 左子树
        root.left = recur(preorder,inorder,rootIndex+1,inorStart,inorIndex-1);
        // 右子树
        root.right = recur(preorder,inorder,rootIndex+(inorIndex-inorStart)+1 , inorIndex+1,inorEnd);

        return root;
    }
}
```



## Related Topics

- [Tree](https://leetcode.cn//tag/tree)
- [Array](https://leetcode.cn//tag/array)
- [Hash Table](https://leetcode.cn//tag/hash-table)
- [Divide and Conquer](https://leetcode.cn//tag/divide-and-conquer)
- [Binary Tree](https://leetcode.cn//tag/binary-tree)

## Similar Questions

- [Construct Binary Tree from Inorder and Postorder Traversal](../construct-binary-tree-from-inorder-and-postorder-traversal/README_EN.md)
