
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 041. 滑动窗口的平均值](https://leetcode.cn//problems/qIsx9U/)

## 题目描述

<p>给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。</p>

<p>实现 <code>MovingAverage</code> 类：</p>

<ul>
	<li><code>MovingAverage(int size)</code> 用窗口大小 <code>size</code> 初始化对象。</li>
	<li><code>double next(int val)</code>&nbsp;成员函数 <code>next</code>&nbsp;每次调用的时候都会往滑动窗口增加一个整数，请计算并返回数据流中最后 <code>size</code> 个值的移动平均值，即滑动窗口里所有数字的平均值。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>
inputs = [&quot;MovingAverage&quot;, &quot;next&quot;, &quot;next&quot;, &quot;next&quot;, &quot;next&quot;]
inputs = [[3], [1], [10], [3], [5]]
<strong>输出：</strong>
[null, 1.0, 5.5, 4.66667, 6.0]

<strong>解释：</strong>
MovingAverage movingAverage = new MovingAverage(3);
movingAverage.next(1); // 返回 1.0 = 1 / 1
movingAverage.next(10); // 返回 5.5 = (1 + 10) / 2
movingAverage.next(3); // 返回 4.66667 = (1 + 10 + 3) / 3
movingAverage.next(5); // 返回 6.0 = (10 + 3 + 5) / 3
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= size &lt;= 1000</code></li>
	<li><code>-10<sup>5</sup> &lt;= val &lt;= 10<sup>5</sup></code></li>
	<li>最多调用 <code>next</code> 方法 <code>10<sup>4</sup></code> 次</li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 346&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/moving-average-from-data-stream/">https://leetcode-cn.com/problems/moving-average-from-data-stream/</a></p>


## 题解


### Java

```Java
// @Title: 滑动窗口的平均值 (滑动窗口的平均值)
// @Author: robert.sunq
// @Date: 2023-07-04 21:55:30
// @Runtime: 37 ms
// @Memory: 46.7 MB

class MovingAverage {

    int[] window;
    int sum;
    int size;
    int index;
    int count;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.window = new int[size];
        this.sum = 0;
        this.size = size;
        this.index = -1;
        this.count = 0;
    }
    
    public double next(int val) {
        index = (index + 1) % size;
        if (count < size) {
            window[index] = val;
            sum = sum + val;
            count++;
            return sum * 1.0 / count;
        }
        sum = sum - window[index] + val;
        window[index] = val;
        return sum * 1.0 / count;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
```



## 相关话题

- [设计](https://leetcode.cn//tag/design)
- [队列](https://leetcode.cn//tag/queue)
- [数组](https://leetcode.cn//tag/array)
- [数据流](https://leetcode.cn//tag/data-stream)

## 相似题目



