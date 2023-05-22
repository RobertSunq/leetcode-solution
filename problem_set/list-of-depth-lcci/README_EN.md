
| English | [简体中文](README.md) |

# [面试题 04.03. List of Depth LCCI](https://leetcode.cn//problems/list-of-depth-lcci/)

## Description

<p>Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth (e.g., if you have a tree with depth D, you&#39;ll have D linked lists). Return a array containing all the linked lists.</p>

<p>&nbsp;</p>

<p><strong>Example: </strong></p>

<pre>
<strong>Input: </strong>[1,2,3,4,5,null,7,8]

        1
       /  \ 
      2    3
     / \    \ 
    4   5    7
   /
  8

<strong>Output: </strong>[[1],[2,3],[4,5,7],[8]]
</pre>


## Solutions


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



## Related Topics

- [Tree](https://leetcode.cn//tag/tree)
- [Breadth-First Search](https://leetcode.cn//tag/breadth-first-search)
- [Linked List](https://leetcode.cn//tag/linked-list)
- [Binary Tree](https://leetcode.cn//tag/binary-tree)

## Similar Questions


