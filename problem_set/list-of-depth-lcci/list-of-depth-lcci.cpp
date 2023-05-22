
```
// @Title: 特定深度节点链表 (List of Depth LCCI)
// @Author: robert.sunq
// @Date: 2020-04-09 17:39:15
// @Runtime: 0 ms
// @Memory: 8.3 MB

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    vector<ListNode*> listOfDepth(TreeNode* tree) {
        vector<ListNode*> an;
        if(tree == NULL) return an;
        queue<TreeNode*> q;
        TreeNode *p = tree;
        q.push(p);
        while(!q.empty()){
            int len = q.size();
            ListNode *thead = new ListNode(0);
            ListNode *last = thead;
            for(int i=0; i<len;i++){
                p = q.front();
                q.pop();
                ListNode * t = new ListNode(p->val);
                last->next = t;
                last = t;
                if(p->left != NULL) q.push(p->left);
                if(p->right!= NULL) q.push(p->right);

            }
            an.push_back(thead->next);
        }
        return an;

    }
};
