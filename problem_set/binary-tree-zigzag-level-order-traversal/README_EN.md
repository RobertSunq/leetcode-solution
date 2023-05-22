
| English | [简体中文](README.md) |

# [103. Binary Tree Zigzag Level Order Traversal](https://leetcode.cn//problems/binary-tree-zigzag-level-order-traversal/)

## Description

<p>Given the <code>root</code> of a binary tree, return <em>the zigzag level order traversal of its nodes&#39; values</em>. (i.e., from left to right, then right to left for the next level and alternate between).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/tree1.jpg" style="width: 277px; height: 302px;" />
<pre>
<strong>Input:</strong> root = [3,9,20,null,null,15,7]
<strong>Output:</strong> [[3],[20,9],[15,7]]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = [1]
<strong>Output:</strong> [[1]]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> root = []
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[0, 2000]</code>.</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
</ul>


## Solutions


### C++

```C++
// @Title: 二叉树的锯齿形层序遍历 (Binary Tree Zigzag Level Order Traversal)
// @Author: robert.sunq
// @Date: 2020-05-13 12:21:16
// @Runtime: 0 ms
// @Memory: 11.1 MB

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int> > out;
        int res = 1;
        if (root == NULL) return out;
        stack<TreeNode*> st1,st2;
        st1.push(root);
        while (!st1.empty() || !st2.empty()){
            vector<int> temp;
            if(res%2){
                while(!st1.empty()){
                    TreeNode *p = st1.top();
                    st1.pop();
                    temp.push_back(p->val);
                    if(p->left != NULL) st2.push(p->left);
                    if(p->right != NULL) st2.push(p->right);
                }
                out.push_back(temp);
                res++;

            }
            else{
                 while(!st2.empty()){
                    TreeNode *p = st2.top();
                    st2.pop();
                    temp.push_back(p->val);
                    if(p->right != NULL) st1.push(p->right);
                    if(p->left != NULL) st1.push(p->left);
                    
                }
                out.push_back(temp);
                res++;

            }
        }
        return out;
        
    }
};
```



### Java

```Java
// @Title: 二叉树的锯齿形层序遍历 (Binary Tree Zigzag Level Order Traversal)
// @Author: robert.sunq
// @Date: 2021-06-30 23:22:48
// @Runtime: 1 ms
// @Memory: 38.4 MB

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
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        int deep = 1;
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        List<Integer> temp = new ArrayList<>();
        // 下一层的遍历顺序与填入的顺序反向访问  正好可以使用栈的特性
        Stack<TreeNode> st1 = new Stack<>(),st2 = new Stack<>();
        TreeNode p;
        st1.push(root);
        // 奇数层
        while(!st1.isEmpty() || !st2.isEmpty()){
            if(deep %2 == 1){
                // 遍历奇数层
                deep++;
                temp = new ArrayList<>();
                while(!st1.isEmpty()){
                    p = st1.pop();
                    temp.add(p.val);
                    // 下一层要从右往左，当前层是从左往右，所有下一层需要 是逆序访问，所有先放入左节点
                    if(p.left != null) st2.push(p.left);
                    if(p.right != null) st2.push(p.right);
                }
                res.add(temp);
            }else{
                // 遍历偶数层
                deep++;
                temp = new ArrayList<>();
                while(!st2.isEmpty()){
                    p = st2.pop();
                    temp.add(p.val);
                    // 下一层要从左往右，当前层是从右往左，所有下一层需要 是逆序访问，所有先放入右节点
                    if(p.right != null) st1.push(p.right);
                    if(p.left != null) st1.push(p.left);
                }
                res.add(temp);
            }

        }
        return res;
    }
}
```



## Related Topics

- [Tree](https://leetcode.cn//tag/tree)
- [Breadth-First Search](https://leetcode.cn//tag/breadth-first-search)
- [Binary Tree](https://leetcode.cn//tag/binary-tree)

## Similar Questions

- [Binary Tree Level Order Traversal](../binary-tree-level-order-traversal/README_EN.md)
