
| [English](README_EN.md) | 简体中文 |

# [297. 二叉树的序列化与反序列化](https://leetcode.cn//problems/serialize-and-deserialize-binary-tree/)

## 题目描述

<p>序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。</p>

<p>请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。</p>

<p><strong>提示: </strong>输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 <a href="/faq/#binary-tree">LeetCode 序列化二叉树的格式</a>。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/15/serdeser.jpg" style="width: 442px; height: 324px;" />
<pre>
<strong>输入：</strong>root = [1,2,3,null,null,4,5]
<strong>输出：</strong>[1,2,3,null,null,4,5]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>root = []
<strong>输出：</strong>[]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>root = [1]
<strong>输出：</strong>[1]
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>root = [1,2]
<strong>输出：</strong>[1,2]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li>树中结点数在范围 <code>[0, 10<sup>4</sup>]</code> 内</li>
	<li><code>-1000 <= Node.val <= 1000</code></li>
</ul>


## 题解


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



## 相关话题

- [树](https://leetcode.cn//tag/tree)
- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [广度优先搜索](https://leetcode.cn//tag/breadth-first-search)
- [设计](https://leetcode.cn//tag/design)
- [字符串](https://leetcode.cn//tag/string)
- [二叉树](https://leetcode.cn//tag/binary-tree)

## 相似题目


- [字符串的编码与解码](../encode-and-decode-strings/README.md)
- [序列化和反序列化二叉搜索树](../serialize-and-deserialize-bst/README.md)
- [寻找重复的子树](../find-duplicate-subtrees/README.md)
- [序列化和反序列化 N 叉树](../serialize-and-deserialize-n-ary-tree/README.md)
