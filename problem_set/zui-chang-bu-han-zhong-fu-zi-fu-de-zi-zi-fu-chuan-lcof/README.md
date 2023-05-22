
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 48. 最长不含重复字符的子字符串](https://leetcode.cn//problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/)

## 题目描述

<p>请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre><strong>输入: </strong>&quot;abcabcbb&quot;
<strong>输出: </strong>3 
<strong>解释:</strong> 因为无重复字符的最长子串是 <code>&quot;abc&quot;，所以其</code>长度为 3。
</pre>

<p><strong>示例 2:</strong></p>

<pre><strong>输入: </strong>&quot;bbbbb&quot;
<strong>输出: </strong>1
<strong>解释: </strong>因为无重复字符的最长子串是 <code>&quot;b&quot;</code>，所以其长度为 1。
</pre>

<p><strong>示例 3:</strong></p>

<pre><strong>输入: </strong>&quot;pwwkew&quot;
<strong>输出: </strong>3
<strong>解释: </strong>因为无重复字符的最长子串是&nbsp;<code>&quot;wke&quot;</code>，所以其长度为 3。
&nbsp;    请注意，你的答案必须是 <strong>子串 </strong>的长度，<code>&quot;pwke&quot;</code>&nbsp;是一个<em>子序列，</em>不是子串。
</pre>

<p>&nbsp;</p>

<p>提示：</p>

<ul>
	<li><code>s.length &lt;= 40000</code></li>
</ul>

<p>注意：本题与主站 3 题相同：<a href="https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/">https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/</a></p>


## 题解


### Java

```Java
// @Title: 最长不含重复字符的子字符串 (最长不含重复字符的子字符串 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 00:29:10
// @Runtime: 8 ms
// @Memory: 38.6 MB

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> dict = new HashMap<>();
        // res 最大值， temp 前一个字符串的长度
        int res = 0 ,temp = 0;
        for (int j=0;j<s.length();j++){
            // 字符第一次出现
            if(dict.get(s.charAt(j)) != null){
                // 该字符上次出现的位置
                int i = dict.get(s.charAt(j));
                // 如果两个字符间距大于前一个字符串，则证明前一个字符串的长度不包含 当前字符
                if (temp < (j - i) ){
                    temp = temp+1;
                }else{
                    // 否则 新的长度就是两个相等字符之间的差
                    temp = j-i;
                }
            }else{
                // 不存在时候，字符为出现，
                // 该状态 可以与前面进行合并
                temp = temp +1;
            }
            res = Math.max(res,temp);
            // 更新hash表
            dict.put(s.charAt(j),j);
        }
        return res;
    }
}
```



## 相关话题

- [哈希表](https://leetcode.cn//tag/hash-table)
- [字符串](https://leetcode.cn//tag/string)
- [滑动窗口](https://leetcode.cn//tag/sliding-window)

## 相似题目



