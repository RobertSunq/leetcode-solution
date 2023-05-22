
```
// @Title: 复杂链表的复制 (复杂链表的复制  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-28 00:03:19
// @Runtime: 4 ms
// @Memory: 38.4 MB

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node p = head;
        Node nhead = new Node(0);
        Node np = nhead;
        LinkedList<Node> temp = new  LinkedList<>();
        LinkedList<Node> ntemp =new  LinkedList<>();
        while(p != null) {
            np.next = new Node(p.val);
            temp.add(p);
            p = p.next;
            np = np.next;
            ntemp.add(np);
        }
        p = head;
        np = nhead.next;
        while(p != null){
            int index = temp.indexOf(p.random);
            if(index >= 0) np.random = ntemp.get(index);
            p = p.next;
            np = np.next;
        }
        return nhead.next;
    }
}
