
| English | [简体中文](README.md) |

# [面试题 04.02. Minimum Height Tree LCCI](https://leetcode.cn//problems/minimum-height-tree-lcci/)

## Description

<p>Given a sorted (increasing order) array with unique integer elements, write an algo&shy;rithm to create a binary search tree with minimal height.</p>

<p><strong>Example:</strong></p>

<pre>
Given sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5]，which represents the following tree: 

          0 
         / \ 
       -3   9 
       /   / 
     -10  5 
</pre>


## Solutions


### C++

```C++
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
```



## Related Topics

- [Tree](https://leetcode.cn//tag/tree)
- [Binary Search Tree](https://leetcode.cn//tag/binary-search-tree)
- [Array](https://leetcode.cn//tag/array)
- [Divide and Conquer](https://leetcode.cn//tag/divide-and-conquer)
- [Binary Tree](https://leetcode.cn//tag/binary-tree)

## Similar Questions


