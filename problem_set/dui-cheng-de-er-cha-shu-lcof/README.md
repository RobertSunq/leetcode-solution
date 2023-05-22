
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 28. 对称的二叉树](https://leetcode.cn//problems/dui-cheng-de-er-cha-shu-lcof/)

## 题目描述

<p>请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。</p>

<p>例如，二叉树&nbsp;[1,2,2,3,4,4,3] 是对称的。</p>

<p><code>&nbsp; &nbsp; 1<br>
&nbsp; &nbsp;/ \<br>
&nbsp; 2 &nbsp; 2<br>
&nbsp;/ \ / \<br>
3 &nbsp;4 4 &nbsp;3</code><br>
但是下面这个&nbsp;[1,2,2,null,3,null,3] 则不是镜像对称的:</p>

<p><code>&nbsp; &nbsp; 1<br>
&nbsp; &nbsp;/ \<br>
&nbsp; 2 &nbsp; 2<br>
&nbsp; &nbsp;\ &nbsp; \<br>
&nbsp; &nbsp;3 &nbsp; &nbsp;3</code></p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>root = [1,2,2,3,4,4,3]
<strong>输出：</strong>true
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>root = [1,2,2,null,3,null,3]
<strong>输出：</strong>false</pre>

<p>&nbsp;</p>

<p><strong>限制：</strong></p>

<p><code>0 &lt;= 节点个数 &lt;= 1000</code></p>

<p>注意：本题与主站 101 题相同：<a href="https://leetcode-cn.com/problems/symmetric-tree/">https://leetcode-cn.com/problems/symmetric-tree/</a></p>


## 题解


### Java

```Java
// @Title: 对称的二叉树 (对称的二叉树  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-26 23:32:17
// @Runtime: 0 ms
// @Memory: 36.6 MB

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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        // 左子树 右子树进行对比
        return recur(root.left,root.right);
    }
    boolean recur(TreeNode r1,TreeNode r2){
        if(r1 == null && r2 == null) return true;
        if(r1 == null || r2 == null) return false;
        if(r1.val == r2.val){
            // 两棵树的 左子树和右子树 交叉对比
            return recur(r1.left,r2.right) && recur(r1.right,r2.left);
        }else{
            return false;
        }
    }
}
```



## 相关话题

- [树](https://leetcode.cn//tag/tree)
- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [广度优先搜索](https://leetcode.cn//tag/breadth-first-search)
- [二叉树](https://leetcode.cn//tag/binary-tree)

## 相似题目



