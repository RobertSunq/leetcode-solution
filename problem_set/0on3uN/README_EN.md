
| English | [简体中文](README.md) |

# [剑指 Offer II 087. 复原 IP ](https://leetcode.cn//problems/0on3uN/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 复原 IP  (复原 IP )
// @Author: robert.sunq
// @Date: 2023-07-25 23:08:43
// @Runtime: 4 ms
// @Memory: 40.7 MB

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        List<String> tmp = new ArrayList<>();

        dfs(ans, tmp , s, 0);
        return ans;
    }

    private void dfs(List<String> ans, List<String> tmp, String s, int index) {
        if (tmp.size() == 4 && index  == s.length()) {
            ans.add(String.join(".", tmp));
            return;
        }

        if(tmp.size() > 4 || index == s.length()) {
            return;
        }

        String sub = s.substring(index, index + 1);
        // 如果当前的字符 不能作为 ip 中的一个数字，直接退回
        if (!isNumInIp(sub)) {
            return;
        }

        // 作为一个新数字填入 
        tmp.add(sub);
        dfs(ans, tmp, s, index + 1);
        tmp.remove(tmp.size() - 1);

        // 连接上上一个数字
        if (tmp.size() == 0) {
            return;
        }

        String tmpSt = tmp.get(tmp.size() - 1);
        if (isNumInIp( tmpSt + sub)) {
            
            tmp.set(tmp.size() - 1, tmpSt + sub);
            dfs(ans, tmp, s, index + 1);
            // 恢复现场
            tmp.set(tmp.size() - 1, tmpSt);
        }

    }


    private boolean isNumInIp(String s) {
        if (s == null || s.length() == 0 || s.length() > 3) {
            return false;
        }

        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }

            num = num * 10 + (c - '0');
        }

        if (num > 255) {
            return false;
        }

        // 比较数值和原始字符串长度，来判断首位是不是 0 开头的非一位数字
        return s.length() == String.valueOf(num).length();
    }
}
```



## Related Topics

- [String](https://leetcode.cn//tag/string)
- [Backtracking](https://leetcode.cn//tag/backtracking)

## Similar Questions


