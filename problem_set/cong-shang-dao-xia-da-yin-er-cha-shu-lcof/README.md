
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 32 - I. 从上到下打印二叉树](https://leetcode.cn//problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/)

## 题目描述

<p>从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。</p>

<p>&nbsp;</p>

<p>例如:<br>
给定二叉树:&nbsp;<code>[3,9,20,null,null,15,7]</code>,</p>

<pre>    3
   / \
  9  20
    /  \
   15   7
</pre>

<p>返回：</p>

<pre>[3,9,20,15,7]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>节点总数 &lt;= 1000</code></li>
</ol>


## 题解


### Java

```Java
// @Title: 从上到下打印二叉树 (从上到下打印二叉树 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-27 21:22:12
// @Runtime: 1 ms
// @Memory: 38.8 MB

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
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        List<Integer> result = new ArrayList<>();
        TreeNode p = new TreeNode(0);
        while(!queue.isEmpty()){
            p = queue.poll();
            result.add(p.val);
            if(p.left != null) queue.offer(p.left);
            if(p.right != null) queue.offer(p.right);
        }
        int[] s = new int[result.size()];
        for (int i =0;i<result.size();i++){
            s[i] = result.get(i);
        }
        return s;
    }
}
```



## 相关话题

- [树](https://leetcode.cn//tag/tree)
- [广度优先搜索](https://leetcode.cn//tag/breadth-first-search)
- [二叉树](https://leetcode.cn//tag/binary-tree)

## 相似题目



