
| English | [简体中文](README.md) |

# [72. Edit Distance](https://leetcode.cn//problems/edit-distance/)

## Description

<p>Given two strings <code>word1</code> and <code>word2</code>, return <em>the minimum number of operations required to convert <code>word1</code> to <code>word2</code></em>.</p>

<p>You have the following three operations permitted on a word:</p>

<ul>
	<li>Insert a character</li>
	<li>Delete a character</li>
	<li>Replace a character</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> word1 = &quot;horse&quot;, word2 = &quot;ros&quot;
<strong>Output:</strong> 3
<strong>Explanation:</strong> 
horse -&gt; rorse (replace &#39;h&#39; with &#39;r&#39;)
rorse -&gt; rose (remove &#39;r&#39;)
rose -&gt; ros (remove &#39;e&#39;)
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> word1 = &quot;intention&quot;, word2 = &quot;execution&quot;
<strong>Output:</strong> 5
<strong>Explanation:</strong> 
intention -&gt; inention (remove &#39;t&#39;)
inention -&gt; enention (replace &#39;i&#39; with &#39;e&#39;)
enention -&gt; exention (replace &#39;n&#39; with &#39;x&#39;)
exention -&gt; exection (replace &#39;n&#39; with &#39;c&#39;)
exection -&gt; execution (insert &#39;u&#39;)
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= word1.length, word2.length &lt;= 500</code></li>
	<li><code>word1</code> and <code>word2</code> consist of lowercase English letters.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 编辑距离 (Edit Distance)
// @Author: robert.sunq
// @Date: 2021-06-09 23:21:47
// @Runtime: 7 ms
// @Memory: 38.6 MB

class Solution {
    public int minDistance(String word1, String word2) {
        // if(word1.length() <= 0) return word2.length();
        // if(word2.length() <= 0) return word1.length();
        // dp[i][j] 表示由i位的word1 到j位的word2 需要的最少转换步骤
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i = 0;i<=word1.length();i++){
            for(int j = 0;j<=word2.length();j++){
                // 边界
                if(j == 0){
                    // 全删除
                    dp[i][j] = i;
                }else if(i == 0){
                    // 全添加
                    dp[i][j] = j;
                }else{
                    // 当前位置相同，则最少转换状态与前一个相同
                    if(word1.charAt(i-1) == word2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        // 不相等时，则I的位置选择 删除，添加，替换中间最小的变化
                        dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1] , dp[i-1][j-1])) + 1;
                    }
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
```



## Related Topics

- [String](https://leetcode.cn//tag/string)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions

- [One Edit Distance](../one-edit-distance/README_EN.md)
- [Delete Operation for Two Strings](../delete-operation-for-two-strings/README_EN.md)
- [Minimum ASCII Delete Sum for Two Strings](../minimum-ascii-delete-sum-for-two-strings/README_EN.md)
- [Uncrossed Lines](../uncrossed-lines/README_EN.md)
