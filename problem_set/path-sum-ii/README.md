
| [English](README_EN.md) | 简体中文 |

# [113. 路径总和 II](https://leetcode.cn//problems/path-sum-ii/)

## 题目描述

<p>给你二叉树的根节点 <code>root</code> 和一个整数目标和 <code>targetSum</code> ，找出所有 <strong>从根节点到叶子节点</strong> 路径总和等于给定目标和的路径。</p>

<p><strong>叶子节点</strong> 是指没有子节点的节点。</p>

<div class="original__bRMd">
<div>
<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/pathsumii1.jpg" style="width: 500px; height: 356px;" />
<pre>
<strong>输入：</strong>root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
<strong>输出：</strong>[[5,4,11,2],[5,8,4,5]]
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/pathsum2.jpg" style="width: 212px; height: 181px;" />
<pre>
<strong>输入：</strong>root = [1,2,3], targetSum = 5
<strong>输出：</strong>[]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>root = [1,2], targetSum = 0
<strong>输出：</strong>[]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li>树中节点总数在范围 <code>[0, 5000]</code> 内</li>
	<li><code>-1000 <= Node.val <= 1000</code></li>
	<li><code>-1000 <= targetSum <= 1000</code></li>
</ul>
</div>
</div>


## 题解


### Java

```Java
// @Title: 路径总和 II (Path Sum II)
// @Author: robert.sunq
// @Date: 2021-07-08 22:25:35
// @Runtime: 1 ms
// @Memory: 38.7 MB

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

    List<List<Integer>> res;
    List<Integer> temp;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        temp = new ArrayList<>();
        recur(root,targetSum);
        return res;
    }
    void recur(TreeNode root,int targetSum){
        if(root == null) return ;
        temp.add(root.val);
        if(root.val == targetSum){
            // 如果是根节点
            if(root.left == null && root.right == null){
                // 注意 此处为new一个新的，做深拷贝
                res.add(new ArrayList<Integer>(temp));
            }
        }
        // 遍历访问左右节点
        recur(root.left,targetSum-root.val);
        recur(root.right,targetSum-root.val);
        // 从路径表中删除当前节点
        temp.remove(temp.size()-1);
    }
}
```



## 相关话题

- [树](https://leetcode.cn//tag/tree)
- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [回溯](https://leetcode.cn//tag/backtracking)
- [二叉树](https://leetcode.cn//tag/binary-tree)

## 相似题目


- [路径总和](../path-sum/README.md)
- [二叉树的所有路径](../binary-tree-paths/README.md)
- [路径总和 III](../path-sum-iii/README.md)
- [路径总和 IV](../path-sum-iv/README.md)
