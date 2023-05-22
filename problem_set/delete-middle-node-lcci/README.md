
| [English](README_EN.md) | 简体中文 |

# [面试题 02.03. 删除中间节点](https://leetcode.cn//problems/delete-middle-node-lcci/)

## 题目描述

<p>若链表中的某个节点，既不是链表头节点，也不是链表尾节点，则称其为该链表的「中间节点」。</p>

<p>假定已知链表的某一个中间节点，请实现一种算法，将该节点从链表中删除。</p>

<p>例如，传入节点 <code>c</code>（位于单向链表 <code>a->b->c->d->e->f</code> 中），将其删除后，剩余链表为 <code>a->b->d->e->f</code></p>

<p> </p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>节点 5 （位于单向链表 4->5->1->9 中）
<strong>输出：</strong>不返回任何数据，从链表中删除传入的节点 5，使链表变为 4->1->9
</pre>

<p> </p>


## 题解


### Java

```Java
// @Title: 删除中间节点 (Delete Middle Node LCCI)
// @Author: robert.sunq
// @Date: 2021-08-02 22:11:57
// @Runtime: 0 ms
// @Memory: 37.9 MB

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
```



### C++

```C++
// @Title: 删除中间节点 (Delete Middle Node LCCI)
// @Author: robert.sunq
// @Date: 2020-03-25 21:36:29
// @Runtime: 12 ms
// @Memory: 6.7 MB

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
    void deleteNode(ListNode* node) {
        while(node->next->next != NULL){
            node->val = node->next->val;
            node = node->next;
        }
        node->val = node->next->val;
        node->next = NULL;

    }
};
```



## 相关话题

- [链表](https://leetcode.cn//tag/linked-list)

## 相似题目



