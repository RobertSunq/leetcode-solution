
| English | [简体中文](README.md) |

# [718. Maximum Length of Repeated Subarray](https://leetcode.cn//problems/maximum-length-of-repeated-subarray/)

## Description

<p>Given two integer arrays <code>nums1</code> and <code>nums2</code>, return <em>the maximum length of a subarray that appears in <strong>both</strong> arrays</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
<strong>Output:</strong> 3
<strong>Explanation:</strong> The repeated subarray with maximum length is [3,2,1].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
<strong>Output:</strong> 5
<strong>Explanation:</strong> The repeated subarray with maximum length is [0,0,0,0,0].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums1.length, nums2.length &lt;= 1000</code></li>
	<li><code>0 &lt;= nums1[i], nums2[i] &lt;= 100</code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 最长重复子数组 (Maximum Length of Repeated Subarray)
// @Author: robert.sunq
// @Date: 2021-07-18 15:47:42
// @Runtime: 46 ms
// @Memory: 47.5 MB

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int res = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        // 边界状态，长度为0的两个串匹配为0
        int[][] dp = new int[len1+1][len2+1];

        // i 表示长度为i的结尾为 num1[i-1]的字符串与
        // j 表示长度为j的结尾为num2[j-1]的字符串的最长子数组长度
        for(int i = 1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                // 当前结尾匹配
                if(nums1[i-1] == nums2[j-1]){
                    // 前一个字符不匹配，则匹配长度为0，匹配时则为dp[i-1][j-1]故不需要区分， + 1 表示加上当前匹配字符
                    // 当前状态两字符匹配长度
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = 0;
                }
                res = Math.max(res,dp[i][j]);
            }
        }

        return res;
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Binary Search](https://leetcode.cn//tag/binary-search)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)
- [Sliding Window](https://leetcode.cn//tag/sliding-window)
- [Hash Function](https://leetcode.cn//tag/hash-function)
- [Rolling Hash](https://leetcode.cn//tag/rolling-hash)

## Similar Questions

- [Minimum Size Subarray Sum](../minimum-size-subarray-sum/README_EN.md)
