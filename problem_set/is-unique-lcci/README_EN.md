
| English | [简体中文](README.md) |

# [面试题 01.01. Is Unique LCCI](https://leetcode.cn//problems/is-unique-lcci/)

## Description

<p>Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?</p>

<p><strong>Example 1:</strong></p>

<pre>
<strong>Input: </strong><code>s</code> = &quot;leetcode&quot;
<strong>Output: </strong>false
</pre>

<p><strong>Example 2:</strong></p>

<pre>
<strong>Input: </strong><code>s</code> = &quot;abc&quot;
<strong>Output: </strong>true
</pre>

<p>&nbsp;</p>

<p><strong>Note:</strong></p>

<ul>
	<li><code>0 &lt;= len(s) &lt;= 100 </code></li>
</ul>


## Solutions


### C++

```C++
// @Title: 判定字符是否唯一 (Is Unique LCCI)
// @Author: robert.sunq
// @Date: 2020-03-21 23:51:14
// @Runtime: 0 ms
// @Memory: 7.4 MB

class Solution {
public:
    bool isUnique(string astr) {

        map<char, int> mp;
        for(int i=0;i<astr.size();i++){
            mp[astr[i]]++;
            if(mp[astr[i]]>1){
                return false;
            }
        }
        return true;

    }
};
```



### Java

```Java
// @Title: 判定字符是否唯一 (Is Unique LCCI)
// @Author: robert.sunq
// @Date: 2021-05-23 14:20:13
// @Runtime: 0 ms
// @Memory: 35.9 MB

class Solution {
    public boolean isUnique(String astr) {
        Set<String> se = new HashSet<>();
        for(int i = 0 ; i<astr.length();i++){
            if(se.contains(astr.substring(i,i+1)))
            {return false;}
            se.add(astr.substring(i,i+1));
        }
        return true;
    }
}
```



## Related Topics

- [Bit Manipulation](https://leetcode.cn//tag/bit-manipulation)
- [Hash Table](https://leetcode.cn//tag/hash-table)
- [String](https://leetcode.cn//tag/string)
- [Sorting](https://leetcode.cn//tag/sorting)

## Similar Questions


