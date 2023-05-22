
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 07. 重建二叉树](https://leetcode.cn//problems/zhong-jian-er-cha-shu-lcof/)

## 题目描述

<p>输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。</p>

<p>假设输入的前序遍历和中序遍历的结果中都不含重复的数字。</p>

<p> </p>

<p><strong>示例 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/tree.jpg" />
<pre>
<strong>Input:</strong> preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
<strong>Output:</strong> [3,9,20,null,null,15,7]
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>Input:</strong> preorder = [-1], inorder = [-1]
<strong>Output:</strong> [-1]
</pre>

<p> </p>

<p><strong>限制：</strong></p>

<p><code>0 <= 节点个数 <= 5000</code></p>

<p> </p>

<p><strong>注意</strong>：本题与主站 105 题重复：<a href="https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/</a></p>


## 题解


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



## 相关话题

- [树](https://leetcode.cn//tag/tree)
- [数组](https://leetcode.cn//tag/array)
- [哈希表](https://leetcode.cn//tag/hash-table)
- [分治](https://leetcode.cn//tag/divide-and-conquer)
- [二叉树](https://leetcode.cn//tag/binary-tree)

## 相似题目



