
| English | [简体中文](README.md) |

# [78. Subsets](https://leetcode.cn//problems/subsets/)

## Description

<p>Given an integer array <code>nums</code> of <strong>unique</strong> elements, return <em>all possible</em> <span data-keyword="subset"><em>subsets</em></span> <em>(the power set)</em>.</p>

<p>The solution set <strong>must not</strong> contain duplicate subsets. Return the solution in <strong>any order</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3]
<strong>Output:</strong> [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0]
<strong>Output:</strong> [[],[0]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10</code></li>
	<li><code>-10 &lt;= nums[i] &lt;= 10</code></li>
	<li>All the numbers of&nbsp;<code>nums</code> are <strong>unique</strong>.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 子集 (Subsets)
// @Author: robert.sunq
// @Date: 2021-06-05 23:15:46
// @Runtime: 1 ms
// @Memory: 38.3 MB

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length-1;
        List<List<Integer>> res = recur(nums,len);
        return res;
    }

    List<List<Integer>> recur(int[] nums , int end){
        // List<List<Integer>> res = new ArrayList<>();
        if(end < 0) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            res.add(temp);
            return res;
        }
        List<List<Integer>> res = recur(nums,end-1);
        int i = 0;
        int len = res.size();
        while(i<len){

            List<Integer> temp = new ArrayList<>(res.get(i));
            // ArrayList<Integer> temp1 = new ArrayList<>(temp);
            // 放入当前位置的字符
            temp.add(nums[end]);
            res.add(temp);
            i++;
        }
        return res;
    }
}
```



## Related Topics

- [Bit Manipulation](https://leetcode.cn//tag/bit-manipulation)
- [Array](https://leetcode.cn//tag/array)
- [Backtracking](https://leetcode.cn//tag/backtracking)

## Similar Questions

- [Subsets II](../subsets-ii/README_EN.md)
- [Generalized Abbreviation](../generalized-abbreviation/README_EN.md)
- [Letter Case Permutation](../letter-case-permutation/README_EN.md)
