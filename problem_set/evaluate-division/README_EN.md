
| English | [简体中文](README.md) |

# [399. Evaluate Division](https://leetcode.cn//problems/evaluate-division/)

## Description

<p>You are given an array of variable pairs <code>equations</code> and an array of real numbers <code>values</code>, where <code>equations[i] = [A<sub>i</sub>, B<sub>i</sub>]</code> and <code>values[i]</code> represent the equation <code>A<sub>i</sub> / B<sub>i</sub> = values[i]</code>. Each <code>A<sub>i</sub></code> or <code>B<sub>i</sub></code> is a string that represents a single variable.</p>

<p>You are also given some <code>queries</code>, where <code>queries[j] = [C<sub>j</sub>, D<sub>j</sub>]</code> represents the <code>j<sup>th</sup></code> query where you must find the answer for <code>C<sub>j</sub> / D<sub>j</sub> = ?</code>.</p>

<p>Return <em>the answers to all queries</em>. If a single answer cannot be determined, return <code>-1.0</code>.</p>

<p><strong>Note:</strong> The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> equations = [[&quot;a&quot;,&quot;b&quot;],[&quot;b&quot;,&quot;c&quot;]], values = [2.0,3.0], queries = [[&quot;a&quot;,&quot;c&quot;],[&quot;b&quot;,&quot;a&quot;],[&quot;a&quot;,&quot;e&quot;],[&quot;a&quot;,&quot;a&quot;],[&quot;x&quot;,&quot;x&quot;]]
<strong>Output:</strong> [6.00000,0.50000,-1.00000,1.00000,-1.00000]
<strong>Explanation:</strong> 
Given: <em>a / b = 2.0</em>, <em>b / c = 3.0</em>
queries are: <em>a / c = ?</em>, <em>b / a = ?</em>, <em>a / e = ?</em>, <em>a / a = ?</em>, <em>x / x = ?</em>
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> equations = [[&quot;a&quot;,&quot;b&quot;],[&quot;b&quot;,&quot;c&quot;],[&quot;bc&quot;,&quot;cd&quot;]], values = [1.5,2.5,5.0], queries = [[&quot;a&quot;,&quot;c&quot;],[&quot;c&quot;,&quot;b&quot;],[&quot;bc&quot;,&quot;cd&quot;],[&quot;cd&quot;,&quot;bc&quot;]]
<strong>Output:</strong> [3.75000,0.40000,5.00000,0.20000]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> equations = [[&quot;a&quot;,&quot;b&quot;]], values = [0.5], queries = [[&quot;a&quot;,&quot;b&quot;],[&quot;b&quot;,&quot;a&quot;],[&quot;a&quot;,&quot;c&quot;],[&quot;x&quot;,&quot;y&quot;]]
<strong>Output:</strong> [0.50000,2.00000,-1.00000,-1.00000]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= equations.length &lt;= 20</code></li>
	<li><code>equations[i].length == 2</code></li>
	<li><code>1 &lt;= A<sub>i</sub>.length, B<sub>i</sub>.length &lt;= 5</code></li>
	<li><code>values.length == equations.length</code></li>
	<li><code>0.0 &lt; values[i] &lt;= 20.0</code></li>
	<li><code>1 &lt;= queries.length &lt;= 20</code></li>
	<li><code>queries[i].length == 2</code></li>
	<li><code>1 &lt;= C<sub>j</sub>.length, D<sub>j</sub>.length &lt;= 5</code></li>
	<li><code>A<sub>i</sub>, B<sub>i</sub>, C<sub>j</sub>, D<sub>j</sub></code> consist of lower case English letters and digits.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 除法求值 (Evaluate Division)
// @Author: robert.sunq
// @Date: 2021-06-28 00:09:56
// @Runtime: 1 ms
// @Memory: 37.3 MB

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int count=0;
        //统计出现的所有字符，并赋予对应的index
        Map<String,Integer> map=new HashMap<>();
        // 即节点信息
        for (List<String> list:equations){
            for (String s:list){
                if(!map.containsKey(s)){
                    // 此处的 count 即为字符在矩阵中的位置
                    map.put(s,count++);
                }
            }
        }
        
        //构建一个矩阵来代替图结构
        // graph[row][col] 表示 字符 row/col的值
        double[][] graph=new double[count+1][count+1];
        
        //初始化
        for (String s:map.keySet()){
            int x=map.get(s);
            graph[x][x]=1.0;
        }
        int index=0;
        // 将一直结果放入矩阵
        for (List<String> list:equations){
            // 获取字符
            String a=list.get(0);
            String b=list.get(1);
            // 获取字符对应的坐标
            int aa=map.get(a);
            int bb=map.get(b);
            // 将其放入矩阵中
            double value=values[index++];
            graph[aa][bb]=value;
            graph[bb][aa]=1/value;
        }
        
        //通过Floyd算法进行运算
        int n=count+1;
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                // 将所有可以计算的结果进行计算
                // 即  计算任意两个节点之间的值
                for (int k=0;k<n;k++){
                    if(j==k||graph[j][k]!=0) continue;
                    if(graph[j][i]!=0&&graph[i][k]!=0){
                        // j/k = j/i * i/k
                        graph[j][k]=graph[j][i]*graph[i][k];
                    }
                }
            }
        }
        
        //直接通过查询矩阵得到答案
        double[] res=new double[queries.size()];
        for (int i=0;i<res.length;i++){
            List<String> q=queries.get(i);
            // 获得需要计算的两个字符
            String a=q.get(0);
            String b=q.get(1);
            // 判断知否在节点中，并计算
            if(map.containsKey(a)&&map.containsKey(b)){
                double ans=graph[map.get(a)][map.get(b)];
                res[i]=(ans==0?-1.0:ans);
            }else {
                res[i]=-1.0;
            }
        }
        return res;
    }
}
```



## Related Topics

- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Breadth-First Search](https://leetcode.cn//tag/breadth-first-search)
- [Union Find](https://leetcode.cn//tag/union-find)
- [Graph](https://leetcode.cn//tag/graph)
- [Array](https://leetcode.cn//tag/array)
- [Shortest Path](https://leetcode.cn//tag/shortest-path)

## Similar Questions


