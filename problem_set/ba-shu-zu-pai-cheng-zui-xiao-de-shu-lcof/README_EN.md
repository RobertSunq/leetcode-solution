
| English | [简体中文](README.md) |

# [剑指 Offer 45. 把数组排成最小的数 LCOF](https://leetcode.cn//problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/)

## Description

English description is not available for the problem. Please switch to Chinese.

## Solutions


### Java

```Java
// @Title: 把数组排成最小的数 (把数组排成最小的数 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-29 21:48:12
// @Runtime: 7 ms
// @Memory: 38 MB

class Solution {
    public String minNumber(int[] nums) {
        String[] num = new String[nums.length];
        for (int i=0;i<nums.length;i++){
            num[i] = String.valueOf(nums[i]);
        }
        quickSort(num,0,num.length-1);
        StringBuilder res = new StringBuilder();
        for(int i=0;i<num.length;i++){
            res.append(num[i]);
        }
        return res.toString();

    }

    void quickSort(String[] num,int left,int right){
        int i = left,j = right;
        if (left >= right) return;
        // 哨兵
        String temp = num[left];
        while(i < j){
            // 找到第一个“大于”哨兵的值
            while(i<j && compare(num[j],temp)) j--;
            if(i <j){
                num[i] = num[j];
                i++;
            }
            // 找到第小个“大于”哨兵的值
            while(i<j && !compare(num[i],temp)) i++;
            if(i <j){
                num[j] = num[i];
                j--;
            }
        }
        num[i] = temp;
        quickSort(num,left,i-1);
        quickSort(num,i+1,right);

    }

    // true 大， false 小
    boolean compare(String a,String b){
        long am = Long.parseLong(a+b);
        long bm = Long.parseLong(b+a);
        // 及 A 在前 大于 B 在前
        if(am >= bm) return true;
        return false;
    }
}
```



## Related Topics

- [Greedy](https://leetcode.cn//tag/greedy)
- [String](https://leetcode.cn//tag/string)
- [Sorting](https://leetcode.cn//tag/sorting)

## Similar Questions


