
| English | [简体中文](README.md) |

# [面试题 03.01. Three in One LCCI](https://leetcode.cn//problems/three-in-one-lcci/)

## Description

<p>Describe how you could use a single array to implement three stacks.</p>

<p>You&nbsp;should implement&nbsp;<code>push(stackNum, value)</code>、<code>pop(stackNum)</code>、<code>isEmpty(stackNum)</code>、<code>peek(stackNum)</code>&nbsp;methods.&nbsp;<code>stackNum<font face="sans-serif, Arial, Verdana, Trebuchet MS">&nbsp;</font></code><font face="sans-serif, Arial, Verdana, Trebuchet MS">is the index of the stack.&nbsp;</font><code>value</code>&nbsp;is the value that pushed to the stack.</p>

<p>The constructor requires a&nbsp;<code>stackSize</code>&nbsp;parameter, which represents the size of each stack.</p>

<p><strong>Example1:</strong></p>

<pre>
<strong> Input</strong>: 
[&quot;TripleInOne&quot;, &quot;push&quot;, &quot;push&quot;, &quot;pop&quot;, &quot;pop&quot;, &quot;pop&quot;, &quot;isEmpty&quot;]
[[1], [0, 1], [0, 2], [0], [0], [0], [0]]
<strong> Output</strong>: 
[null, null, null, 1, -1, -1, true]
<b>Explanation</b>: When the stack is empty, `pop, peek` return -1. When the stack is full, `push` does nothing.
</pre>

<p><strong>Example2:</strong></p>

<pre>
<strong> Input</strong>: 
[&quot;TripleInOne&quot;, &quot;push&quot;, &quot;push&quot;, &quot;push&quot;, &quot;pop&quot;, &quot;pop&quot;, &quot;pop&quot;, &quot;peek&quot;]
[[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
<strong> Output</strong>: 
[null, null, null, null, 2, 1, -1, -1]
</pre>


## Solutions


### C++

```C++
// @Title: 三合一 (Three in One LCCI)
// @Author: robert.sunq
// @Date: 2020-03-26 16:26:56
// @Runtime: 148 ms
// @Memory: 32.5 MB

class TripleInOne {
public:
    TripleInOne(int stackSize) {
        Size = stackSize;
        for(int i=0;i<3;i++){
            vector<int> an;
            st.push_back(an);
            tops[i] = -1;
        }
    }
    
    void push(int stackNum, int value) {
        if(tops[stackNum] >= Size-1) return;
        st[stackNum].push_back(value);
        tops[stackNum] ++;
    }
    
    int pop(int stackNum) {
        if(tops[stackNum] <0) return -1;
        
        int temp = st[stackNum][tops[stackNum]];
        st[stackNum].pop_back();
        tops[stackNum] --;
        return temp;
    }
    
    int peek(int stackNum) {
        if(tops[stackNum] < 0) return -1;
        return st[stackNum][tops[stackNum]];

    }
    
    bool isEmpty(int stackNum) {
        if(tops[stackNum] < 0) return true;
        return false;

    }

protected:
    vector<vector<int> > st;
    int Size=0;
    int tops[3] ;
};

/**
 * Your TripleInOne object will be instantiated and called as such:
 * TripleInOne* obj = new TripleInOne(stackSize);
 * obj->push(stackNum,value);
 * int param_2 = obj->pop(stackNum);
 * int param_3 = obj->peek(stackNum);
 * bool param_4 = obj->isEmpty(stackNum);
 */
```



## Related Topics

- [Stack](https://leetcode.cn//tag/stack)
- [Design](https://leetcode.cn//tag/design)
- [Array](https://leetcode.cn//tag/array)

## Similar Questions


