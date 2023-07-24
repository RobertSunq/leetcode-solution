
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 085. 生成匹配的括号](https://leetcode.cn//problems/IDBivT/)

## 题目描述

<p>正整数&nbsp;<code>n</code>&nbsp;代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 <strong>有效的 </strong>括号组合。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 3
<strong>输出：</strong>[&quot;((()))&quot;,&quot;(()())&quot;,&quot;(())()&quot;,&quot;()(())&quot;,&quot;()()()&quot;]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 1
<strong>输出：</strong>[&quot;()&quot;]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 8</code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 22&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/generate-parentheses/">https://leetcode-cn.com/problems/generate-parentheses/</a></p>


## 题解


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



## 相关话题

- [字符串](https://leetcode.cn//tag/string)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)
- [回溯](https://leetcode.cn//tag/backtracking)

## 相似题目



