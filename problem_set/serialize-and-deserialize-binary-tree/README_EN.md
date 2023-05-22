
| English | [简体中文](README.md) |

# [297. Serialize and Deserialize Binary Tree](https://leetcode.cn//problems/serialize-and-deserialize-binary-tree/)

## Description

<p>Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.</p>

<p>Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.</p>

<p><strong>Clarification:</strong> The input/output format is the same as <a href="https://support.leetcode.com/hc/en-us/articles/360011883654-What-does-1-null-2-3-mean-in-binary-tree-representation-" target="_blank">how LeetCode serializes a binary tree</a>. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/15/serdeser.jpg" style="width: 442px; height: 324px;" />
<pre>
<strong>Input:</strong> root = [1,2,3,null,null,4,5]
<strong>Output:</strong> [1,2,3,null,null,4,5]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = []
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[0, 10<sup>4</sup>]</code>.</li>
	<li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 二叉树的序列化与反序列化 (Serialize and Deserialize Binary Tree)
// @Author: robert.sunq
// @Date: 2021-06-19 00:54:35
// @Runtime: 23 ms
// @Memory: 40.2 MB

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
        if (root == null) return null;
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> qu = new LinkedList<>();
        // 层次遍历
        qu.offer(root);

        while(!qu.isEmpty()){
            TreeNode temp = qu.poll();
            if(temp == null) {
                res.append("null,");
            }else{
                res.append(String.valueOf(temp.val)+",");
                qu.offer(temp.left);
                qu.offer(temp.right);
            }
        }
        String s = res.toString();
        return s.substring(0,s.length()-1);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null) return null;
        // System.out.println(data);
        List<String> res = Arrays.asList(data.split(","));
        Queue<TreeNode> qu = new LinkedList<>();
        int i = 0;
        TreeNode root = new TreeNode(Integer.parseInt(res.get(i++)));
        qu.offer(root);
        while(!qu.isEmpty() && i<res.size()){
            TreeNode p = qu.poll();
            // 左节点
            if(!"null".equals(res.get(i))){
                TreeNode temp = new TreeNode(Integer.parseInt(res.get(i)));
                qu.offer(temp);
                p.left = temp;
            }
            i++;
            // 右节点
            if(!"null".equals(res.get(i))){
                TreeNode temp = new TreeNode(Integer.parseInt(res.get(i)));
                qu.offer(temp);
                p.right = temp;
            }
            i++;
        }

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

- [Encode and Decode Strings](../encode-and-decode-strings/README_EN.md)
- [Serialize and Deserialize BST](../serialize-and-deserialize-bst/README_EN.md)
- [Find Duplicate Subtrees](../find-duplicate-subtrees/README_EN.md)
- [Serialize and Deserialize N-ary Tree](../serialize-and-deserialize-n-ary-tree/README_EN.md)
