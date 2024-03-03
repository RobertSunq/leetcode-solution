
| [English](README_EN.md) | 简体中文 |

# [841. 钥匙和房间](https://leetcode.cn//problems/keys-and-rooms/)

## 题目描述

<p>有 <code>n</code> 个房间，房间按从 <code>0</code> 到 <code>n - 1</code> 编号。最初，除 <code>0</code> 号房间外的其余所有房间都被锁住。你的目标是进入所有的房间。然而，你不能在没有获得钥匙的时候进入锁住的房间。</p>

<p>当你进入一个房间，你可能会在里面找到一套不同的钥匙，每把钥匙上都有对应的房间号，即表示钥匙可以打开的房间。你可以拿上所有钥匙去解锁其他房间。</p>

<p>给你一个数组 <code>rooms</code> 其中 <code>rooms[i]</code> 是你进入 <code>i</code> 号房间可以获得的钥匙集合。如果能进入 <strong>所有</strong> 房间返回 <code>true</code>，否则返回 <code>false</code>。</p>

<p>&nbsp;</p>

<ol>
</ol>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>rooms = [[1],[2],[3],[]]
<strong>输出：</strong>true
<strong>解释：</strong>
我们从 0 号房间开始，拿到钥匙 1。
之后我们去 1 号房间，拿到钥匙 2。
然后我们去 2 号房间，拿到钥匙 3。
最后我们去了 3 号房间。
由于我们能够进入每个房间，我们返回 true。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>rooms = [[1,3],[3,0,1],[2],[0]]
<strong>输出：</strong>false
<strong>解释：</strong>我们不能进入 2 号房间。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == rooms.length</code></li>
	<li><code>2 &lt;= n &lt;= 1000</code></li>
	<li><code>0 &lt;= rooms[i].length &lt;= 1000</code></li>
	<li><code>1 &lt;= sum(rooms[i].length) &lt;= 3000</code></li>
	<li><code>0 &lt;= rooms[i][j] &lt; n</code></li>
	<li>所有 <code>rooms[i]</code> 的值 <strong>互不相同</strong></li>
</ul>


## 题解


### Java

```Java
// @Title: 钥匙和房间 (Keys and Rooms)
// @Author: robert.sunq
// @Date: 2023-09-08 22:27:59
// @Runtime: 4 ms
// @Memory: 41.9 MB

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> ans = new HashSet<>();
        for (int i = 0; i<rooms.size(); i++) {
            ans.add(i);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int n : rooms.get(0)) {
            queue.add(n);
        }
        ans.remove(0);

        while(!queue.isEmpty()) {
            int n = queue.poll();
            if (ans.contains(n)) {
                for (int k : rooms.get(n)) {
                    queue.add(k);
                }
                ans.remove(n);
            }
        }
        return ans.isEmpty();
    }
}
```



## 相关话题

- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [广度优先搜索](https://leetcode.cn//tag/breadth-first-search)
- [图](https://leetcode.cn//tag/graph)

## 相似题目


