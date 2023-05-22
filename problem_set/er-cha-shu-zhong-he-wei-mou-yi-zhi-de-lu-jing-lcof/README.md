
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 34. 二叉树中和为某一值的路径](https://leetcode.cn//problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/)

## 题目描述

<p>给你二叉树的根节点 <code>root</code> 和一个整数目标和 <code>targetSum</code> ，找出所有 <strong>从根节点到叶子节点</strong> 路径总和等于给定目标和的路径。</p>

<p><strong>叶子节点</strong> 是指没有子节点的节点。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/pathsumii1.jpg" /></p>

<pre>
<strong>输入：</strong>root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
<strong>输出：</strong>[[5,4,11,2],[5,8,4,5]]
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/pathsum2.jpg" /></p>

<pre>
<strong>输入：</strong>root = [1,2,3], targetSum = 5
<strong>输出：</strong>[]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>root = [1,2], targetSum = 0
<strong>输出：</strong>[]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>树中节点总数在范围 <code>[0, 5000]</code> 内</li>
	<li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
	<li><code>-1000 &lt;= targetSum &lt;= 1000</code></li>
</ul>

<p>注意：本题与主站 113&nbsp;题相同：<a href="https://leetcode-cn.com/problems/path-sum-ii/">https://leetcode-cn.com/problems/path-sum-ii/</a></p>


## 题解


### Java

```Java
// @Title: 二叉树中和为某一值的路径 (二叉树中和为某一值的路径 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-27 23:38:55
// @Runtime: 2 ms
// @Memory: 39.1 MB

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
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if(root == null) return res; 
        recur(root,target,0);
        return res;
    }
    void recur(TreeNode root ,int target , int now){
        int sum = root.val+now;
        temp.add(root.val);
        if(sum == target && root.left == null && root.right == null) {
            List<Integer> temp1 = new ArrayList<>();
            // 做深拷贝
            for(Integer i:temp) temp1.add(i);
            // 恢复路径表
            res.add(temp1);

            temp.remove(temp.size()-1);
            return;
        }
        if(root.left != null) recur(root.left,target,sum);
        if(root.right != null) recur(root.right,target,sum);
        // 恢复路径表
        temp.remove(temp.size()-1);
        return;
    }
}
```



## 相关话题

- [树](https://leetcode.cn//tag/tree)
- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [回溯](https://leetcode.cn//tag/backtracking)
- [二叉树](https://leetcode.cn//tag/binary-tree)

## 相似题目



