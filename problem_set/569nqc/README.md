
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 035. 最小时间差](https://leetcode.cn//problems/569nqc/)

## 题目描述

<p>给定一个 24 小时制（小时:分钟 <strong>&quot;HH:MM&quot;</strong>）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>timePoints = [&quot;23:59&quot;,&quot;00:00&quot;]
<strong>输出：</strong>1
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>timePoints = [&quot;00:00&quot;,&quot;23:59&quot;,&quot;00:00&quot;]
<strong>输出：</strong>0
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= timePoints &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>timePoints[i]</code> 格式为 <strong>&quot;HH:MM&quot;</strong></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 539&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/minimum-time-difference/">https://leetcode-cn.com/problems/minimum-time-difference/</a></p>


## 题解


### Java

```Java
// @Title: 最小时间差 (最小时间差)
// @Author: robert.sunq
// @Date: 2023-06-28 23:56:07
// @Runtime: 8 ms
// @Memory: 42.9 MB

class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> times = new ArrayList<>();

        for (int i=0; i<timePoints.size(); i++) {
            String s = timePoints.get(i);
            times.add((s.charAt(0) - '0') * 10 * 60 + (s.charAt(1) - '0') * 60 + (s.charAt(3) - '0') * 10 + (s.charAt(4) - '0'));
        }
        times.sort(Integer::compare);
        int sum = 24 * 60;
        int ans = Math.min(times.get(times.size() - 1) - times.get(0), sum + times.get(0) - times.get(times.size() - 1) );

        for (int i=1; i<times.size(); i++) {
            ans = Math.min(ans, times.get(i) - times.get(i-1));
            ans = Math.min(ans, sum + times.get(i-1) - times.get(i));
        }
        return ans;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [数学](https://leetcode.cn//tag/math)
- [字符串](https://leetcode.cn//tag/string)
- [排序](https://leetcode.cn//tag/sorting)

## 相似题目



