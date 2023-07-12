
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 060. 出现频率最高的 k 个数字](https://leetcode.cn//problems/g5c51o/)

## 题目描述

<p>给定一个整数数组 <code>nums</code> 和一个整数 <code>k</code>&nbsp;，请返回其中出现频率前 <code>k</code> 高的元素。可以按 <strong>任意顺序</strong> 返回答案。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入: </strong>nums = [1,1,1,2,2,3], k = 2
<strong>输出: </strong>[1,2]
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入: </strong>nums = [1], k = 1
<strong>输出: </strong>[1]</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>k</code> 的取值范围是 <code>[1, 数组中不相同的元素的个数]</code></li>
	<li>题目数据保证答案唯一，换句话说，数组中前 <code>k</code> 个高频元素的集合是唯一的</li>
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>所设计算法的时间复杂度 <strong>必须</strong> 优于 <code>O(n log n)</code> ，其中 <code>n</code><em>&nbsp;</em>是数组大小。</p>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 347&nbsp;题相同：<a href="https://leetcode-cn.com/problems/top-k-frequent-elements/">https://leetcode-cn.com/problems/top-k-frequent-elements/</a></p>


## 题解


### Java

```Java
// @Title: 出现频率最高的 k 个数字 (出现频率最高的 k 个数字)
// @Author: robert.sunq
// @Date: 2023-07-12 22:35:25
// @Runtime: 14 ms
// @Memory: 46.5 MB

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<int[]> que = new PriorityQueue<>(count.size() + 1, (a , b) -> a[1] - b[1]);
        int[] tmp;
        for (int n : count.keySet()) {
            tmp = new int[]{n, count.get(n)};
            que.offer(tmp);
            if(que.size() > k) {
                que.poll();
            }
        }

        tmp = new int[k];
        for (int i = 0; i < k; i++) {
            tmp[i] = que.poll()[0];
        }
        return tmp;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [哈希表](https://leetcode.cn//tag/hash-table)
- [分治](https://leetcode.cn//tag/divide-and-conquer)
- [桶排序](https://leetcode.cn//tag/bucket-sort)
- [计数](https://leetcode.cn//tag/counting)
- [快速选择](https://leetcode.cn//tag/quickselect)
- [排序](https://leetcode.cn//tag/sorting)
- [堆（优先队列）](https://leetcode.cn//tag/heap-priority-queue)

## 相似题目



