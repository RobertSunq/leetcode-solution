
```
// @Title: 最小高度树 (Minimum Height Tree LCCI)
// @Author: robert.sunq
// @Date: 2020-04-09 17:18:07
// @Runtime: 44 ms
// @Memory: 24.1 MB

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
    TreeNode *creat(vector<int> &nums , int start,int last){
        if(start<=last){
            int temp = (start+last)/2;
            TreeNode *head = new TreeNode(nums[temp]);
            head->left = creat(nums,start,temp-1);
            head->right = creat(nums,temp+1,last);
            return head;
        }
        else return NULL;
    }
public:
    TreeNode* sortedArrayToBST(vector<int>& nums) {

        int len = nums.size();
        if(len == 0) return NULL;
        int temp = (len-1)/2;
        TreeNode *head = new TreeNode(nums[temp]);
        head->left = creat(nums,0,temp-1);
        head->right = creat(nums,temp+1,len-1);
        return head;
    }
};
