
| English | [简体中文](README.md) |

# [76. Minimum Window Substring](https://leetcode.cn//problems/minimum-window-substring/)

## Description

<p>Given two strings <code>s</code> and <code>t</code> of lengths <code>m</code> and <code>n</code> respectively, return <em>the <strong>minimum window</strong></em> <span data-keyword="substring-nonempty"><strong><em>substring</em></strong></span><em> of </em><code>s</code><em> such that every character in </em><code>t</code><em> (<strong>including duplicates</strong>) is included in the window</em>. If there is no such substring, return <em>the empty string </em><code>&quot;&quot;</code>.</p>

<p>The testcases will be generated such that the answer is <strong>unique</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;ADOBECODEBANC&quot;, t = &quot;ABC&quot;
<strong>Output:</strong> &quot;BANC&quot;
<strong>Explanation:</strong> The minimum window substring &quot;BANC&quot; includes &#39;A&#39;, &#39;B&#39;, and &#39;C&#39; from string t.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;a&quot;, t = &quot;a&quot;
<strong>Output:</strong> &quot;a&quot;
<strong>Explanation:</strong> The entire string s is the minimum window.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;a&quot;, t = &quot;aa&quot;
<strong>Output:</strong> &quot;&quot;
<strong>Explanation:</strong> Both &#39;a&#39;s from t must be included in the window.
Since the largest window of s only has one &#39;a&#39;, return empty string.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == s.length</code></li>
	<li><code>n == t.length</code></li>
	<li><code>1 &lt;= m, n &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> and <code>t</code> consist of uppercase and lowercase English letters.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Could you find an algorithm that runs in <code>O(m + n)</code> time?</p>


## Solutions


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



## Related Topics

- [Hash Table](https://leetcode.cn//tag/hash-table)
- [String](https://leetcode.cn//tag/string)
- [Sliding Window](https://leetcode.cn//tag/sliding-window)

## Similar Questions

- [Substring with Concatenation of All Words](../substring-with-concatenation-of-all-words/README_EN.md)
- [Minimum Size Subarray Sum](../minimum-size-subarray-sum/README_EN.md)
- [Sliding Window Maximum](../sliding-window-maximum/README_EN.md)
- [Permutation in String](../permutation-in-string/README_EN.md)
- [Minimum Window Subsequence](../minimum-window-subsequence/README_EN.md)
