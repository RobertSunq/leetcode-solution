
| English | [简体中文](README.md) |

# [剑指 Offer 39. 数组中出现次数超过一半的数字  LCOF](https://leetcode.cn//problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/)

## Description

English description is not available for the problem. Please switch to Chinese.

## Solutions


### Java

```Java
// @Title: 数组中出现次数超过一半的数字 (数组中出现次数超过一半的数字  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-28 00:15:06
// @Runtime: 1 ms
// @Memory: 41.7 MB

class Solution {
    public int majorityElement(int[] nums) {
        int num = nums[0];
        int n=0;
        for(int i =0;i<nums.length;i++){
            if  (n == 0){
                num = nums[i];
                n++;
            }else{
                if(nums[i] == num) n++;
                else n-- ;
            }
            
        }
        return num;
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Hash Table](https://leetcode.cn//tag/hash-table)
- [Divide and Conquer](https://leetcode.cn//tag/divide-and-conquer)
- [Counting](https://leetcode.cn//tag/counting)
- [Sorting](https://leetcode.cn//tag/sorting)

## Similar Questions


