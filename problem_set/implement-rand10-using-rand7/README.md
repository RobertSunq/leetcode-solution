
| [English](README_EN.md) | 简体中文 |

# [470. 用 Rand7() 实现 Rand10()](https://leetcode.cn//problems/implement-rand10-using-rand7/)

## 题目描述

<p>给定方法&nbsp;<code>rand7</code>&nbsp;可生成 <code>[1,7]</code> 范围内的均匀随机整数，试写一个方法&nbsp;<code>rand10</code>&nbsp;生成 <code>[1,10]</code> 范围内的均匀随机整数。</p>

<p>你只能调用&nbsp;<code>rand7()</code>&nbsp;且不能调用其他方法。请不要使用系统的&nbsp;<code>Math.random()</code>&nbsp;方法。</p>

<ol>
</ol>

<p>每个测试用例将有一个内部参数 <code>n</code>，即你实现的函数 <code>rand10()</code> 在测试时将被调用的次数。请注意，这不是传递给 <code>rand10()</code> 的参数。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入: </strong>1
<strong>输出: </strong>[2]
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入: </strong>2
<strong>输出: </strong>[2,8]
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入: </strong>3
<strong>输出: </strong>[3,8,10]
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
</ul>

<p>&nbsp;</p>

<p><strong>进阶:</strong></p>

<ul>
	<li><code>rand7()</code>调用次数的&nbsp;<a href="https://en.wikipedia.org/wiki/Expected_value" target="_blank">期望值</a>&nbsp;是多少&nbsp;?</li>
	<li>你能否尽量少调用 <code>rand7()</code> ?</li>
</ul>


## 题解


### Java

```Java
// @Title: 用 Rand7() 实现 Rand10() (Implement Rand10() Using Rand7())
// @Author: robert.sunq
// @Date: 2021-07-12 22:26:27
// @Runtime: 5 ms
// @Memory: 43.3 MB

/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int res = 0;
        while(true){
            //构造1~49的均匀分布
            // 因为 (rand7() - 1) * 7 是  0,7,14,21,28,35,42 均匀出现
            // 之后再加上随机数 rand7() 从而使得 1 —— 49 均匀出现 
            res = (rand7() - 1) * 7 + rand7();
            //剔除大于40的值，1-40等概率出现
            if(res <= 40){
                break;
            }
        }
        // 构造1-10的均匀分布
        return res % 10 +1;
    }
}
```



## 相关话题

- [数学](https://leetcode.cn//tag/math)
- [拒绝采样](https://leetcode.cn//tag/rejection-sampling)
- [概率与统计](https://leetcode.cn//tag/probability-and-statistics)
- [随机化](https://leetcode.cn//tag/randomized)

## 相似题目



