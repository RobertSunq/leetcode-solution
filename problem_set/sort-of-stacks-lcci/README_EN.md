
| English | [简体中文](README.md) |

# [面试题 03.05. Sort of Stacks LCCI](https://leetcode.cn//problems/sort-of-stacks-lcci/)

## Description

<p>Write a program to sort a stack such that the smallest items are on the top. You can use an additional temporary stack, but you may not copy the elements into any other data structure (such as an array). The stack supports the following operations: <code>push</code>, <code>pop</code>, <code>peek</code>, and <code>isEmpty</code>. When the stack is empty, <code>peek</code> should return -1.</p>

<p><strong>Example1:</strong></p>

<pre>
<strong> Input</strong>: 
[&quot;SortedStack&quot;, &quot;push&quot;, &quot;push&quot;, &quot;peek&quot;, &quot;pop&quot;, &quot;peek&quot;]
[[], [1], [2], [], [], []]
<strong> Output</strong>: 
[null,null,null,1,null,2]
</pre>

<p><strong>Example2:</strong></p>

<pre>
<strong> Input</strong>:  
[&quot;SortedStack&quot;, &quot;pop&quot;, &quot;pop&quot;, &quot;push&quot;, &quot;pop&quot;, &quot;isEmpty&quot;]
[[], [], [], [1], [], []]
<strong> Output</strong>: 
[null,null,null,null,null,true]
</pre>

<p><strong>Note:</strong></p>

<ol>
	<li>The total number of elements in the stack is within the range [0, 5000].</li>
</ol>


## Solutions


### C++

```C++
// @Title: 栈排序 (Sort of Stacks LCCI)
// @Author: robert.sunq
// @Date: 2020-04-08 19:46:53
// @Runtime: 156 ms
// @Memory: 11.8 MB

class SortedStack {
public:
    SortedStack() {
        top_an = -1;
        top_temp = -1;

    }
    
    void push(int val) {
        if(top_an ==-1) {
            an.push_back(val);
            top_an++;

        }
        else if(top_an >= 5000 ) return ;
        else{
            
            while(top_an >-1 && an[top_an] < val){
                temp.push_back(an[top_an]);
                top_temp++;
                top_an--;
                an.pop_back();
            }
            an.push_back(val);
            top_an++;
            while(top_temp > -1){
                an.push_back(temp[top_temp]);
                top_temp--;
                top_an++;
                temp.pop_back();
            }

        }

    }
    
    void pop() {
        if(top_an == -1) return;
        else{
            top_an--;
            an.pop_back();
        }

    }
    
    int peek() {
        if(top_an == -1) return -1;
        else return an[top_an];

    }
    
    bool isEmpty() {
        if(top_an == -1) return true;
        else return false;

    }

protected: 
   vector<int> an;
   vector<int> temp;
   int top_an = -1;
   int top_temp = -1;
};

/**
 * Your SortedStack object will be instantiated and called as such:
 * SortedStack* obj = new SortedStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->isEmpty();
 */
```



## Related Topics

- [Stack](https://leetcode.cn//tag/stack)
- [Design](https://leetcode.cn//tag/design)
- [Monotonic Stack](https://leetcode.cn//tag/monotonic-stack)

## Similar Questions


