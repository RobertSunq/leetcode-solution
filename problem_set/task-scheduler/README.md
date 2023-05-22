
| [English](README_EN.md) | 简体中文 |

# [621. 任务调度器](https://leetcode.cn//problems/task-scheduler/)

## 题目描述

<p>给你一个用字符数组 <code>tasks</code> 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。</p>

<p>然而，两个<strong> 相同种类</strong> 的任务之间必须有长度为整数<strong> </strong><code>n</code><strong> </strong>的冷却时间，因此至少有连续 <code>n</code> 个单位时间内 CPU 在执行不同的任务，或者在待命状态。</p>

<p>你需要计算完成所有任务所需要的<strong> 最短时间</strong> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>tasks = ["A","A","A","B","B","B"], n = 2
<strong>输出：</strong>8
<strong>解释：</strong>A -> B -> (待命) -> A -> B -> (待命) -> A -> B
     在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。 </pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>tasks = ["A","A","A","B","B","B"], n = 0
<strong>输出：</strong>6
<strong>解释：</strong>在这种情况下，任何大小为 6 的排列都可以满足要求，因为 n = 0
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]
...
诸如此类
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
<strong>输出：</strong>16
<strong>解释：</strong>一种可能的解决方案是：
     A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命) -> (待命) -> A -> (待命) -> (待命) -> A
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= task.length <= 10<sup>4</sup></code></li>
	<li><code>tasks[i]</code> 是大写英文字母</li>
	<li><code>n</code> 的取值范围为 <code>[0, 100]</code></li>
</ul>


## 题解


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



## 相关话题

- [贪心](https://leetcode.cn//tag/greedy)
- [数组](https://leetcode.cn//tag/array)
- [哈希表](https://leetcode.cn//tag/hash-table)
- [计数](https://leetcode.cn//tag/counting)
- [排序](https://leetcode.cn//tag/sorting)
- [堆（优先队列）](https://leetcode.cn//tag/heap-priority-queue)

## 相似题目


- [K 距离间隔重排字符串](../rearrange-string-k-distance-apart/README.md)
- [重构字符串](../reorganize-string/README.md)
