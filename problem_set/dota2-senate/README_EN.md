
| English | [简体中文](README.md) |

# [649. Dota2 Senate](https://leetcode.cn//problems/dota2-senate/)

## Description

<p>In the world of Dota2, there are two parties: the Radiant and the Dire.</p>

<p>The Dota2 senate consists of senators coming from two parties. Now the Senate wants to decide on a change in the Dota2 game. The voting for this change is a round-based procedure. In each round, each senator can exercise <strong>one</strong> of the two rights:</p>

<ul>
	<li><strong>Ban one senator&#39;s right:</strong> A senator can make another senator lose all his rights in this and all the following rounds.</li>
	<li><strong>Announce the victory:</strong> If this senator found the senators who still have rights to vote are all from the same party, he can announce the victory and decide on the change in the game.</li>
</ul>

<p>Given a string <code>senate</code> representing each senator&#39;s party belonging. The character <code>&#39;R&#39;</code> and <code>&#39;D&#39;</code> represent the Radiant party and the Dire party. Then if there are <code>n</code> senators, the size of the given string will be <code>n</code>.</p>

<p>The round-based procedure starts from the first senator to the last senator in the given order. This procedure will last until the end of voting. All the senators who have lost their rights will be skipped during the procedure.</p>

<p>Suppose every senator is smart enough and will play the best strategy for his own party. Predict which party will finally announce the victory and change the Dota2 game. The output should be <code>&quot;Radiant&quot;</code> or <code>&quot;Dire&quot;</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> senate = &quot;RD&quot;
<strong>Output:</strong> &quot;Radiant&quot;
<strong>Explanation:</strong> 
The first senator comes from Radiant and he can just ban the next senator&#39;s right in round 1. 
And the second senator can&#39;t exercise any rights anymore since his right has been banned. 
And in round 2, the first senator can just announce the victory since he is the only guy in the senate who can vote.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> senate = &quot;RDD&quot;
<strong>Output:</strong> &quot;Dire&quot;
<strong>Explanation:</strong> 
The first senator comes from Radiant and he can just ban the next senator&#39;s right in round 1. 
And the second senator can&#39;t exercise any rights anymore since his right has been banned. 
And the third senator comes from Dire and he can ban the first senator&#39;s right in round 1. 
And in round 2, the third senator can just announce the victory since he is the only guy in the senate who can vote.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == senate.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>4</sup></code></li>
	<li><code>senate[i]</code> is either <code>&#39;R&#39;</code> or <code>&#39;D&#39;</code>.</li>
</ul>


## Solutions


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



## Related Topics

- [Greedy](https://leetcode.cn//tag/greedy)
- [Queue](https://leetcode.cn//tag/queue)
- [String](https://leetcode.cn//tag/string)

## Similar Questions

- [Teemo Attacking](../teemo-attacking/README_EN.md)
