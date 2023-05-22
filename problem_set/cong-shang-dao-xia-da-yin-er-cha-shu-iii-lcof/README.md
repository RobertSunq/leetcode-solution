
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 32 - III. 从上到下打印二叉树 III](https://leetcode.cn//problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/)

## 题目描述

<p>请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。</p>

<p>&nbsp;</p>

<p>例如:<br>
给定二叉树:&nbsp;<code>[3,9,20,null,null,15,7]</code>,</p>

<pre>    3
   / \
  9  20
    /  \
   15   7
</pre>

<p>返回其层次遍历结果：</p>

<pre>[
  [3],
  [20,9],
  [15,7]
]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>节点总数 &lt;= 1000</code></li>
</ol>


## 题解


### Java

```Java
// @Title: 从上到下打印二叉树 III (从上到下打印二叉树 III LCOF)
// @Author: robert.sunq
// @Date: 2021-05-27 22:05:55
// @Runtime: 2 ms
// @Memory: 38.9 MB

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> qu = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null ) return res;
        qu.add(root);
        // 用于标记打印方向， false为由左到右
        boolean  flag  = false;
        while(!qu.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for(int i = qu.size(); i > 0; i--) {
                TreeNode node;
                node = qu.remove();
                temp.add(node.val);
                // 使得放入的顺序与下一行要访问的顺序相反。
                // 有右往左打印， 先放入右节点
                if(flag){
                    if(node.right != null) qu.add(node.right);                      
                    if(node.left != null) qu.add(node.left);
                }else{
                    // 由左到右，先放入左节点
                    if(node.left != null) qu.add(node.left);
                    if(node.right != null) qu.add(node.right);
                }
            }
            flag ^= true;
            res.add(temp);
            // 反转列表
            LinkedList<TreeNode> qu_temp = new LinkedList<>();
            for(TreeNode t:qu){
                qu_temp.addFirst(t);
            }
            qu = qu_temp;
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



