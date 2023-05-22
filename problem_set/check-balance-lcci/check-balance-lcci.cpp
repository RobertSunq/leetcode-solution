
```
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
