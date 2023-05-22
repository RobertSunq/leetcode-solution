
| English | [简体中文](README.md) |

# [面试题 02.07. Intersection of Two Linked Lists LCCI](https://leetcode.cn//problems/intersection-of-two-linked-lists-lcci/)

## Description

<p>Given two (singly) linked lists, determine if the two lists intersect. Return the inter&shy; secting node. Note that the intersection is defined based on reference, not value. That is, if the kth node of the first linked list is the exact same node (by reference) as the jth node of the second linked list, then they are intersecting.</p>

<p><strong>Example 1: </strong></p>

<pre>
<strong>Input: </strong>intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
<strong>Output: </strong>Reference of the node with value = 8
<strong>Input Explanation:</strong> The intersected node&#39;s value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.</pre>

<p><strong>Example 2: </strong></p>

<pre>
<strong>Input: </strong>intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
<strong>Output: </strong>Reference of the node with value = 2
<strong>Input Explanation:</strong>&nbsp;The intersected node&#39;s value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.</pre>

<p><strong>Example 3: </strong></p>

<pre>
<strong>Input: </strong>intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
<strong>Output: </strong>null
<strong>Input Explanation:</strong> From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
<strong>Explanation:</strong> The two lists do not intersect, so return null.</pre>

<p><b>Notes:</b></p>

<ul>
	<li>If the two linked lists have no intersection at all, return&nbsp;<code>null</code>.</li>
	<li>The linked lists must retain their original structure after the function returns.</li>
	<li>You may assume there are no cycles anywhere in the entire linked structure.</li>
	<li>Your code should preferably run in O(n) time and use only O(1) memory.</li>
</ul>


## Solutions


### C++

```C++
// @Title: 链表相交 (Intersection of Two Linked Lists LCCI)
// @Author: robert.sunq
// @Date: 2020-03-26 14:33:48
// @Runtime: 60 ms
// @Memory: 14.1 MB

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
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        int lenA = 0,lenB = 0;
        ListNode *pA = headA,*pB = headB;
        while(pA != NULL) {
            lenA++;
            pA = pA->next;
        }
        while(pB != NULL){
            lenB++;
            pB = pB->next;
        }
        int c = lenA - lenB;
       // cout << c;
        pA = headA;
        pB = headB;
        if(c<0){
            pA = headB;
            pB = headA;
            c = lenB-lenA;
        }
        while(pA != NULL && pB!= NULL){
            if(pA == pB) return pA;
            if(c>0) pA = pA->next;
            else {
                pA = pA->next;
                pB = pB->next;
            }
            c--;
        }

        return NULL;
        
        
    }
};
```



### Java

```Java
// @Title: 链表相交 (Intersection of Two Linked Lists LCCI)
// @Author: robert.sunq
// @Date: 2021-08-02 22:54:49
// @Runtime: 1 ms
// @Memory: 41.3 MB

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA != pB){
            pA = (pA == null)? headB:pA.next;
            pB = (pB == null)? headA:pB.next;
        }
        return pA;
    }
}
```



## Related Topics

- [Hash Table](https://leetcode.cn//tag/hash-table)
- [Linked List](https://leetcode.cn//tag/linked-list)
- [Two Pointers](https://leetcode.cn//tag/two-pointers)

## Similar Questions


