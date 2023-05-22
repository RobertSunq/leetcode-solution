
| [English](README_EN.md) | 简体中文 |

# [面试题 04.04. 检查平衡性](https://leetcode.cn//problems/check-balance-lcci/)

## 题目描述

<p>实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。</p><br><strong>示例 1:</strong><pre>给定二叉树 [3,9,20,null,null,15,7]<br>    3<br>   / &#92<br>  9  20<br>    /  &#92<br>   15   7<br>返回 true 。</pre><strong>示例 2:</strong><br><pre>给定二叉树 [1,2,2,3,3,null,null,4,4]<br>      1<br>     / &#92<br>    2   2<br>   / &#92<br>  3   3<br> / &#92<br>4   4<br>返回 false 。</pre>

## 题解


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



## 相关话题

- [树](https://leetcode.cn//tag/tree)
- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [二叉树](https://leetcode.cn//tag/binary-tree)

## 相似题目



