
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 09. 用两个栈实现队列](https://leetcode.cn//problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/)

## 题目描述

<p>用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 <code>appendTail</code> 和 <code>deleteHead</code> ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，<code>deleteHead</code>&nbsp;操作返回 -1 )</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>
["CQueue","appendTail","deleteHead","deleteHead","deleteHead"]
[[],[3],[],[],[]]
<strong>输出：</strong>[null,null,3,-1,-1]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
<strong>输出：</strong>[null,-1,null,null,5,2]
</pre>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= values &lt;= 10000</code></li>
	<li>最多会对<code>&nbsp;appendTail、deleteHead </code>进行<code>&nbsp;10000</code>&nbsp;次调用</li>
</ul>


## 题解


### Java

```Java
// @Title: 用两个栈实现队列 (用两个栈实现队列 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-24 22:52:14
// @Runtime: 270 ms
// @Memory: 47.7 MB

class CQueue {

    LinkedList<Integer> A, B;

    public CQueue() {
        A = new LinkedList<Integer>();
        B = new LinkedList<Integer>();
    }
    
    public void appendTail(int value) {
        if(A.isEmpty()) {
           A.addLast(value); 
           return;
        }
        do{
            B.addLast(A.removeLast());
        }while(!A.isEmpty());
        A.addLast(value);
        do{
            A.addLast(B.removeLast());
        }while(!B.isEmpty());
    }
    
    public int deleteHead() {
        if (A.size() < 1 ) return -1;
        return A.removeLast();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
```



## 相关话题

- [栈](https://leetcode.cn//tag/stack)
- [设计](https://leetcode.cn//tag/design)
- [队列](https://leetcode.cn//tag/queue)

## 相似题目



