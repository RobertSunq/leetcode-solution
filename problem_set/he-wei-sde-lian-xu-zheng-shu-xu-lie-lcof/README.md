
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 57 - II. 和为s的连续正数序列](https://leetcode.cn//problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/)

## 题目描述

<p>输入一个正整数 <code>target</code> ，输出所有和为 <code>target</code> 的连续正整数序列（至少含有两个数）。</p>

<p>序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>target = 9
<strong>输出：</strong>[[2,3,4],[4,5]]
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>target = 15
<strong>输出：</strong>[[1,2,3,4,5],[4,5,6],[7,8]]
</pre>

<p>&nbsp;</p>

<p><strong>限制：</strong></p>

<ul>
	<li><code>1 &lt;= target &lt;= 10^5</code></li>
</ul>

<p>&nbsp;</p>


## 题解


### Java

```Java
// @Title: 和为s的连续正数序列 (和为s的连续正数序列 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 19:42:11
// @Runtime: 3 ms
// @Memory: 36.6 MB

class Solution {
    public int[][] findContinuousSequence(int target) {
        // 滑动窗口左开右闭，
        int i = 1,j = 1;
        // 记录结果
        List<int[]> res = new ArrayList<>();
        int sum = 0; // 滑动窗口中数字的和
        while(i <= target/2){
           if(sum < target){
               sum = sum + j;
               j++;
           } else if (sum > target) {
               sum= sum - i;
               i++;
           } else{
               int[] temp = new int[j-i];
               for (int t = 0;t<(j - i );t++){
                   temp[t] = t+i;
               }
               res.add(temp);
               // 相等也是移动左边界
               sum= sum - i;
               i++;
           }
        }
        return res.toArray(new int[res.size()][]);
    }
}
```



## 相关话题

- [数学](https://leetcode.cn//tag/math)
- [双指针](https://leetcode.cn//tag/two-pointers)
- [枚举](https://leetcode.cn//tag/enumeration)

## 相似题目



