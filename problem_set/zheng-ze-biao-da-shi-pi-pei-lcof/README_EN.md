
| English | [简体中文](README.md) |

# [剑指 Offer 19. 正则表达式匹配 LCOF](https://leetcode.cn//problems/zheng-ze-biao-da-shi-pi-pei-lcof/)

## Description

English description is not available for the problem. Please switch to Chinese.

## Solutions


### Java

```Java
// @Title: 正则表达式匹配 (正则表达式匹配 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-26 22:08:16
// @Runtime: 2 ms
// @Memory: 38.3 MB

class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        // f[i][j] 表示 s的0-i，与怕p的0-j是否匹配
        boolean[][] f = new boolean[n+1][m+1];
        // 注意 0 代表字符串为空
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                //分成空正则和非空正则两种
                if (j == 0) {
                    f[i][j] = i == 0;
                }else{
                    // 非空正则分 * 和 非* 
                    // 采用 -1 是因为， 长为j再字符串中位置为 j-1 ，及当前位置字符是否为 * 
                    if(p.charAt(j-1) != '*') {
                        if(i>0 && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.')){
                            f[i][j] = f[i-1][j-1];
                        }
                    }else{
                        // 不看，及不匹配
                        if(j >= 2){
                            // 注意为 或的关系 意思就是算两次，第一次不看，第二次看为下面的地方  ****** 
                            f[i][j] |= f[i][j-2];
                        }
                        // 看， 及匹配 (相等，和 匹配 . 效果是一样的，转换子问题状态也一致)
                        if(i>=1 && j>=2 && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.')){
                            f[i][j] |= f[i-1][j];
                        }
                    }
                }
            }
        }
        return f[n][m];
    }
}
```



## Related Topics

- [Recursion](https://leetcode.cn//tag/recursion)
- [String](https://leetcode.cn//tag/string)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions


