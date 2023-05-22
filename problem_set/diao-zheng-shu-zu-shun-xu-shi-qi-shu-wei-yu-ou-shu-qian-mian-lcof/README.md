
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 21. 调整数组顺序使奇数位于偶数前面](https://leetcode.cn//problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/)

## 题目描述

<p>输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>nums =&nbsp;[1,2,3,4]
<strong>输出：</strong>[1,3,2,4] 
<strong>注：</strong>[3,1,2,4] 也是正确的答案之一。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>0 &lt;= nums.length &lt;= 50000</code></li>
	<li><code>0 &lt;= nums[i] &lt;= 10000</code></li>
</ol>


## 题解


### Java

```Java
// @Title: 调整数组顺序使奇数位于偶数前面 (调整数组顺序使奇数位于偶数前面 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-26 22:18:33
// @Runtime: 3 ms
// @Memory: 46.4 MB

class Solution {
    public int[] exchange(int[] nums) {
        int pre = 0,i = 0;
        // 不论pre所指位置为奇偶 最后再两个的分界线上，所以不需要过多考虑，直接交换即可
        while(i<nums.length && pre < nums.length) {
            if( (nums[i] % 2) == 1 ){
                int temp = nums[pre];
                nums[pre] = nums[i];
                nums[i] = temp;
                pre ++;
            }
            i++;
        }
        return nums;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [双指针](https://leetcode.cn//tag/two-pointers)
- [排序](https://leetcode.cn//tag/sorting)

## 相似题目



