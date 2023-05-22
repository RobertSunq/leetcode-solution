
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 37. 序列化二叉树](https://leetcode.cn//problems/xu-lie-hua-er-cha-shu-lcof/)

## 题目描述

<p>请实现两个函数，分别用来序列化和反序列化二叉树。</p>

<p>你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。</p>

<p><strong>提示：</strong>输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅&nbsp;<a href="https://support.leetcode-cn.com/hc/kb/article/1567641/">LeetCode 序列化二叉树的格式</a>。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/15/serdeser.jpg" style="width: 442px; height: 324px;" />
<pre>
<strong>输入：</strong>root = [1,2,3,null,null,4,5]
<strong>输出：</strong>[1,2,3,null,null,4,5]
</pre>

<p>&nbsp;</p>

<p>注意：本题与主站 297 题相同：<a href="https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/">https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/</a></p>


## 题解


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



## 相关话题

- [树](https://leetcode.cn//tag/tree)
- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [广度优先搜索](https://leetcode.cn//tag/breadth-first-search)
- [设计](https://leetcode.cn//tag/design)
- [字符串](https://leetcode.cn//tag/string)
- [二叉树](https://leetcode.cn//tag/binary-tree)

## 相似题目



