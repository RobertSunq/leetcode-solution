
| English | [简体中文](README.md) |

# [剑指 Offer II 048. 序列化与反序列化二叉树](https://leetcode.cn//problems/h54YBf/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 序列化与反序列化二叉树 (序列化与反序列化二叉树)
// @Author: robert.sunq
// @Date: 2023-07-06 22:14:24
// @Runtime: 99 ms
// @Memory: 45 MB

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
        return rserialize(root, "");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        List<String> list = new LinkedList<String>(Arrays.asList(arr));
        return rdeserialize(list);
    }


    // dfs
    private String rserialize(TreeNode root, String str) {
        if (root == null) {
            return str + "null,";
        }
        str = str + String.valueOf(root.val) + ",";
        str = rserialize(root.left, str);
        str = rserialize(root.right, str);

        return str;
    }

    private TreeNode rdeserialize(List<String> list) {
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }

        // dfs 注意和序列化时一样的 先序
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        // 注意，及时删除已经反序列化的节点
        list.remove(0);
        root.left = rdeserialize(list);
        root.right = rdeserialize(list);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
```



## Related Topics

- [Tree](https://leetcode.cn//tag/tree)
- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Breadth-First Search](https://leetcode.cn//tag/breadth-first-search)
- [Design](https://leetcode.cn//tag/design)
- [String](https://leetcode.cn//tag/string)
- [Binary Tree](https://leetcode.cn//tag/binary-tree)

## Similar Questions


