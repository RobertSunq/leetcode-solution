
| [English](README_EN.md) | 简体中文 |

# [LCR 115. 序列重建](https://leetcode.cn//problems/ur2n8P/)

## 题目描述

<p>给定一个长度为 <code>n</code> 的整数数组 <code>nums</code> ，其中 <code>nums</code> 是范围为 <code>[1，n]</code> 的整数的排列。还提供了一个 2D 整数数组&nbsp;<code>sequences</code>&nbsp;，其中&nbsp;<code>sequences[i]</code>&nbsp;是&nbsp;<code>nums</code>&nbsp;的子序列。<br />
检查 <code>nums</code> 是否是唯一的最短&nbsp;<strong>超序列</strong> 。最短 <strong>超序列</strong> 是 <strong>长度最短</strong> 的序列，并且所有序列&nbsp;<code>sequences[i]</code>&nbsp;都是它的子序列。对于给定的数组&nbsp;<code>sequences</code>&nbsp;，可能存在多个有效的 <strong>超序列</strong> 。</p>

<ul>
	<li>例如，对于&nbsp;<code>sequences = [[1,2],[1,3]]</code>&nbsp;，有两个最短的 <strong>超序列</strong> ，<code>[1,2,3]</code> 和 <code>[1,3,2]</code> 。</li>
	<li>而对于&nbsp;<code>sequences = [[1,2],[1,3],[1,2,3]]</code>&nbsp;，唯一可能的最短 <strong>超序列</strong> 是 <code>[1,2,3]</code> 。<code>[1,2,3,4]</code> 是可能的超序列，但不是最短的。</li>
</ul>

<p><em>如果 <code>nums</code> 是序列的唯一最短 <strong>超序列</strong> ，则返回 <code>true</code> ，否则返回 <code>false</code> 。</em><br />
<strong>子序列</strong> 是一个可以通过从另一个序列中删除一些元素或不删除任何元素，而不改变其余元素的顺序的序列。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3], sequences = [[1,2],[1,3]]
<strong>输出：</strong>false
<strong>解释：</strong>有两种可能的超序列：[1,2,3]和[1,3,2]。
序列 [1,2] 是[<u><strong>1,2</strong></u>,3]和[<u><strong>1</strong></u>,3,<u><strong>2</strong></u>]的子序列。
序列 [1,3] 是[<u><strong>1</strong></u>,2,<u><strong>3</strong></u>]和[<u><strong>1,3</strong></u>,2]的子序列。
因为 nums 不是唯一最短的超序列，所以返回false。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3], sequences = [[1,2]]
<strong>输出：</strong>false
<strong>解释：</strong>最短可能的超序列为 [1,2]。
序列 [1,2] 是它的子序列：[<u><strong>1,2</strong></u>]。
因为 nums 不是最短的超序列，所以返回false。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3], sequences = [[1,2],[1,3],[2,3]]
<strong>输出：</strong>true
<strong>解释：</strong>最短可能的超序列为[1,2,3]。
序列 [1,2] 是它的一个子序列：[<strong>1,2</strong>,3]。
序列 [1,3] 是它的一个子序列：[<u><strong>1</strong></u>,2,<u><strong>3</strong></u>]。
序列 [2,3] 是它的一个子序列：[1,<u><strong>2,3</strong></u>]。
因为 nums 是唯一最短的超序列，所以返回true。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>4</sup></code></li>
	<li><code>nums</code>&nbsp;是&nbsp;<code>[1, n]</code>&nbsp;范围内所有整数的排列</li>
	<li><code>1 &lt;= sequences.length &lt;= 10<sup>4</sup></code></li>
	<li><code>1 &lt;= sequences[i].length &lt;= 10<sup>4</sup></code></li>
	<li><code>1 &lt;= sum(sequences[i].length) &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= sequences[i][j] &lt;= n</code></li>
	<li><code>sequences</code>&nbsp;的所有数组都是 <strong>唯一 </strong>的</li>
	<li><code>sequences[i]</code>&nbsp;是&nbsp;<code>nums</code> 的一个子序列</li>
</ul>

<p>&nbsp;</p>

<p>注意：本题与主站 444&nbsp;题相同：<a href="https://leetcode-cn.com/problems/sequence-reconstruction/">https://leetcode-cn.com/problems/sequence-reconstruction/</a></p>


## 题解


### Java

```Java
// @Title: 序列重建 (序列重建)
// @Author: robert.sunq
// @Date: 2023-08-06 18:26:38
// @Runtime: 50 ms
// @Memory: 52.8 MB

class Solution {
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        Map<Integer, List<Integer>> edges = new HashMap<>();
        Map<Integer, Integer> indexCount = new HashMap<>();

        for (int[] seq : sequences) {
            for (int i = 1; i < seq.length; i++) {
                if (!edges.containsKey(seq[i - 1])) {
                    edges.put(seq[i - 1], new ArrayList<>());
                }
                edges.get(seq[i - 1]).add(seq[i]);
                indexCount.put(seq[i], indexCount.getOrDefault(seq[i], 0) + 1);
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!indexCount.containsKey(i)) {
                queue.offer(i);
            }
        }

        if (queue.isEmpty() || queue.size() > 1 || nums.length != indexCount.size() + 1) {
            return false;
        }

        List<Integer> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            int i = queue.poll();
            ans.add(i);
            for (int j : edges.getOrDefault(i, new ArrayList<>())) {
                indexCount.put(j , indexCount.get(j) - 1);
                if (indexCount.get(j) == 0) {
                    queue.offer(j);
                }
            }
            if (queue.size() > 1) {
                return false;
            }
        }

        if (ans.size() != nums.length) {
            return false;
        }

        int n = ans.size();
        for (int i = 0; i < n; i++) {
            if (ans.get(i) != nums[i]) {
                return false;
            }
        }

        return true;
    }
}
```



## 相关话题

- [图](https://leetcode.cn//tag/graph)
- [拓扑排序](https://leetcode.cn//tag/topological-sort)
- [数组](https://leetcode.cn//tag/array)

## 相似题目



