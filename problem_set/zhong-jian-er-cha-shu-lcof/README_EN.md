
| English | [简体中文](README.md) |

# [剑指 Offer 07. 重建二叉树 LCOF](https://leetcode.cn//problems/zhong-jian-er-cha-shu-lcof/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>

## Solutions


### C++

```C++
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
```



### Java

```Java
// @Title: 重建二叉树 (重建二叉树 LCOF)
// @Author: robert.sunq
// @Date: 2023-02-05 23:56:17
// @Runtime: 3 ms
// @Memory: 41.5 MB

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return builder(preorder, inorder, 0, 0, preorder.length);
    }

    /** 
    左闭右开
     */
    public TreeNode builder(int[] preorder, int[] inorder,int preIndex, int inorLeft, int inorRight) {
        if (inorLeft >= inorRight) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[preIndex]);
        int inorHeadIndex = inorLeft;
        for (int i = inorLeft; i < inorRight; i++) {
            if (inorder[i] == preorder[preIndex]) {
                inorHeadIndex = i;
                break;
            }
        }
        TreeNode left = builder(preorder, inorder, preIndex + 1, inorLeft, inorHeadIndex);
        TreeNode right = builder(preorder, inorder, preIndex + (inorHeadIndex - inorLeft) + 1,inorHeadIndex + 1, inorRight);
        head.left = left;
        head.right = right;
        return head;
    }
}
```



## Related Topics

- [Tree](https://leetcode.cn//tag/tree)
- [Array](https://leetcode.cn//tag/array)
- [Hash Table](https://leetcode.cn//tag/hash-table)
- [Divide and Conquer](https://leetcode.cn//tag/divide-and-conquer)
- [Binary Tree](https://leetcode.cn//tag/binary-tree)

## Similar Questions


