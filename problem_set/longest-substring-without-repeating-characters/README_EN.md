
| English | [简体中文](README.md) |

# [3. Longest Substring Without Repeating Characters](https://leetcode.cn//problems/longest-substring-without-repeating-characters/)

## Description

<p>Given a string <code>s</code>, find the length of the <strong>longest</strong> <span data-keyword="substring-nonempty"><strong>substring</strong></span> without repeating characters.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;abcabcbb&quot;
<strong>Output:</strong> 3
<strong>Explanation:</strong> The answer is &quot;abc&quot;, with the length of 3.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;bbbbb&quot;
<strong>Output:</strong> 1
<strong>Explanation:</strong> The answer is &quot;b&quot;, with the length of 1.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;pwwkew&quot;
<strong>Output:</strong> 3
<strong>Explanation:</strong> The answer is &quot;wke&quot;, with the length of 3.
Notice that the answer must be a substring, &quot;pwke&quot; is a subsequence and not a substring.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>s</code> consists of English letters, digits, symbols and spaces.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 无重复字符的最长子串 (Longest Substring Without Repeating Characters)
// @Author: robert.sunq
// @Date: 2021-06-30 22:07:58
// @Runtime: 7 ms
// @Memory: 38.5 MB

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0,temp =0;
        char[] cs = s.toCharArray();
        Map<Character,Integer> mp = new HashMap<>();
        for(int i = 0;i<cs.length;i++){
            // 如果前面有字符cs[i] 存在
            if(mp.containsKey(cs[i])){
                int j = mp.get(cs[i]);
                // 说明 前一次出现的位置 在temp距离之外
                if(i-j > temp){
                    temp = temp+1;
                }else{
                    // 否则到这个元素最长不重复的长度就是两个字符的距离差
                    temp =i - j;
                }
            }else{
                temp++;
            }
            mp.put(cs[i],i);
            res = Math.max(temp,res);
        }
        return res;
    }
}
```



## Related Topics

- [Hash Table](https://leetcode.cn//tag/hash-table)
- [String](https://leetcode.cn//tag/string)
- [Sliding Window](https://leetcode.cn//tag/sliding-window)

## Similar Questions

- [Longest Substring with At Most Two Distinct Characters](../longest-substring-with-at-most-two-distinct-characters/README_EN.md)
- [Longest Substring with At Most K Distinct Characters](../longest-substring-with-at-most-k-distinct-characters/README_EN.md)
- [Subarrays with K Different Integers](../subarrays-with-k-different-integers/README_EN.md)
