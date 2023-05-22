
| English | [简体中文](README.md) |

# [剑指 Offer 59 - I. 滑动窗口的最大值 LCOF](https://leetcode.cn//problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


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



## Related Topics

- [Queue](https://leetcode.cn//tag/queue)
- [Sliding Window](https://leetcode.cn//tag/sliding-window)
- [Monotonic Queue](https://leetcode.cn//tag/monotonic-queue)
- [Heap (Priority Queue)](https://leetcode.cn//tag/heap-priority-queue)

## Similar Questions


