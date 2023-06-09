
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 30. 包含min函数的栈](https://leetcode.cn//problems/bao-han-minhan-shu-de-zhan-lcof/)

## 题目描述

<p>定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。</p>

<p>&nbsp;</p>

<p><strong>示例:</strong></p>

<pre>MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();   --&gt; 返回 -3.
minStack.pop();
minStack.top();      --&gt; 返回 0.
minStack.min();   --&gt; 返回 -2.
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li>各函数的调用总次数不超过 20000 次</li>
</ol>

<p>&nbsp;</p>

<p>注意：本题与主站 155 题相同：<a href="https://leetcode-cn.com/problems/min-stack/">https://leetcode-cn.com/problems/min-stack/</a></p>


## 题解


### Java

```Java
// @Title: 包含min函数的栈 (包含min函数的栈 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-26 23:50:41
// @Runtime: 22 ms
// @Memory: 40.1 MB

class MinStack {

    LinkedList<Integer> st;
    LinkedList<Integer> minSt = new LinkedList<Integer>();
    /** initialize your data structure here. */
    public MinStack() {
        st = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        st.addLast(x);
        // 维护最小值栈，为非严格递减
        if(minSt.isEmpty() || x<= minSt.getLast()) minSt.addLast(x);
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        int temp = st.removeLast();
        if(temp == minSt.getLast()) minSt.removeLast();
    }
    
    public int top() {
        if(st.isEmpty()) return -1;
        return st.getLast();
    }
    
    public int min() {
        if(minSt.isEmpty()) return -1;
        return minSt.getLast();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
```



## 相关话题

- [栈](https://leetcode.cn//tag/stack)
- [设计](https://leetcode.cn//tag/design)

## 相似题目



