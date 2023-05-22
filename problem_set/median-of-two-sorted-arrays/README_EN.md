
| English | [简体中文](README.md) |

# [4. Median of Two Sorted Arrays](https://leetcode.cn//problems/median-of-two-sorted-arrays/)

## Description

<p>Given two sorted arrays <code>nums1</code> and <code>nums2</code> of size <code>m</code> and <code>n</code> respectively, return <strong>the median</strong> of the two sorted arrays.</p>

<p>The overall run time complexity should be <code>O(log (m+n))</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [1,3], nums2 = [2]
<strong>Output:</strong> 2.00000
<strong>Explanation:</strong> merged array = [1,2,3] and median is 2.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [1,2], nums2 = [3,4]
<strong>Output:</strong> 2.50000
<strong>Explanation:</strong> merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>nums1.length == m</code></li>
	<li><code>nums2.length == n</code></li>
	<li><code>0 &lt;= m &lt;= 1000</code></li>
	<li><code>0 &lt;= n &lt;= 1000</code></li>
	<li><code>1 &lt;= m + n &lt;= 2000</code></li>
	<li><code>-10<sup>6</sup> &lt;= nums1[i], nums2[i] &lt;= 10<sup>6</sup></code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 寻找两个正序数组的中位数 (Median of Two Sorted Arrays)
// @Author: robert.sunq
// @Date: 2021-06-01 22:09:19
// @Runtime: 3 ms
// @Memory: 39.6 MB

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n= nums2.length;
        int index1 = (m+n-1)/2;
        int index2 = (m+n-1)/2 + (m+n-1)% 2;
        int i = 0,j=0,t=0;
        int[] res = new int[n+m];
        while(i < m && j <n){
            if(nums1[i]<=nums2[j]) {
                res[t] = nums1[i];
                i++;
            }else{
                res[t] = nums2[j];
                j++;
            }
            t++;
        }
        while(i<m){
            res[t++] = nums1[i++];
        }
        while(j<n){
            res[t++] = nums2[j++];
        }
        return (res[index1] + res[index2]) / 2.0;
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Binary Search](https://leetcode.cn//tag/binary-search)
- [Divide and Conquer](https://leetcode.cn//tag/divide-and-conquer)

## Similar Questions


