
| [English](README_EN.md) | 简体中文 |

# [649. Dota2 参议院](https://leetcode.cn//problems/dota2-senate/)

## 题目描述

<p>Dota2 的世界里有两个阵营：<code>Radiant</code>（天辉）和&nbsp;<code>Dire</code>（夜魇）</p>

<p>Dota2 参议院由来自两派的参议员组成。现在参议院希望对一个 Dota2 游戏里的改变作出决定。他们以一个基于轮为过程的投票进行。在每一轮中，每一位参议员都可以行使两项权利中的 <strong>一 </strong>项：</p>

<ul>
	<li><strong>禁止一名参议员的权利</strong>：参议员可以让另一位参议员在这一轮和随后的几轮中丧失<strong> 所有的权利 </strong>。</li>
	<li><strong>宣布胜利</strong>：如果参议员发现有权利投票的参议员都是 <strong>同一个阵营的</strong> ，他可以宣布胜利并决定在游戏中的有关变化。</li>
</ul>

<p>给你一个字符串&nbsp;<code>senate</code> 代表每个参议员的阵营。字母 <code>'R'</code> 和 <code>'D'</code>分别代表了&nbsp;<code>Radiant</code>（天辉）和&nbsp;<code>Dire</code>（夜魇）。然后，如果有 <code>n</code> 个参议员，给定字符串的大小将是&nbsp;<code>n</code>。</p>

<p>以轮为基础的过程从给定顺序的第一个参议员开始到最后一个参议员结束。这一过程将持续到投票结束。所有失去权利的参议员将在过程中被跳过。</p>

<p>假设每一位参议员都足够聪明，会为自己的政党做出最好的策略，你需要预测哪一方最终会宣布胜利并在 Dota2 游戏中决定改变。输出应该是&nbsp;<code>"Radiant"</code> 或 <code>"Dire"</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>senate = "RD"
<strong>输出：</strong>"Radiant"
<strong>解释：
</strong><code>第 1 轮时，第一个参议员来自 Radiant 阵营，他可以使用第一项权利让第二个参议员失去所有权利。
这一轮中，第二个参议员将会被跳过，因为他的权利被禁止了。
第 2 轮时，第一个参议员可以宣布胜利，因为他是唯一一个有投票权的人</code>。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>senate = "RDD"
<strong>输出：</strong>"Dire"
<strong>解释：</strong>
第 1 轮时，第一个<code>来自 Radiant 阵营的</code>参议员可以使用第一项权利禁止第二个参议员的权利。
<code>这一轮中，</code>第二个<code>来自 Dire 阵营的</code>参议员会将被跳过，因为他的权利被禁止了。
<code>这一轮中，</code>第三个<code>来自 Dire 阵营的</code>参议员可以使用他的第一项权利禁止第一个参议员的权利。
因此在第二轮只剩下第三个参议员拥有投票的权利,于是他可以宣布胜利
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == senate.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>4</sup></code></li>
	<li><code>senate[i]</code> 为 <code>'R'</code> 或 <code>'D'</code></li>
</ul>


## 题解


### Java

```Java
// @Title: Dota2 参议院 (Dota2 Senate)
// @Author: robert.sunq
// @Date: 2023-08-28 19:35:24
// @Runtime: 290 ms
// @Memory: 40.2 MB

class Solution {
    public String predictPartyVictory(String senate) {
        int RCount = 0;
        int DCount = 0;
        int n = senate.length();
        char[] cs = senate.toCharArray();
        for (char c : cs) {
            if (c == 'R') {
                RCount++;
            } else {
                DCount++;
            }
        }

        while(RCount != 0 && DCount != 0) {
            for (int i = 0; i < n; i++) {
                char c = cs[i];
                if (c == 'A') {
                    continue;
                } else if (c == 'R') {
                    if (DCount == 0) {
                        return "Radiant";
                    }
                    DCount--;
                    for (int j = (i + 1) % n; j != i; ) {
                        if (cs[j] == 'D') {
                            cs[j] = 'A';
                            break;
                        }
                        j = (j + 1) % n;
                    }
                } else {
                    if (RCount == 0) {
                        return "Dire";
                    } 
                    RCount--;
                    for (int j = (i + 1) % n; j != i;) {
                        if (cs[j] == 'R') {
                            cs[j] = 'A';
                            break;
                        }
                        j = (j + 1) % n;
                    }
                }
            }
        }

        return RCount == 0 ? "Dire" : "Radiant";
    }

/** 
    
     public String predictPartyVictory(String senate) {
        int n = senate.length();
        // 模拟投票队列
        Queue<Integer> radiant = new LinkedList<Integer>();
        Queue<Integer> dire = new LinkedList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int radiantIndex = radiant.poll(), direIndex = dire.poll();
            // 索引小的先投票，将另一个队列的队头删除。
            if (radiantIndex < direIndex) {
                // 如果索引不变，会影响当前轮次和下一轮次的比较优先级，所以 + n
                radiant.offer(radiantIndex + n);
            } else {
                dire.offer(direIndex + n);
            }
        }
        return !radiant.isEmpty() ? "Radiant" : "Dire";
    }
*/
}
```



## 相关话题

- [贪心](https://leetcode.cn//tag/greedy)
- [队列](https://leetcode.cn//tag/queue)
- [字符串](https://leetcode.cn//tag/string)

## 相似题目


- [提莫攻击](../teemo-attacking/README.md)
