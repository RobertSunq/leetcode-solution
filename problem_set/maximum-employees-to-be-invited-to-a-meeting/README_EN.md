
| English | [简体中文](README.md) |

# [2127. Maximum Employees to Be Invited to a Meeting](https://leetcode.cn//problems/maximum-employees-to-be-invited-to-a-meeting/)

## Description

<p>A company is organizing a meeting and has a list of <code>n</code> employees, waiting to be invited. They have arranged for a large <strong>circular</strong> table, capable of seating <strong>any number</strong> of employees.</p>

<p>The employees are numbered from <code>0</code> to <code>n - 1</code>. Each employee has a <strong>favorite</strong> person and they will attend the meeting <strong>only if</strong> they can sit next to their favorite person at the table. The favorite person of an employee is <strong>not</strong> themself.</p>

<p>Given a <strong>0-indexed</strong> integer array <code>favorite</code>, where <code>favorite[i]</code> denotes the favorite person of the <code>i<sup>th</sup></code> employee, return <em>the <strong>maximum number of employees</strong> that can be invited to the meeting</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/12/14/ex1.png" style="width: 236px; height: 195px;" />
<pre>
<strong>Input:</strong> favorite = [2,2,1,2]
<strong>Output:</strong> 3
<strong>Explanation:</strong>
The above figure shows how the company can invite employees 0, 1, and 2, and seat them at the round table.
All employees cannot be invited because employee 2 cannot sit beside employees 0, 1, and 3, simultaneously.
Note that the company can also invite employees 1, 2, and 3, and give them their desired seats.
The maximum number of employees that can be invited to the meeting is 3. 
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> favorite = [1,2,0]
<strong>Output:</strong> 3
<strong>Explanation:</strong> 
Each employee is the favorite person of at least one other employee, and the only way the company can invite them is if they invite every employee.
The seating arrangement will be the same as that in the figure given in example 1:
- Employee 0 will sit between employees 2 and 1.
- Employee 1 will sit between employees 0 and 2.
- Employee 2 will sit between employees 1 and 0.
The maximum number of employees that can be invited to the meeting is 3.
</pre>

<p><strong class="example">Example 3:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/12/14/ex2.png" style="width: 219px; height: 220px;" />
<pre>
<strong>Input:</strong> favorite = [3,0,1,4,1]
<strong>Output:</strong> 4
<strong>Explanation:</strong>
The above figure shows how the company will invite employees 0, 1, 3, and 4, and seat them at the round table.
Employee 2 cannot be invited because the two spots next to their favorite employee 1 are taken.
So the company leaves them out of the meeting.
The maximum number of employees that can be invited to the meeting is 4.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == favorite.length</code></li>
	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= favorite[i] &lt;=&nbsp;n - 1</code></li>
	<li><code>favorite[i] != i</code></li>
</ul>


## Solutions


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



## Related Topics

- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Graph](https://leetcode.cn//tag/graph)
- [Topological Sort](https://leetcode.cn//tag/topological-sort)

## Similar Questions


