
| English | [简体中文](README.md) |

# [剑指 Offer 48. 最长不含重复字符的子字符串 LCOF](https://leetcode.cn//problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/)

## Description

English description is not available for the problem. Please switch to Chinese.

## Solutions


### Java

```Java
// @Title: 最长不含重复字符的子字符串 (最长不含重复字符的子字符串 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 00:29:10
// @Runtime: 8 ms
// @Memory: 38.6 MB

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> dict = new HashMap<>();
        // res 最大值， temp 前一个字符串的长度
        int res = 0 ,temp = 0;
        for (int j=0;j<s.length();j++){
            // 字符第一次出现
            if(dict.get(s.charAt(j)) != null){
                // 该字符上次出现的位置
                int i = dict.get(s.charAt(j));
                // 如果两个字符间距大于前一个字符串，则证明前一个字符串的长度不包含 当前字符
                if (temp < (j - i) ){
                    temp = temp+1;
                }else{
                    // 否则 新的长度就是两个相等字符之间的差
                    temp = j-i;
                }
            }else{
                // 不存在时候，字符为出现，
                // 该状态 可以与前面进行合并
                temp = temp +1;
            }
            res = Math.max(res,temp);
            // 更新hash表
            dict.put(s.charAt(j),j);
        }
        return res;
    }
}
```



## Related Topics

- [Hash Table](https://leetcode.cn//tag/hash-table)
- [String](https://leetcode.cn//tag/string)
- [Sliding Window](https://leetcode.cn//tag/sliding-window)

## Similar Questions


