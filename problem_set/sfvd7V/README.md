
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 033. 变位词组](https://leetcode.cn//problems/sfvd7V/)

## 题目描述

<p>给定一个字符串数组 <code>strs</code> ，将&nbsp;<strong>变位词&nbsp;</strong>组合在一起。 可以按任意顺序返回结果列表。</p>

<p><strong>注意：</strong>若两个字符串中每个字符出现的次数都相同，则称它们互为变位词。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> strs = <code>[&quot;eat&quot;, &quot;tea&quot;, &quot;tan&quot;, &quot;ate&quot;, &quot;nat&quot;, &quot;bat&quot;]</code>
<strong>输出: </strong>[[&quot;bat&quot;],[&quot;nat&quot;,&quot;tan&quot;],[&quot;ate&quot;,&quot;eat&quot;,&quot;tea&quot;]]</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> strs = <code>[&quot;&quot;]</code>
<strong>输出: </strong>[[&quot;&quot;]]
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入:</strong> strs = <code>[&quot;a&quot;]</code>
<strong>输出: </strong>[[&quot;a&quot;]]</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= strs.length &lt;= 10<sup>4</sup></code></li>
	<li><code>0 &lt;= strs[i].length &lt;= 100</code></li>
	<li><code>strs[i]</code>&nbsp;仅包含小写字母</li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 49&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/group-anagrams/">https://leetcode-cn.com/problems/group-anagrams/</a></p>


## 题解


### Java

```Java
// @Title: 变位词组 (变位词组)
// @Author: robert.sunq
// @Date: 2023-06-28 23:10:03
// @Runtime: 683 ms
// @Memory: 45.7 MB

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        if (strs == null || strs.length == 0) {
            return ans;
        }
        
        boolean add = false;
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            for (int j = 0; j < ans.size(); j++) {
                if (isAnagram(ans.get(j).get(0), str)) {
                    ans.get(j).add(str);
                    add = true;
                    break;
                }
            }
            if (add) {
                add = false;
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(str);
                ans.add(tmp);
            }
        }

        return ans;
    }



    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        if (s.equals(t)) {
            return true;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [哈希表](https://leetcode.cn//tag/hash-table)
- [字符串](https://leetcode.cn//tag/string)
- [排序](https://leetcode.cn//tag/sorting)

## 相似题目



