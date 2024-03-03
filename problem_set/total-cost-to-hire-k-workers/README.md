
| [English](README_EN.md) | 简体中文 |

# [2462. 雇佣 K 位工人的总代价](https://leetcode.cn//problems/total-cost-to-hire-k-workers/)

## 题目描述

<p>给你一个下标从 <strong>0</strong>&nbsp;开始的整数数组&nbsp;<code>costs</code>&nbsp;，其中&nbsp;<code>costs[i]</code>&nbsp;是雇佣第 <code>i</code>&nbsp;位工人的代价。</p>

<p>同时给你两个整数&nbsp;<code>k</code> 和&nbsp;<code>candidates</code>&nbsp;。我们想根据以下规则恰好雇佣&nbsp;<code>k</code>&nbsp;位工人：</p>

<ul>
	<li>总共进行&nbsp;<code>k</code>&nbsp;轮雇佣，且每一轮恰好雇佣一位工人。</li>
	<li>在每一轮雇佣中，从最前面 <code>candidates</code>&nbsp;和最后面 <code>candidates</code>&nbsp;人中选出代价最小的一位工人，如果有多位代价相同且最小的工人，选择下标更小的一位工人。
	<ul>
		<li>比方说，<code>costs = [3,2,7,7,1,2]</code> 且&nbsp;<code>candidates = 2</code>&nbsp;，第一轮雇佣中，我们选择第&nbsp;<code>4</code>&nbsp;位工人，因为他的代价最小&nbsp;<code>[<em>3,2</em>,7,7,<em><strong>1</strong>,2</em>]</code>&nbsp;。</li>
		<li>第二轮雇佣，我们选择第&nbsp;<code>1</code>&nbsp;位工人，因为他们的代价与第&nbsp;<code>4</code>&nbsp;位工人一样都是最小代价，而且下标更小，<code>[<em>3,<strong>2</strong></em>,7,<em>7,2</em>]</code>&nbsp;。注意每一轮雇佣后，剩余工人的下标可能会发生变化。</li>
	</ul>
	</li>
	<li>如果剩余员工数目不足 <code>candidates</code>&nbsp;人，那么下一轮雇佣他们中代价最小的一人，如果有多位代价相同且最小的工人，选择下标更小的一位工人。</li>
	<li>一位工人只能被选择一次。</li>
</ul>

<p>返回雇佣恰好<em>&nbsp;</em><code>k</code>&nbsp;位工人的总代价。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>costs = [17,12,10,2,7,2,11,20,8], k = 3, candidates = 4
<b>输出：</b>11
<b>解释：</b>我们总共雇佣 3 位工人。总代价一开始为 0 。
- 第一轮雇佣，我们从 [<strong><em>17,12,10,2</em></strong>,7,<strong><em>2,11,20,8</em></strong>] 中选择。最小代价是 2 ，有两位工人，我们选择下标更小的一位工人，即第 3 位工人。总代价是 0 + 2 = 2 。
- 第二轮雇佣，我们从 [<strong><em>17,12,10,7</em></strong>,<strong><em>2,11,20,8</em></strong>] 中选择。最小代价是 2 ，下标为 4 ，总代价是 2 + 2 = 4 。
- 第三轮雇佣，我们从 [<strong><em>17,12,10,7,11,20,8</em></strong>] 中选择，最小代价是 7 ，下标为 3 ，总代价是 4 + 7 = 11 。注意下标为 3 的工人同时在最前面和最后面 4 位工人中。
总雇佣代价是 11 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>costs = [1,2,4,1], k = 3, candidates = 3
<b>输出：</b>4
<b>解释：</b>我们总共雇佣 3 位工人。总代价一开始为 0 。
- 第一轮雇佣，我们从 [<strong><em>1,2,4,1</em></strong>] 中选择。最小代价为 1 ，有两位工人，我们选择下标更小的一位工人，即第 0 位工人，总代价是 0 + 1 = 1 。注意，下标为 1 和 2 的工人同时在最前面和最后面 3 位工人中。
- 第二轮雇佣，我们从 [<strong><em>2,4,1</em></strong>] 中选择。最小代价为 1 ，下标为 2 ，总代价是 1 + 1 = 2 。
- 第三轮雇佣，少于 3 位工人，我们从剩余工人 [<strong><em>2,4</em></strong>] 中选择。最小代价是 2 ，下标为 0 。总代价为 2 + 2 = 4 。
总雇佣代价是 4 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= costs.length &lt;= 10<sup>5 </sup></code></li>
	<li><code>1 &lt;= costs[i] &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= k, candidates &lt;= costs.length</code></li>
</ul>


## 题解


### Java

```Java
// @Title: 雇佣 K 位工人的总代价 (Total Cost to Hire K Workers)
// @Author: robert.sunq
// @Date: 2023-09-15 21:29:24
// @Runtime: 57 ms
// @Memory: 54 MB

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;

        // 注意 是 long， 避免溢出
        long ans = 0;

        PriorityQueue<Integer> leftQueue = new PriorityQueue<>((a, b) -> costs[a] - costs[b]);
        PriorityQueue<Integer> rightQueue = new PriorityQueue<>((a, b) -> costs[a] - costs[b]);
        int left = 0;
        int right = n - 1;
        for (; left < candidates && left < n; left++) {
            leftQueue.offer(left);
        }
        // 如果，right < left, 则证明元素已经被队列分割完，不需要再入队列了，避免重复
        for (; right >= 0 && right >= (n - candidates) && right >= left; right--) {
            rightQueue.offer(right);
        }
        int patch = 0;
        boolean leftPoll = true;
        while (patch++ < k) {
            // 因为 k < n， 所以不肯两个同时为空
            int leftPeek = leftQueue.isEmpty() ? -1 : leftQueue.peek();
            int rightPeek = rightQueue.isEmpty() ? -1 : rightQueue.peek();

            if (leftPeek == -1) {
                ans = ans + costs[rightPeek];
                rightQueue.poll();
                leftPoll = false;
            } else if (rightPeek == -1) {
                ans = ans + costs[leftPeek];
                leftQueue.poll();
                leftPoll = true;
            } else if (costs[leftPeek] <= costs[rightPeek]) {
                ans = ans + costs[leftPeek];
                leftQueue.poll();
                leftPoll = true;
            } else {
                ans = ans + costs[rightPeek];
                rightQueue.poll();
                leftPoll = false;
            }
            // 元素已经被队列分割完, 每次获取两边最小的即可，所以，不需要入列新元素。
            // 反之，则需要对有元素消耗的队列，录入新元素
            if (left <= right) {
                if (leftPoll) {
                    leftQueue.offer(left++);
                } else {
                    rightQueue.offer(right--);
                }
            }
        }

        return ans;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [双指针](https://leetcode.cn//tag/two-pointers)
- [模拟](https://leetcode.cn//tag/simulation)
- [堆（优先队列）](https://leetcode.cn//tag/heap-priority-queue)

## 相似题目



