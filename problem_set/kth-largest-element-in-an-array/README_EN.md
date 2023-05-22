
| English | [简体中文](README.md) |

# [215. Kth Largest Element in an Array](https://leetcode.cn//problems/kth-largest-element-in-an-array/)

## Description

<p>Given an integer array <code>nums</code> and an integer <code>k</code>, return <em>the</em> <code>k<sup>th</sup></code> <em>largest element in the array</em>.</p>

<p>Note that it is the <code>k<sup>th</sup></code> largest element in the sorted order, not the <code>k<sup>th</sup></code> distinct element.</p>

<p>You must solve it in <code>O(n)</code> time complexity.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [3,2,1,5,6,4], k = 2
<strong>Output:</strong> 5
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [3,2,3,1,2,4,5,5,6], k = 4
<strong>Output:</strong> 4
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= k &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
</ul>


## Solutions


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



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Divide and Conquer](https://leetcode.cn//tag/divide-and-conquer)
- [Quickselect](https://leetcode.cn//tag/quickselect)
- [Sorting](https://leetcode.cn//tag/sorting)
- [Heap (Priority Queue)](https://leetcode.cn//tag/heap-priority-queue)

## Similar Questions

- [Wiggle Sort II](../wiggle-sort-ii/README_EN.md)
- [Top K Frequent Elements](../top-k-frequent-elements/README_EN.md)
- [Third Maximum Number](../third-maximum-number/README_EN.md)
- [Kth Largest Element in a Stream](../kth-largest-element-in-a-stream/README_EN.md)
- [K Closest Points to Origin](../k-closest-points-to-origin/README_EN.md)
