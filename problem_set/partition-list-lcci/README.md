
| [English](README_EN.md) | 简体中文 |

# [面试题 02.04. 分割链表](https://leetcode.cn//problems/partition-list-lcci/)

## 题目描述

<p>给你一个链表的头节点 <code>head</code> 和一个特定值<em> </em><code>x</code> ，请你对链表进行分隔，使得所有 <strong>小于</strong> <code>x</code> 的节点都出现在 <strong>大于或等于</strong> <code>x</code> 的节点之前。</p>

<p>你不需要&nbsp;<strong>保留</strong>&nbsp;每个分区中各节点的初始相对位置。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/partition.jpg" style="width: 662px; height: 222px;" />
<pre>
<strong>输入：</strong>head = [1,4,3,2,5,2], x = 3
<strong>输出</strong>：[1,2,2,4,3,5]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>head = [2,1], x = 2
<strong>输出</strong>：[1,2]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>链表中节点的数目在范围 <code>[0, 200]</code> 内</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
	<li><code>-200 &lt;= x &lt;= 200</code></li>
</ul>


## 题解


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



## 相关话题

- [链表](https://leetcode.cn//tag/linked-list)
- [双指针](https://leetcode.cn//tag/two-pointers)

## 相似题目



