
```
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
