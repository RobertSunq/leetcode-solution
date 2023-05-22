
| [English](README_EN.md) | 简体中文 |

# [面试题 04.05. 合法二叉搜索树](https://leetcode.cn//problems/legal-binary-search-tree-lcci/)

## 题目描述

<p>实现一个函数，检查一棵二叉树是否为二叉搜索树。</p><strong>示例 1:</strong><pre><strong>输入:</strong><br>    2<br>   / &#92<br>  1   3<br><strong>输出:</strong> true<br></pre><strong>示例 2:</strong><pre><strong>输入:</strong><br>    5<br>   / &#92<br>  1   4<br>     / &#92<br>    3   6<br><strong>输出:</strong> false<br><strong>解释:</strong> 输入为: [5,1,4,null,null,3,6]。<br>     根节点的值为 5 ，但是其右子节点值为 4 。</pre>

## 题解


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



## 相关话题

- [树](https://leetcode.cn//tag/tree)
- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [二叉搜索树](https://leetcode.cn//tag/binary-search-tree)
- [二叉树](https://leetcode.cn//tag/binary-tree)

## 相似题目



