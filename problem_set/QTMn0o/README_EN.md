
| English | [简体中文](README.md) |

# [剑指 Offer II 010. 和为 k 的子数组](https://leetcode.cn//problems/QTMn0o/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 和为 k 的子数组 (和为 k 的子数组)
// @Author: robert.sunq
// @Date: 2023-06-06 23:51:29
// @Runtime: 1034 ms
// @Memory: 43.9 MB

class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int[] sums = new int[nums.length + 1];
        sums[0] = 0;
        // sums 中 i 表示前 i 个数的和
        for(int i = 1 ; i < sums.length; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }
        
        // 以每个数字为基准，直接遍历查找和位k的数字
        for (int i = 0; i < sums.length;i++) {
            int target = k + sums[i];
            for ( int j = i+1; j < sums.length; j++) {
                if (target == sums[j]) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Hash Table](https://leetcode.cn//tag/hash-table)
- [Prefix Sum](https://leetcode.cn//tag/prefix-sum)

## Similar Questions


