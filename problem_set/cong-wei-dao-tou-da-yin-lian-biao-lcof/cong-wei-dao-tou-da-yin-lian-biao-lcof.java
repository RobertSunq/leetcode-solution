
```
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
