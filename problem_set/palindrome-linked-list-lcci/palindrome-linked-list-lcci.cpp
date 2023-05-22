
```
// @Title: 回文链表 (Palindrome Linked List LCCI)
// @Author: robert.sunq
// @Date: 2020-03-26 00:16:51
// @Runtime: 40 ms
// @Memory: 15.4 MB

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
    bool isPalindrome(ListNode* head) {
        ListNode *pHead = new ListNode(-1);
        ListNode *pre ,*p = head;
        //pHead->next = head;
        if(head == NULL) return true;
        int counts= 0;
        while(p!= NULL){
            ListNode *q = new ListNode(p->val);
            q->next = pHead->next;
            pHead->next = q;
            p = p ->next;
            counts++;
        }
        p = head;
        pHead = pHead->next;
        for(int i=0;i<counts/2;i++){
            
            if(p->val != pHead->val) return false;
            p = p->next;
            pHead = pHead->next;
        }
        return true;



    }
};
