
| [English](README_EN.md) | 简体中文 |

# [1094. 拼车](https://leetcode.cn//problems/car-pooling/)

## 题目描述

<p>车上最初有&nbsp;<code>capacity</code>&nbsp;个空座位。车&nbsp;<strong>只能&nbsp;</strong>向一个方向行驶（也就是说，<strong>不允许掉头或改变方向</strong>）</p>

<p>给定整数&nbsp;<code>capacity</code>&nbsp;和一个数组 <code>trips</code> , &nbsp;<code>trip[i] = [numPassengers<sub>i</sub>, from<sub>i</sub>, to<sub>i</sub>]</code>&nbsp;表示第 <code>i</code> 次旅行有&nbsp;<code>numPassengers<sub>i</sub></code>&nbsp;乘客，接他们和放他们的位置分别是&nbsp;<code>from<sub>i</sub></code>&nbsp;和&nbsp;<code>to<sub>i</sub></code>&nbsp;。这些位置是从汽车的初始位置向东的公里数。</p>

<p>当且仅当你可以在所有给定的行程中接送所有乘客时，返回&nbsp;<code>true</code>，否则请返回 <code>false</code>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>trips = [[2,1,5],[3,3,7]], capacity = 4
<strong>输出：</strong>false
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>trips = [[2,1,5],[3,3,7]], capacity = 5
<strong>输出：</strong>true
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= trips.length &lt;= 1000</code></li>
	<li><code>trips[i].length == 3</code></li>
	<li><code>1 &lt;= numPassengers<sub>i</sub>&nbsp;&lt;= 100</code></li>
	<li><code>0 &lt;= from<sub>i</sub>&nbsp;&lt; to<sub>i</sub>&nbsp;&lt;= 1000</code></li>
	<li><code>1 &lt;= capacity &lt;= 10<sup>5</sup></code></li>
</ul>


## 题解


### Java

```Java
// @Title: 拼车 (Car Pooling)
// @Author: robert.sunq
// @Date: 2023-12-02 21:01:41
// @Runtime: 1 ms
// @Memory: 42 MB

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        // 遍历计算每个tripes， 对每个节点的人数影响，得到每个节点的count数量来计算是否符合要求，是一个方案

        // 同时，也可以使用 差分数组
        // 差分数组是前缀和的逆运算。 即 count[0] = diff[0], count[1] = diff[0] + diff(1), count[n] = diff[1] + ... + diff(k)
        // 得  diff[k] = count[0] k = 0; 或者 diff[k] = count[k] - count[k - 1] k > 0
        
        // 所以，当 k == from_i 时， diff[k] 的值增加 num
        // 当 k = to_i 时， diff[k] 的值减少 num
        // 其他状态下，因为没有上下车的出现，所以 差分 不受到这个批次人的影响
        
        // 最后计算下前缀和，就得到了count 数组， 不用对每个 批次 进行循环遍历 [from_i, to_i] 的区间 都加 num_i 来计算了


        int toMax = 0;
        for (int[] trip : trips) {
            toMax = Math.max(toMax, trip[2]);
        }

        // 缩减计算，只用计算到能到达的最远距离即可
        int[] diff = new int[toMax + 1];

        for (int[] trip : trips) {
            diff[trip[1]] += trip[0];
            diff[trip[2]] -= trip[0];
        }

        int count = 0;
        for (int i = 0; i <= toMax; i++) {
            count += diff[i];
            // 中间存在某个时刻， 人数大于容量了
            if (count > capacity) {
                return false;
            }
        }

        // 一直在容量内，可以正常行驶。
        return true;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [前缀和](https://leetcode.cn//tag/prefix-sum)
- [排序](https://leetcode.cn//tag/sorting)
- [模拟](https://leetcode.cn//tag/simulation)
- [堆（优先队列）](https://leetcode.cn//tag/heap-priority-queue)

## 相似题目


- [会议室 II](../meeting-rooms-ii/README.md)
