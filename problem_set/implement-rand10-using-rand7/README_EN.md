
| English | [简体中文](README.md) |

# [470. Implement Rand10() Using Rand7()](https://leetcode.cn//problems/implement-rand10-using-rand7/)

## Description

<p>Given the <strong>API</strong> <code>rand7()</code> that generates a uniform random integer in the range <code>[1, 7]</code>, write a function <code>rand10()</code> that generates a uniform random integer in the range <code>[1, 10]</code>. You can only call the API <code>rand7()</code>, and you shouldn&#39;t call any other API. Please <strong>do not</strong> use a language&#39;s built-in random API.</p>

<p>Each test case will have one <strong>internal</strong> argument <code>n</code>, the number of times that your implemented function <code>rand10()</code> will be called while testing. Note that this is <strong>not an argument</strong> passed to <code>rand10()</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> n = 1
<strong>Output:</strong> [2]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> n = 2
<strong>Output:</strong> [2,8]
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> n = 3
<strong>Output:</strong> [3,8,10]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong></p>

<ul>
	<li>What is the <a href="https://en.wikipedia.org/wiki/Expected_value" target="_blank">expected value</a> for the number of calls to <code>rand7()</code> function?</li>
	<li>Could you minimize the number of calls to <code>rand7()</code>?</li>
</ul>


## Solutions


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



## Related Topics

- [Math](https://leetcode.cn//tag/math)
- [Rejection Sampling](https://leetcode.cn//tag/rejection-sampling)
- [Probability and Statistics](https://leetcode.cn//tag/probability-and-statistics)
- [Randomized](https://leetcode.cn//tag/randomized)

## Similar Questions


