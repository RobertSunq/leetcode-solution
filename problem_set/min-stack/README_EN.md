
| English | [简体中文](README.md) |

# [155. Min Stack](https://leetcode.cn//problems/min-stack/)

## Description

<p>Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.</p>

<p>Implement the <code>MinStack</code> class:</p>

<ul>
	<li><code>MinStack()</code> initializes the stack object.</li>
	<li><code>void push(int val)</code> pushes the element <code>val</code> onto the stack.</li>
	<li><code>void pop()</code> removes the element on the top of the stack.</li>
	<li><code>int top()</code> gets the top element of the stack.</li>
	<li><code>int getMin()</code> retrieves the minimum element in the stack.</li>
</ul>

<p>You must implement a solution with <code>O(1)</code> time complexity for each function.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input</strong>
[&quot;MinStack&quot;,&quot;push&quot;,&quot;push&quot;,&quot;push&quot;,&quot;getMin&quot;,&quot;pop&quot;,&quot;top&quot;,&quot;getMin&quot;]
[[],[-2],[0],[-3],[],[],[],[]]

<strong>Output</strong>
[null,null,null,null,-3,null,0,-2]

<strong>Explanation</strong>
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>-2<sup>31</sup> &lt;= val &lt;= 2<sup>31</sup> - 1</code></li>
	<li>Methods <code>pop</code>, <code>top</code> and <code>getMin</code> operations will always be called on <strong>non-empty</strong> stacks.</li>
	<li>At most <code>3 * 10<sup>4</sup></code> calls will be made to <code>push</code>, <code>pop</code>, <code>top</code>, and <code>getMin</code>.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 最小栈 (Min Stack)
// @Author: robert.sunq
// @Date: 2021-06-14 21:50:01
// @Runtime: 7 ms
// @Memory: 40.2 MB

class MinStack {


    Stack<Integer> st ;
    Stack<Integer> minSt;
    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack<Integer>();
        minSt = new Stack<Integer>();
    }
    
    public void push(int val) {
        if(minSt.isEmpty()){
            minSt.push(val);
        }else{
            if(minSt.peek() >= val){
                minSt.push(val);
            }
        }
        st.push(val);
    }
    
    public void pop() {
        if(st.isEmpty()) return ;
        int temp = st.pop();
        if(!minSt.isEmpty() &&  temp == minSt.peek()){
            minSt.pop();
        }
    }
    
    public int top() {
        if(st.isEmpty()) return -1;
        int temp = st.peek();
        return temp;
    }
    
    public int getMin() {
        if(minSt.isEmpty()) return -1;
        return minSt.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```



## Related Topics

- [Stack](https://leetcode.cn//tag/stack)
- [Design](https://leetcode.cn//tag/design)

## Similar Questions

- [Sliding Window Maximum](../sliding-window-maximum/README_EN.md)
- [Max Stack](../max-stack/README_EN.md)
