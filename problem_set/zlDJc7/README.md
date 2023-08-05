
| [English](README_EN.md) | 简体中文 |

# [LCR 109. 打开转盘锁](https://leetcode.cn//problems/zlDJc7/)

## 题目描述

<p>一个密码锁由 4&nbsp;个环形拨轮组成，每个拨轮都有 10 个数字： <code>&#39;0&#39;, &#39;1&#39;, &#39;2&#39;, &#39;3&#39;, &#39;4&#39;, &#39;5&#39;, &#39;6&#39;, &#39;7&#39;, &#39;8&#39;, &#39;9&#39;</code> 。每个拨轮可以自由旋转：例如把 <code>&#39;9&#39;</code> 变为&nbsp;<code>&#39;0&#39;</code>，<code>&#39;0&#39;</code> 变为 <code>&#39;9&#39;</code> 。每次旋转都只能旋转一个拨轮的一位数字。</p>

<p>锁的初始数字为 <code>&#39;0000&#39;</code> ，一个代表四个拨轮的数字的字符串。</p>

<p>列表 <code>deadends</code> 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。</p>

<p>字符串 <code>target</code> 代表可以解锁的数字，请给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 <code>-1</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入：</strong>deadends = [&quot;0201&quot;,&quot;0101&quot;,&quot;0102&quot;,&quot;1212&quot;,&quot;2002&quot;], target = &quot;0202&quot;
<strong>输出：</strong>6
<strong>解释：</strong>
可能的移动序列为 &quot;0000&quot; -&gt; &quot;1000&quot; -&gt; &quot;1100&quot; -&gt; &quot;1200&quot; -&gt; &quot;1201&quot; -&gt; &quot;1202&quot; -&gt; &quot;0202&quot;。
注意 &quot;0000&quot; -&gt; &quot;0001&quot; -&gt; &quot;0002&quot; -&gt; &quot;0102&quot; -&gt; &quot;0202&quot; 这样的序列是不能解锁的，因为当拨动到 &quot;0102&quot; 时这个锁就会被锁定。
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> deadends = [&quot;8888&quot;], target = &quot;0009&quot;
<strong>输出：</strong>1
<strong>解释：</strong>
把最后一位反向旋转一次即可 &quot;0000&quot; -&gt; &quot;0009&quot;。
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入:</strong> deadends = [&quot;8887&quot;,&quot;8889&quot;,&quot;8878&quot;,&quot;8898&quot;,&quot;8788&quot;,&quot;8988&quot;,&quot;7888&quot;,&quot;9888&quot;], target = &quot;8888&quot;
<strong>输出：</strong>-1
<strong>解释：
</strong>无法旋转到目标数字且不被锁定。
</pre>

<p><strong>示例 4:</strong></p>

<pre>
<strong>输入:</strong> deadends = [&quot;0000&quot;], target = &quot;8888&quot;
<strong>输出：</strong>-1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;=&nbsp;deadends.length &lt;= 500</code></li>
	<li><code><font face="monospace">deadends[i].length == 4</font></code></li>
	<li><code><font face="monospace">target.length == 4</font></code></li>
	<li><code>target</code> <strong>不在</strong> <code>deadends</code> 之中</li>
	<li><code>target</code> 和 <code>deadends[i]</code> 仅由若干位数字组成</li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 752&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/open-the-lock/">https://leetcode-cn.com/problems/open-the-lock/</a></p>


## 题解


### Java

```Java
// @Title: 打开转盘锁 (打开转盘锁)
// @Author: robert.sunq
// @Date: 2023-08-04 22:39:06
// @Runtime: 68 ms
// @Memory: 44.2 MB

class Solution {
    public int openLock(String[] deadends, String target) {
        if ("0000".equals(target)) {
            return 0;
        }

        Set<String> dead = new HashSet<String>();
        for (String str : deadends) {
            dead.add(str);
        }

        // 一次都不用拨动，直接锁死
        if (dead.contains("0000")) {
            return -1;
        }

        int step = 0;
        Queue<String> queue = new LinkedList<String>();
        queue.offer("0000");
        Set<String> seen = new HashSet<String>();
        seen.add("0000");

        while(!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String status = queue.poll();
                // 拨动一个字符后，得到的下一个序列
                for (String nextStatus : bfs(status)) {
                    // 未访问过的，或者不是死亡状态
                    if (!seen.contains(nextStatus) && !dead.contains(nextStatus)) {
                        if (nextStatus.equals(target)) {
                            return step;
                        }
                        queue.offer(nextStatus);
                        seen.add(nextStatus);
                    }
                }
            }
        }
        // 没找到
        return -1;
    }

    private List<String> bfs(String status) {
        List<String> ans = new ArrayList<>();
        char[] array = status.toCharArray();
        for (int i = 0; i <4 ; i++) {
            char c = array[i];
            // 前拨，  0  -- 1 -- 2
            array[i] = c == '9' ? '0' : (char) (c + 1);
            ans.add(new String(array));
            // 后拨    0  -- 9 -- 8
            array[i] = c == '0' ? '9' : (char) (c - 1);
            ans.add(new String(array));

            // 恢复现场
            array[i] = c;
        }

        return ans;
    }
}
```



## 相关话题

- [广度优先搜索](https://leetcode.cn//tag/breadth-first-search)
- [数组](https://leetcode.cn//tag/array)
- [哈希表](https://leetcode.cn//tag/hash-table)
- [字符串](https://leetcode.cn//tag/string)

## 相似题目



