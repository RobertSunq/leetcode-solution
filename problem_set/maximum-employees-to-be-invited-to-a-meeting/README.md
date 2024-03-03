
| [English](README_EN.md) | 简体中文 |

# [2127. 参加会议的最多员工数](https://leetcode.cn//problems/maximum-employees-to-be-invited-to-a-meeting/)

## 题目描述

<p>一个公司准备组织一场会议，邀请名单上有&nbsp;<code>n</code>&nbsp;位员工。公司准备了一张 <strong>圆形</strong>&nbsp;的桌子，可以坐下 <strong>任意数目</strong>&nbsp;的员工。</p>

<p>员工编号为 <code>0</code>&nbsp;到 <code>n - 1</code>&nbsp;。每位员工都有一位 <strong>喜欢</strong>&nbsp;的员工，每位员工&nbsp;<strong>当且仅当</strong>&nbsp;他被安排在喜欢员工的旁边，他才会参加会议。每位员工喜欢的员工 <strong>不会</strong>&nbsp;是他自己。</p>

<p>给你一个下标从 <strong>0</strong>&nbsp;开始的整数数组&nbsp;<code>favorite</code>&nbsp;，其中&nbsp;<code>favorite[i]</code>&nbsp;表示第&nbsp;<code>i</code>&nbsp;位员工喜欢的员工。请你返回参加会议的&nbsp;<strong>最多员工数目</strong>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/12/14/ex1.png" style="width: 236px; height: 195px;" /></p>

<pre>
<b>输入：</b>favorite = [2,2,1,2]
<b>输出：</b>3
<strong>解释：</strong>
上图展示了公司邀请员工 0，1 和 2 参加会议以及他们在圆桌上的座位。
没办法邀请所有员工参与会议，因为员工 2 没办法同时坐在 0，1 和 3 员工的旁边。
注意，公司也可以邀请员工 1，2 和 3 参加会议。
所以最多参加会议的员工数目为 3 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<b>输入：</b>favorite = [1,2,0]
<b>输出：</b>3
<b>解释：</b>
每个员工都至少是另一个员工喜欢的员工。所以公司邀请他们所有人参加会议的前提是所有人都参加了会议。
座位安排同图 1 所示：
- 员工 0 坐在员工 2 和 1 之间。
- 员工 1 坐在员工 0 和 2 之间。
- 员工 2 坐在员工 1 和 0 之间。
参与会议的最多员工数目为 3 。
</pre>

<p><strong>示例 3：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/12/14/ex2.png" style="width: 219px; height: 220px;" /></p>

<pre>
<b>输入：</b>favorite = [3,0,1,4,1]
<b>输出：</b>4
<b>解释：</b>
上图展示了公司可以邀请员工 0，1，3 和 4 参加会议以及他们在圆桌上的座位。
员工 2 无法参加，因为他喜欢的员工 1 旁边的座位已经被占领了。
所以公司只能不邀请员工 2 。
参加会议的最多员工数目为 4 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == favorite.length</code></li>
	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= favorite[i] &lt;=&nbsp;n - 1</code></li>
	<li><code>favorite[i] != i</code></li>
</ul>


## 题解


### Java

```Java
// @Title: 参加会议的最多员工数 (Maximum Employees to Be Invited to a Meeting)
// @Author: robert.sunq
// @Date: 2023-11-01 22:38:47
// @Runtime: 17 ms
// @Memory: 54.3 MB

class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;

        // 统计入度， 方便进行拓扑排序
        int[] indeg = new int[n];

        for (int i = 0; i < n; i++) {
            indeg[favorite[i]] = indeg[favorite[i]] + 1;
        }

        boolean[] visit = new boolean[n];

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        Queue<Integer> queue = new ArrayDeque<>();

        // 入度为 0 的点
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        // 计算不再环内的节点的最大步长
        while (!queue.isEmpty()) {
            int u = queue.poll();
            visit[u] = true;

            int v = favorite[u];
            // 状态转移方程
            dp[v] = Math.max(dp[v], dp[u] + 1);

            // 被喜欢的节点 入度 - 1
            indeg[v] = indeg[v] - 1;
            if (indeg[v] == 0) {
                queue.offer(v);
            }
        }

        // ring 表示最大环的大小
        // total 表示 所有环大小为 2的 【基环 内向树】上的最长的 【双端游走】 路径之和

        int ring = 0, total = 0;

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                int j = favorite[i];
                // favorite[favorite[i]] = i, 说明相互喜欢， 即 环的大小为2
                if (favorite[j] == i) {
                    total = total + dp[i] + dp[j];
                    visit[i] = true;
                    visit[j] = true;
                } else {
                    // 否则环的大小至少为 3， 此时找出环并计算大小
                    int u = i, cnt =  0;
                    while (true) {
                        cnt++;
                        u = favorite[u];
                        visit[u] = true;
                        // 绕完了整个环
                        if (u == i) {
                            break;
                        }
                    }

                    ring = Math.max(ring, cnt);
                }
            }
        }

        return Math.max(ring, total);
    }
}
```



## 相关话题

- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [图](https://leetcode.cn//tag/graph)
- [拓扑排序](https://leetcode.cn//tag/topological-sort)

## 相似题目



