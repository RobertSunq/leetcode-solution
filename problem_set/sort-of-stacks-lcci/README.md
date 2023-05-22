
| [English](README_EN.md) | 简体中文 |

# [面试题 03.05. 栈排序](https://leetcode.cn//problems/sort-of-stacks-lcci/)

## 题目描述

<p>栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：<code>push</code>、<code>pop</code>、<code>peek</code> 和 <code>isEmpty</code>。当栈为空时，<code>peek</code>&nbsp;返回 -1。</p>

<p><strong>示例1:</strong></p>

<pre><strong> 输入</strong>：
[&quot;SortedStack&quot;, &quot;push&quot;, &quot;push&quot;, &quot;peek&quot;, &quot;pop&quot;, &quot;peek&quot;]
[[], [1], [2], [], [], []]
<strong> 输出</strong>：
[null,null,null,1,null,2]
</pre>

<p><strong>示例2:</strong></p>

<pre><strong> 输入</strong>： 
[&quot;SortedStack&quot;, &quot;pop&quot;, &quot;pop&quot;, &quot;push&quot;, &quot;pop&quot;, &quot;isEmpty&quot;]
[[], [], [], [1], [], []]
<strong> 输出</strong>：
[null,null,null,null,null,true]
</pre>

<p><strong>说明:</strong></p>

<ol>
	<li>栈中的元素数目在[0, 5000]范围内。</li>
</ol>


## 题解


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



## 相关话题

- [栈](https://leetcode.cn//tag/stack)
- [设计](https://leetcode.cn//tag/design)
- [单调栈](https://leetcode.cn//tag/monotonic-stack)

## 相似题目



