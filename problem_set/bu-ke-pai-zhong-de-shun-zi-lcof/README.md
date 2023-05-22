
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 61. 扑克牌中的顺子](https://leetcode.cn//problems/bu-ke-pai-zhong-de-shun-zi-lcof/)

## 题目描述

<p>从<strong>若干副扑克牌</strong>中随机抽 <code>5</code> 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre>
<strong>输入:</strong> [1,2,3,4,5]
<strong>输出:</strong> True</pre>

<p>&nbsp;</p>

<p><strong>示例&nbsp;2:</strong></p>

<pre>
<strong>输入:</strong> [0,0,1,2,5]
<strong>输出:</strong> True</pre>

<p>&nbsp;</p>

<p><strong>限制：</strong></p>

<p>数组长度为 5&nbsp;</p>

<p>数组的数取值为 [0, 13] .</p>


## 题解


### Java

```Java
// @Title: 扑克牌中的顺子 (扑克牌中的顺子  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 22:51:27
// @Runtime: 1 ms
// @Memory: 35.8 MB

class Solution {
    public boolean isStraight(int[] nums) {
        // recur(nums,0,nums.length-1);
        int max = 0, min = 14;
        Set<Integer> temp = new HashSet<>();
        for(int i =0;i<nums.length;i++){
            if(nums[i] == 0) continue;
            max = Math.max(nums[i],max);
            min = Math.min(nums[i],min);
            if(temp.contains(nums[i])) return false;
            temp.add(nums[i]);
        }
        return  max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子;
    }

    void recur(int[] nums,int start,int end){
        if(start >= end) return;
        int temp = nums[start];
        int i = start,j = end;
        while(i < j){
            while(i < j && nums[j] >= temp ) j--;
            if(i < j){
                nums[i] = nums[j];
                i++;
            }
            while(i < j && nums[i] <= temp ) i++;
            if(i < j){
                nums[j] = nums[i];
                j--;
            }
            nums[i] = temp;
            
        }
        recur(nums,start,i-1);
        recur(nums,i+1,end);
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [排序](https://leetcode.cn//tag/sorting)

## 相似题目



