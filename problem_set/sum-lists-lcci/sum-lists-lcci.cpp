
```
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
