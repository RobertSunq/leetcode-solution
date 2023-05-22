
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 54. 二叉搜索树的第k大节点](https://leetcode.cn//problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/)

## 题目描述

<p>给定一棵二叉搜索树，请找出其中第 <code>k</code> 大的节点的值。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
&nbsp;  2
<strong>输出:</strong> 4</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
<strong>输出:</strong> 4</pre>

<p>&nbsp;</p>

<p><strong>限制：</strong></p>

<ul>
	<li>1 ≤ k ≤ 二叉搜索树元素个数</li>
</ul>


## 题解


### Java

```Java
// @Title: 二叉搜索树的第k大节点 (二叉搜索树的第k大节点  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 17:31:51
// @Runtime: 1 ms
// @Memory: 38.3 MB

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int kthLargest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        if (root == null) return -1;
        TreeNode p = root;
        while(p!=null || !st.isEmpty()){
            while(p != null){
                st.push(p);
                p = p.right;
            }
            if(!st.isEmpty()){
                p = st.pop();
                k--;
                if(k == 0){
                    return p.val;
                }
                p = p.left;
            }
        }
        return -1;
    }
}
```



## 相关话题

- [树](https://leetcode.cn//tag/tree)
- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [二叉搜索树](https://leetcode.cn//tag/binary-search-tree)
- [二叉树](https://leetcode.cn//tag/binary-tree)

## 相似题目



