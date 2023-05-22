
```
// @Title: 二叉树的锯齿形层序遍历 (Binary Tree Zigzag Level Order Traversal)
// @Author: robert.sunq
// @Date: 2020-05-13 12:21:16
// @Runtime: 0 ms
// @Memory: 11.1 MB

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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int> > out;
        int res = 1;
        if (root == NULL) return out;
        stack<TreeNode*> st1,st2;
        st1.push(root);
        while (!st1.empty() || !st2.empty()){
            vector<int> temp;
            if(res%2){
                while(!st1.empty()){
                    TreeNode *p = st1.top();
                    st1.pop();
                    temp.push_back(p->val);
                    if(p->left != NULL) st2.push(p->left);
                    if(p->right != NULL) st2.push(p->right);
                }
                out.push_back(temp);
                res++;

            }
            else{
                 while(!st2.empty()){
                    TreeNode *p = st2.top();
                    st2.pop();
                    temp.push_back(p->val);
                    if(p->right != NULL) st1.push(p->right);
                    if(p->left != NULL) st1.push(p->left);
                    
                }
                out.push_back(temp);
                res++;

            }
        }
        return out;
        
    }
};
