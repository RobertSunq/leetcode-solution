
| English | [简体中文](README.md) |

# [剑指 Offer II 009. 乘积小于 K 的子数组](https://leetcode.cn//problems/ZVAVXX/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 乘积小于 K 的子数组 (乘积小于 K 的子数组)
// @Author: robert.sunq
// @Date: 2023-06-06 00:06:30
// @Runtime: 4 ms
// @Memory: 44.8 MB

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int prod = 1;
        int ans = 0;
        int i = 0;
        for (int j = 0; j < n; j++){
            prod = prod * nums[j];
            while(i <= j && prod >= k) {
                prod = prod / nums[i];
                i++;
            }
            ans = ans + (j - i) + 1;
        }
        return ans;
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Sliding Window](https://leetcode.cn//tag/sliding-window)

## Similar Questions


