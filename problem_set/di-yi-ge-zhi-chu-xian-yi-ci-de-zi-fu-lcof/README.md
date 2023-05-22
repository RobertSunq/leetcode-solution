
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 50. 第一个只出现一次的字符](https://leetcode.cn//problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/)

## 题目描述

<p>在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。</p>

<p><strong>示例 1:</strong></p>

<pre>
输入：s = "abaccdeff"
输出：'b'
</pre>

<p><strong>示例 2:</strong></p>

<pre>
输入：s = "" 
输出：' '
</pre>

<p>&nbsp;</p>

<p><strong>限制：</strong></p>

<p><code>0 &lt;= s 的长度 &lt;= 50000</code></p>


## 题解


### Java

```Java
// @Title: 第一个只出现一次的字符 (第一个只出现一次的字符  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 01:51:40
// @Runtime: 31 ms
// @Memory: 38.4 MB

class Solution {
    public char firstUniqChar(String s) {
        Map<Character,Integer> dict = new HashMap<>();
        char[] schar = s.toCharArray();
        for (char c : schar){
            dict.put(c,dict.containsKey(c)?2:1);
        }
        for(char c : schar){
            if(dict.get(c) == 1){
                return c;
            }
        }
        return ' ';
    }
}
```



## 相关话题

- [队列](https://leetcode.cn//tag/queue)
- [哈希表](https://leetcode.cn//tag/hash-table)
- [字符串](https://leetcode.cn//tag/string)
- [计数](https://leetcode.cn//tag/counting)

## 相似题目



