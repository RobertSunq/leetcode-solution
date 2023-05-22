
| English | [简体中文](README.md) |

# [395. Longest Substring with At Least K Repeating Characters](https://leetcode.cn//problems/longest-substring-with-at-least-k-repeating-characters/)

## Description

<p>Given a string <code>s</code> and an integer <code>k</code>, return <em>the length of the longest substring of</em> <code>s</code> <em>such that the frequency of each character in this substring is greater than or equal to</em> <code>k</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;aaabb&quot;, k = 3
<strong>Output:</strong> 3
<strong>Explanation:</strong> The longest substring is &quot;aaa&quot;, as &#39;a&#39; is repeated 3 times.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;ababbc&quot;, k = 2
<strong>Output:</strong> 5
<strong>Explanation:</strong> The longest substring is &quot;ababb&quot;, as &#39;a&#39; is repeated 2 times and &#39;b&#39; is repeated 3 times.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s</code> consists of only lowercase English letters.</li>
	<li><code>1 &lt;= k &lt;= 10<sup>5</sup></code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 至少有 K 个重复字符的最长子串 (Longest Substring with At Least K Repeating Characters)
// @Author: robert.sunq
// @Date: 2021-07-16 23:10:07
// @Runtime: 5 ms
// @Memory: 36.4 MB

class Solution {
    public int longestSubstring(String s, int k) {
        int res = 0;
        int sum = 0;
        int t = 0;
        char[] c = s.toCharArray();
        // 保存个字符的个数
        int[] temp = new int[26];
        // 枚举二十六种情况，即字串包含K个字母的时候，满足题意
        for(int K = 1;K<26;K++){
            // 状态还原  +++++++ 容易遗忘
            temp = new int[26];
            t = 0;
            sum = 0;
            int j = 0;
            // sum 表示区间[j,i] 满足个数不小于K的字符的个数，t 表示当前字符种类个数
            for(int i=0;i<s.length();i++){
                int index = c[i] -'a';
                temp[index]++;
                // 添加后，该字符个数为一，则表示种类+1
                if(temp[index] == 1){
                    t++;
                }
                // 如果字符个数等于K，则满足的个数加一，大于情况下，字符的种类没有增长
                if(temp[index] == k){
                    sum++;
                }
                // 当出现的个数，大于此次枚举的时候，右移左指针，使得个数降低
                while(t > K){
                    int index_1 = c[j]-'a';
                    temp[index_1]--;
                    if(temp[index_1] == 0) {
                        t--;
                    }
                    if(temp[index_1] == k-1){
                        sum--;
                    }
                    j++;
                }
                 // 当所有字符都符合要求，更新答案
                if (t == sum) res = Math.max(res, i - j + 1);
            }
        }
        return res;
    }
}
```



## Related Topics

- [Hash Table](https://leetcode.cn//tag/hash-table)
- [String](https://leetcode.cn//tag/string)
- [Divide and Conquer](https://leetcode.cn//tag/divide-and-conquer)
- [Sliding Window](https://leetcode.cn//tag/sliding-window)

## Similar Questions


