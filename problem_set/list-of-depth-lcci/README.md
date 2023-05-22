
| [English](README_EN.md) | 简体中文 |

# [面试题 04.03. 特定深度节点链表](https://leetcode.cn//problems/list-of-depth-lcci/)

## 题目描述

<p>给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 <code>D</code>，则会创建出 <code>D</code> 个链表）。返回一个包含所有深度的链表的数组。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre><strong>输入：</strong>[1,2,3,4,5,null,7,8]

        1
       /  \ 
      2    3
     / \    \ 
    4   5    7
   /
  8

<strong>输出：</strong>[[1],[2,3],[4,5,7],[8]]
</pre>


## 题解


### C++

```C++
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
```



## 相关话题

- [树](https://leetcode.cn//tag/tree)
- [广度优先搜索](https://leetcode.cn//tag/breadth-first-search)
- [链表](https://leetcode.cn//tag/linked-list)
- [二叉树](https://leetcode.cn//tag/binary-tree)

## 相似题目



