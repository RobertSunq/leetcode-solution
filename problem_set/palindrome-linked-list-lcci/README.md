
| [English](README_EN.md) | 简体中文 |

# [面试题 02.06. 回文链表](https://leetcode.cn//problems/palindrome-linked-list-lcci/)

## 题目描述

<p>编写一个函数，检查输入的链表是否是回文的。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入： </strong>1-&gt;2
<strong>输出：</strong> false 
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入： </strong>1-&gt;2-&gt;2-&gt;1
<strong>输出：</strong> true 
</pre>

<p>&nbsp;</p>

<p><strong>进阶：</strong><br>
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？</p>


## 题解


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



## 相关话题

- [栈](https://leetcode.cn//tag/stack)
- [递归](https://leetcode.cn//tag/recursion)
- [链表](https://leetcode.cn//tag/linked-list)
- [双指针](https://leetcode.cn//tag/two-pointers)

## 相似题目



