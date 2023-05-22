
| [English](README_EN.md) | 简体中文 |

# [958. 二叉树的完全性检验](https://leetcode.cn//problems/check-completeness-of-a-binary-tree/)

## 题目描述

<p>给定一个二叉树的<meta charset="UTF-8" />&nbsp;<code>root</code>&nbsp;，确定它是否是一个&nbsp;<em>完全二叉树</em>&nbsp;。</p>

<p>在一个&nbsp;<strong><a href="https://baike.baidu.com/item/完全二叉树/7773232?fr=aladdin" target="_blank">完全二叉树</a></strong>&nbsp;中，除了最后一个关卡外，所有关卡都是完全被填满的，并且最后一个关卡中的所有节点都是尽可能靠左的。它可以包含<meta charset="UTF-8" />&nbsp;<code>1</code>&nbsp;到<meta charset="UTF-8" />&nbsp;<code>2<sup>h</sup></code>&nbsp;节点之间的最后一级 <code>h</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/15/complete-binary-tree-1.png" /></p>

<pre>
<strong>输入：</strong>root = [1,2,3,4,5,6]
<strong>输出：</strong>true
<strong>解释：</strong>最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
</pre>

<p><strong>示例 2：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/15/complete-binary-tree-2.png" /></strong></p>

<pre>
<strong>输入：</strong>root = [1,2,3,4,5,null,7]
<strong>输出：</strong>false
<strong>解释：</strong>值为 7 的结点没有尽可能靠向左侧。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>树的结点数在范围 <meta charset="UTF-8" />&nbsp;<code>[1, 100]</code>&nbsp;内。</li>
	<li><code>1 &lt;= Node.val &lt;= 1000</code></li>
</ul>


## 题解


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



## 相关话题

- [树](https://leetcode.cn//tag/tree)
- [广度优先搜索](https://leetcode.cn//tag/breadth-first-search)
- [二叉树](https://leetcode.cn//tag/binary-tree)

## 相似题目



