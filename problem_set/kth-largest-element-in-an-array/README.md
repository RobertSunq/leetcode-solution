
| [English](README_EN.md) | 简体中文 |

# [215. 数组中的第K个最大元素](https://leetcode.cn//problems/kth-largest-element-in-an-array/)

## 题目描述

<p>给定整数数组 <code>nums</code> 和整数 <code>k</code>，请返回数组中第 <code><strong>k</strong></code> 个最大的元素。</p>

<p>请注意，你需要找的是数组排序后的第 <code>k</code> 个最大的元素，而不是第 <code>k</code> 个不同的元素。</p>

<p>你必须设计并实现时间复杂度为 <code>O(n)</code> 的算法解决此问题。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> <code>[3,2,1,5,6,4],</code> k = 2
<strong>输出:</strong> 5
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre>
<strong>输入:</strong> <code>[3,2,3,1,2,4,5,5,6], </code>k = 4
<strong>输出:</strong> 4</pre>

<p>&nbsp;</p>

<p><strong>提示： </strong></p>

<ul>
	<li><code>1 &lt;= k &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>4</sup>&nbsp;&lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
</ul>


## 题解


### Java

```Java
// @Title: 数组中的第K个最大元素 (Kth Largest Element in an Array)
// @Author: robert.sunq
// @Date: 2021-06-30 22:26:59
// @Runtime: 10 ms
// @Memory: 39.1 MB

class Solution {
    int K;
    // 冒泡排序
    public int findKthLargest(int[] nums, int k) {
        K = k;
        recur(nums,0,nums.length-1);
        return nums[k-1];
    }
    // 采用快速排序每次确定一个元素位置 来  剪枝
    void recur(int[] nums,int start,int end){
        if ( end <= start) return;
        // 哨兵
        int temp = nums[start];
        int i = start;
        int j = end;
        while(i<j){
            while(j>i && nums[j] <= temp) j--;
            if(j>i) nums[i] = nums[j];
            while(j>i && nums[i] > temp) i++;
            if(j>i) nums[j] = nums[i];
        }
        nums[i] = temp;
        // 此时 哨兵就是 第k个元素
        if(i == K-1) return ;
        else if(i < K-1){
            // 则第K个大 肯定在后半段中
            recur(nums,i+1,end);
        } else{
            // 否则 在前半段中
            recur(nums,start,i-1);
        }
        
    }
}
```



### C++

```C++
// @Title: 数组中的第K个最大元素 (Kth Largest Element in an Array)
// @Author: robert.sunq
// @Date: 2020-05-13 19:03:00
// @Runtime: 36 ms
// @Memory: 9.6 MB

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {

        sort(nums.begin(),nums.end());
        int res = -1;
        int n = nums.size();
        if(k<=0 || k>n) return res;
        return nums[n-k];
        

    }
};
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [分治](https://leetcode.cn//tag/divide-and-conquer)
- [快速选择](https://leetcode.cn//tag/quickselect)
- [排序](https://leetcode.cn//tag/sorting)
- [堆（优先队列）](https://leetcode.cn//tag/heap-priority-queue)

## 相似题目


- [摆动排序 II](../wiggle-sort-ii/README.md)
- [前 K 个高频元素](../top-k-frequent-elements/README.md)
- [第三大的数](../third-maximum-number/README.md)
- [数据流中的第 K 大元素](../kth-largest-element-in-a-stream/README.md)
- [最接近原点的 K 个点](../k-closest-points-to-origin/README.md)
