
| English | [简体中文](README.md) |

# [面试题 04.05. Legal Binary Search Tree LCCI](https://leetcode.cn//problems/legal-binary-search-tree-lcci/)

## Description

<p>Implement a function to check if a binary tree is a binary search tree.</p>

<p><strong>Example&nbsp;1:</strong></p>

<pre>
<strong>Input:</strong>
    2
   / \
  1   3
<strong>Output:</strong> true
</pre>

<p><strong>Example&nbsp;2:</strong></p>

<pre>
<strong>Input:</strong>
    5
   / \
  1   4
&nbsp;    / \
&nbsp;   3   6
<strong>Output:</strong> false
<strong>Explanation:</strong> Input: [5,1,4,null,null,3,6].
&nbsp;    the value of root node is 5, but its right child has value 4.</pre>


## Solutions


### C++

```C++
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
```



## Related Topics

- [Tree](https://leetcode.cn//tag/tree)
- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Binary Search Tree](https://leetcode.cn//tag/binary-search-tree)
- [Binary Tree](https://leetcode.cn//tag/binary-tree)

## Similar Questions


