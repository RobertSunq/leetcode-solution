
```
// @Title: 填充每个节点的下一个右侧节点指针 II (Populating Next Right Pointers in Each Node II)
// @Author: robert.sunq
// @Date: 2023-11-03 21:28:23
// @Runtime: 1 ms
// @Memory: 42 MB

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null ) {
            return root;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        Node p;
        Node prv;
        while (!queue.isEmpty()) {
            prv = queue.peek();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                p = queue.poll();
                prv.next = p;
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
                prv = p;
            }
            prv.next = null;
        }

        return root;

    }
}
