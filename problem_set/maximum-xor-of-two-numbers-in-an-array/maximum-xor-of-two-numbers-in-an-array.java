
```
// @Title: 数组中两个数的最大异或值 (Maximum XOR of Two Numbers in an Array)
// @Author: robert.sunq
// @Date: 2023-11-04 20:35:22
// @Runtime: 354 ms
// @Memory: 110.8 MB

class Solution {
    
    // 字典树的根节点
    Trie root = new Trie();

    static final int HiGH_BIT = 30;

    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        int x = 0;

        for (int i = 1; i < n; i++) {
            add(nums[i - 1]);
            x = Math.max(x, check(nums[i]));
        }
        return x;
    }

    // 将数字，按照每位是 0 还是 1 放入到前缀树中
    public void add(int num) {
        Trie p = root;
        for (int k = HiGH_BIT; k >= 0; k--) {
            int bit = (num >> k) & 1;
            if (bit == 0) {
                if (p.left == null) {
                    p.left = new Trie();
                }
                p = p.left;
            } else {
                if (p.right == null) {
                    p.right = new Trie();
                }
                p = p.right;
            }
        }
    }

    // 从前缀树中找到可用与 num 进行 异或而最大的数字，  即根据 num 当前位是 0 还是 1来判断走那个支路
    // 注意，如果所能最大的支路没有符合要求的数，需要走另一路。注意 因为 num 也在数中，所有另一路一定不会是null
    // 注意，走到 某个 节点 p 时， 表示数组中存在这个数，
    public int check(int num) {
        Trie p = root;
        int x = 0;

        for (int k = HiGH_BIT; k >= 0; k--) {
            int bit = (num >> k) & 1;
            if (bit == 0) {
                // a_i 的 第 k 个二进制位为 0， 应当往 1的子节点走
                if (p.right != null) {
                    p = p.right;
                    x = x * 2 + 1;
                } else {
                    p = p.left;
                    x = x * 2;
                }
            } else {
                if (p.left != null) {
                    p = p.left;
                    x = x * 2 + 1;
                } else {
                    p = p.right;
                    x = x * 2;
                }
            }
        }

        return x;
    }
}

class Trie {
    // 左子树指向表示0的子节点
    Trie left = null;

    // 右子树指向白哦是1的子节点
    Trie right = null;
}
