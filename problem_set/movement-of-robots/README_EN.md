
| English | [简体中文](README.md) |

# [2731. Movement of Robots](https://leetcode.cn//problems/movement-of-robots/)

## Description

<p>Some robots are standing on an infinite number line with their initial coordinates given by a <strong>0-indexed</strong> integer array <code>nums</code> and will start moving once given the command to move. The robots will move a unit distance each second.</p>

<p>You are given a string <code>s</code> denoting the direction in which robots will move on command. <code>&#39;L&#39;</code> means the robot will move towards the left side or negative side of the number line, whereas <code>&#39;R&#39;</code> means the robot will move towards the right side or positive side of the number line.</p>

<p>If two robots collide, they will start moving in opposite directions.</p>

<p>Return <em>the sum of distances between all the&nbsp;pairs of robots </em><code>d</code> <em>seconds after&nbsp;the command. </em>Since the sum can be very large, return it modulo <code>10<sup>9</sup> + 7</code>.</p>

<p><b>Note: </b></p>

<ul>
	<li>For two robots at the index <code>i</code> and <code>j</code>, pair <code>(i,j)</code> and pair <code>(j,i)</code> are considered the same pair.</li>
	<li>When robots collide, they <strong>instantly change</strong> their directions without wasting any time.</li>
	<li>Collision happens&nbsp;when two robots share the same place in a&nbsp;moment.
	<ul>
		<li>For example, if a robot is positioned in 0 going to the right and another is positioned in 2 going to the left, the next second they&#39;ll be both in 1 and they will change direction and the next second the first one will be in 0, heading left, and another will be in 2, heading right.</li>
		<li>For example,&nbsp;if a robot is positioned in 0 going to the right and another is positioned in 1&nbsp;going to the left, the next second the first one will be in 0, heading left, and another will be in 1, heading right.</li>
	</ul>
	</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [-2,0,2], s = &quot;RLL&quot;, d = 3
<strong>Output:</strong> 8
<strong>Explanation:</strong> 
After 1 second, the positions are [-1,-1,1]. Now, the robot at index 0 will move left, and the robot at index 1 will move right.
After 2 seconds, the positions are [-2,0,0]. Now, the robot at index 1 will move left, and the robot at index 2 will move right.
After 3 seconds, the positions are [-3,-1,1].
The distance between the robot at index 0 and 1 is abs(-3 - (-1)) = 2.
The distance between the robot at index 0 and 2 is abs(-3 - 1) = 4.
The distance between the robot at index 1 and 2 is abs(-1 - 1) = 2.
The sum of the pairs of all distances = 2 + 4 + 2 = 8.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,0], s = &quot;RL&quot;, d = 2
<strong>Output:</strong> 5
<strong>Explanation:</strong> 
After 1 second, the positions are [2,-1].
After 2 seconds, the positions are [3,-2].
The distance between the two robots is abs(-2 - 3) = 5.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-2 * 10<sup>9</sup>&nbsp;&lt;= nums[i] &lt;= 2 * 10<sup>9</sup></code></li>
	<li><code>0 &lt;= d &lt;= 10<sup>9</sup></code></li>
	<li><code>nums.length == s.length&nbsp;</code></li>
	<li><code>s</code> consists of &#39;L&#39; and &#39;R&#39; only</li>
	<li><code>nums[i]</code>&nbsp;will be unique.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 移动机器人 (Movement of Robots)
// @Author: robert.sunq
// @Date: 2023-10-10 22:19:58
// @Runtime: 13 ms
// @Memory: 53.2 MB

class Solution {
    // 当两个机器人相撞时，它们会沿着原本相反的方向移动。
    // 由于机器人之间并灭有任何区别，相撞可以看作是穿透，
    // 原本左边的机器人相撞后交换为右边的机器人，原本右边的机器人相撞后交换为左边的机器人
    // 如此，可以无视相撞，独立计算每个机器人d秒后所在的位置即可

    private static final int MOD = 1000000007;
    public int sumDistance(int[] nums, String s, int d) {

        int n = nums.length;
        long[] pos = new long[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'L') {
                pos[i] = (long) nums[i] - d;
            } else {
                pos[i] = (long) nums[i] + d;
            }
        }

        Arrays.sort(pos);
        long ans = 0;
        for (int i = 1; i < n; i++) {
            // 注意这里计算的是排序后的两个相近节点之间的距离
            // 在计算两两节点之间的具体时， 这个相邻的节点会被重复计算多次， 次数就是左侧的节点数 * 右侧（包含本身）
            ans = (ans + (pos[i] - pos[i - 1]) * i % MOD * (n - i) % MOD) % MOD;
        }

        return (int) ans;
    }
}
```



## Related Topics

- [Brainteaser](https://leetcode.cn//tag/brainteaser)
- [Array](https://leetcode.cn//tag/array)
- [Prefix Sum](https://leetcode.cn//tag/prefix-sum)
- [Sorting](https://leetcode.cn//tag/sorting)

## Similar Questions


