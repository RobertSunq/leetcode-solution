
| English | [简体中文](README.md) |

# [面试题 04.01. Route Between Nodes LCCI ](https://leetcode.cn//problems/route-between-nodes-lcci/)

## Description

<p>Given a directed graph, design an algorithm to find out whether there is a route between two nodes.</p>

<p><strong>Example1:</strong></p>

<pre>
<strong> Input</strong>: n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
<strong> Output</strong>: true
</pre>

<p><strong>Example2:</strong></p>

<pre>
<strong> Input</strong>: n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]], start = 0, target = 4
<strong> Output</strong> true
</pre>

<p><strong>Note: </strong></p>

<ol>
	<li><code>0 &lt;= n &lt;= 100000</code></li>
	<li>All node numbers are within the range [0, n].</li>
	<li>There might be self cycles and duplicated edges.</li>
</ol>


## Solutions


### C++

```C++
// @Title: 节点间通路 (Route Between Nodes LCCI )
// @Author: robert.sunq
// @Date: 2020-04-09 16:48:16
// @Runtime: 644 ms
// @Memory: 91.4 MB

class Solution {

protected:
    vector<int> virsted;    
    vector<vector<int> > list;
    
    void DFS(int val , int target ){
        if (virsted[val]  || virsted[target]) return;
        else{
            virsted[val] = 1;
            for(int i=1;i<list[val].size();i++){
                if(virsted[list[val][i]] == 0){
                    DFS(list[val][i],target);
                }
            }
        }
    }
public:
    bool findWhetherExistsPath(int n, vector<vector<int>>& graph, int start, int target) {
        
        
        for(int i=0;i<n;i++) {
            vector<int> temp;
            temp.push_back(i);
            list.push_back(temp);
            virsted.push_back(0);
        }
        for(int i=0;i<graph.size();i++){
            list[graph[i][0]].push_back(graph[i][1]);
           // list[graph[i][1]].push_back(graph[i][0]);
        }

       // for(int i=0;i<list.size();i++){
            //for(int j=0;j<list[i].size();j++)
           // cout << list[i][j] << ' ';
           // cout << endl;
       // }
        DFS(start,target);
        if(virsted[target]) return true;
        else return false;
    
    }      

    
};
```



## Related Topics

- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Breadth-First Search](https://leetcode.cn//tag/breadth-first-search)
- [Graph](https://leetcode.cn//tag/graph)

## Similar Questions


