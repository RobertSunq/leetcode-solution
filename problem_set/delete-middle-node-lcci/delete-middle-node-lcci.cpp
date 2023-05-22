
```
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
