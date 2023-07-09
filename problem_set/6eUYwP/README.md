
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 050. 向下的路径节点之和](https://leetcode.cn//problems/6eUYwP/)

## 题目描述

<p>给定一个二叉树的根节点 <code>root</code>&nbsp;，和一个整数 <code>targetSum</code> ，求该二叉树里节点值之和等于 <code>targetSum</code> 的 <strong>路径</strong> 的数目。</p>

<p><strong>路径</strong> 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2021/04/09/pathsum3-1-tree.jpg" style="width: 452px; " /></p>

<pre>
<strong>输入：</strong>root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
<strong>输出：</strong>3
<strong>解释：</strong>和等于 8 的路径有 3 条，如图所示。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
<strong>输出：</strong>3
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li>二叉树的节点个数的范围是 <code>[0,1000]</code></li>
	<li><meta charset="UTF-8" /><code>-10<sup><span style="font-size: 9.449999809265137px;">9</span></sup>&nbsp;&lt;= Node.val &lt;= 10<sup><span style="font-size: 9.449999809265137px;">9</span></sup></code>&nbsp;</li>
	<li><code>-1000&nbsp;&lt;= targetSum&nbsp;&lt;= 1000</code>&nbsp;</li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 437&nbsp;题相同：<a href="https://leetcode-cn.com/problems/path-sum-iii/">https://leetcode-cn.com/problems/path-sum-iii/</a></p>


## 题解


### Java

```Java
// @Title: 向下的路径节点之和 (向下的路径节点之和)
// @Author: robert.sunq
// @Date: 2023-07-09 21:56:22
// @Runtime: 2 ms
// @Memory: 41.9 MB

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
    // key 表示 前缀和， value 表示 次数
    private Map<Long, Integer> preSumCount = new HashMap<>();

    private int targetSum;
    public int pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;

        // 同 https://leetcode.cn/problems/QTMn0o/description/

        // 记录前缀和， 注意这里，初始设置前缀和为 0 的个数为 1， 则后面其他节点前缀和 - targetSum = 0时，可以直接计数为 1，不用单独加1
        preSumCount.put(0L, 1);
        
        return dfs(root, 0L);
    }

    private int dfs(TreeNode root, long curSum) {
        if (root == null) {
            return 0;
        }

        int  res = 0;
        curSum = curSum + root.val;

        // 当前前缀和 和 减去 目标值的差， 如果存在于map中，则说明从某一个点到当前点的和 等于目标值
        res = res + preSumCount.getOrDefault(curSum - targetSum, 0);

        // 将当前的前缀和也加入map
        preSumCount.put(curSum, preSumCount.getOrDefault(curSum, 0) + 1);

        // 递归左右子树
        res = res + dfs(root.left, curSum);
        res = res + dfs(root.right, curSum);

        // 遍历完当前节点后，从前缀和计数中删除当前节点，避免重复计算
        preSumCount.put(curSum, preSumCount.get(curSum) - 1);

        return res;
    }
}
```



## 相关话题

- [树](https://leetcode.cn//tag/tree)
- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [二叉树](https://leetcode.cn//tag/binary-tree)

## 相似题目



