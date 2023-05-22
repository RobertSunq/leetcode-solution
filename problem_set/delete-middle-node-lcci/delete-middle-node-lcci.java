
```
// @Title: 删除中间节点 (Delete Middle Node LCCI)
// @Author: robert.sunq
// @Date: 2021-08-02 22:11:57
// @Runtime: 0 ms
// @Memory: 37.9 MB

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
