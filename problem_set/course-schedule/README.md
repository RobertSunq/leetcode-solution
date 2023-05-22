
| [English](README_EN.md) | 简体中文 |

# [207. 课程表](https://leetcode.cn//problems/course-schedule/)

## 题目描述

<p>你这个学期必须选修 <code>numCourses</code> 门课程，记为 <code>0</code> 到 <code>numCourses - 1</code> 。</p>

<p>在选修某些课程之前需要一些先修课程。 先修课程按数组 <code>prerequisites</code> 给出，其中 <code>prerequisites[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> ，表示如果要学习课程 <code>a<sub>i</sub></code> 则 <strong>必须</strong> 先学习课程  <code>b<sub>i</sub></code><sub> </sub>。</p>

<ul>
	<li>例如，先修课程对 <code>[0, 1]</code> 表示：想要学习课程 <code>0</code> ，你需要先完成课程 <code>1</code> 。</li>
</ul>

<p>请你判断是否可能完成所有课程的学习？如果可以，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>numCourses = 2, prerequisites = [[1,0]]
<strong>输出：</strong>true
<strong>解释：</strong>总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>numCourses = 2, prerequisites = [[1,0],[0,1]]
<strong>输出：</strong>false
<strong>解释：</strong>总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= numCourses <= 10<sup>5</sup></code></li>
	<li><code>0 <= prerequisites.length <= 5000</code></li>
	<li><code>prerequisites[i].length == 2</code></li>
	<li><code>0 <= a<sub>i</sub>, b<sub>i</sub> < numCourses</code></li>
	<li><code>prerequisites[i]</code> 中的所有课程对 <strong>互不相同</strong></li>
</ul>


## 题解


### Java

```Java
// @Title: 课程表 (Course Schedule)
// @Author: robert.sunq
// @Date: 2021-06-16 22:16:35
// @Runtime: 25 ms
// @Memory: 39 MB

class Solution {

    // 拓扑排序
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 各点的入度
        int[] count = new int[numCourses];
        // 保存入度为零的点
        Stack<Integer> st = new Stack<>();
        // 保存拓扑排序序列
        for(int i=0;i<prerequisites.length;i++){
            count[prerequisites[i][0]]++;
        }
        for(int i=0;i<numCourses;i++){
            // 入读为零的点放入栈，
            if(count[i] == 0){
                st.push(i);
            }
        }
        // 记录访问点的个数
        int res = 0;
        while(!st.isEmpty()){
            int temp = st.pop();
            res++;
            // 将以temp为起点的 入度减一
            for(int i=0;i<prerequisites.length;i++){
                if(prerequisites[i][1] == temp){
                    count[prerequisites[i][0]]--;
                    // 出现入度为零，则该点放入栈
                    if(count[prerequisites[i][0]] == 0){
                        st.push(prerequisites[i][0]);
                    }
                }
                
            }
        }
        return res == numCourses;
    }
}
```



## 相关话题

- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [广度优先搜索](https://leetcode.cn//tag/breadth-first-search)
- [图](https://leetcode.cn//tag/graph)
- [拓扑排序](https://leetcode.cn//tag/topological-sort)

## 相似题目


- [课程表 II](../course-schedule-ii/README.md)
- [以图判树](../graph-valid-tree/README.md)
- [最小高度树](../minimum-height-trees/README.md)
- [课程表 III](../course-schedule-iii/README.md)
