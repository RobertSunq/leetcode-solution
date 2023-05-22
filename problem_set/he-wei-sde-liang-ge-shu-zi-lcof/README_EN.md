
| English | [简体中文](README.md) |

# [剑指 Offer 57. 和为s的两个数字 LCOF](https://leetcode.cn//problems/he-wei-sde-liang-ge-shu-zi-lcof/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 和为s的两个数字 (和为s的两个数字 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 19:18:06
// @Runtime: 2 ms
// @Memory: 55.2 MB

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0,j = nums.length-1;
        while(i < j && (nums[i]+nums[j] != target) ){
            int sum = nums[i]+nums[j];
            if(sum > target) j--;
            else if(sum < target) i++;
            else{
                break;
            }
        }
        if (i < j) return new int[]{nums[i],nums[j]};
        return new int[0];
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Two Pointers](https://leetcode.cn//tag/two-pointers)
- [Binary Search](https://leetcode.cn//tag/binary-search)

## Similar Questions


