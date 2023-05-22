
| [English](README_EN.md) | 简体中文 |

# [139. 单词拆分](https://leetcode.cn//problems/word-break/)

## 题目描述

<p>给你一个字符串 <code>s</code> 和一个字符串列表 <code>wordDict</code> 作为字典。请你判断是否可以利用字典中出现的单词拼接出 <code>s</code> 。</p>

<p><strong>注意：</strong>不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入:</strong> s = "leetcode", wordDict = ["leet", "code"]
<strong>输出:</strong> true
<strong>解释:</strong> 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入:</strong> s = "applepenapple", wordDict = ["apple", "pen"]
<strong>输出:</strong> true
<strong>解释:</strong> 返回 true 因为 <code>"</code>applepenapple<code>"</code> 可以由 <code>"</code>apple" "pen" "apple<code>" 拼接成</code>。
&nbsp;    注意，你可以重复使用字典中的单词。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入:</strong> s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
<strong>输出:</strong> false
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 300</code></li>
	<li><code>1 &lt;= wordDict.length &lt;= 1000</code></li>
	<li><code>1 &lt;= wordDict[i].length &lt;= 20</code></li>
	<li><code>s</code> 和 <code>wordDict[i]</code> 仅有小写英文字母组成</li>
	<li><code>wordDict</code> 中的所有字符串 <strong>互不相同</strong></li>
</ul>


## 题解


### Java

```Java
// @Title: 单词拆分 (Word Break)
// @Author: robert.sunq
// @Date: 2021-06-10 00:21:41
// @Runtime: 14 ms
// @Memory: 38.7 MB

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0) return true;
        int len = s.length();
        // 保存可以可以拆分成单词的 字符串下标
        List<Integer> li = new ArrayList<>();
        li.add(-1);
        for(int i =0 ;i<len;i++){
            for(int j = 0;j<li.size();j++){
                // 当前长度的字符串可以 由之前可以拆分的子字符串和某单词组成
                if(wordDict.contains(s.substring(li.get(j)+1,i+1))){
                    li.add(i);
                    break;
                }
            }
        }
        // System.out.println(li);
        return li.get(li.size()-1) == len -1;
    }
}
```



## 相关话题

- [字典树](https://leetcode.cn//tag/trie)
- [记忆化搜索](https://leetcode.cn//tag/memoization)
- [数组](https://leetcode.cn//tag/array)
- [哈希表](https://leetcode.cn//tag/hash-table)
- [字符串](https://leetcode.cn//tag/string)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目


- [单词拆分 II](../word-break-ii/README.md)
