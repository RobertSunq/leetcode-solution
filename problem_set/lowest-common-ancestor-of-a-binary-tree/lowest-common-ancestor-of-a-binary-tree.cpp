
```
// @Title: 二叉树的最近公共祖先 (Lowest Common Ancestor of a Binary Tree)
// @Author: robert.sunq
// @Date: 2020-05-13 12:39:00
// @Runtime: 20 ms
// @Memory: 14.2 MB

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
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (root == NULL) return NULL;
        if(root == p) return p;
        if(root == q) return q;

        TreeNode *left = lowestCommonAncestor(root->left,p,q);
        TreeNode *right = lowestCommonAncestor(root->right,p,q);

        if(left == NULL) return right;
        if(right == NULL) return left;
        if(left && right) return root;
        
        return NULL;
    }
};
