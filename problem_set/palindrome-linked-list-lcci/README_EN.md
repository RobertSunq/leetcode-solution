
| English | [简体中文](README.md) |

# [面试题 02.06. Palindrome Linked List LCCI](https://leetcode.cn//problems/palindrome-linked-list-lcci/)

## Description

<p>Implement a function to check if a linked list is a palindrome.</p>

<p>&nbsp;</p>

<p><strong>Example 1: </strong></p>

<pre>
<strong>Input:  </strong>1-&gt;2
<strong>Output: </strong> false 
</pre>

<p><strong>Example 2: </strong></p>

<pre>
<strong>Input:  </strong>1-&gt;2-&gt;2-&gt;1
<strong>Output: </strong> true 
</pre>

<p>&nbsp;</p>

<p><b>Follow up:</b><br />
Could you do it in O(n) time and O(1) space?</p>


## Solutions


### C++

```C++
// @Title: 回文链表 (Palindrome Linked List LCCI)
// @Author: robert.sunq
// @Date: 2020-03-26 00:16:51
// @Runtime: 40 ms
// @Memory: 15.4 MB

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
    bool isPalindrome(ListNode* head) {
        ListNode *pHead = new ListNode(-1);
        ListNode *pre ,*p = head;
        //pHead->next = head;
        if(head == NULL) return true;
        int counts= 0;
        while(p!= NULL){
            ListNode *q = new ListNode(p->val);
            q->next = pHead->next;
            pHead->next = q;
            p = p ->next;
            counts++;
        }
        p = head;
        pHead = pHead->next;
        for(int i=0;i<counts/2;i++){
            
            if(p->val != pHead->val) return false;
            p = p->next;
            pHead = pHead->next;
        }
        return true;



    }
};
```



## Related Topics

- [Stack](https://leetcode.cn//tag/stack)
- [Recursion](https://leetcode.cn//tag/recursion)
- [Linked List](https://leetcode.cn//tag/linked-list)
- [Two Pointers](https://leetcode.cn//tag/two-pointers)

## Similar Questions


