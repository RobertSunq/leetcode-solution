
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 004. 只出现一次的数字 ](https://leetcode.cn//problems/WGki4K/)

## 题目描述

<p>给你一个整数数组&nbsp;<code>nums</code> ，除某个元素仅出现 <strong>一次</strong> 外，其余每个元素都恰出现 <strong>三次 。</strong>请你找出并返回那个只出现了一次的元素。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [2,2,3,2]
<strong>输出：</strong>3
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,1,0,1,0,1,100]
<strong>输出：</strong>100
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
	<li><code>nums</code> 中，除某个元素仅出现 <strong>一次</strong> 外，其余每个元素都恰出现 <strong>三次</strong></li>
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？</p>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 137&nbsp;题相同：<a href="https://leetcode-cn.com/problems/single-number-ii/">https://leetcode-cn.com/problems/single-number-ii/</a></p>


## 题解


### Java

```Java
// @Title: 只出现一次的数字  (只出现一次的数字 )
// @Author: robert.sunq
// @Date: 2023-05-25 23:44:04
// @Runtime: 3 ms
// @Memory: 42.9 MB

class Solution {
    public int singleNumber(int[] nums) {
        // DFA 的解法有点不太懂，不太好理解， DFA 的解法 放到Cpp中
        // 这里来计数字二进制后，每个位上数字的和对三取余， 预留下来的就是只出现一次的数字在该位置上的数值
        // 主要是注意下对符号位的理解， 
        int[] cnt = new int[32];
        for (int x : nums) {
            for (int i = 0; i < 32; i++) {
                // 采用直接位移 并且 & 1 判断该位是不是 1
                // 因为 -3 > 1 = -2,  即  -3 % 2 = -1
                if (((x >> i) & 1) == 1) {
                    cnt[i]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            // 直接左移到符号位即可
            if ((cnt[i] % 3 & 1) == 1) {
                ans += (1 << i);
            }
        }
        return ans;
    }
}
```



### C++

```C++
// @Title: 只出现一次的数字  (只出现一次的数字 )
// @Author: robert.sunq
// @Date: 2023-05-25 23:50:15
// @Runtime: 8 ms
// @Memory: 9.3 MB

class Solution {
public:
    int singleNumber(vector<int>& nums) {
        // DFS 参考 官方答案解析 https://leetcode.cn/problems/WGki4K/solution/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-0vrt/
        // 数字电路设计, 不过我已经忘完了。
        int a = 0, b = 0;
        for (int num: nums) {
            b = ~a & (b ^ num);
            a = ~b & (a ^ num);
            // 未简化之前或者，tie(a, b) = pair{(~a & b & num) | (a & ~b & ~num), ~a & (b ^ num)};
        }
        return b;
    }
};
```



## 相关话题

- [位运算](https://leetcode.cn//tag/bit-manipulation)
- [数组](https://leetcode.cn//tag/array)

## 相似题目



