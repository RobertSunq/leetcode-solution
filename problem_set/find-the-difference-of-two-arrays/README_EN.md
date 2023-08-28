
| English | [简体中文](README.md) |

# [2215. Find the Difference of Two Arrays](https://leetcode.cn//problems/find-the-difference-of-two-arrays/)

## Description

<p>Given two <strong>0-indexed</strong> integer arrays <code>nums1</code> and <code>nums2</code>, return <em>a list</em> <code>answer</code> <em>of size</em> <code>2</code> <em>where:</em></p>

<ul>
	<li><code>answer[0]</code> <em>is a list of all <strong>distinct</strong> integers in</em> <code>nums1</code> <em>which are <strong>not</strong> present in</em> <code>nums2</code><em>.</em></li>
	<li><code>answer[1]</code> <em>is a list of all <strong>distinct</strong> integers in</em> <code>nums2</code> <em>which are <strong>not</strong> present in</em> <code>nums1</code>.</li>
</ul>

<p><strong>Note</strong> that the integers in the lists may be returned in <strong>any</strong> order.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [1,2,3], nums2 = [2,4,6]
<strong>Output:</strong> [[1,3],[4,6]]
<strong>Explanation:
</strong>For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [1,2,3,3], nums2 = [1,1,2,2]
<strong>Output:</strong> [[3],[]]
<strong>Explanation:
</strong>For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
Every integer in nums2 is present in nums1. Therefore, answer[1] = [].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums1.length, nums2.length &lt;= 1000</code></li>
	<li><code>-1000 &lt;= nums1[i], nums2[i] &lt;= 1000</code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 找出两数组的不同 (Find the Difference of Two Arrays)
// @Author: robert.sunq
// @Date: 2023-08-22 21:52:23
// @Runtime: 11 ms
// @Memory: 43.1 MB

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> numSet1 = new HashSet<>();
        Set<Integer> numSet2 = new HashSet<>();
        for (int n : nums1) {
            numSet1.add(n);
        }

        for (int n : nums2) {
            numSet2.add(n);
        }

        for (int n : nums1) {
            numSet2.remove(n);
        }

        for (int n : nums2) {
            numSet1.remove(n);
        }

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        for (int n : numSet1) {
            tmp.add(n);
        }
        ans.add(tmp);

        tmp = new ArrayList<>();
        for (int n : numSet2) {
            tmp.add(n);
        }
        ans.add(tmp);

        return ans;
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Hash Table](https://leetcode.cn//tag/hash-table)

## Similar Questions


