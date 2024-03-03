
| English | [简体中文](README.md) |

# [2216. Minimum Deletions to Make Array Beautiful](https://leetcode.cn//problems/minimum-deletions-to-make-array-beautiful/)

## Description

<p>You are given a <strong>0-indexed</strong> integer array <code>nums</code>. The array <code>nums</code> is <strong>beautiful</strong> if:</p>

<ul>
	<li><code>nums.length</code> is even.</li>
	<li><code>nums[i] != nums[i + 1]</code> for all <code>i % 2 == 0</code>.</li>
</ul>

<p>Note that an empty array is considered beautiful.</p>

<p>You can delete any number of elements from <code>nums</code>. When you delete an element, all the elements to the right of the deleted element will be <strong>shifted one unit to the left</strong> to fill the gap created and all the elements to the left of the deleted element will remain <strong>unchanged</strong>.</p>

<p>Return <em>the <strong>minimum</strong> number of elements to delete from </em><code>nums</code><em> to make it </em><em>beautiful.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,1,2,3,5]
<strong>Output:</strong> 1
<strong>Explanation:</strong> You can delete either <code>nums[0]</code> or <code>nums[1]</code> to make <code>nums</code> = [1,2,3,5] which is beautiful. It can be proven you need at least 1 deletion to make <code>nums</code> beautiful.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,1,2,2,3,3]
<strong>Output:</strong> 2
<strong>Explanation:</strong> You can delete <code>nums[0]</code> and <code>nums[5]</code> to make nums = [1,2,2,3] which is beautiful. It can be proven you need at least 2 deletions to make nums beautiful.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 美化数组的最少删除数 (Minimum Deletions to Make Array Beautiful)
// @Author: robert.sunq
// @Date: 2023-11-21 22:17:34
// @Runtime: 2 ms
// @Memory: 55.7 MB

class Solution {
    public int minDeletion(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int right = 1;
        int left = 0 ;
        while (right < n) {
            // 初始时，left % 2 == 0， right = left + 1; 所以可以直接判断，是否满足需求
            // 在满足需求时，left = right + 1, 即来到了奇数位的下一位，则还是偶数位置，同理，right = right + 2， 也就是下一个要对比的偶数维
            if (nums[left] != nums[right]) {
                left = right + 1;
                right = left + 1;
            } else {
                // 相等，则删除下一位， right往后走，视作在移动整个右侧。
                right = right + 1;
                ans += 1;
            }
        }

        // 删除相关元素后，剩余的长度是奇数，则代表最后一位也要删除
        if ((n - ans) % 2 == 1) {
            ans += 1;
        }

        return ans;
    }
}
```



## Related Topics

- [Stack](https://leetcode.cn//tag/stack)
- [Greedy](https://leetcode.cn//tag/greedy)
- [Array](https://leetcode.cn//tag/array)

## Similar Questions


