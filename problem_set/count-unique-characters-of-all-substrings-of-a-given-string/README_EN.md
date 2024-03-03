
| English | [简体中文](README.md) |

# [828. Count Unique Characters of All Substrings of a Given String](https://leetcode.cn//problems/count-unique-characters-of-all-substrings-of-a-given-string/)

## Description

<p>Let&#39;s define a function <code>countUniqueChars(s)</code> that returns the number of unique characters in&nbsp;<code>s</code>.</p>

<ul>
	<li>For example, calling <code>countUniqueChars(s)</code> if <code>s = &quot;LEETCODE&quot;</code> then <code>&quot;L&quot;</code>, <code>&quot;T&quot;</code>, <code>&quot;C&quot;</code>, <code>&quot;O&quot;</code>, <code>&quot;D&quot;</code> are the unique characters since they appear only once in <code>s</code>, therefore <code>countUniqueChars(s) = 5</code>.</li>
</ul>

<p>Given a string <code>s</code>, return the sum of <code>countUniqueChars(t)</code> where <code>t</code> is a substring of <code>s</code>. The test cases are generated such that the answer fits in a 32-bit integer.</p>

<p>Notice that some substrings can be repeated so in this case you have to count the repeated ones too.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;ABC&quot;
<strong>Output:</strong> 10
<strong>Explanation: </strong>All possible substrings are: &quot;A&quot;,&quot;B&quot;,&quot;C&quot;,&quot;AB&quot;,&quot;BC&quot; and &quot;ABC&quot;.
Every substring is composed with only unique letters.
Sum of lengths of all substring is 1 + 1 + 1 + 2 + 2 + 3 = 10
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;ABA&quot;
<strong>Output:</strong> 8
<strong>Explanation: </strong>The same as example 1, except <code>countUniqueChars</code>(&quot;ABA&quot;) = 1.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;LEETCODE&quot;
<strong>Output:</strong> 92
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> consists of uppercase English letters only.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 统计子串中的唯一字符 (Count Unique Characters of All Substrings of a Given String)
// @Author: robert.sunq
// @Date: 2023-11-26 15:39:13
// @Runtime: 45 ms
// @Memory: 45.7 MB

class Solution {
    public int uniqueLetterString(String s) {
        // 注意， 这里统计的时子字符串， 不是元素的排列组合
        // 当字符 c 出现在i位置时，如果在某个子字符串中出现一次，就对结果有贡献
        // 所以 记 c 上一次出现的位置位  j, 则从j (不包含) 到 i 位置开始的所有字符串都只有一个 c
        // 同理，记 c 下一次出现的位置位 k， 则从 i 到 k (不包含) 位置结束的所有字符串都只有一个 c
        // 所以，这个j 到 k 区间内的所有可能为  (i - j) * (k - i)

        Map<Character, List<Integer>> index = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!index.containsKey(c)) {
                index.put(c, new ArrayList<>());
                index.get(c).add(-1);
            }
            index.get(c).add(i);
        }


        int ans = 0;
        for (Map.Entry<Character, List<Integer>> entry : index.entrySet()) {
            List<Integer> arr = entry.getValue();
            // 注意这里， 字符的最后结束位置为字符串的长度，方便计算
            arr.add(s.length());
            for (int i = 1; i < arr.size() - 1; i++) {
                ans = ans + ((arr.get(i) - arr.get(i - 1)) * (arr.get(i + 1) - arr.get(i)));
            }
        }


        return ans;
    }
}
```



## Related Topics

- [Hash Table](https://leetcode.cn//tag/hash-table)
- [String](https://leetcode.cn//tag/string)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions


