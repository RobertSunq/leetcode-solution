
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 31. 栈的压入、弹出序列](https://leetcode.cn//problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/)

## 题目描述

<p>输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
<strong>输出：</strong>true
<strong>解释：</strong>我们可以按以下顺序执行：
push(1), push(2), push(3), push(4), pop() -&gt; 4,
push(5), pop() -&gt; 5, pop() -&gt; 3, pop() -&gt; 2, pop() -&gt; 1
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
<strong>输出：</strong>false
<strong>解释：</strong>1 不能在 2 之前弹出。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>0 &lt;= pushed.length == popped.length &lt;= 1000</code></li>
	<li><code>0 &lt;= pushed[i], popped[i] &lt; 1000</code></li>
	<li><code>pushed</code>&nbsp;是&nbsp;<code>popped</code>&nbsp;的排列。</li>
</ol>

<p>注意：本题与主站 946 题相同：<a href="https://leetcode-cn.com/problems/validate-stack-sequences/">https://leetcode-cn.com/problems/validate-stack-sequences/</a></p>


## 题解


### Java

```Java
// @Title: 栈的压入、弹出序列 (栈的压入、弹出序列 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-27 00:07:27
// @Runtime: 3 ms
// @Memory: 38.3 MB

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> st = new LinkedList<>();
        int n = pushed.length;
        int m = popped.length;
        if(n != m) return false;
        int i=0,j=0;
        // 值判断 J 因为 i 一定时先于j达到最大值。
        while(j< m){
            if(st.isEmpty()) {
                st.addLast(pushed[i]);
                i++;
            }else{
                if(st.getLast() == popped[j]){
                    st.removeLast();
                    j++;
                }else {
                    // 需要 i 超出输入的长度继续输入，则肯定是不匹配的
                    if(i >= n ) return false;
                    st.addLast(pushed[i]);
                    i++; 
                }
            }
        }
        if(i == n &&  j == m && st.isEmpty()) return true;
        return false; 
    }
}
```



## 相关话题

- [栈](https://leetcode.cn//tag/stack)
- [数组](https://leetcode.cn//tag/array)
- [模拟](https://leetcode.cn//tag/simulation)

## 相似题目



