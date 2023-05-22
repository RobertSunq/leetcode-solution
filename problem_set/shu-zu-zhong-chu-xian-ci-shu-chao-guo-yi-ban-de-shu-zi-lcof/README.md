
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 39. 数组中出现次数超过一半的数字](https://leetcode.cn//problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/)

## 题目描述

<p>数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。</p>

<p>&nbsp;</p>

<p>你可以假设数组是非空的，并且给定的数组总是存在多数元素。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre><strong>输入:</strong> [1, 2, 3, 2, 2, 2, 5, 4, 2]
<strong>输出:</strong> 2</pre>

<p>&nbsp;</p>

<p><strong>限制：</strong></p>

<p><code>1 &lt;= 数组长度 &lt;= 50000</code></p>

<p>&nbsp;</p>

<p>注意：本题与主站 169 题相同：<a href="https://leetcode-cn.com/problems/majority-element/">https://leetcode-cn.com/problems/majority-element/</a></p>

<p>&nbsp;</p>


## 题解


### Java

```Java
// @Title: 数组中出现次数超过一半的数字 (数组中出现次数超过一半的数字  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-28 00:15:06
// @Runtime: 1 ms
// @Memory: 41.7 MB

class Solution {
    public int majorityElement(int[] nums) {
        int num = nums[0];
        int n=0;
        for(int i =0;i<nums.length;i++){
            if  (n == 0){
                num = nums[i];
                n++;
            }else{
                if(nums[i] == num) n++;
                else n-- ;
            }
            
        }
        return num;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [哈希表](https://leetcode.cn//tag/hash-table)
- [分治](https://leetcode.cn//tag/divide-and-conquer)
- [计数](https://leetcode.cn//tag/counting)
- [排序](https://leetcode.cn//tag/sorting)

## 相似题目



