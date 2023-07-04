
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 043. 往完全二叉树添加节点](https://leetcode.cn//problems/NaqhDT/)

## 题目描述

<p>完全二叉树是每一层（除最后一层外）都是完全填充（即，节点数达到最大，第 <code>n</code> 层有 <code>2<sup>n-1</sup></code>&nbsp;个节点）的，并且所有的节点都尽可能地集中在左侧。</p>

<p>设计一个用完全二叉树初始化的数据结构&nbsp;<code>CBTInserter</code>，它支持以下几种操作：</p>

<ul>
	<li><code>CBTInserter(TreeNode root)</code>&nbsp;使用根节点为&nbsp;<code>root</code>&nbsp;的给定树初始化该数据结构；</li>
	<li><code>CBTInserter.insert(int v)</code>&nbsp; 向树中插入一个新节点，节点类型为 <code>TreeNode</code>，值为 <code>v</code> 。使树保持完全二叉树的状态，<strong>并返回插入的新节点的父节点的值</strong>；</li>
	<li><code>CBTInserter.get_root()</code> 将返回树的根节点。</li>
</ul>

<p>&nbsp;</p>

<ol>
</ol>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>inputs = [&quot;CBTInserter&quot;,&quot;insert&quot;,&quot;get_root&quot;], inputs = [[[1]],[2],[]]
<strong>输出：</strong>[null,1,[1,2]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>inputs = [&quot;CBTInserter&quot;,&quot;insert&quot;,&quot;insert&quot;,&quot;get_root&quot;], inputs = [[[1,2,3,4,5,6]],[7],[8],[]]
<strong>输出：</strong>[null,3,4,[1,2,3,4,5,6,7,8]]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>最初给定的树是完全二叉树，且包含&nbsp;<code>1</code>&nbsp;到&nbsp;<code>1000</code>&nbsp;个节点。</li>
	<li>每个测试用例最多调用&nbsp;<code>CBTInserter.insert</code>&nbsp; 操作&nbsp;<code>10000</code>&nbsp;次。</li>
	<li>给定节点或插入节点的每个值都在&nbsp;<code>0</code>&nbsp;到&nbsp;<code>5000</code>&nbsp;之间。</li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 919&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/complete-binary-tree-inserter/">https://leetcode-cn.com/problems/complete-binary-tree-inserter/</a></p>


## 题解


### Java

```Java
// @Title: 往完全二叉树添加节点 (往完全二叉树添加节点)
// @Author: robert.sunq
// @Date: 2023-07-04 23:02:46
// @Runtime: 14 ms
// @Memory: 42.4 MB

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class CBTInserter {

    Queue<TreeNode> q;
    TreeNode root;
    int n;

    public CBTInserter(TreeNode root) {
        this.q = new ArrayDeque<>();
        this.n = 0;
        TreeNode p;
        TreeNode left, right;
        this.n++;
        q.add(root);
        this.root = root;
        // 广度遍历，遍历每一层
        while (!q.isEmpty()) {
            p = q.peek();
            left = p.left;
            right = p.right;
            // 将一个节点的左右子节点添加到队列
            if (left != null) {
                q.add(left);
                n++;
            }
            if (right != null) {
                q.add(right);
                n++;
            }
            // 左右子节点都有值，表示当前父节点是一个完全节点，可以抛出
            if (left != null && right != null) {
                q.remove();
            }
            // 存在一个子节点为空，则证明是最后一个需要遍历的父节点，同时该父节点不完全
            if (left == null || right == null) {
                break;
            }
        }
    }
    
    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        TreeNode p = q.peek();
        q.add(node);
        if (p.left == null) {
            p.left = node;
            return p.val;
        } else {
            p.right = node;
            // 添加右枝之后，就是完全节点，可以抛出当前父节点了
            q.remove();
        }
        return p.val;
    }
    
    public TreeNode get_root() {
        return this.root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */
```



## 相关话题

- [树](https://leetcode.cn//tag/tree)
- [广度优先搜索](https://leetcode.cn//tag/breadth-first-search)
- [设计](https://leetcode.cn//tag/design)
- [二叉树](https://leetcode.cn//tag/binary-tree)

## 相似题目



