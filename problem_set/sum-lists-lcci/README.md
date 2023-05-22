
| [English](README_EN.md) | 简体中文 |

# [面试题 02.05. 链表求和](https://leetcode.cn//problems/sum-lists-lcci/)

## 题目描述

<p>给定两个用链表表示的整数，每个节点包含一个数位。</p>

<p>这些数位是反向存放的，也就是个位排在链表首部。</p>

<p>编写函数对这两个整数求和，并用链表形式返回结果。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre><strong>输入：</strong>(7 -&gt; 1 -&gt; 6) + (5 -&gt; 9 -&gt; 2)，即617 + 295
<strong>输出：</strong>2 -&gt; 1 -&gt; 9，即912
</pre>

<p><strong>进阶：</strong>思考一下，假设这些数位是正向存放的，又该如何解决呢?</p>

<p><strong>示例：</strong></p>

<pre><strong>输入：</strong>(6 -&gt; 1 -&gt; 7) + (2 -&gt; 9 -&gt; 5)，即617 + 295
<strong>输出：</strong>9 -&gt; 1 -&gt; 2，即912
</pre>


## 题解


### C++

```C++
// @Title: 链表求和 (Sum Lists LCCI)
// @Author: robert.sunq
// @Date: 2020-03-25 23:34:46
// @Runtime: 36 ms
// @Memory: 68.5 MB

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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode *sum_head =  new ListNode(-1);
        //ListNode *p1 = rev(l1);
        //ListNode *p2 = rev(l2);
        ListNode *p1 = l1;
        ListNode *p2 = l2;
        ListNode *p_sum = sum_head;
        int count = 0;

        while(p1 != NULL && p2!= NULL){
            int temp = p1->val+p2->val+count;
            count = temp/10;
            ListNode *p = new ListNode(temp%10);
            p->next = p_sum->next;
            p_sum ->next = p;
            p1 = p1->next;
            p2 = p2->next;
        }
        while(p1 != NULL){
            int temp = p1->val+count;
            count = temp/10;
            ListNode *p = new ListNode(temp%10);
            p->next = p_sum->next;
            p_sum ->next = p;
            p1 = p1->next;
        }
        while(p2 != NULL){
            int temp = p2->val+count;
            count = temp/10;
            ListNode *p = new ListNode(temp%10);
            p->next = p_sum->next;
            p_sum ->next = p;
            p2 = p2->next;
        }
        if(count!=0){
            ListNode *p = new ListNode(count);
            p->next = p_sum->next;
            p_sum ->next = p;
        }
        
        return rev(p_sum->next);


    }

protected:
    ListNode* rev(ListNode * head){
        ListNode *phead = new ListNode(-1);
        phead->next = head;
        ListNode *p = head,*pre = phead;
        while(p != NULL){
            if(p == head){
                pre = p;
                p = p->next;
            }
            else{
                pre->next = p->next;
                p->next = phead->next;
                phead->next = p;
                p = pre->next;
            }
        }
        //while(phead)
        return phead->next;
    }
};
```



## 相关话题

- [递归](https://leetcode.cn//tag/recursion)
- [链表](https://leetcode.cn//tag/linked-list)
- [数学](https://leetcode.cn//tag/math)

## 相似题目



