
| [English](README_EN.md) | 简体中文 |

# [134. 加油站](https://leetcode.cn//problems/gas-station/)

## 题目描述

<p>在一条环路上有 <code>n</code>&nbsp;个加油站，其中第 <code>i</code>&nbsp;个加油站有汽油&nbsp;<code>gas[i]</code><em>&nbsp;</em>升。</p>

<p>你有一辆油箱容量无限的的汽车，从第<em> </em><code>i</code><em> </em>个加油站开往第<em> </em><code>i+1</code><em>&nbsp;</em>个加油站需要消耗汽油&nbsp;<code>cost[i]</code><em>&nbsp;</em>升。你从其中的一个加油站出发，开始时油箱为空。</p>

<p>给定两个整数数组 <code>gas</code> 和 <code>cost</code> ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 <code>-1</code> 。如果存在解，则 <strong>保证</strong> 它是 <strong>唯一</strong> 的。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre>
<strong>输入:</strong> gas = [1,2,3,4,5], cost = [3,4,5,1,2]
<strong>输出:</strong> 3
<strong>解释:
</strong>从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
因此，3 可为起始索引。</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> gas = [2,3,4], cost = [3,4,3]
<strong>输出:</strong> -1
<strong>解释:
</strong>你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
因此，无论怎样，你都不可能绕环路行驶一周。</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>gas.length == n</code></li>
	<li><code>cost.length == n</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= gas[i], cost[i] &lt;= 10<sup>4</sup></code></li>
</ul>


## 题解


### Java

```Java
// @Title: 加油站 (Gas Station)
// @Author: robert.sunq
// @Date: 2023-11-10 22:48:12
// @Runtime: 3 ms
// @Memory: 54.2 MB

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int i = 0;
        while ( i < n) {
            int gasSum = 0;
            int costSum = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                gasSum = gasSum + gas[j];
                costSum = costSum + cost[j];
                if (costSum > gasSum) {
                    break;
                }
                cnt++;
            }

            if (cnt == n) {
                return i;
            } else {
                // 加速计算， 如果无法到达p, 则从 i 到 p 中任意一个节点 j 出发也是无法到达的（毕竟 从 i 触发到 j 是有油量的，比直接用 j 出发 要多出剩余的部分）
                i = i + cnt + 1;
            }
        }
        return -1;
    }
}
```



## 相关话题

- [贪心](https://leetcode.cn//tag/greedy)
- [数组](https://leetcode.cn//tag/array)

## 相似题目



