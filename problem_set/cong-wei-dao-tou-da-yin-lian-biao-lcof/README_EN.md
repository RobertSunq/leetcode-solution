
| English | [简体中文](README.md) |

# [剑指 Offer 06. 从尾到头打印链表 LCOF](https://leetcode.cn//problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>

## Solutions


### Java

```Java
// @Title: 从尾到头打印链表 (从尾到头打印链表 LCOF)
// @Author: robert.sunq
// @Date: 2023-02-05 23:10:11
// @Runtime: 1 ms
// @Memory: 42.4 MB

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        List<Integer> tmpResult = reverse(head);
        int[] result = new int[tmpResult.size()];
        for (int i = 0; i<tmpResult.size(); i++){
            result[i] = tmpResult.get(i);
        }
        return result;
    }

    public List<Integer> reverse(ListNode head) {
        if (head == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> result = reverse(head.next);
        result.add(head.val);
        return result;
    }
}
```



### C++

```C++
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
```



## Related Topics

- [Stack](https://leetcode.cn//tag/stack)
- [Recursion](https://leetcode.cn//tag/recursion)
- [Linked List](https://leetcode.cn//tag/linked-list)
- [Two Pointers](https://leetcode.cn//tag/two-pointers)

## Similar Questions


