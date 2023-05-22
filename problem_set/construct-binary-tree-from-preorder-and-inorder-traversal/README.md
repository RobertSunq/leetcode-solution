
| [English](README_EN.md) | 简体中文 |

# [105. 从前序与中序遍历序列构造二叉树](https://leetcode.cn//problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

## 题目描述

<p>给定两个整数数组&nbsp;<code>preorder</code> 和 <code>inorder</code>&nbsp;，其中&nbsp;<code>preorder</code> 是二叉树的<strong>先序遍历</strong>， <code>inorder</code>&nbsp;是同一棵树的<strong>中序遍历</strong>，请构造二叉树并返回其根节点。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/tree.jpg" style="height: 302px; width: 277px;" />
<pre>
<strong>输入</strong><strong>:</strong> preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
<strong>输出:</strong> [3,9,20,null,null,15,7]
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> preorder = [-1], inorder = [-1]
<strong>输出:</strong> [-1]
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>1 &lt;= preorder.length &lt;= 3000</code></li>
	<li><code>inorder.length == preorder.length</code></li>
	<li><code>-3000 &lt;= preorder[i], inorder[i] &lt;= 3000</code></li>
	<li><code>preorder</code>&nbsp;和&nbsp;<code>inorder</code>&nbsp;均 <strong>无重复</strong> 元素</li>
	<li><code>inorder</code>&nbsp;均出现在&nbsp;<code>preorder</code></li>
	<li><code>preorder</code>&nbsp;<strong>保证</strong> 为二叉树的前序遍历序列</li>
	<li><code>inorder</code>&nbsp;<strong>保证</strong> 为二叉树的中序遍历序列</li>
</ul>


## 题解


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



## 相关话题

- [树](https://leetcode.cn//tag/tree)
- [数组](https://leetcode.cn//tag/array)
- [哈希表](https://leetcode.cn//tag/hash-table)
- [分治](https://leetcode.cn//tag/divide-and-conquer)
- [二叉树](https://leetcode.cn//tag/binary-tree)

## 相似题目


- [从中序与后序遍历序列构造二叉树](../construct-binary-tree-from-inorder-and-postorder-traversal/README.md)
