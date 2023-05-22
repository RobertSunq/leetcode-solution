
```
// @Title: 移除重复节点 (Remove Duplicate Node LCCI)
// @Author: robert.sunq
// @Date: 2020-03-25 00:08:25
// @Runtime: 80 ms
// @Memory: 15 MB

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
    ListNode* removeDuplicateNodes(ListNode* head) {
        map<int,int>mp;
        if(head == NULL) return NULL;
        ListNode*p = head;
        ListNode*pre = head;
        mp[p->val]++;
        p = p->next;
        while(p!=NULL){
            mp[p->val]++;
            if(mp[p->val] > 1) {
                pre->next = p->next;
                //free(p);
                p = pre->next;
            }
            else{
                pre = p;
                p = p->next;
            }
        }
        return head;

    }
};
