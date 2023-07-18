
| English | [简体中文](README.md) |

# [剑指 Offer II 076. 数组中的第 k 大的数字](https://leetcode.cn//problems/xx4gT2/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 数组中的第 k 大的数字 (数组中的第 k 大的数字)
// @Author: robert.sunq
// @Date: 2023-07-18 23:29:35
// @Runtime: 6 ms
// @Memory: 41.6 MB

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>();
        for (int n : nums) {
            q.offer(n);
        }

        int n = nums.length;
        while (n-- > k) {
            q.poll();
        }

        return q.peek();
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Divide and Conquer](https://leetcode.cn//tag/divide-and-conquer)
- [Quickselect](https://leetcode.cn//tag/quickselect)
- [Sorting](https://leetcode.cn//tag/sorting)
- [Heap (Priority Queue)](https://leetcode.cn//tag/heap-priority-queue)

## Similar Questions


