
| English | [简体中文](README.md) |

# [面试题 03.03. Stack of Plates LCCI](https://leetcode.cn//problems/stack-of-plates-lcci/)

## Description

<p>Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold. Implement a data structure <code>SetOfStacks</code> that mimics this.&nbsp;<code>SetOfStacks</code> should be composed of several stacks and should create a new stack once the previous one exceeds capacity. <code>SetOfStacks.push()</code> and <code>SetOfStacks.pop()</code> should behave identically to a single stack (that is, <code>pop()</code> should return the same values as it would if there were just a single stack). Follow Up: Implement a function <code>popAt(int index)</code> which performs a pop operation on a specific sub-stack.</p>

<p>You should delete the sub-stack when it becomes empty. <code>pop</code>, <code>popAt</code> should return -1 when there&#39;s no element to pop.</p>

<p><strong>Example1:</strong></p>

<pre>
<strong> Input</strong>: 
[&quot;StackOfPlates&quot;, &quot;push&quot;, &quot;push&quot;, &quot;popAt&quot;, &quot;pop&quot;, &quot;pop&quot;]
[[1], [1], [2], [1], [], []]
<strong> Output</strong>: 
[null, null, null, 2, 1, -1]
<strong> Explanation</strong>: 
</pre>

<p><strong>Example2:</strong></p>

<pre>
<strong> Input</strong>: 
[&quot;StackOfPlates&quot;, &quot;push&quot;, &quot;push&quot;, &quot;push&quot;, &quot;popAt&quot;, &quot;popAt&quot;, &quot;popAt&quot;]
[[2], [1], [2], [3], [0], [0], [0]]
<strong> Output</strong>: 
[null, null, null, null, 2, 1, 3]
</pre>


## Solutions


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



## Related Topics

- [Stack](https://leetcode.cn//tag/stack)
- [Design](https://leetcode.cn//tag/design)
- [Linked List](https://leetcode.cn//tag/linked-list)

## Similar Questions


