
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 26. 树的子结构](https://leetcode.cn//problems/shu-de-zi-jie-gou-lcof/)

## 题目描述

<p>输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)</p>

<p>B是A的子结构， 即 A中有出现和B相同的结构和节点值。</p>

<p>例如:<br>
给定的树 A:</p>

<p><code>&nbsp; &nbsp; &nbsp;3<br>
&nbsp; &nbsp; / \<br>
&nbsp; &nbsp;4 &nbsp; 5<br>
&nbsp; / \<br>
&nbsp;1 &nbsp; 2</code><br>
给定的树 B：</p>

<p><code>&nbsp; &nbsp;4&nbsp;<br>
&nbsp; /<br>
&nbsp;1</code><br>
返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>A = [1,2,3], B = [3,1]
<strong>输出：</strong>false
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>A = [3,4,5,1,2], B = [4,1]
<strong>输出：</strong>true</pre>

<p><strong>限制：</strong></p>

<p><code>0 &lt;= 节点个数 &lt;= 10000</code></p>


## 题解


### Java

```Java
// @Title: 树的子结构 (树的子结构  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-26 23:12:06
// @Runtime: 5 ms
// @Memory: 40.2 MB

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
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) return false;
        LinkedList<TreeNode> st = new LinkedList<>();
        TreeNode p = A;
        // 根节点入栈
        st.addLast(A);
        while (!st.isEmpty()){
            p = st.removeLast();
            if(p.val == B.val){
                if(isEqualsTree(p,B)){
                    return true;
                }
            }
            if(p.right != null) st.addLast(p.right);
            if(p.left != null) st.addLast(p.left);
        }
        return false;
    }

    boolean isEqualsTree(TreeNode A, TreeNode B){
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        // 比较左右子树
        return isEqualsTree(A.left,B.left) && isEqualsTree(A.right,B.right);
    }
}
```



## 相关话题

- [树](https://leetcode.cn//tag/tree)
- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [二叉树](https://leetcode.cn//tag/binary-tree)

## 相似题目



