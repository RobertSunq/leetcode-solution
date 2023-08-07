
| English | [简体中文](README.md) |

# [LCR 117. 相似字符串组](https://leetcode.cn//problems/H6lPxb/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 相似字符串组 (相似字符串组)
// @Author: robert.sunq
// @Date: 2023-08-07 22:20:07
// @Runtime: 11 ms
// @Memory: 41.6 MB

class Solution {

    // 记录字符串的索引
    int[] f;

    // 并查集
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        f = new int[n];
        for (int i = 0; i<n; i++) {
            f[i] = i;
        }

        for (int i =0; i<n; i++) {
            for (int j = i+1; j <n; j++) {
                int fi = find(i);
                int fj = find(j);
                // 说明已经是一个并查集了
                if (fi == fj) {
                    continue;
                }

                if (check(strs[i], strs[j], m)) {
                    // 合并并查集
                    f[fj] = fi;
                    // f[fi] = fj;  // 同等的， 不过是将前面的后边到后面的集合， 还是将后面的合并到前面的集合
                }
            }
        }
        int ans = 0;
        for (int i =0; i < n; i++) {
            // 还等于本身索引，说明是集合的根
            if (f[i] == i) {
                ans++;
            }
        }

        return ans;
    }



    public int find(int x) {
        if (f[x] == x) {
            return x;
        }
        f[x] = find(f[x]);
        return f[x];
    }

    private boolean check(String s1, String s2, int len) {
        int num =0;
        for (int i = 0; i< len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                num++;
                if (num > 2) {
                    return false;
                }
            }
        }

        return true;
    }
}
```



## Related Topics

- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Breadth-First Search](https://leetcode.cn//tag/breadth-first-search)
- [Union Find](https://leetcode.cn//tag/union-find)
- [String](https://leetcode.cn//tag/string)

## Similar Questions


