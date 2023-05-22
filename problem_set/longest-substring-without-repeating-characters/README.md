
| [English](README_EN.md) | 简体中文 |

# [3. 无重复字符的最长子串](https://leetcode.cn//problems/longest-substring-without-repeating-characters/)

## 题目描述

<p>给定一个字符串 <code>s</code> ，请你找出其中不含有重复字符的&nbsp;<strong>最长子串&nbsp;</strong>的长度。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre>
<strong>输入: </strong>s = "abcabcbb"
<strong>输出: </strong>3 
<strong>解释:</strong> 因为无重复字符的最长子串是 <code>"abc"，所以其</code>长度为 3。
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入: </strong>s = "bbbbb"
<strong>输出: </strong>1
<strong>解释: </strong>因为无重复字符的最长子串是 <code>"b"</code>，所以其长度为 1。
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入: </strong>s = "pwwkew"
<strong>输出: </strong>3
<strong>解释: </strong>因为无重复字符的最长子串是&nbsp;<code>"wke"</code>，所以其长度为 3。
&nbsp;    请注意，你的答案必须是 <strong>子串 </strong>的长度，<code>"pwke"</code>&nbsp;是一个<em>子序列，</em>不是子串。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>s</code>&nbsp;由英文字母、数字、符号和空格组成</li>
</ul>


## 题解


### Java

```Java
// @Title: 无重复字符的最长子串 (Longest Substring Without Repeating Characters)
// @Author: robert.sunq
// @Date: 2021-06-30 22:07:58
// @Runtime: 7 ms
// @Memory: 38.5 MB

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0,temp =0;
        char[] cs = s.toCharArray();
        Map<Character,Integer> mp = new HashMap<>();
        for(int i = 0;i<cs.length;i++){
            // 如果前面有字符cs[i] 存在
            if(mp.containsKey(cs[i])){
                int j = mp.get(cs[i]);
                // 说明 前一次出现的位置 在temp距离之外
                if(i-j > temp){
                    temp = temp+1;
                }else{
                    // 否则到这个元素最长不重复的长度就是两个字符的距离差
                    temp =i - j;
                }
            }else{
                temp++;
            }
            mp.put(cs[i],i);
            res = Math.max(temp,res);
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


- [至多包含两个不同字符的最长子串](../longest-substring-with-at-most-two-distinct-characters/README.md)
- [至多包含 K 个不同字符的最长子串](../longest-substring-with-at-most-k-distinct-characters/README.md)
- [K 个不同整数的子数组](../subarrays-with-k-different-integers/README.md)
