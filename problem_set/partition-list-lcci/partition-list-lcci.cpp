
```
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
