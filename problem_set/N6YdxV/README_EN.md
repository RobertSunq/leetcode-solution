
| English | [简体中文](README.md) |

# [剑指 Offer II 068. 查找插入位置](https://leetcode.cn//problems/N6YdxV/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 查找插入位置 (查找插入位置)
// @Author: robert.sunq
// @Date: 2023-07-16 21:54:18
// @Runtime: 0 ms
// @Memory: 42.3 MB

class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int tmp = 0;
        while (start <= end) {
            tmp = (start + end) /2;
            if (nums[tmp] == target) {
                return tmp;
            } else if (nums[tmp] > target) {
                end = tmp - 1;
            } else {
                start = tmp + 1;
            }
        }

        // 注意这里，
        // 如果 target 不在数组中，此时，start 指针和 end 指针就会相遇。因此，最终我们只用考虑 target 插入的位置和 middle 的关系即可
        return nums[tmp] < target ? tmp + 1: tmp;

    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Binary Search](https://leetcode.cn//tag/binary-search)

## Similar Questions


