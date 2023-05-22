
| English | [简体中文](README.md) |

# [面试题 02.01. Remove Duplicate Node LCCI](https://leetcode.cn//problems/remove-duplicate-node-lcci/)

## Description

<p>Write code to remove duplicates from an unsorted linked list.</p>

<p><strong>Example1:</strong></p>

<pre>
<strong> Input</strong>: [1, 2, 3, 3, 2, 1]
<strong> Output</strong>: [1, 2, 3]
</pre>

<p><strong>Example2:</strong></p>

<pre>
<strong> Input</strong>: [1, 1, 1, 1, 2]
<strong> Output</strong>: [1, 2]
</pre>

<p><strong>Note: </strong></p>

<ol>
	<li>The length of the list is within the range[0, 20000].</li>
	<li>The values of the list elements are within the range [0, 20000].</li>
</ol>

<p><strong>Follow Up: </strong></p>

<p>How would you solve this problem if a temporary buffer is not allowed?</p>


## Solutions


### C++

```C++
// @Title: 移除重复节点 (Remove Duplicate Node LCCI)
// @Author: robert.sunq
// @Date: 2020-03-25 00:08:25
// @Runtime: 80 ms
// @Memory: 15 MB

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
    ListNode* removeDuplicateNodes(ListNode* head) {
        map<int,int>mp;
        if(head == NULL) return NULL;
        ListNode*p = head;
        ListNode*pre = head;
        mp[p->val]++;
        p = p->next;
        while(p!=NULL){
            mp[p->val]++;
            if(mp[p->val] > 1) {
                pre->next = p->next;
                //free(p);
                p = pre->next;
            }
            else{
                pre = p;
                p = p->next;
            }
        }
        return head;

    }
};
```



## Related Topics

- [Hash Table](https://leetcode.cn//tag/hash-table)
- [Linked List](https://leetcode.cn//tag/linked-list)
- [Two Pointers](https://leetcode.cn//tag/two-pointers)

## Similar Questions


