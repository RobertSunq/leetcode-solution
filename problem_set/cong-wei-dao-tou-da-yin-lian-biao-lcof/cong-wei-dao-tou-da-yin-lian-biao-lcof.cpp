
```
// @Title: 从尾到头打印链表 (从尾到头打印链表 LCOF)
// @Author: robert.sunq
// @Date: 2020-03-21 15:26:16
// @Runtime: 8 ms
// @Memory: 10 MB

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
    vector<int> reversePrint(ListNode* head) {
        vector<int> res;
        if(head == NULL) return res;
        while(head!=NULL){
            res.push_back(head->val);
            head = head->next;
        }
        revers(res);
        return res;

    }

protected:
    void    revers(vector<int> &an){
        int len = an.size();
        int i=0;
        int j= len-1;
        while(i<j){
            int temp = an[i];
            an[i] = an[j];
            an[j] = temp;
            i++;
            j--;
        }
        return ;
    }

};
