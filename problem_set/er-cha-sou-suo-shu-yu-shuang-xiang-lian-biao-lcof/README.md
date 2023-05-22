
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 36. 二叉搜索树与双向链表](https://leetcode.cn//problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/)

## 题目描述

<p>输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。</p>

<p>&nbsp;</p>

<p>为了让您更好地理解问题，以下面的二叉搜索树为例：</p>

<p>&nbsp;</p>

<p><img src="https://assets.leetcode.com/uploads/2018/10/12/bstdlloriginalbst.png"></p>

<p>&nbsp;</p>

<p>我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。</p>

<p>下图展示了上面的二叉搜索树转化成的链表。&ldquo;head&rdquo; 表示指向链表中有最小元素的节点。</p>

<p>&nbsp;</p>

<p><img src="https://assets.leetcode.com/uploads/2018/10/12/bstdllreturndll.png"></p>

<p>&nbsp;</p>

<p>特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。</p>

<p>&nbsp;</p>

<p><strong>注意：</strong>本题与主站 426 题相同：<a href="https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/">https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/</a></p>

<p><strong>注意：</strong>此题对比原题有改动。</p>


## 题解


### Java

```Java
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
```



## 相关话题

- [栈](https://leetcode.cn//tag/stack)
- [树](https://leetcode.cn//tag/tree)
- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [二叉搜索树](https://leetcode.cn//tag/binary-search-tree)
- [链表](https://leetcode.cn//tag/linked-list)
- [二叉树](https://leetcode.cn//tag/binary-tree)
- [双向链表](https://leetcode.cn//tag/doubly-linked-list)

## 相似题目



