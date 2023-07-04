
```
// @Title: 二叉树每层的最大值 (二叉树每层的最大值)
// @Author: robert.sunq
// @Date: 2023-07-04 23:15:48
// @Runtime: 2 ms
// @Memory: 43 MB

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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new ArrayDeque<>();
        // 记录当前需要遍历的层的节点数
        int n = 1;
        // 记录下一层的节点数
        int nextN = 0;
        q.add(root);
        TreeNode p;
        int min = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            nextN = 0;
            min = Integer.MIN_VALUE;
            while (n-- > 0) {
                p = q.poll();
                min = Math.max(min, p.val);
                if (p.left != null) {
                    q.add(p.left);
                    nextN++;
                }
                if (p.right != null) {
                    q.add(p.right);
                    nextN++;
                }
            }
            ans.add(min);
            n = nextN;
        }

        return ans;

    }
}
