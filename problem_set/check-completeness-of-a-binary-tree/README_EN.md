
| English | [简体中文](README.md) |

# [958. Check Completeness of a Binary Tree](https://leetcode.cn//problems/check-completeness-of-a-binary-tree/)

## Description

<p>Given the <code>root</code> of a binary tree, determine if it is a <em>complete binary tree</em>.</p>

<p>In a <strong><a href="http://en.wikipedia.org/wiki/Binary_tree#Types_of_binary_trees" target="_blank">complete binary tree</a></strong>, every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between <code>1</code> and <code>2<sup>h</sup></code> nodes inclusive at the last level <code>h</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/15/complete-binary-tree-1.png" style="width: 180px; height: 145px;" />
<pre>
<strong>Input:</strong> root = [1,2,3,4,5,6]
<strong>Output:</strong> true
<strong>Explanation:</strong> Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/15/complete-binary-tree-2.png" style="width: 200px; height: 145px;" />
<pre>
<strong>Input:</strong> root = [1,2,3,4,5,null,7]
<strong>Output:</strong> false
<strong>Explanation:</strong> The node with value 7 isn&#39;t as far left as possible.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[1, 100]</code>.</li>
	<li><code>1 &lt;= Node.val &lt;= 1000</code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 二叉树的完全性检验 (Check Completeness of a Binary Tree)
// @Author: robert.sunq
// @Date: 2021-07-11 22:59:56
// @Runtime: 1 ms
// @Memory: 37.5 MB

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
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) return true;
        // 表示未出现空
        boolean flag = true;
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.offer(root);
        while(!qu.isEmpty()){
            // 第一个子节点为空后，后面不能再出现子节点
            TreeNode temp = qu.poll();
            if(temp.left== null){
                flag = false;
            }else{
                // 如果前面已经出现了空，则后面的节点存在子，则肯定不为完全
                if(flag){
                    qu.offer(temp.left);
                }else{
                    return false;
                }
            }
            if(temp.right == null){
                flag = false;
            }else{
               // 如果前面已经出现了空，则后面的节点存在子，则肯定不为完全
               if(flag){
                   qu.offer(temp.right);
               }else{
                   return false;
               }
            }
        }
        return true;
    }
}
```



## Related Topics

- [Tree](https://leetcode.cn//tag/tree)
- [Breadth-First Search](https://leetcode.cn//tag/breadth-first-search)
- [Binary Tree](https://leetcode.cn//tag/binary-tree)

## Similar Questions


