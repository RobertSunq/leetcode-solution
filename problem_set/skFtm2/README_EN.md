
| English | [简体中文](README.md) |

# [剑指 Offer II 070. 排序数组中只出现一次的数字](https://leetcode.cn//problems/skFtm2/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 排序数组中只出现一次的数字 (排序数组中只出现一次的数字)
// @Author: robert.sunq
// @Date: 2023-07-17 22:20:20
// @Runtime: 0 ms
// @Memory: 41.8 MB

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = left + ((right - left) >> 1);
            // 左侧为偶数个, 
            if (((middle - left) & 1) == 0) {
                // 中间值和左侧相邻相等，则证明结果在左区间
                if (nums[middle] == nums[middle - 1]) {
                    // 注意 保证区间个数为 奇数 个
                    right = middle;
                } else {
                    left = middle;
                }
            } else {
                // 左侧为奇数个
                if (nums[middle] == nums[middle - 1]) {
                    // 结果在右侧区间， 保证区间个数为奇数个
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return nums[left];
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Binary Search](https://leetcode.cn//tag/binary-search)

## Similar Questions


