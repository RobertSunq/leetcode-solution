
```
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
