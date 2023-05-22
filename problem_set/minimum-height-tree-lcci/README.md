
| [English](README_EN.md) | 简体中文 |

# [面试题 04.02. 最小高度树](https://leetcode.cn//problems/minimum-height-tree-lcci/)

## 题目描述

<p>给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。</p><strong>示例:</strong><pre>给定有序数组: [-10,-3,0,5,9],<br><br>一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：<br><br>          0 <br>         / &#92 <br>       -3   9 <br>       /   / <br>     -10  5 <br></pre>

## 题解


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



## 相关话题

- [树](https://leetcode.cn//tag/tree)
- [二叉搜索树](https://leetcode.cn//tag/binary-search-tree)
- [数组](https://leetcode.cn//tag/array)
- [分治](https://leetcode.cn//tag/divide-and-conquer)
- [二叉树](https://leetcode.cn//tag/binary-tree)

## 相似题目



