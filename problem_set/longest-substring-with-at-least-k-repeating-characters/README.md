
| [English](README_EN.md) | 简体中文 |

# [395. 至少有 K 个重复字符的最长子串](https://leetcode.cn//problems/longest-substring-with-at-least-k-repeating-characters/)

## 题目描述

<p>给你一个字符串 <code>s</code> 和一个整数 <code>k</code> ，请你找出 <code>s</code> 中的最长子串， 要求该子串中的每一字符出现次数都不少于 <code>k</code> 。返回这一子串的长度。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "aaabb", k = 3
<strong>输出：</strong>3
<strong>解释：</strong>最长子串为 "aaa" ，其中 'a' 重复了 3 次。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "ababbc", k = 2
<strong>输出：</strong>5
<strong>解释：</strong>最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= s.length <= 10<sup>4</sup></code></li>
	<li><code>s</code> 仅由小写英文字母组成</li>
	<li><code>1 <= k <= 10<sup>5</sup></code></li>
</ul>


## 题解


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



## 相关话题

- [哈希表](https://leetcode.cn//tag/hash-table)
- [字符串](https://leetcode.cn//tag/string)
- [分治](https://leetcode.cn//tag/divide-and-conquer)
- [滑动窗口](https://leetcode.cn//tag/sliding-window)

## 相似题目



