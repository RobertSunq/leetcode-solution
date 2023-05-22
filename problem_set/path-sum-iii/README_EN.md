
| English | [简体中文](README.md) |

# [437. Path Sum III](https://leetcode.cn//problems/path-sum-iii/)

## Description

<p>Given the <code>root</code> of a binary tree and an integer <code>targetSum</code>, return <em>the number of paths where the sum of the values&nbsp;along the path equals</em>&nbsp;<code>targetSum</code>.</p>

<p>The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/04/09/pathsum3-1-tree.jpg" style="width: 450px; height: 386px;" />
<pre>
<strong>Input:</strong> root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
<strong>Output:</strong> 3
<strong>Explanation:</strong> The paths that sum to 8 are shown.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
<strong>Output:</strong> 3
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[0, 1000]</code>.</li>
	<li><code>-10<sup>9</sup> &lt;= Node.val &lt;= 10<sup>9</sup></code></li>
	<li><code>-1000 &lt;= targetSum &lt;= 1000</code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 路径总和 III (Path Sum III)
// @Author: robert.sunq
// @Date: 2021-06-21 00:10:47
// @Runtime: 28 ms
// @Memory: 38.3 MB

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
    int num=0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return num;
        // 从当前结点开始访问，查找有多少个符合要求的路径
        recur(root,targetSum);
        // 由于不需要从根节点开始，所以要去其左右子树种继续查找
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);

        return num;
    }

    void recur(TreeNode root,int targetSum ){
        if(root == null) return;
        targetSum = targetSum-root.val;
        if(targetSum == 0){
            num++;
        }
        // 由于不是以根节点为结束，所以去左右树种寻找相等路径
        recur(root.left,targetSum);
        recur(root.right,targetSum);
    }
}
```



## Related Topics

- [Tree](https://leetcode.cn//tag/tree)
- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Binary Tree](https://leetcode.cn//tag/binary-tree)

## Similar Questions

- [Path Sum](../path-sum/README_EN.md)
- [Path Sum II](../path-sum-ii/README_EN.md)
- [Path Sum IV](../path-sum-iv/README_EN.md)
- [Longest Univalue Path](../longest-univalue-path/README_EN.md)
