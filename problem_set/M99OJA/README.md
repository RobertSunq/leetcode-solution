
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 086. 分割回文子字符串](https://leetcode.cn//problems/M99OJA/)

## 题目描述

<p>给定一个字符串 <code>s</code> ，请将 <code>s</code> 分割成一些子串，使每个子串都是 <strong>回文串</strong> ，返回 s 所有可能的分割方案。</p>

<p><meta charset="UTF-8" /><strong>回文串</strong>&nbsp;是正着读和反着读都一样的字符串。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s =<strong> </strong>&quot;google&quot;
<strong>输出：</strong>[[&quot;g&quot;,&quot;o&quot;,&quot;o&quot;,&quot;g&quot;,&quot;l&quot;,&quot;e&quot;],[&quot;g&quot;,&quot;oo&quot;,&quot;g&quot;,&quot;l&quot;,&quot;e&quot;],[&quot;goog&quot;,&quot;l&quot;,&quot;e&quot;]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = &quot;aab&quot;
<strong>输出：</strong>[[&quot;a&quot;,&quot;a&quot;,&quot;b&quot;],[&quot;aa&quot;,&quot;b&quot;]]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = &quot;a&quot;
<strong>输出：</strong>[[&quot;a&quot;]]</pre>

<p>&nbsp;</p>

<p><b>提示：</b></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 16</code></li>
	<li><code>s </code>仅由小写英文字母组成</li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 131&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/palindrome-partitioning/">https://leetcode-cn.com/problems/palindrome-partitioning/</a></p>


## 题解


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



## 相关话题

- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [广度优先搜索](https://leetcode.cn//tag/breadth-first-search)
- [图](https://leetcode.cn//tag/graph)
- [哈希表](https://leetcode.cn//tag/hash-table)

## 相似题目



