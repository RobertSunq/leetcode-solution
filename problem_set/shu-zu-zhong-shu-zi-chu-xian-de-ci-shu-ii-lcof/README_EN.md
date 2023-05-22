
| English | [简体中文](README.md) |

# [剑指 Offer 56 - II. 数组中数字出现的次数 II LCOF](https://leetcode.cn//problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 数组中数字出现的次数 II (数组中数字出现的次数 II LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 18:44:02
// @Runtime: 19 ms
// @Memory: 39.6 MB

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Boolean> mp = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if(mp.containsKey(nums[i])){
                mp.put(nums[i],mp.get(nums[i]) ^ mp.get(nums[i]));
            }else{
                mp.put(nums[i],true);
            }
        }
        for(int i=0;i<nums.length;i++ ){
            if(mp.get(nums[i])) return nums[i];
        }
        return -1;
    }
}
```



## Related Topics

- [Bit Manipulation](https://leetcode.cn//tag/bit-manipulation)
- [Array](https://leetcode.cn//tag/array)

## Similar Questions


