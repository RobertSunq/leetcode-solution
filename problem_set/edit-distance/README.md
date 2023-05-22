
| [English](README_EN.md) | 简体中文 |

# [72. 编辑距离](https://leetcode.cn//problems/edit-distance/)

## 题目描述

<p>给你两个单词&nbsp;<code>word1</code> 和&nbsp;<code>word2</code>， <em>请返回将&nbsp;<code>word1</code>&nbsp;转换成&nbsp;<code>word2</code> 所使用的最少操作数</em> &nbsp;。</p>

<p>你可以对一个单词进行如下三种操作：</p>

<ul>
	<li>插入一个字符</li>
	<li>删除一个字符</li>
	<li>替换一个字符</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1：</strong></p>

<pre>
<strong>输入：</strong>word1 = "horse", word2 = "ros"
<strong>输出：</strong>3
<strong>解释：</strong>
horse -&gt; rorse (将 'h' 替换为 'r')
rorse -&gt; rose (删除 'r')
rose -&gt; ros (删除 'e')
</pre>

<p><strong>示例&nbsp;2：</strong></p>

<pre>
<strong>输入：</strong>word1 = "intention", word2 = "execution"
<strong>输出：</strong>5
<strong>解释：</strong>
intention -&gt; inention (删除 't')
inention -&gt; enention (将 'i' 替换为 'e')
enention -&gt; exention (将 'n' 替换为 'x')
exention -&gt; exection (将 'n' 替换为 'c')
exection -&gt; execution (插入 'u')
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 &lt;= word1.length, word2.length &lt;= 500</code></li>
	<li><code>word1</code> 和 <code>word2</code> 由小写英文字母组成</li>
</ul>


## 题解


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



## 相关话题

- [字符串](https://leetcode.cn//tag/string)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目


- [相隔为 1 的编辑距离](../one-edit-distance/README.md)
- [两个字符串的删除操作](../delete-operation-for-two-strings/README.md)
- [两个字符串的最小ASCII删除和](../minimum-ascii-delete-sum-for-two-strings/README.md)
- [不相交的线](../uncrossed-lines/README.md)
