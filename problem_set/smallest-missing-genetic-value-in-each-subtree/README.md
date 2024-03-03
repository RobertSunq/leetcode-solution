
| [English](README_EN.md) | 简体中文 |

# [2003. 每棵子树内缺失的最小基因值](https://leetcode.cn//problems/smallest-missing-genetic-value-in-each-subtree/)

## 题目描述

<p>有一棵根节点为 <code>0</code>&nbsp;的 <strong>家族树</strong>&nbsp;，总共包含 <code>n</code>&nbsp;个节点，节点编号为 <code>0</code>&nbsp;到 <code>n - 1</code>&nbsp;。给你一个下标从 <strong>0</strong>&nbsp;开始的整数数组 <code>parents</code>&nbsp;，其中&nbsp;<code>parents[i]</code>&nbsp;是节点 <code>i</code>&nbsp;的父节点。由于节点 <code>0</code>&nbsp;是 <strong>根</strong>&nbsp;，所以&nbsp;<code>parents[0] == -1</code>&nbsp;。</p>

<p>总共有&nbsp;<code>10<sup>5</sup></code>&nbsp;个基因值，每个基因值都用 <strong>闭区间</strong>&nbsp;<code>[1, 10<sup>5</sup>]</code>&nbsp;中的一个整数表示。给你一个下标从&nbsp;<strong>0</strong>&nbsp;开始的整数数组&nbsp;<code>nums</code>&nbsp;，其中&nbsp;<code>nums[i]</code>&nbsp;是节点 <code>i</code>&nbsp;的基因值，且基因值 <strong>互不相同</strong>&nbsp;。</p>

<p>请你返回一个数组<em>&nbsp;</em><code>ans</code>&nbsp;，长度为&nbsp;<code>n</code>&nbsp;，其中&nbsp;<code>ans[i]</code>&nbsp;是以节点&nbsp;<code>i</code>&nbsp;为根的子树内 <b>缺失</b>&nbsp;的&nbsp;<strong>最小</strong>&nbsp;基因值。</p>

<p>节点 <code>x</code>&nbsp;为根的 <strong>子树&nbsp;</strong>包含节点 <code>x</code>&nbsp;和它所有的 <strong>后代</strong>&nbsp;节点。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/08/23/case-1.png" style="width: 204px; height: 167px;"></p>

<pre><b>输入：</b>parents = [-1,0,0,2], nums = [1,2,3,4]
<b>输出：</b>[5,1,1,1]
<b>解释：</b>每个子树答案计算结果如下：
- 0：子树包含节点 [0,1,2,3] ，基因值分别为 [1,2,3,4] 。5 是缺失的最小基因值。
- 1：子树只包含节点 1 ，基因值为 2 。1 是缺失的最小基因值。
- 2：子树包含节点 [2,3] ，基因值分别为 [3,4] 。1 是缺失的最小基因值。
- 3：子树只包含节点 3 ，基因值为 4 。1是缺失的最小基因值。
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/08/23/case-2.png" style="width: 247px; height: 168px;"></p>

<pre><b>输入：</b>parents = [-1,0,1,0,3,3], nums = [5,4,6,2,1,3]
<b>输出：</b>[7,1,1,4,2,1]
<b>解释：</b>每个子树答案计算结果如下：
- 0：子树内包含节点 [0,1,2,3,4,5] ，基因值分别为 [5,4,6,2,1,3] 。7 是缺失的最小基因值。
- 1：子树内包含节点 [1,2] ，基因值分别为 [4,6] 。 1 是缺失的最小基因值。
- 2：子树内只包含节点 2 ，基因值为 6 。1 是缺失的最小基因值。
- 3：子树内包含节点 [3,4,5] ，基因值分别为 [2,1,3] 。4 是缺失的最小基因值。
- 4：子树内只包含节点 4 ，基因值为 1 。2 是缺失的最小基因值。
- 5：子树内只包含节点 5 ，基因值为 3 。1 是缺失的最小基因值。
</pre>

<p><strong>示例 3：</strong></p>

<pre><b>输入：</b>parents = [-1,2,3,0,2,4,1], nums = [2,3,4,5,6,7,8]
<b>输出：</b>[1,1,1,1,1,1,1]
<b>解释：</b>所有子树都缺失基因值 1 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == parents.length == nums.length</code></li>
	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li>对于&nbsp;<code>i != 0</code>&nbsp;，满足&nbsp;<code>0 &lt;= parents[i] &lt;= n - 1</code></li>
	<li><code>parents[0] == -1</code></li>
	<li><code>parents</code>&nbsp;表示一棵合法的树。</li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
	<li><code>nums[i]</code>&nbsp;互不相同。</li>
</ul>


## 题解


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



## 相关话题

- [树](https://leetcode.cn//tag/tree)
- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [并查集](https://leetcode.cn//tag/union-find)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目



