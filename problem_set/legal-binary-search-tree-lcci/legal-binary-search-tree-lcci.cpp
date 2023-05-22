
```
// @Title: 合法二叉搜索树 (Legal Binary Search Tree LCCI)
// @Author: robert.sunq
// @Date: 2020-04-09 22:38:25
// @Runtime: 24 ms
// @Memory: 21.4 MB

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
    bool isValidBST(TreeNode* root) {
        stack<TreeNode *> st;
        TreeNode *p = root;
        vector<int> an;
        if(root == NULL) return true;
        while(p!= NULL ||  !st.empty()){
            while(p!= NULL){
                st.push(p);
                p = p->left;
            }
            if(!st.empty()) {
                p = st.top();
                st.pop();
                an.push_back(p->val);
                p = p->right;

            }
        }
        for(int i=0;i<an.size()-1;i++){
            if(an[i] >= an[i+1]) return false;
        }
        return true;

    }
};
