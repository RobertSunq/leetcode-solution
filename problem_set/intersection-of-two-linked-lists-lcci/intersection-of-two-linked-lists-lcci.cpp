
```
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
