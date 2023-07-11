
| English | [简体中文](README.md) |

# [剑指 Offer II 057. 值和下标之差都在给定的范围内](https://leetcode.cn//problems/7WqeDu/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 值和下标之差都在给定的范围内 (值和下标之差都在给定的范围内)
// @Author: robert.sunq
// @Date: 2023-07-11 22:45:07
// @Runtime: 33 ms
// @Memory: 44 MB

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        if (n < 2 || k == 0) {
            return false;
        }
        // 只保留 [x - t, x + t] 的数据
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < n; i++) {
            // 从排序数组中查找大于或等于的数据。  找到大于下限的数据
            Long tmp = set.ceiling((long) nums[i] - (long) t );
            
            // 找到了，检查数据 是否满足小于上线，否则不符合题意
            if (tmp != null && tmp <= ((long) nums[i] + (long) t)) {
                return true;
            }
            // 没找到，将当前元素放入有序集合
            set.add((long) nums[i]);

            // 当i大于k之后，再放入元素，要同时删除窗口外的数据
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Bucket Sort](https://leetcode.cn//tag/bucket-sort)
- [Ordered Set](https://leetcode.cn//tag/ordered-set)
- [Sorting](https://leetcode.cn//tag/sorting)
- [Sliding Window](https://leetcode.cn//tag/sliding-window)

## Similar Questions


