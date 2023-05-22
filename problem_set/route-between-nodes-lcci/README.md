
| [English](README_EN.md) | 简体中文 |

# [面试题 04.01. 节点间通路](https://leetcode.cn//problems/route-between-nodes-lcci/)

## 题目描述

<p>节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。</p>

<p><strong>示例1:</strong></p>

<pre><strong> 输入</strong>：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
<strong> 输出</strong>：true
</pre>

<p><strong>示例2:</strong></p>

<pre><strong> 输入</strong>：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]], start = 0, target = 4
<strong> 输出</strong> true
</pre>

<p><strong>提示：</strong></p>

<ol>
	<li>节点数量n在[0, 1e5]范围内。</li>
	<li>节点编号大于等于 0 小于 n。</li>
	<li>图中可能存在自环和平行边。</li>
</ol>


## 题解


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



## 相关话题

- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [广度优先搜索](https://leetcode.cn//tag/breadth-first-search)
- [图](https://leetcode.cn//tag/graph)

## 相似题目



