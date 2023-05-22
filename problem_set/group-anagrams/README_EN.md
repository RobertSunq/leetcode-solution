
| English | [简体中文](README.md) |

# [49. Group Anagrams](https://leetcode.cn//problems/group-anagrams/)

## Description

<p>Given an array of strings <code>strs</code>, group <strong>the anagrams</strong> together. You can return the answer in <strong>any order</strong>.</p>

<p>An <strong>Anagram</strong> is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> strs = ["eat","tea","tan","ate","nat","bat"]
<strong>Output:</strong> [["bat"],["nat","tan"],["ate","eat","tea"]]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> strs = [""]
<strong>Output:</strong> [[""]]
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> strs = ["a"]
<strong>Output:</strong> [["a"]]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= strs.length &lt;= 10<sup>4</sup></code></li>
	<li><code>0 &lt;= strs[i].length &lt;= 100</code></li>
	<li><code>strs[i]</code> consists of lowercase English letters.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 字母异位词分组 (Group Anagrams)
// @Author: robert.sunq
// @Date: 2021-06-03 23:49:44
// @Runtime: 7 ms
// @Memory: 41.2 MB

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            List<String> value = map.getOrDefault(key,new ArrayList<String>());
            value.add(str);
            map.put(key,value);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Hash Table](https://leetcode.cn//tag/hash-table)
- [String](https://leetcode.cn//tag/string)
- [Sorting](https://leetcode.cn//tag/sorting)

## Similar Questions

- [Valid Anagram](../valid-anagram/README_EN.md)
- [Group Shifted Strings](../group-shifted-strings/README_EN.md)
