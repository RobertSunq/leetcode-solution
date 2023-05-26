
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 005. 单词长度的最大乘积](https://leetcode.cn//problems/aseY1I/)

## 题目描述

<p>给定一个字符串数组&nbsp;<code>words</code>，请计算当两个字符串 <code>words[i]</code> 和 <code>words[j]</code> 不包含相同字符时，它们长度的乘积的最大值。假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre>
<strong>输入:</strong> words = <code>[&quot;abcw&quot;,&quot;baz&quot;,&quot;foo&quot;,&quot;bar&quot;,&quot;fxyz&quot;,&quot;abcdef&quot;]</code>
<strong>输出: </strong><code>16 
<strong>解释:</strong> 这两个单词为<strong> </strong></code><code>&quot;abcw&quot;, &quot;fxyz&quot;</code>。它们不包含相同字符，且长度的乘积最大。</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> words = <code>[&quot;a&quot;,&quot;ab&quot;,&quot;abc&quot;,&quot;d&quot;,&quot;cd&quot;,&quot;bcd&quot;,&quot;abcd&quot;]</code>
<strong>输出: </strong><code>4 
<strong>解释: </strong></code>这两个单词为 <code>&quot;ab&quot;, &quot;cd&quot;</code>。</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入:</strong> words = <code>[&quot;a&quot;,&quot;aa&quot;,&quot;aaa&quot;,&quot;aaaa&quot;]</code>
<strong>输出: </strong><code>0 
<strong>解释: </strong>不存在这样的两个单词。</code>
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= words.length &lt;= 1000</code></li>
	<li><code>1 &lt;= words[i].length &lt;= 1000</code></li>
	<li><code>words[i]</code>&nbsp;仅包含小写字母</li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 318&nbsp;题相同：<a href="https://leetcode-cn.com/problems/maximum-product-of-word-lengths/">https://leetcode-cn.com/problems/maximum-product-of-word-lengths/</a></p>


## 题解


### Java

```Java
// @Title: 单词长度的最大乘积 (单词长度的最大乘积)
// @Author: robert.sunq
// @Date: 2023-05-27 00:01:37
// @Runtime: 6 ms
// @Memory: 42.1 MB

class Solution {
    public int maxProduct(String[] words) {
        // 第一行保存每个字符串的特征值，第二行保存字符串的长度
        int[][] abstractKeyToSize = new int[2][words.length];

        int result = 0;
        for(int i = 0; i < words.length; i++) {
            int tmp = 0;
            String word = words[i];

            // 将字符串中每个字符传为 int 数值上的对应位的 1。 作为字符串的特征值
            for (int j = 0; j < word.length(); j ++) {
                char a = word.charAt(j);
                // 计算每个字符所在位置
                // 注意是或，因为这里是用 高位 来标记字符的存在，存在两个相同的字符也要是高位，而不是进位
                tmp = tmp | (1 << (a - 'a'));
            }

            // 存储当字符串的状态
            abstractKeyToSize[0][i] = tmp;
            abstractKeyToSize[1][i] = word.length();

            // 和已经计算出特征做对比
            for (int j = 0; j < i; j ++) {
                int abstractKey = abstractKeyToSize[0][j];
                // 位与， 如果大于1 则证明两个字符串有相同的字符，就不参与计算
                if ((abstractKey & tmp) > 0) {
                    continue;
                }
                // 没有相同字符，计算最大值
                result = max(result, abstractKeyToSize[1][j] * word.length());
            }
        }

        return result;
    }

    /**
    返回最大值
     */
    private int max(int a, int b) {
        return a >= b ? a : b;
    }
}
```



## 相关话题

- [位运算](https://leetcode.cn//tag/bit-manipulation)
- [数组](https://leetcode.cn//tag/array)
- [字符串](https://leetcode.cn//tag/string)

## 相似题目



