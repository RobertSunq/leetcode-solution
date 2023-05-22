
```
// @Title: 环路检测 (Linked List Cycle LCCI)
// @Author: robert.sunq
// @Date: 2020-03-26 16:01:18
// @Runtime: 8 ms
// @Memory: 7.2 MB

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
    ListNode *detectCycle(ListNode *head) {

        ListNode *slow = head,*fast = head;
        while(fast != NULL  && fast->next != NULL){
            slow = slow->next;
            fast = fast->next->next;
            if(fast == slow){
                break;
            }
        }
        if(fast == NULL || fast->next == NULL) return NULL;
        slow = head;
        while(slow != fast){
            slow = slow->next;
            fast = fast->next;
        }
        return fast;
        
    }
};
