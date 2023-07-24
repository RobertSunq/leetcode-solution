
| English | [简体中文](README.md) |

# [剑指 Offer II 085. 生成匹配的括号](https://leetcode.cn//problems/IDBivT/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 生成匹配的括号 (生成匹配的括号)
// @Author: robert.sunq
// @Date: 2023-07-24 22:41:35
// @Runtime: 0 ms
// @Memory: 40.5 MB

class Solution {
    public List<String> generateParenthesis(int n) {

        int rightCount = n;
        int leftCount = n;
        List<String> ans = new ArrayList<>();
        StringBuilder str = new StringBuilder();

        dfs(ans, str, rightCount, leftCount);
        return ans;
    }


    private void dfs(List<String> ans, StringBuilder str, int leftCount, int rightCount) {
        // 左右括号都消耗完了
        if (leftCount == 0 && rightCount == 0) {
            ans.add(str.toString());
            return;
        }


        // 左括号没有消耗完，选择消耗
        if (leftCount > 0 ) {
            str.append("(");
            dfs(ans, str, leftCount - 1, rightCount);
            // 恢复
            str.deleteCharAt(str.length() - 1);
        }

        // 如果右括号大于左括号，可以选择消耗右括号
        if (rightCount > 0 && rightCount > leftCount) {
            str.append(")");
            dfs(ans, str, leftCount, rightCount - 1);
            str.deleteCharAt(str.length() - 1);
        }

    }
}
```



## Related Topics

- [String](https://leetcode.cn//tag/string)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)
- [Backtracking](https://leetcode.cn//tag/backtracking)

## Similar Questions


