
| English | [简体中文](README.md) |

# [113. Path Sum II](https://leetcode.cn//problems/path-sum-ii/)

## Description

<p>Given the <code>root</code> of a binary tree and an integer <code>targetSum</code>, return <em>all <strong>root-to-leaf</strong> paths where the sum of the node values in the path equals </em><code>targetSum</code><em>. Each path should be returned as a list of the node <strong>values</strong>, not node references</em>.</p>

<p>A <strong>root-to-leaf</strong> path is a path starting from the root and ending at any leaf node. A <strong>leaf</strong> is a node with no children.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/pathsumii1.jpg" style="width: 500px; height: 356px;" />
<pre>
<strong>Input:</strong> root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
<strong>Output:</strong> [[5,4,11,2],[5,8,4,5]]
<strong>Explanation:</strong> There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/pathsum2.jpg" style="width: 212px; height: 181px;" />
<pre>
<strong>Input:</strong> root = [1,2,3], targetSum = 5
<strong>Output:</strong> []
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> root = [1,2], targetSum = 0
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[0, 5000]</code>.</li>
	<li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
	<li><code>-1000 &lt;= targetSum &lt;= 1000</code></li>
</ul>


## Solutions


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



## Related Topics

- [Tree](https://leetcode.cn//tag/tree)
- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Backtracking](https://leetcode.cn//tag/backtracking)
- [Binary Tree](https://leetcode.cn//tag/binary-tree)

## Similar Questions

- [Path Sum](../path-sum/README_EN.md)
- [Binary Tree Paths](../binary-tree-paths/README_EN.md)
- [Path Sum III](../path-sum-iii/README_EN.md)
- [Path Sum IV](../path-sum-iv/README_EN.md)
