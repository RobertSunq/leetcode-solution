
| English | [简体中文](README.md) |

# [621. Task Scheduler](https://leetcode.cn//problems/task-scheduler/)

## Description

<p>Given a characters array <code>tasks</code>, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.</p>

<p>However, there is a non-negative integer&nbsp;<code>n</code> that represents the cooldown period between&nbsp;two <b>same tasks</b>&nbsp;(the same letter in the array), that is that there must be at least <code>n</code> units of time between any two same tasks.</p>

<p>Return <em>the least number of units of times that the CPU will take to finish all the given tasks</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> tasks = [&quot;A&quot;,&quot;A&quot;,&quot;A&quot;,&quot;B&quot;,&quot;B&quot;,&quot;B&quot;], n = 2
<strong>Output:</strong> 8
<strong>Explanation:</strong> 
A -&gt; B -&gt; idle -&gt; A -&gt; B -&gt; idle -&gt; A -&gt; B
There is at least 2 units of time between any two same tasks.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> tasks = [&quot;A&quot;,&quot;A&quot;,&quot;A&quot;,&quot;B&quot;,&quot;B&quot;,&quot;B&quot;], n = 0
<strong>Output:</strong> 6
<strong>Explanation:</strong> On this case any permutation of size 6 would work since n = 0.
[&quot;A&quot;,&quot;A&quot;,&quot;A&quot;,&quot;B&quot;,&quot;B&quot;,&quot;B&quot;]
[&quot;A&quot;,&quot;B&quot;,&quot;A&quot;,&quot;B&quot;,&quot;A&quot;,&quot;B&quot;]
[&quot;B&quot;,&quot;B&quot;,&quot;B&quot;,&quot;A&quot;,&quot;A&quot;,&quot;A&quot;]
...
And so on.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> tasks = [&quot;A&quot;,&quot;A&quot;,&quot;A&quot;,&quot;A&quot;,&quot;A&quot;,&quot;A&quot;,&quot;B&quot;,&quot;C&quot;,&quot;D&quot;,&quot;E&quot;,&quot;F&quot;,&quot;G&quot;], n = 2
<strong>Output:</strong> 16
<strong>Explanation:</strong> 
One possible solution is
A -&gt; B -&gt; C -&gt; A -&gt; D -&gt; E -&gt; A -&gt; F -&gt; G -&gt; A -&gt; idle -&gt; idle -&gt; A -&gt; idle -&gt; idle -&gt; A
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= task.length &lt;= 10<sup>4</sup></code></li>
	<li><code>tasks[i]</code> is upper-case English letter.</li>
	<li>The integer <code>n</code> is in the range <code>[0, 100]</code>.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 任务调度器 (Task Scheduler)
// @Author: robert.sunq
// @Date: 2021-06-23 22:09:57
// @Runtime: 2 ms
// @Memory: 39.8 MB

class Solution {
    public int leastInterval(char[] tasks, int n) {
        //  不管任务代号是多少，都是一样的，所以主要针对的是不同的词频
        // 统计词频
        int[] dict = new int[26];
        int N = tasks.length;
        for(int  i = 0;i<N;i++){
            dict[tasks[i] - 'A']++;
        }
        // 此时 词频最高的地方再最后面
        Arrays.sort(dict);
        // 需要完成N个任务
        int res = 0;
        int i = 25;
        while(i >=0 && dict[i] == dict[25]) {res++;i--;}

        /**
        * 解题思路：
            * 1、将任务按类型分组，正好A-Z用一个int[26]保存任务类型个数
            * 2、对数组进行排序，优先排列个数（count）最大的任务，
            *      如题得到的时间至少为 retCount =（count-1）* (n+1) + 1 ==> A->X->X->A->X->X->A(X为其他任务或者待命)
            * 3、再排序下一个任务，如果下一个任务B个数和最大任务数一致，
            *      则retCount++ ==> A->B->X->A->B->X->A->B
            * 4、如果空位都插满之后还有任务，那就随便在这些间隔里面插入就可以，
            *      因为间隔长度肯定会大于n，在这种情况下就是任务的总数是最小所需时间 
            */
        return Math.max((dict[25]-1) * (n+1) + res , N);
    }
}
```



## Related Topics

- [Greedy](https://leetcode.cn//tag/greedy)
- [Array](https://leetcode.cn//tag/array)
- [Hash Table](https://leetcode.cn//tag/hash-table)
- [Counting](https://leetcode.cn//tag/counting)
- [Sorting](https://leetcode.cn//tag/sorting)
- [Heap (Priority Queue)](https://leetcode.cn//tag/heap-priority-queue)

## Similar Questions

- [Rearrange String k Distance Apart](../rearrange-string-k-distance-apart/README_EN.md)
- [Reorganize String](../reorganize-string/README_EN.md)
