
| [English](README_EN.md) | 简体中文 |

# [347. 前 K 个高频元素](https://leetcode.cn//problems/top-k-frequent-elements/)

## 题目描述

<p>给你一个整数数组 <code>nums</code> 和一个整数 <code>k</code> ，请你返回其中出现频率前 <code>k</code> 高的元素。你可以按 <strong>任意顺序</strong> 返回答案。</p>

<p> </p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入: </strong>nums = [1,1,1,2,2,3], k = 2
<strong>输出: </strong>[1,2]
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入: </strong>nums = [1], k = 1
<strong>输出: </strong>[1]</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 10<sup>5</sup></code></li>
	<li><code>k</code> 的取值范围是 <code>[1, 数组中不相同的元素的个数]</code></li>
	<li>题目数据保证答案唯一，换句话说，数组中前 <code>k</code> 个高频元素的集合是唯一的</li>
</ul>

<p> </p>

<p><strong>进阶：</strong>你所设计算法的时间复杂度 <strong>必须</strong> 优于 <code>O(n log n)</code> ，其中 <code>n</code><em> </em>是数组大小。</p>


## 题解


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


- [统计词频](../word-frequency/README.md)
- [数组中的第K个最大元素](../kth-largest-element-in-an-array/README.md)
- [根据字符出现频率排序](../sort-characters-by-frequency/README.md)
- [分割数组为连续子序列](../split-array-into-consecutive-subsequences/README.md)
- [前K个高频单词](../top-k-frequent-words/README.md)
- [最接近原点的 K 个点](../k-closest-points-to-origin/README.md)
