
| English | [简体中文](README.md) |

# [124. Binary Tree Maximum Path Sum](https://leetcode.cn//problems/binary-tree-maximum-path-sum/)

## Description

<p>A <strong>path</strong> in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence <strong>at most once</strong>. Note that the path does not need to pass through the root.</p>

<p>The <strong>path sum</strong> of a path is the sum of the node&#39;s values in the path.</p>

<p>Given the <code>root</code> of a binary tree, return <em>the maximum <strong>path sum</strong> of any <strong>non-empty</strong> path</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/13/exx1.jpg" style="width: 322px; height: 182px;" />
<pre>
<strong>Input:</strong> root = [1,2,3]
<strong>Output:</strong> 6
<strong>Explanation:</strong> The optimal path is 2 -&gt; 1 -&gt; 3 with a path sum of 2 + 1 + 3 = 6.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/13/exx2.jpg" />
<pre>
<strong>Input:</strong> root = [-10,9,20,null,null,15,7]
<strong>Output:</strong> 42
<strong>Explanation:</strong> The optimal path is 15 -&gt; 20 -&gt; 7 with a path sum of 15 + 20 + 7 = 42.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[1, 3 * 10<sup>4</sup>]</code>.</li>
	<li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 二叉树中的最大路径和 (Binary Tree Maximum Path Sum)
// @Author: robert.sunq
// @Date: 2021-07-11 21:53:29
// @Runtime: 0 ms
// @Memory: 40.4 MB

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
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        recur(root);
        return res;

    }
    int recur(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = Math.max(recur(root.left),0);
        int right = Math.max(recur(root.right),0);
        int temp = Math.max(left,right);
        // 最大的路径为，过根节点的左右子树单一路径和加根，或者左右子树中的最大路径即不过根节点
        res = Math.max(res,left+right+root.val);
        return temp+root.val;
    }
}
```



### C++

```C++
// @Title: 二叉树中的最大路径和 (Binary Tree Maximum Path Sum)
// @Author: robert.sunq
// @Date: 2020-05-13 12:56:40
// @Runtime: 48 ms
// @Memory: 27.7 MB

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
private:int maxs = INT_MIN;
public:
    int maxPathSum(TreeNode* root) {
        if (root == NULL) return 0;

        MaxP(root);
        return maxs;
        

    }
private:
    int MaxP(TreeNode* root){
        if (root == NULL) return 0;
        int lefts = max(MaxP(root->left),0);
        int rights = max(0,MaxP(root->right));

        maxs = max(maxs,lefts+rights+root->val);

        return root->val + max(lefts,rights);
    }
};
```



## Related Topics

- [Tree](https://leetcode.cn//tag/tree)
- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)
- [Binary Tree](https://leetcode.cn//tag/binary-tree)

## Similar Questions

- [Path Sum](../path-sum/README_EN.md)
- [Sum Root to Leaf Numbers](../sum-root-to-leaf-numbers/README_EN.md)
- [Path Sum IV](../path-sum-iv/README_EN.md)
- [Longest Univalue Path](../longest-univalue-path/README_EN.md)
