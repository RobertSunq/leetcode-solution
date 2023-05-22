
| [English](README_EN.md) | 简体中文 |

# [面试题 03.03. 堆盘子](https://leetcode.cn//problems/stack-of-plates-lcci/)

## 题目描述

<p>堆盘子。设想有一堆盘子，堆太高可能会倒下来。因此，在现实生活中，盘子堆到一定高度时，我们就会另外堆一堆盘子。请实现数据结构<code>SetOfStacks</code>，模拟这种行为。<code>SetOfStacks</code>应该由多个栈组成，并且在前一个栈填满时新建一个栈。此外，<code>SetOfStacks.push()</code>和<code>SetOfStacks.pop()</code>应该与普通栈的操作方法相同（也就是说，pop()返回的值，应该跟只有一个栈时的情况一样）。 进阶：实现一个<code>popAt(int index)</code>方法，根据指定的子栈，执行pop操作。</p>

<p>当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，<code>pop</code>，<code>popAt</code>&nbsp;应返回 -1.</p>

<p><strong>示例1:</strong></p>

<pre><strong> 输入</strong>：
[&quot;StackOfPlates&quot;, &quot;push&quot;, &quot;push&quot;, &quot;popAt&quot;, &quot;pop&quot;, &quot;pop&quot;]
[[1], [1], [2], [1], [], []]
<strong> 输出</strong>：
[null, null, null, 2, 1, -1]
</pre>

<p><strong>示例2:</strong></p>

<pre><strong> 输入</strong>：
[&quot;StackOfPlates&quot;, &quot;push&quot;, &quot;push&quot;, &quot;push&quot;, &quot;popAt&quot;, &quot;popAt&quot;, &quot;popAt&quot;]
[[2], [1], [2], [3], [0], [0], [0]]
<strong> 输出</strong>：
[null, null, null, null, 2, 1, 3]
</pre>


## 题解


### C++

```C++
// @Title: 堆盘子 (Stack of Plates LCCI)
// @Author: robert.sunq
// @Date: 2020-04-02 00:39:52
// @Runtime: 112 ms
// @Memory: 26.8 MB

class StackOfPlates {
public:
    StackOfPlates(int cap) {
        max_size = cap;

    }
    
    void push(int val) {
        int rows = st.size();
        if(max_size == 0) return ;
        if(rows == 0) {
            vector<int> temps;
            temps.push_back(val);
            st.push_back(temps);
        }
        else{
            int cols = st[rows-1].size();
            if(cols<max_size) st[rows-1].push_back(val);
            else{
                vector<int> temps;
                temps.push_back(val);
                st.push_back(temps);
            }
        }
    }
    
    int pop() {
        int rows = st.size();
        if(rows == 0) return -1;
        else{
            int cols = st[rows-1].size();
            int temp = st[rows-1][cols-1];
            if (cols-1 == 0) st.erase(st.begin()+rows-1);
            else{
                st[rows-1].pop_back();
            }
            return temp;
            
        }

    }
    
    int popAt(int index) {

        int rows = st.size();
        if(rows == 0) return -1;
        else{
            if(index > rows -1) return -1;
            else{
                int cols = st[index].size();
                int temp = st[index][cols-1];
                
                if(cols -1 == 0) st.erase(st.begin()+index);
                else{
                    st[index].pop_back();
                }

                rows = st.size();
                return temp;
            } 
        }

    }

protected:
    vector<vector<int> > st;
    int max_size = 0;
};

/**
 * Your StackOfPlates object will be instantiated and called as such:
 * StackOfPlates* obj = new StackOfPlates(cap);
 * obj->push(val);
 * int param_2 = obj->pop();
 * int param_3 = obj->popAt(index);
 */
```



## 相关话题

- [栈](https://leetcode.cn//tag/stack)
- [设计](https://leetcode.cn//tag/design)
- [链表](https://leetcode.cn//tag/linked-list)

## 相似题目



