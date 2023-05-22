
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 59 - II. 队列的最大值](https://leetcode.cn//problems/dui-lie-de-zui-da-zhi-lcof/)

## 题目描述

<p>请定义一个队列并实现函数 <code>max_value</code> 得到队列里的最大值，要求函数<code>max_value</code>、<code>push_back</code> 和 <code>pop_front</code> 的<strong>均摊</strong>时间复杂度都是O(1)。</p>

<p>若队列为空，<code>pop_front</code> 和 <code>max_value</code>&nbsp;需要返回 -1</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入:</strong> 
[&quot;MaxQueue&quot;,&quot;push_back&quot;,&quot;push_back&quot;,&quot;max_value&quot;,&quot;pop_front&quot;,&quot;max_value&quot;]
[[],[1],[2],[],[],[]]
<strong>输出:&nbsp;</strong>[null,null,null,2,1,2]
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入:</strong> 
[&quot;MaxQueue&quot;,&quot;pop_front&quot;,&quot;max_value&quot;]
[[],[],[]]
<strong>输出:&nbsp;</strong>[null,-1,-1]
</pre>

<p>&nbsp;</p>

<p><strong>限制：</strong></p>

<ul>
	<li><code>1 &lt;= push_back,pop_front,max_value的总操作数&nbsp;&lt;= 10000</code></li>
	<li><code>1 &lt;= value &lt;= 10^5</code></li>
</ul>


## 题解


### Java

```Java
// @Title: 队列的最大值 (队列的最大值 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 21:57:06
// @Runtime: 41 ms
// @Memory: 46.3 MB

class MaxQueue {
    Queue<Integer> A ;
    LinkedList<Integer> maxA;
    public MaxQueue() {
        A = new LinkedList<Integer>();
        maxA = new LinkedList<Integer>();
    }
    
    public int max_value() {
        if(maxA.isEmpty()) return -1;
        return maxA.getFirst();
    }
    
    public void push_back(int value) {
        A.offer(value);
        while(!maxA.isEmpty() && maxA.getLast() < value) maxA.removeLast();
        maxA.addLast(value);
    }
    
    public int pop_front() {
        if(A.isEmpty()) return -1;
        int temp = A.poll();
        if(temp == maxA.getFirst()) maxA.removeFirst();
        return temp;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
```



## 相关话题

- [设计](https://leetcode.cn//tag/design)
- [队列](https://leetcode.cn//tag/queue)
- [单调队列](https://leetcode.cn//tag/monotonic-queue)

## 相似题目



