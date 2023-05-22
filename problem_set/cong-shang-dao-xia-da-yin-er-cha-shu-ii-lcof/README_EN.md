
| English | [简体中文](README.md) |

# [剑指 Offer 32 - II. 从上到下打印二叉树 II LCOF](https://leetcode.cn//problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/)

## Description

English description is not available for the problem. Please switch to Chinese.

## Solutions


### Java

```Java
// @Title: 从上到下打印二叉树 II (从上到下打印二叉树 II LCOF)
// @Author: robert.sunq
// @Date: 2021-05-27 21:42:35
// @Runtime: 1 ms
// @Memory: 38.1 MB

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            // 该方法时放入一层，直接循环一层。
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
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


