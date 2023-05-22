
| [English](README_EN.md) | 简体中文 |

# [面试题 02.02. 返回倒数第 k 个节点](https://leetcode.cn//problems/kth-node-from-end-of-list-lcci/)

## 题目描述

<p>实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。</p>

<p><strong>注意：</strong>本题相对原题稍作改动</p>

<p><strong>示例：</strong></p>

<pre><strong>输入：</strong> 1-&gt;2-&gt;3-&gt;4-&gt;5 和 <em>k</em> = 2
<strong>输出： </strong>4</pre>

<p><strong>说明：</strong></p>

<p>给定的 <em>k</em>&nbsp;保证是有效的。</p>


## 题解


### C++

```C++
// @Title: 返回倒数第 k 个节点 (Kth Node From End of List LCCI)
// @Author: robert.sunq
// @Date: 2020-03-25 21:30:51
// @Runtime: 4 ms
// @Memory: 9.9 MB

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
    int kthToLast(ListNode* head, int k) {
        int i=0;
        ListNode *p =  head;
        ListNode *q = head;
        while(p != NULL){
            if(i<k){
                p = p->next;
            }
            else{
                p = p->next;
                q = q->next;
            }
            i++;
        }
        if(i <k) return -1;
        else return q->val;

    }
};
```



## 相关话题

- [链表](https://leetcode.cn//tag/linked-list)
- [双指针](https://leetcode.cn//tag/two-pointers)

## 相似题目



