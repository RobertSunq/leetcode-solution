
```
// @Title: 重建二叉树 (重建二叉树 LCOF)
// @Author: robert.sunq
// @Date: 2020-03-21 15:37:40
// @Runtime: 160 ms
// @Memory: 159.4 MB

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
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
            if(preorder.empty()) return NULL;
            TreeNode* head = new TreeNode(preorder[0]);
            vector<int> pre_left,pre_right;
            vector<int> ino_left,ino_right;
            int i=1;
            int j = 0;
            bool falg = true;
            while(i<preorder.size()){
                if(falg){
                    if(inorder[j] == preorder[0]){
                        falg =  false;
                        j++;
                    }
                    else{
                        pre_left.push_back(preorder[i]);
                        ino_left.push_back(inorder[j]);
                        i++;
                        j++;
                    }
                }
                else{
                    pre_right.push_back(preorder[i]);
                    ino_right.push_back(inorder[j]);
                    i++;
                    j++;
                }
            }
            head->left = buildTree(pre_left,ino_left);
            head->right = buildTree(pre_right,ino_right);
            return head;
    }
};
