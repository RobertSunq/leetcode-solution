
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 59 - I. 滑动窗口的最大值](https://leetcode.cn//problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/)

## 题目描述

<p>给定一个数组 <code>nums</code> 和滑动窗口的大小 <code>k</code>，请找出所有滑动窗口里的最大值。</p>

<p><strong>示例:</strong></p>

<pre>
<strong>输入:</strong> <em>nums</em> = <code>[1,3,-1,-3,5,3,6,7]</code>, 和 <em>k</em> = 3
<strong>输出: </strong><code>[3,3,5,5,6,7] 
<strong>解释: 
</strong></code>
  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<p>你可以假设 <em>k </em>总是有效的，在输入数组&nbsp;<strong>不为空&nbsp;</strong>的情况下，<code>1 ≤ k ≤&nbsp;nums.length</code>。</p>

<p>注意：本题与主站 239 题相同：<a href="https://leetcode-cn.com/problems/sliding-window-maximum/">https://leetcode-cn.com/problems/sliding-window-maximum/</a></p>


## 题解


### Java

```Java
// @Title: 滑动窗口的最大值 (滑动窗口的最大值 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 21:05:52
// @Runtime: 2 ms
// @Memory: 46.3 MB

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int maxNum = Integer.MIN_VALUE;
        if(nums.length < 1) return new int[0];
        int[] res = new int[nums.length - k + 1];
        int j = 0;
        while(j<k){
            maxNum = Math.max(nums[j],maxNum);
            j++;
        }
        int i = 0;
        res[i] = maxNum;
        while(j<nums.length){
            i++;
            if(nums[j] >= maxNum){
                maxNum = nums[j];
            }else{
                if(nums[i-1] >= maxNum){
                    maxNum = Integer.MIN_VALUE;
                    for(int t=i;t<=j;t++){
                        maxNum = Math.max(maxNum,nums[t]);
                    }
                }
            }
            res[i] = maxNum;
            j++;
        }
        return res;
    }
}
```



## 相关话题

- [队列](https://leetcode.cn//tag/queue)
- [滑动窗口](https://leetcode.cn//tag/sliding-window)
- [单调队列](https://leetcode.cn//tag/monotonic-queue)
- [堆（优先队列）](https://leetcode.cn//tag/heap-priority-queue)

## 相似题目



