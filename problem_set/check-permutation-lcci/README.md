
| [English](README_EN.md) | 简体中文 |

# [面试题 01.02. 判定是否互为字符重排](https://leetcode.cn//problems/check-permutation-lcci/)

## 题目描述

<p>给定两个由小写字母组成的字符串 <code>s1</code> 和 <code>s2</code>，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入:</strong> <code>s1</code> = "abc", <code>s2</code> = "bca"
<strong>输出:</strong> true 
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入:</strong> <code>s1</code> = "abc", <code>s2</code> = "bad"
<strong>输出:</strong> false
</pre>

<p><strong>说明：</strong></p>

<ul>
	<li><code>0 &lt;= len(s1) &lt;= 100 </code></li>
	<li><code>0 &lt;= len(s2) &lt;= 100 </code></li>
</ul>


## 题解


### C++

```C++
// @Title: 判定是否互为字符重排 (Check Permutation LCCI)
// @Author: robert.sunq
// @Date: 2020-03-22 00:25:13
// @Runtime: 4 ms
// @Memory: 7.5 MB

class Solution {
public:
    bool CheckPermutation(string s1, string s2) {
            int len_s1 =  s1.size();
            int len_s2 = s2.size();
            if(len_s1 != len_s2 ) return false;
            int mp1[260]={0};
            for(int i=0;i<len_s2;i++){
                    mp1[s1[i]]++;
                    mp1[s2[i]]--;
            }
            for(int i=0;i<256;i++){
                if(mp1[i] != 0)
                   return false;

            }
            return true;

    }
};
```



### Java

```Java
// @Title: 判定是否互为字符重排 (Check Permutation LCCI)
// @Author: robert.sunq
// @Date: 2021-08-02 15:50:35
// @Runtime: 0 ms
// @Memory: 36.2 MB

class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        // 长度不相等直接退回
        if(len1 != len2 ) return false;
        // 保存字符出现次数
        int[] dict = new int[256];
        for(int i=0;i<len1;i++){
            dict[s1.charAt(i)]++;
            dict[s2.charAt(i)]--;
        }
        for(int i=0;i<256;i++){
            if(dict[i] != 0) {
                return false;
            }
        }
        return true;

    }
}
```



## 相关话题

- [哈希表](https://leetcode.cn//tag/hash-table)
- [字符串](https://leetcode.cn//tag/string)
- [排序](https://leetcode.cn//tag/sorting)

## 相似题目



