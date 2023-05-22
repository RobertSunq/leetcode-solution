
| English | [简体中文](README.md) |

# [剑指 Offer 37. 序列化二叉树  LCOF](https://leetcode.cn//problems/xu-lie-hua-er-cha-shu-lcof/)

## Description

English description is not available for the problem. Please switch to Chinese.

## Solutions


### Java

```Java
// @Title: 序列化二叉树 (序列化二叉树  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-28 22:54:40
// @Runtime: 21 ms
// @Memory: 41.2 MB

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        if (root == null) return res.toString();
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        TreeNode p = root;
        res.append(String.valueOf(root.val)+",");
        while( !qu.isEmpty()){
            for(int i= qu.size();i>0;i--){
                p = qu.poll();
                // 将下一列放入结果集
                if(p.left == null){
                    res.append("null,");
                } else{
                    res.append(String.valueOf(p.left.val)+",");
                    qu.offer(p.left);
                }
                if(p.right == null){
                    res.append("null,");
                } else{
                    res.append(String.valueOf(p.right.val)+",");
                    qu.offer(p.right);
                }
            }
        }

        String s = res.toString();
        return s.substring(0,s.length()-1);
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()<=0) return null;
        List<String> list = Arrays.asList(data.split(","));
        Queue<TreeNode> qu = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        int i = 1;
        qu.offer(root);
        while (!qu.isEmpty() && i<list.size()){
            TreeNode p = qu.poll();
            // 左节点
            if(!"null".equals(list.get(i))){
                TreeNode temp = new TreeNode(Integer.parseInt(list.get(i)));
                qu.offer(temp);
                p.left = temp;
            }
            i++;
            // 右节点
            if(!"null".equals(list.get(i))){
                TreeNode temp = new TreeNode(Integer.parseInt(list.get(i)));
                qu.offer(temp);
                p.right = temp;
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
```



## Related Topics

- [Tree](https://leetcode.cn//tag/tree)
- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Breadth-First Search](https://leetcode.cn//tag/breadth-first-search)
- [Design](https://leetcode.cn//tag/design)
- [String](https://leetcode.cn//tag/string)
- [Binary Tree](https://leetcode.cn//tag/binary-tree)

## Similar Questions


