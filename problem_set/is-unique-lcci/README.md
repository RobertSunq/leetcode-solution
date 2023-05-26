
| [English](README_EN.md) | 简体中文 |

# [面试题 01.01. 判定字符是否唯一](https://leetcode.cn//problems/is-unique-lcci/)

## 题目描述

<p>实现一个算法，确定一个字符串 <code>s</code> 的所有字符是否全都不同。</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入:</strong> <code>s</code> = "leetcode"
<strong>输出:</strong> false 
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入:</strong> <code>s</code> = "abc"
<strong>输出:</strong> true
</pre>

<p><strong>限制：</strong></p>

<ul>
	<li><code>0 &lt;= len(s) &lt;= 100 </code></li>
	<li><code>s[i]</code>仅包含小写字母</li>
	<li>如果你不使用额外的数据结构，会很加分。</li>
</ul>


## 题解


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



## 相关话题

- [位运算](https://leetcode.cn//tag/bit-manipulation)
- [哈希表](https://leetcode.cn//tag/hash-table)
- [字符串](https://leetcode.cn//tag/string)
- [排序](https://leetcode.cn//tag/sorting)

## 相似题目



