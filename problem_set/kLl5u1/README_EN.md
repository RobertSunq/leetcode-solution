
| English | [简体中文](README.md) |

# [剑指 Offer II 006. 排序数组中两个数字之和](https://leetcode.cn//problems/kLl5u1/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 排序数组中两个数字之和 (排序数组中两个数字之和)
// @Author: robert.sunq
// @Date: 2023-05-29 22:10:21
// @Runtime: 1 ms
// @Memory: 43.5 MB

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = {0, numbers.length - 1};

        while (ans[0] < ans[1]) {
            int tmp = numbers[ans[0]] + numbers[ans[1]];
            if (tmp == target) {
                break;
            } else if (tmp < target) {
                ans[0] = ans[0] + 1;
            } else {
                ans[1] = ans[1] - 1;
            }
        }

        return ans;

    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Two Pointers](https://leetcode.cn//tag/two-pointers)
- [Binary Search](https://leetcode.cn//tag/binary-search)

## Similar Questions


