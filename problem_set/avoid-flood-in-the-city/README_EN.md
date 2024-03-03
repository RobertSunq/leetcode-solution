
| English | [简体中文](README.md) |

# [1488. Avoid Flood in The City](https://leetcode.cn//problems/avoid-flood-in-the-city/)

## Description

<p>Your country has an infinite number of lakes. Initially, all the lakes are empty, but when it rains over the <code>nth</code> lake, the <code>nth</code> lake becomes full of water. If it rains over a lake that is <strong>full of water</strong>, there will be a <strong>flood</strong>. Your goal is to avoid floods in any lake.</p>

<p>Given an integer array <code>rains</code> where:</p>

<ul>
	<li><code>rains[i] &gt; 0</code> means there will be rains over the <code>rains[i]</code> lake.</li>
	<li><code>rains[i] == 0</code> means there are no rains this day and you can choose <strong>one lake</strong> this day and <strong>dry it</strong>.</li>
</ul>

<p>Return <em>an array <code>ans</code></em> where:</p>

<ul>
	<li><code>ans.length == rains.length</code></li>
	<li><code>ans[i] == -1</code> if <code>rains[i] &gt; 0</code>.</li>
	<li><code>ans[i]</code> is the lake you choose to dry in the <code>ith</code> day if <code>rains[i] == 0</code>.</li>
</ul>

<p>If there are multiple valid answers return <strong>any</strong> of them. If it is impossible to avoid flood return <strong>an empty array</strong>.</p>

<p>Notice that if you chose to dry a full lake, it becomes empty, but if you chose to dry an empty lake, nothing changes.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> rains = [1,2,3,4]
<strong>Output:</strong> [-1,-1,-1,-1]
<strong>Explanation:</strong> After the first day full lakes are [1]
After the second day full lakes are [1,2]
After the third day full lakes are [1,2,3]
After the fourth day full lakes are [1,2,3,4]
There&#39;s no day to dry any lake and there is no flood in any lake.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> rains = [1,2,0,0,2,1]
<strong>Output:</strong> [-1,-1,2,1,-1,-1]
<strong>Explanation:</strong> After the first day full lakes are [1]
After the second day full lakes are [1,2]
After the third day, we dry lake 2. Full lakes are [1]
After the fourth day, we dry lake 1. There is no full lakes.
After the fifth day, full lakes are [2].
After the sixth day, full lakes are [1,2].
It is easy that this scenario is flood-free. [-1,-1,1,2,-1,-1] is another acceptable scenario.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> rains = [1,2,0,1,2]
<strong>Output:</strong> []
<strong>Explanation:</strong> After the second day, full lakes are  [1,2]. We have to dry one lake in the third day.
After that, it will rain over lakes [1,2]. It&#39;s easy to prove that no matter which lake you choose to dry in the 3rd day, the other one will flood.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= rains.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= rains[i] &lt;= 10<sup>9</sup></code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 避免洪水泛滥 (Avoid Flood in The City)
// @Author: robert.sunq
// @Date: 2023-10-13 20:36:46
// @Runtime: 60 ms
// @Memory: 59 MB

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        
        // 保存可以用作来抽干的天， 在某个湖泊第二次下雨的时候，
        // 找到 大于等于上次下雨时间，的最小的晴天，来达到对晴天抽干的最大利用
        TreeSet<Integer> st = new TreeSet<>();

        // 保存  湖泊rains[i] 和上次下雨积满的日期 i
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                st.add(i);
            } else {
                // 雨天， - 1
                ans[i] = -1;

                // 说明该湖泊已经下雨积满了一次，需要吧前一次的选则日期排空
                if (map.containsKey(rains[i])) {
                    // 从现有的晴天中，找到大于上次积满时的最小的晴天，
                    Integer tmp = st.ceiling(map.get(rains[i]));

                    // 每找到，也就是无法及时排空
                    if (tmp == null) {
                        return new int[0];
                    }

                    // 找到的排空日期，放入需要排空的湖泊
                    ans[tmp] = rains[i];

                    st.remove(tmp);
                }
                // 注意这里， 排空一次后，需要把这次填满的时间，及时放入
                map.put(rains[i], i);
            }
        }

        return ans;
    }
}
```



## Related Topics

- [Greedy](https://leetcode.cn//tag/greedy)
- [Array](https://leetcode.cn//tag/array)
- [Hash Table](https://leetcode.cn//tag/hash-table)
- [Binary Search](https://leetcode.cn//tag/binary-search)
- [Heap (Priority Queue)](https://leetcode.cn//tag/heap-priority-queue)

## Similar Questions


