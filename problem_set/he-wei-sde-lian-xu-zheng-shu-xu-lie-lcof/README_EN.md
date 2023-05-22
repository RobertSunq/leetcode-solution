
| English | [简体中文](README.md) |

# [剑指 Offer 57 - II. 和为s的连续正数序列 LCOF](https://leetcode.cn//problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 和为s的连续正数序列 (和为s的连续正数序列 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 19:42:11
// @Runtime: 3 ms
// @Memory: 36.6 MB

class Solution {
    public int[][] findContinuousSequence(int target) {
        // 滑动窗口左开右闭，
        int i = 1,j = 1;
        // 记录结果
        List<int[]> res = new ArrayList<>();
        int sum = 0; // 滑动窗口中数字的和
        while(i <= target/2){
           if(sum < target){
               sum = sum + j;
               j++;
           } else if (sum > target) {
               sum= sum - i;
               i++;
           } else{
               int[] temp = new int[j-i];
               for (int t = 0;t<(j - i );t++){
                   temp[t] = t+i;
               }
               res.add(temp);
               // 相等也是移动左边界
               sum= sum - i;
               i++;
           }
        }
        return res.toArray(new int[res.size()][]);
    }
}
```



## Related Topics

- [Math](https://leetcode.cn//tag/math)
- [Two Pointers](https://leetcode.cn//tag/two-pointers)
- [Enumeration](https://leetcode.cn//tag/enumeration)

## Similar Questions


