
```
// @Title: 返回倒数第 k 个节点 (Kth Node From End of List LCCI)
// @Author: robert.sunq
// @Date: 2020-03-25 21:30:51
// @Runtime: 4 ms
// @Memory: 9.9 MB

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
    int kthToLast(ListNode* head, int k) {
        int i=0;
        ListNode *p =  head;
        ListNode *q = head;
        while(p != NULL){
            if(i<k){
                p = p->next;
            }
            else{
                p = p->next;
                q = q->next;
            }
            i++;
        }
        if(i <k) return -1;
        else return q->val;

    }
};
