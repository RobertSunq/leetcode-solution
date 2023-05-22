
| English | [简体中文](README.md) |

# [剑指 Offer 03. 数组中重复的数字 LCOF](https://leetcode.cn//problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 数组中重复的数字 (数组中重复的数字 LCOF)
// @Author: robert.sunq
// @Date: 2023-02-02 22:35:05
// @Runtime: 0 ms
// @Memory: 48.4 MB

class Solution {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            int index = nums[i];
             if (i == index){
                continue;
            }
            if (nums[index] == index){
                return index;
            }
            int tmp = nums[index];
            nums[index] = index;
            nums[i] = tmp;
            i--;
        }
        return -1;
    }
}
```



### C++

```C++
// @Title: 数组中重复的数字 (数组中重复的数字 LCOF)
// @Author: robert.sunq
// @Date: 2020-03-21 14:46:52
// @Runtime: 88 ms
// @Memory: 29.5 MB

class Solution {
public:
    int findRepeatNumber(vector<int>& nums) {
        int len = nums.size();
        map<int ,int> mp;
        for(int i=0;i<len;i++){
            mp[nums[i]]++;
            if(mp[nums[i]] > 1) return nums[i];
        }
        return -1;
        

    }
};
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Hash Table](https://leetcode.cn//tag/hash-table)
- [Sorting](https://leetcode.cn//tag/sorting)

## Similar Questions


