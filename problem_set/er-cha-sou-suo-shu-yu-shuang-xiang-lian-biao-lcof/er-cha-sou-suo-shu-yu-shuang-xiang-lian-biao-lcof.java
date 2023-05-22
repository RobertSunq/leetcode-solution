
```
// @Title: 二叉搜索树与双向链表 (二叉搜索树与双向链表  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-28 21:56:32
// @Runtime: 1 ms
// @Memory: 37.8 MB

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        Node head = new Node(0);
        if(root == null) return  null;
        // pre 记录访问的前节点，p为当前节点
        Node pre = head,p=root;
        Stack<Node> st = new Stack<Node>();
        while(!st.isEmpty() || p!= null){
            // 找到最左侧的点
            while(p != null){
                st.push(p);
                p = p.left;
            }
            // 开始访问
            if(!st.isEmpty()){
                p = st.pop();
                Node tempRight = p.right;
                // 前一个点的右子树，指向当前点。
                pre.right = p;
                // 注，由于之前时直接找最左侧的点，可知此时左子树已经保存完毕，可以取缔
                p.left = pre;
                // 为上个节点，此时该节点的右指针为变化
                pre = p;
                // 获取之前暂存的右子树,走向右子树
                p = tempRight;
            }
        }
        // 此时 pre将指向最后的节点
        head.right.left = pre;
        pre.right = head.right;
        return head.right;
    }
}
