
| English | [简体中文](README.md) |

# [面试题 02.03. Delete Middle Node LCCI](https://leetcode.cn//problems/delete-middle-node-lcci/)

## Description

<p>Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node, not necessarily the exact middle) of a singly linked list, given only access to that node.</p>

<p>&nbsp;</p>

<p><strong>Example: </strong></p>

<pre>
<strong>Input: </strong>the node c from the linked list a-&gt;b-&gt;c-&gt;d-&gt;e-&gt;f
<strong>Output: </strong>nothing is returned, but the new linked list looks like a-&gt;b-&gt;d-&gt;e-&gt;f
</pre>


## Solutions


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



## Related Topics

- [Linked List](https://leetcode.cn//tag/linked-list)

## Similar Questions


