
| English | [简体中文](README.md) |

# [面试题 02.02. Kth Node From End of List LCCI](https://leetcode.cn//problems/kth-node-from-end-of-list-lcci/)

## Description

<p>Implement an algorithm to find the kth to last element of a singly linked list.&nbsp;Return the value of the element.</p>

<p><strong>Note: </strong>This problem is slightly different from the original one in the book.</p>

<p><strong>Example: </strong></p>

<pre>
<strong>Input: </strong> 1-&gt;2-&gt;3-&gt;4-&gt;5 和 <em>k</em> = 2
<strong>Output:  </strong>4</pre>

<p><strong>Note: </strong></p>

<p>k is always valid.</p>


## Solutions


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



## Related Topics

- [Linked List](https://leetcode.cn//tag/linked-list)
- [Two Pointers](https://leetcode.cn//tag/two-pointers)

## Similar Questions


