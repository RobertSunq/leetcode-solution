
| [English](README_EN.md) | 简体中文 |

# [面试题 03.02. 栈的最小值](https://leetcode.cn//problems/min-stack-lcci/)

## 题目描述

<p>请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。</p><br><p><strong>示例：</strong><pre>MinStack minStack = new MinStack();<br>minStack.push(-2);<br>minStack.push(0);<br>minStack.push(-3);<br>minStack.getMin();   --> 返回 -3.<br>minStack.pop();<br>minStack.top();      --> 返回 0.<br>minStack.getMin();   --> 返回 -2.</pre></p>

## 题解


### C++

```C++
// @Title: 栈的最小值 (Min Stack LCCI)
// @Author: robert.sunq
// @Date: 2020-03-26 16:49:10
// @Runtime: 48 ms
// @Memory: 14.9 MB

class MinStack {
public:
    /** initialize your data structure here. */
    MinStack() {
        top_st = -1;
        top_minst = -1;
    }
    
    void push(int x) {
        if(top_minst == -1 || minst[top_minst] >= x){
            minst.push_back(x);
            top_minst++;
        } 
        st.push_back(x);
        top_st++;
        return ;
    }
    
    void pop() {
        if(top_st < 0) return;
        if(st[top_st] == minst[top_minst]) {
            minst.pop_back();
            top_minst--;
        }
        st.pop_back();
        top_st--;
        return ;

    }
    
    int top() {
        if(top_st <0) return -1;
        return st[top_st];

    }
    
    int getMin() {
        if(top_minst <0) return 0;
        return minst[top_minst];

    }
protected:
    vector<int> st,minst;
    int top_st = -1,top_minst = -1;
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
```



## 相关话题

- [栈](https://leetcode.cn//tag/stack)
- [设计](https://leetcode.cn//tag/design)

## 相似题目



