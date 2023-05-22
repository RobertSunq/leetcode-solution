
| English | [简体中文](README.md) |

# [面试题 02.04. Partition List LCCI](https://leetcode.cn//problems/partition-list-lcci/)

## Description

<p>Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x. If x is contained within the list, the values of x only need to be after the elements less than x (see below). The partition element x can appear anywhere in the &quot;right partition&quot;; it does not need to appear between the left and right partitions.</p>

<p><strong>Example:</strong></p>

<pre>
<strong>Input:</strong> head = 3-&gt;5-&gt;8-&gt;5-&gt;10-&gt;2-&gt;1, <em>x</em> = 5
<strong>Output:</strong> 3-&gt;1-&gt;2-&gt;10-&gt;5-&gt;5-&gt;8
</pre>


## Solutions


### Java

```Java
// @Title: 分割链表 (Partition List LCCI)
// @Author: robert.sunq
// @Date: 2021-08-02 22:43:10
// @Runtime: 0 ms
// @Memory: 38 MB

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null ) return head;
        ListNode resHead = new ListNode(-1);
        resHead.next = head;
        ListNode pre = resHead,p = head,minPre = resHead;
        while(p!=null){
            if(p.val >= x){
                pre = p;
                p = p.next;
            }else{
                if(pre == minPre){
                    pre= pre.next;
                    minPre = minPre.next;
                    p = p.next;
                    continue;
                }
                pre.next = p.next;
                p.next = minPre.next;
                minPre.next = p;
                minPre = p;
                p = pre.next;
            }
        }
        return resHead.next;
    }
}
```



### C++

```C++
// @Title: 分割链表 (Partition List LCCI)
// @Author: robert.sunq
// @Date: 2020-03-25 22:35:17
// @Runtime: 8 ms
// @Memory: 9.5 MB

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
    ListNode* partition(ListNode* head, int x) {
        ListNode *pHead = new ListNode(-1);

        pHead->next = head;
        ListNode *pre = head;
        ListNode *p = head;
        while(p != NULL){
            if(p->val < x && p!= head) {
                pre->next = p->next;
                p->next =  pHead->next;
                pHead->next = p;
                p = pre->next;

            }else{
                pre = p;
                p = p->next;
            }
        }
        return pHead->next;

    }
};
```



## Related Topics

- [Linked List](https://leetcode.cn//tag/linked-list)
- [Two Pointers](https://leetcode.cn//tag/two-pointers)

## Similar Questions


