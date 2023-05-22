
| English | [简体中文](README.md) |

# [438. Find All Anagrams in a String](https://leetcode.cn//problems/find-all-anagrams-in-a-string/)

## Description

<p>Given two strings <code>s</code> and <code>p</code>, return <em>an array of all the start indices of </em><code>p</code><em>&#39;s anagrams in </em><code>s</code>. You may return the answer in <strong>any order</strong>.</p>

<p>An <strong>Anagram</strong> is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;cbaebabacd&quot;, p = &quot;abc&quot;
<strong>Output:</strong> [0,6]
<strong>Explanation:</strong>
The substring with start index = 0 is &quot;cba&quot;, which is an anagram of &quot;abc&quot;.
The substring with start index = 6 is &quot;bac&quot;, which is an anagram of &quot;abc&quot;.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;abab&quot;, p = &quot;ab&quot;
<strong>Output:</strong> [0,1,2]
<strong>Explanation:</strong>
The substring with start index = 0 is &quot;ab&quot;, which is an anagram of &quot;ab&quot;.
The substring with start index = 1 is &quot;ba&quot;, which is an anagram of &quot;ab&quot;.
The substring with start index = 2 is &quot;ab&quot;, which is an anagram of &quot;ab&quot;.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length, p.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>s</code> and <code>p</code> consist of lowercase English letters.</li>
</ul>


## Solutions


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



## Related Topics

- [Hash Table](https://leetcode.cn//tag/hash-table)
- [String](https://leetcode.cn//tag/string)
- [Sliding Window](https://leetcode.cn//tag/sliding-window)

## Similar Questions

- [Valid Anagram](../valid-anagram/README_EN.md)
- [Permutation in String](../permutation-in-string/README_EN.md)
