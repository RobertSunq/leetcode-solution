
| [English](README_EN.md) | 简体中文 |

# [面试题 03.01. 三合一](https://leetcode.cn//problems/three-in-one-lcci/)

## 题目描述

<p>三合一。描述如何只用一个数组来实现三个栈。</p>

<p>你应该实现<code>push(stackNum, value)</code>、<code>pop(stackNum)</code>、<code>isEmpty(stackNum)</code>、<code>peek(stackNum)</code>方法。<code>stackNum</code>表示栈下标，<code>value</code>表示压入的值。</p>

<p>构造函数会传入一个<code>stackSize</code>参数，代表每个栈的大小。</p>

<p><strong>示例1:</strong></p>

<pre>
<strong> 输入</strong>：
["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
[[1], [0, 1], [0, 2], [0], [0], [0], [0]]
<strong> 输出</strong>：
[null, null, null, 1, -1, -1, true]
<strong>说明</strong>：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
</pre>

<p><strong>示例2:</strong></p>

<pre>
<strong> 输入</strong>：
["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
[[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
<strong> 输出</strong>：
[null, null, null, null, 2, 1, -1, -1]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 &lt;= stackNum &lt;= 2</code></li>
</ul>


## 题解


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



## 相关话题

- [栈](https://leetcode.cn//tag/stack)
- [设计](https://leetcode.cn//tag/design)
- [数组](https://leetcode.cn//tag/array)

## 相似题目



