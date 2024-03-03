
| English | [简体中文](README.md) |

# [187. Repeated DNA Sequences](https://leetcode.cn//problems/repeated-dna-sequences/)

## Description

<p>The <strong>DNA sequence</strong> is composed of a series of nucleotides abbreviated as <code>&#39;A&#39;</code>, <code>&#39;C&#39;</code>, <code>&#39;G&#39;</code>, and <code>&#39;T&#39;</code>.</p>

<ul>
	<li>For example, <code>&quot;ACGAATTCCG&quot;</code> is a <strong>DNA sequence</strong>.</li>
</ul>

<p>When studying <strong>DNA</strong>, it is useful to identify repeated sequences within the DNA.</p>

<p>Given a string <code>s</code> that represents a <strong>DNA sequence</strong>, return all the <strong><code>10</code>-letter-long</strong> sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in <strong>any order</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
<strong>Output:</strong> ["AAAAACCCCC","CCCCCAAAAA"]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> s = "AAAAAAAAAAAAA"
<strong>Output:</strong> ["AAAAAAAAAA"]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s[i]</code> is either <code>&#39;A&#39;</code>, <code>&#39;C&#39;</code>, <code>&#39;G&#39;</code>, or <code>&#39;T&#39;</code>.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 重复的DNA序列 (Repeated DNA Sequences)
// @Author: robert.sunq
// @Date: 2023-11-05 17:02:33
// @Runtime: 22 ms
// @Memory: 50.6 MB

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();

        Map<String, Integer> count = new HashMap<>();

        int n = s.length();

        for (int i = 0; i <= n - 10; i++) {
            String sub = s.substring(i , i + 10);
            count.put(sub, count.getOrDefault(sub, 0) + 1);

            if (count.get(sub) == 2) {
                ans.add(sub);
            }
        }

        return ans;
    }
}
```



## Related Topics

- [Bit Manipulation](https://leetcode.cn//tag/bit-manipulation)
- [Hash Table](https://leetcode.cn//tag/hash-table)
- [String](https://leetcode.cn//tag/string)
- [Sliding Window](https://leetcode.cn//tag/sliding-window)
- [Hash Function](https://leetcode.cn//tag/hash-function)
- [Rolling Hash](https://leetcode.cn//tag/rolling-hash)

## Similar Questions


