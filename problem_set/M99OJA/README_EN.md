
| English | [简体中文](README.md) |

# [剑指 Offer II 086. 分割回文子字符串](https://leetcode.cn//problems/M99OJA/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 分割回文子字符串 (分割回文子字符串)
// @Author: robert.sunq
// @Date: 2023-07-24 23:22:20
// @Runtime: 23 ms
// @Memory: 54.4 MB

class Solution {

    // 保存 [i,j] 是否是一个回文串
    boolean[][] f;

    List<List<String>> tmp = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    int n;
    public String[][] partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i< n; i++) {
            for (int j = 0; j<n; j++) {
                f[i][j] = true;
            }
        }
        // [i , j] = [i + 1, j - 1] & s[i] == s[j]
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j<n; j++) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }


        dfs(s , 0);

        String[][] res = new String[tmp.size()][];
        for (int i = 0; i < tmp.size(); i++) {
            res[i] = new String[tmp.get(i).size()];
            for (int j = 0; j< tmp.get(i).size(); j++) {
                res[i][j] = tmp.get(i).get(j);
            }
        }

        return res;
    }


    private void dfs(String s, int i) {

        // 处理完所有的字符串，保存结果
        if (i == n) {
            tmp.add(new ArrayList<>(ans));
            return;
        }

        for (int j = i; j < n; j++) {
            // 如果 [i , j] 是回文串，则可以放入结果集， 继续递归 j + 1。
            // 不是则忽略
            if (f[i][j]) {
                ans.add(s.substring(i , j + 1));
                dfs(s, j + 1);
                // 恢复现场
                ans.remove(ans.size() - 1);
            }
        }
    }
}
```



## Related Topics

- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Breadth-First Search](https://leetcode.cn//tag/breadth-first-search)
- [Graph](https://leetcode.cn//tag/graph)
- [Hash Table](https://leetcode.cn//tag/hash-table)

## Similar Questions


