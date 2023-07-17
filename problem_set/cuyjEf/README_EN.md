
| English | [简体中文](README.md) |

# [剑指 Offer II 071. 按权重生成随机数](https://leetcode.cn//problems/cuyjEf/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 按权重生成随机数 (按权重生成随机数)
// @Author: robert.sunq
// @Date: 2023-07-17 22:46:59
// @Runtime: 24 ms
// @Memory: 46.8 MB

class Solution {
    int[] preSum;
    Random ran;
    int n;

    public Solution(int[] w) {
        ran = new Random();
        n = w.length;
        preSum = new int[n + 1];
        for (int i = 1; i<= n; i++) {
            preSum[i] = preSum[i - 1] + w[i - 1];
        }
    }
    
    public int pickIndex() {
        int r = ran.nextInt(preSum[n]);
        // 在前缀和数组中，查找随机数，  注意 r 属于前缀和数组中 [a[i - 1], a[i]) ， 是在下标 i 的概率范围
        int a = searchInsert(preSum, r);
        // 注意，返回的是下标
        return a - 1;
    }

    private int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int tmp = 0;
        while (start <= end) {
            tmp = (start + end) /2;
            if (nums[tmp] == target) {
                return tmp + 1;
            } else if (nums[tmp] > target) {
                end = tmp - 1;
            } else {
                start = tmp + 1;
            }
        }
        return nums[tmp] < target ? tmp + 1: tmp;

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Math](https://leetcode.cn//tag/math)
- [Binary Search](https://leetcode.cn//tag/binary-search)
- [Prefix Sum](https://leetcode.cn//tag/prefix-sum)
- [Randomized](https://leetcode.cn//tag/randomized)

## Similar Questions


