
| [English](README_EN.md) | 简体中文 |

# [438. 找到字符串中所有字母异位词](https://leetcode.cn//problems/find-all-anagrams-in-a-string/)

## 题目描述

<p>给定两个字符串&nbsp;<code>s</code>&nbsp;和 <code>p</code>，找到&nbsp;<code>s</code><strong>&nbsp;</strong>中所有&nbsp;<code>p</code><strong>&nbsp;</strong>的&nbsp;<strong>异位词&nbsp;</strong>的子串，返回这些子串的起始索引。不考虑答案输出的顺序。</p>

<p><strong>异位词 </strong>指由相同字母重排列形成的字符串（包括相同的字符串）。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre>
<strong>输入: </strong>s = "cbaebabacd", p = "abc"
<strong>输出: </strong>[0,6]
<strong>解释:</strong>
起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
</pre>

<p><strong>&nbsp;示例 2:</strong></p>

<pre>
<strong>输入: </strong>s = "abab", p = "ab"
<strong>输出: </strong>[0,1,2]
<strong>解释:</strong>
起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>1 &lt;= s.length, p.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>s</code>&nbsp;和&nbsp;<code>p</code>&nbsp;仅包含小写字母</li>
</ul>


## 题解


### Java

```Java
// @Title: 找到字符串中所有字母异位词 (Find All Anagrams in a String)
// @Author: robert.sunq
// @Date: 2021-06-21 22:15:22
// @Runtime: 39 ms
// @Memory: 39.7 MB

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> dict = new HashMap<>();
        // 创建 子串字典
        for(Character c : p.toCharArray()){
            dict.put(c,dict.getOrDefault(c,0)+1);
        }
        Map<Character,Integer> mp = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        char[] temp = s.toCharArray();
        int i = 0,j=0,len=s.length();
        while(j<len){
            // 如果当前j所指元素不在 字典中，则I，J均当前的下一位开始
            if(!dict.containsKey(temp[j])){
                i = j+1;
                j = j+1;
                // 暂存数值，恢复
                mp = new HashMap<Character,Integer>();
                continue;
            }
            // 匹配当前元素
            mp.put(temp[j],mp.getOrDefault(temp[j],0)+1);
            // 如果 j - i + 1 = p的长度，检验现在的子字符串是否是异位词
            if((j - i + 1) == p.length()){
                if(recur(mp,dict)) res.add(i);
                mp.put(temp[i],mp.get(temp[i])-1);
                i++;
            }
            j++;
        }
        return res;
    }

    // 检验mp种是否所有元素均为 零，即所有的都匹配到
    boolean recur(Map<Character,Integer> mp,Map<Character,Integer> dict){
        for(Character c : mp.keySet()){
            if((int)mp.get(c) != (int)dict.get(c)) return false;
        }
        return true;
    }
}
```



## 相关话题

- [哈希表](https://leetcode.cn//tag/hash-table)
- [字符串](https://leetcode.cn//tag/string)
- [滑动窗口](https://leetcode.cn//tag/sliding-window)

## 相似题目


- [有效的字母异位词](../valid-anagram/README.md)
- [字符串的排列](../permutation-in-string/README.md)
