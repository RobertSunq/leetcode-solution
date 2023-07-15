
| English | [简体中文](README.md) |

# [剑指 Offer II 067. 最大的异或](https://leetcode.cn//problems/ms70jA/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 最大的异或 (最大的异或)
// @Author: robert.sunq
// @Date: 2023-07-15 23:20:44
// @Runtime: 111 ms
// @Memory: 77.3 MB

class Solution {
    // 理解为 遍历整个树组，找到齐总与当前数 a[i] 31 二进制位上不同的数量最多的数
    // 因为不同的最多，异或出来的结果就越大

    // 使用前缀树的逻辑 来保存数字的最高位到最低位（一个数字 看作 一个31长度的单词，用前缀树来保存已遍历的数字）
    public int findMaximumXOR(int[] nums) {
        // 前缀树
        Trie root = new Trie();
        int res = 0;
        for (int n : nums) {
            root.insert(n);
            // 注意，插入一个数字之后就可以遍历获取结果了， 不需要一次性全部插入在开始遍历
            // 可以从暴力遍历的角度考虑， 只需要当前值 nums[i]  和 nums[0] --- nums[i - 1] 可覆盖所有。 先插入当前数字，避免出现遍历树时出现 空 分支
            res = Math.max(res, root.max(n));
        }
        return res;
    }


    // 只有两个节点的二叉树，注意理解：每个到根节点的路径都表示一个树
    class Trie {
        // 两个空间，表示爆粗 0 1 即可
        public Trie[] next;

        public Trie() {
            next = new Trie[2];
        }

        // 写入二叉树
        public void insert(int num) {
            Trie node = this;
            for (int i = 30; i>=0; i--) {
                // 从高位开始
                // 左移动对应位数，与 1 与得到最高位的状态
                int bit = num >> i & 1;
                if (node.next[bit] == null) {
                    node.next[bit] = new Trie();
                }
                node = node.next[bit];
            }
        }

        // 找出与当前数字 异或 最大的结果
        public int max(int num) {
            // 此时前缀树中保存着已遍历的所有树
            Trie node = this;
            int max = 0; // 均时正数，所以 最小值是 0
            for (int i = 30; i>= 0; i--) {
                int bit = num >> i & 1;

                // 由于是异或，所以如果待处理数字该位是 1  ， 则需要取找 当前位是 0 的来保证 整体的异或最大。当然如果不存在，则走相同位
                int index = bit == 0 ? 1 : 0;
                if (node.next[index] != null) {
                    // 计算异或的结果，从高位遍历，所以当前结果 右移 +  1 
                    max = max * 2 + 1;
                    node = node.next[index];
                } else {
                    max = max * 2 + 0;
                    node = node.next[bit];
                }
            }
            return max;
        }
        
    }
}
```



## Related Topics

- [Bit Manipulation](https://leetcode.cn//tag/bit-manipulation)
- [Trie](https://leetcode.cn//tag/trie)
- [Array](https://leetcode.cn//tag/array)
- [Hash Table](https://leetcode.cn//tag/hash-table)

## Similar Questions


