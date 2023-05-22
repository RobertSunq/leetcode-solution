
| English | [简体中文](README.md) |

# [面试题 04.04. Check Balance LCCI](https://leetcode.cn//problems/check-balance-lcci/)

## Description

<p>Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.</p>

<p><br />
<strong>Example 1:</strong></p>

<pre>
Given tree [3,9,20,null,null,15,7]
    3
   / \
  9  20
    /  \
   15   7
return true.</pre>

<p><strong>Example 2:</strong></p>

<pre>
Given [1,2,2,3,3,null,null,4,4]
      1
     / \
    2   2
   / \
  3   3
 / \
4   4
return&nbsp;false.</pre>

<p>&nbsp;</p>


## Solutions


### C++

```C++
// @Title: 检查平衡性 (Check Balance LCCI)
// @Author: robert.sunq
// @Date: 2020-04-09 20:48:17
// @Runtime: 12 ms
// @Memory: 20.5 MB

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
protected:
    int isbalan(TreeNode * root){
        if(root == NULL) return 0;
        else{
            
            
            int deep_left = isbalan(root->left) +1;
            
            int deep_right =isbalan(root->right)+1;
            if(deep_left <0 || deep_right <0) return -5;
            if(abs(deep_left-deep_right) >1) return -5;
            return deep_left > deep_right ? deep_left :deep_right;
        }
    }
public:
    bool isBalanced(TreeNode* root) {
        if(root == NULL) return true;
        
        int deep = isbalan(root);
        if(deep < 0) return false;
        else return true;

    }
};
```



### Java

```Java
// @Title: 检查平衡性 (Check Balance LCCI)
// @Author: robert.sunq
// @Date: 2021-08-02 23:19:44
// @Runtime: 1 ms
// @Memory: 38.6 MB

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
    public boolean isBalanced(TreeNode root) {
        return recur(root) >-1;
    }
    public int recur(TreeNode root){
        if(root == null) return 0;
        int left = recur(root.left);
        if(left == -1) return -1;
        int right = recur(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) >1 ? -1:Math.max(left , right) +1;
    }
}
```



## Related Topics

- [Tree](https://leetcode.cn//tag/tree)
- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Binary Tree](https://leetcode.cn//tag/binary-tree)

## Similar Questions


