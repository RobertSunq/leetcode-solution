
| English | [简体中文](README.md) |

# [剑指 Offer II 020. 回文子字符串的个数](https://leetcode.cn//problems/a7VOhD/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 回文子字符串的个数 (回文子字符串的个数)
// @Author: robert.sunq
// @Date: 2023-06-20 00:09:37
// @Runtime: 11 ms
// @Memory: 43.7 MB

class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int[][] revertCount = new int[n][n];
        int ans = 0;

        // 注意 i 从大到小，j 从小到大，原因在于 [i, j] 的状态 依赖于 [i+1, j-1]。 所以需要先计算出i较大的值，j较小的值
        for (int i=n-1; i>=0; i--) {
            for (int j=i; j<n; j++) {
                if (i==j) {
                    revertCount[i][j] = 1;
                    ans++;
                    continue;
                }
                int tmp = 0;
                if (i + 1 < n && j - 1 >=i ) {
                    // 在 i上的字符等于j上的字符时，看其子串是否为回文字符串
                    if (s.charAt(i) == s.charAt(j)) {
                        // 当然如何j 结束变开始了，那么就是两个字符，时回文串
                        // 否则看子串
                        if (j-1<=i+1 || revertCount[i+1][j-1] == 1) {
                            revertCount[i][j] = 1;
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
```



## Related Topics

- [String](https://leetcode.cn//tag/string)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions


