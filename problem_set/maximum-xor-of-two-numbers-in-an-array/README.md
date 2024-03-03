
| [English](README_EN.md) | 简体中文 |

# [421. 数组中两个数的最大异或值](https://leetcode.cn//problems/maximum-xor-of-two-numbers-in-an-array/)

## 题目描述

<p>给你一个整数数组 <code>nums</code> ，返回<em> </em><code>nums[i] XOR nums[j]</code> 的最大运算结果，其中 <code>0 ≤ i ≤ j &lt; n</code> 。</p>

<p>&nbsp;</p>

<div class="original__bRMd">
<div>
<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [3,10,5,25,2,8]
<strong>输出：</strong>28
<strong>解释：</strong>最大运算结果是 5 XOR 25 = 28.</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [14,70,53,83,49,91,36,80,92,51,66,70]
<strong>输出：</strong>127
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 2 * 10<sup>5</sup></code></li>
	<li><code>0 &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
</ul>
</div>
</div>


## 题解


### Java

```Java
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
```



## 相关话题

- [位运算](https://leetcode.cn//tag/bit-manipulation)
- [字典树](https://leetcode.cn//tag/trie)
- [数组](https://leetcode.cn//tag/array)
- [哈希表](https://leetcode.cn//tag/hash-table)

## 相似题目



