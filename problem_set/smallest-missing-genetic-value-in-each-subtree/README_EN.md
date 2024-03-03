
| English | [简体中文](README.md) |

# [2003. Smallest Missing Genetic Value in Each Subtree](https://leetcode.cn//problems/smallest-missing-genetic-value-in-each-subtree/)

## Description

<p>There is a <strong>family tree</strong> rooted at <code>0</code> consisting of <code>n</code> nodes numbered <code>0</code> to <code>n - 1</code>. You are given a <strong>0-indexed</strong> integer array <code>parents</code>, where <code>parents[i]</code> is the parent for node <code>i</code>. Since node <code>0</code> is the <strong>root</strong>, <code>parents[0] == -1</code>.</p>

<p>There are <code>10<sup>5</sup></code> genetic values, each represented by an integer in the <strong>inclusive</strong> range <code>[1, 10<sup>5</sup>]</code>. You are given a <strong>0-indexed</strong> integer array <code>nums</code>, where <code>nums[i]</code> is a <strong>distinct </strong>genetic value for node <code>i</code>.</p>

<p>Return <em>an array </em><code>ans</code><em> of length </em><code>n</code><em> where </em><code>ans[i]</code><em> is</em> <em>the <strong>smallest</strong> genetic value that is <strong>missing</strong> from the subtree rooted at node</em> <code>i</code>.</p>

<p>The <strong>subtree</strong> rooted at a node <code>x</code> contains node <code>x</code> and all of its <strong>descendant</strong> nodes.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/08/23/case-1.png" style="width: 204px; height: 167px;" />
<pre>
<strong>Input:</strong> parents = [-1,0,0,2], nums = [1,2,3,4]
<strong>Output:</strong> [5,1,1,1]
<strong>Explanation:</strong> The answer for each subtree is calculated as follows:
- 0: The subtree contains nodes [0,1,2,3] with values [1,2,3,4]. 5 is the smallest missing value.
- 1: The subtree contains only node 1 with value 2. 1 is the smallest missing value.
- 2: The subtree contains nodes [2,3] with values [3,4]. 1 is the smallest missing value.
- 3: The subtree contains only node 3 with value 4. 1 is the smallest missing value.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/08/23/case-2.png" style="width: 247px; height: 168px;" />
<pre>
<strong>Input:</strong> parents = [-1,0,1,0,3,3], nums = [5,4,6,2,1,3]
<strong>Output:</strong> [7,1,1,4,2,1]
<strong>Explanation:</strong> The answer for each subtree is calculated as follows:
- 0: The subtree contains nodes [0,1,2,3,4,5] with values [5,4,6,2,1,3]. 7 is the smallest missing value.
- 1: The subtree contains nodes [1,2] with values [4,6]. 1 is the smallest missing value.
- 2: The subtree contains only node 2 with value 6. 1 is the smallest missing value.
- 3: The subtree contains nodes [3,4,5] with values [2,1,3]. 4 is the smallest missing value.
- 4: The subtree contains only node 4 with value 1. 2 is the smallest missing value.
- 5: The subtree contains only node 5 with value 3. 1 is the smallest missing value.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> parents = [-1,2,3,0,2,4,1], nums = [2,3,4,5,6,7,8]
<strong>Output:</strong> [1,1,1,1,1,1,1]
<strong>Explanation:</strong> The value 1 is missing from all the subtrees.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == parents.length == nums.length</code></li>
	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= parents[i] &lt;= n - 1</code> for <code>i != 0</code></li>
	<li><code>parents[0] == -1</code></li>
	<li><code>parents</code> represents a valid tree.</li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
	<li>Each <code>nums[i]</code> is distinct.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 每棵子树内缺失的最小基因值 (Smallest Missing Genetic Value in Each Subtree)
// @Author: robert.sunq
// @Date: 2023-10-31 23:29:30
// @Runtime: 68 ms
// @Memory: 79 MB

class Solution {
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int n = parents.length;

        List<Integer>[] children = new List[n];

        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        // 创建子节点列表， 每个数组表示其子节点
        for (int i = 1; i < n; i++) {
            children[parents[i]].add(i);
        }

        Set<Integer> geneSet = new HashSet<>();
        boolean[] visited = new boolean[n];

        int[] ans = new int[n];

        // 初始化结果， 因为基因值种最小值为1， 所以存在的最小 缺失 基因值默认为 1 
        // 对于 不包含 基因 1 的节点的树，其最小 缺失 基因值就是 1
        Arrays.fill(ans, 1);

        // 记录已经找到的 缺失 基因值
        int iNode = 1;
        // 记录 1 所在的节点
        int node = -1;

        // 找现有的基因值种 1 的位置
        for (int i = 0; i < n; i++) {
            if (nums[i]  == 1) {
                node = i;
                break;
            }
        }

        // 即 如果存在 1， 那么所有包含 1 基因 的树中，缺失的最小值都不是 1， 那么就需要dfs遍历这个树
        // 的所有基因， 来找到其最小的 缺失 基因值
        // 从 基因 1 的树开始 向上遍历树， 因为 包含父节点时包含子节点的所有节点的， 所有父节点的最小缺失值是 大于等于 子节点的最小缺失值
        while (node != -1) {
            dfs(node, nums, children, geneSet, visited);

            // 这里的技巧， 将基因值 从小到大一步一步遍历， 当某个基因值不存在于 树中时，这个基因值就是最小缺失的
            while (geneSet.contains(iNode)) {
                iNode++;
            }

            // 当前处理的子树
            ans[node] = iNode;
            
            // 向上找其夫节点的最小值， 其父节点的最小 缺失 一定是 大于或等于子节点的， 因为包含关系
            node = parents[node];

        }
        // 对于不包含 基因1 的树，其最小缺失值就是 1
        return ans;
    }

    public void dfs(int node, int[] nums, List<Integer>[] children, Set<Integer> geneSet, boolean[] visited) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;
        geneSet.add(nums[node]);
        for (int child : children[node]) {
            dfs(child, nums, children, geneSet, visited);
        }
    }
}
```



## Related Topics

- [Tree](https://leetcode.cn//tag/tree)
- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Union Find](https://leetcode.cn//tag/union-find)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions


