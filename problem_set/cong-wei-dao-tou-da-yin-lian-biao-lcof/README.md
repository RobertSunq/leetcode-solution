
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 06. 从尾到头打印链表](https://leetcode.cn//problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/)

## 题目描述

<p>输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>head = [1,3,2]
<strong>输出：</strong>[2,3,1]</pre>

<p>&nbsp;</p>

<p><strong>限制：</strong></p>

<p><code>0 &lt;= 链表长度 &lt;= 10000</code></p>


## 题解


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



## 相关话题

- [栈](https://leetcode.cn//tag/stack)
- [递归](https://leetcode.cn//tag/recursion)
- [链表](https://leetcode.cn//tag/linked-list)
- [双指针](https://leetcode.cn//tag/two-pointers)

## 相似题目



