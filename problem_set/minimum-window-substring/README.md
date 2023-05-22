
| [English](README_EN.md) | 简体中文 |

# [76. 最小覆盖子串](https://leetcode.cn//problems/minimum-window-substring/)

## 题目描述

<p>给你一个字符串 <code>s</code> 、一个字符串 <code>t</code> 。返回 <code>s</code> 中涵盖 <code>t</code> 所有字符的最小子串。如果 <code>s</code> 中不存在涵盖 <code>t</code> 所有字符的子串，则返回空字符串 <code>""</code> 。</p>

<p>&nbsp;</p>

<p><strong>注意：</strong></p>

<ul>
	<li>对于 <code>t</code> 中重复字符，我们寻找的子字符串中该字符数量必须不少于 <code>t</code> 中该字符数量。</li>
	<li>如果 <code>s</code> 中存在这样的子串，我们保证它是唯一的答案。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "ADOBECODEBANC", t = "ABC"
<strong>输出：</strong>"BANC"
<strong>解释：</strong>最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "a", t = "a"
<strong>输出：</strong>"a"
<strong>解释：</strong>整个字符串 s 是最小覆盖子串。
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入:</strong> s = "a", t = "aa"
<strong>输出:</strong> ""
<strong>解释:</strong> t 中两个字符 'a' 均应包含在 s 的子串中，
因此没有符合条件的子字符串，返回空字符串。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code><sup>m == s.length</sup></code></li>
	<li><code><sup>n == t.length</sup></code></li>
	<li><code>1 &lt;= m, n &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> 和 <code>t</code> 由英文字母组成</li>
</ul>

<p>&nbsp;</p>
<strong>进阶：</strong>你能设计一个在 <code>o(m+n)</code> 时间内解决此问题的算法吗？

## 题解


### Java

```Java
// @Title: 最小覆盖子串 (Minimum Window Substring)
// @Author: robert.sunq
// @Date: 2021-07-11 22:36:11
// @Runtime: 53 ms
// @Memory: 39.4 MB

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        // 记录待匹配字符串中每个字符的个数
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0) + 1);
        }
        int i = 0,j = 0;
        // 记录结果
        int resi = i,resj = j,min = s.length() + 5;
        while(i<s.length() && j<s.length()){
            // System.out.println(map);
            if(map.containsKey(s.charAt(j))){
                // 字符可以匹配，hash表中对应值减一
                map.put(s.charAt(j),map.get(s.charAt(j)) - 1);
                // 表示所有元素都找到
                if(recur(map)){
                    // System.out.println(i+"   " + j);
                    // 则以后前面的节点，来查询当前状态下最短的字符串
                    while(i<s.length()){
                        if(map.containsKey(s.charAt(i))){
                            // 当前起始位置的字符串已经是唯一一个匹配的，不能再右移
                            if(map.get(s.charAt(i)) == 0){
                                break;
                            }else{
                                // 表示当前起始位置的字符，包含多个，可以移除
                                map.put(s.charAt(i),map.get(s.charAt(i)) + 1);
                            }
                        }
                        i++;
                    }
                    // 当前子字符串长度最小时，保存结果集
                    if (min > (j-i + 1) ){
                        resi = i; 
                        resj = j;
                        min = j-i + 1;
                    }                     
                }
            }
            j++;
        }
        // 遍历完成，如果匹配成功，则输出结果
        if(recur(map)) return s.substring(resi,resj+1);
        return "";
    }
    // 如果hash表中某个字符没有被抵消完，则不能匹配
    boolean recur(HashMap<Character,Integer> map){
        for(Character key : map.keySet()){
            if(map.get(key) > 0 ) return false;
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


- [串联所有单词的子串](../substring-with-concatenation-of-all-words/README.md)
- [长度最小的子数组](../minimum-size-subarray-sum/README.md)
- [滑动窗口最大值](../sliding-window-maximum/README.md)
- [字符串的排列](../permutation-in-string/README.md)
- [最小窗口子序列](../minimum-window-subsequence/README.md)
