
| English | [简体中文](README.md) |

# [347. Top K Frequent Elements](https://leetcode.cn//problems/top-k-frequent-elements/)

## Description

<p>Given an integer array <code>nums</code> and an integer <code>k</code>, return <em>the</em> <code>k</code> <em>most frequent elements</em>. You may return the answer in <strong>any order</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [1,1,1,2,2,3], k = 2
<strong>Output:</strong> [1,2]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [1], k = 1
<strong>Output:</strong> [1]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
	<li><code>k</code> is in the range <code>[1, the number of unique elements in the array]</code>.</li>
	<li>It is <strong>guaranteed</strong> that the answer is <strong>unique</strong>.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Your algorithm&#39;s time complexity must be better than <code>O(n log n)</code>, where n is the array&#39;s size.</p>


## Solutions


### Java

```Java
// @Title: 前 K 个高频元素 (Top K Frequent Elements)
// @Author: robert.sunq
// @Date: 2021-06-20 01:23:52
// @Runtime: 14 ms
// @Memory: 41 MB

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        // 计算每个数值出现的个数
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        // 将数量保存到数组第一个，下标表示元素
        int[][] dp = new int[mp.keySet().size()][2];
        int i =0;
        for(Integer key:mp.keySet()){
            dp[i][0] = mp.get(key);
            dp[i][1] = key;
            i++;
        }
        // 采用快排方式，按照数组第一位进行排序
        recur(dp,0,dp.length-1);
        int[] res = new int[k];
        i = 0;
        // 获取前k个
        while(i<k){
            res[i] = dp[i][1];
            i++;
        }
        return res;
        
    }

    void recur(int[][]  dp , int start,int end){
        if(start >= end) return;
        int[] temp = new int[]{dp[start][0],dp[start][1]};
        int i = start;
        int j = end;
        while(i<j){
            while(i<j && dp[j][0] <= temp[0]) j--;
            if(i<j){
                dp[i][0] = dp[j][0];
                dp[i][1] = dp[j][1];
                i++;
            }
            while(i<j && dp[i][0] >= temp[0]) i++;
            if(i<j){
                dp[j][0] = dp[i][0];
                dp[j][1] = dp[i][1];
                j--;
            }
        }
        dp[i][0]=temp[0];
        dp[i][1]=temp[1];
        recur(dp,start,i-1);
        recur(dp,i+1,end);

    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Hash Table](https://leetcode.cn//tag/hash-table)
- [Divide and Conquer](https://leetcode.cn//tag/divide-and-conquer)
- [Bucket Sort](https://leetcode.cn//tag/bucket-sort)
- [Counting](https://leetcode.cn//tag/counting)
- [Quickselect](https://leetcode.cn//tag/quickselect)
- [Sorting](https://leetcode.cn//tag/sorting)
- [Heap (Priority Queue)](https://leetcode.cn//tag/heap-priority-queue)

## Similar Questions

- [Word Frequency](../word-frequency/README_EN.md)
- [Kth Largest Element in an Array](../kth-largest-element-in-an-array/README_EN.md)
- [Sort Characters By Frequency](../sort-characters-by-frequency/README_EN.md)
- [Split Array into Consecutive Subsequences](../split-array-into-consecutive-subsequences/README_EN.md)
- [Top K Frequent Words](../top-k-frequent-words/README_EN.md)
- [K Closest Points to Origin](../k-closest-points-to-origin/README_EN.md)
