
| English | [简体中文](README.md) |

# [448. Find All Numbers Disappeared in an Array](https://leetcode.cn//problems/find-all-numbers-disappeared-in-an-array/)

## Description

<p>Given an array <code>nums</code> of <code>n</code> integers where <code>nums[i]</code> is in the range <code>[1, n]</code>, return <em>an array of all the integers in the range</em> <code>[1, n]</code> <em>that do not appear in</em> <code>nums</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [4,3,2,7,8,2,3,1]
<strong>Output:</strong> [5,6]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [1,1]
<strong>Output:</strong> [2]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= n</code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Could you do it without extra space and in <code>O(n)</code> runtime? You may assume the returned list does not count as extra space.</p>


## Solutions


### Java

```Java
// @Title: 找到所有数组中消失的数字 (Find All Numbers Disappeared in an Array)
// @Author: robert.sunq
// @Date: 2021-06-21 22:35:47
// @Runtime: 7 ms
// @Memory: 47.4 MB

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int i =0;
        while(i<nums.length){
            // 如果位置下标与数字对应 或者 位置该下标对应的数字不存在跳过
            if(nums[i] == i+1 || nums[i] == -1) {
                i++;
                continue;
            }
            // 即当前元素与其对应下标位置的元素重复，将当前位置赋值为 -1，表示暂时该下标对应的数字缺失;
            if(nums[i] == nums[nums[i] - 1]){
                nums[i] = -1;
                i++;
            }else{
                // 否则，交换位置 ， 使得目标位置的下标与数字相同
                int temp = nums[i];
                nums[i] = nums[temp-1];
                nums[temp-1] = temp;
            }
        }
        for(i = 0;i<nums.length;i++){
            if(nums[i] == -1) res.add(i+1);
        }
        return res;
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Hash Table](https://leetcode.cn//tag/hash-table)

## Similar Questions

- [First Missing Positive](../first-missing-positive/README_EN.md)
- [Find All Duplicates in an Array](../find-all-duplicates-in-an-array/README_EN.md)
