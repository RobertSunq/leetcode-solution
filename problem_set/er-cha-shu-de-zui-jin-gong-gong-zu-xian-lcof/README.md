
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 68 - II. 二叉树的最近公共祖先](https://leetcode.cn//problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/)

## 题目描述

<p>给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。</p>

<p><a href="https://baike.baidu.com/item/%E6%9C%80%E8%BF%91%E5%85%AC%E5%85%B1%E7%A5%96%E5%85%88/8918834?fr=aladdin" target="_blank">百度百科</a>中最近公共祖先的定义为：&ldquo;对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（<strong>一个节点也可以是它自己的祖先</strong>）。&rdquo;</p>

<p>例如，给定如下二叉树:&nbsp; root =&nbsp;[3,5,1,6,2,0,8,null,null,7,4]</p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/15/binarytree.png"></p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
<strong>输出:</strong> 3
<strong>解释: </strong>节点 <code>5 </code>和节点 <code>1 </code>的最近公共祖先是节点 <code>3。</code>
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入:</strong> root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
<strong>输出:</strong> 5
<strong>解释: </strong>节点 <code>5 </code>和节点 <code>4 </code>的最近公共祖先是节点 <code>5。</code>因为根据定义最近公共祖先节点可以为节点本身。
</pre>

<p>&nbsp;</p>

<p><strong>说明:</strong></p>

<ul>
	<li>所有节点的值都是唯一的。</li>
	<li>p、q 为不同节点且均存在于给定的二叉树中。</li>
</ul>

<p>注意：本题与主站 236 题相同：<a href="https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/">https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/</a></p>


## 题解


### Java

```Java
// @Title: 二叉树的最近公共祖先 (二叉树的最近公共祖先 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-31 23:05:31
// @Runtime: 8 ms
// @Memory: 39.7 MB

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果root为空返回空。
        if (root == null) return null;
        // 如果等于根 则表示找到一个节点的祖先
        if (root.val == p.val || root.val == q.val) return root;
        // 否则在子树中进行查找

        // 后序遍历，即最后访问根节点
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        // 如果 左右中均不存在，则证明两节点不在该子树中
        if(right == null && left == null) return null;
        // 如果同时不为空则证明在左右子树中
        if(right != null && left != null) return root;
        // 如果左子树返回为空,右不为空，则证明在其中一点在左子树中，或者返回的时两棵树的最进父节点
        if(left == null) return right;
        // 右子树返回同理
        return left;
    }
}
```



## 相关话题

- [树](https://leetcode.cn//tag/tree)
- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [二叉树](https://leetcode.cn//tag/binary-tree)

## 相似题目



