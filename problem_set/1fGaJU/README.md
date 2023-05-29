
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 007. 数组中和为 0 的三个数](https://leetcode.cn//problems/1fGaJU/)

## 题目描述

<p>给你一个整数数组 <code>nums</code> ，判断是否存在三元组 <code>[nums[i], nums[j], nums[k]]</code> 满足 <code>i != j</code>、<code>i != k</code> 且 <code>j != k</code> ，同时还满足 <code>nums[i] + nums[j] + nums[k] == 0</code> 。请</p>

<p>你返回所有和为 <code>0</code> 且不重复的三元组。</p>

<p><strong>注意：</strong>答案中不可以包含重复的三元组。</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [-1,0,1,2,-1,-4]
<strong>输出：</strong>[[-1,-1,2],[-1,0,1]]
<strong>解释：</strong>
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
注意，输出的顺序和三元组的顺序并不重要。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,1,1]
<strong>输出：</strong>[]
<strong>解释：</strong>唯一可能的三元组和不为 0 。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,0,0]
<strong>输出：</strong>[[0,0,0]]
<strong>解释：</strong>唯一可能的三元组和为 0 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>3 &lt;= nums.length &lt;= 3000</code></li>
	<li><code>-10<sup>5</sup> &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>
&nbsp;

<p><meta charset="UTF-8" />注意：本题与主站 15&nbsp;题相同：<a href="https://leetcode.cn/problems/3sum/">leetcode.cn/problems/3sum/</a></p>


## 题解


### Java

```Java
// @Title: 数组中和为 0 的三个数 (数组中和为 0 的三个数)
// @Author: robert.sunq
// @Date: 2023-05-29 22:43:21
// @Runtime: 22 ms
// @Memory: 46.4 MB

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 排序，固定一个位置，然后转为找两个数的和等于第一个
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        int targetIndex = 0;
        int startIndex = 1;
        int endIndex = nums.length - 1;
        while (targetIndex < nums.length - 1) {
            // 当 target 发生变化时， 将起始和终止恢复位置
            startIndex = targetIndex + 1;
            endIndex = nums.length - 1;
            while(startIndex < endIndex) {
                // 注意 负数
                if ( 0 - nums[targetIndex] == nums[startIndex] + nums[endIndex]) {
                    List<Integer> tmpAns = new ArrayList<>();
                    tmpAns.add(nums[targetIndex]);
                    tmpAns.add(nums[startIndex]);
                    tmpAns.add(nums[endIndex]);

                    ans.add(tmpAns);

                    // 注意 跳过相等的数字，避免出现重复结果
                    // 当然不论是从开头还是结果进行跳过，结果都一样，因为和固定情况下，只要一个数发生改变，另一个也变化
                    while (startIndex < endIndex && nums[startIndex] == nums[startIndex + 1]) {
                        startIndex++;
                    }
                    startIndex++;
                } else if (0 - nums[targetIndex] > nums[startIndex] + nums[endIndex]) {
                    startIndex++;
                } else {
                    endIndex--;
                }
            }
            // 同样需要跳过固定值的相同属性
            while (targetIndex < nums.length - 1 && nums[targetIndex] == nums[targetIndex+1]) {
                targetIndex++;
            }
            targetIndex++;
        }

        return ans;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [双指针](https://leetcode.cn//tag/two-pointers)
- [排序](https://leetcode.cn//tag/sorting)

## 相似题目



