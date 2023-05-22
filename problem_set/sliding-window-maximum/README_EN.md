
| English | [简体中文](README.md) |

# [239. Sliding Window Maximum](https://leetcode.cn//problems/sliding-window-maximum/)

## Description

<p>You are given an array of integers&nbsp;<code>nums</code>, there is a sliding window of size <code>k</code> which is moving from the very left of the array to the very right. You can only see the <code>k</code> numbers in the window. Each time the sliding window moves right by one position.</p>

<p>Return <em>the max sliding window</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,3,-1,-3,5,3,6,7], k = 3
<strong>Output:</strong> [3,3,5,5,6,7]
<strong>Explanation:</strong> 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       <strong>3</strong>
 1 [3  -1  -3] 5  3  6  7       <strong>3</strong>
 1  3 [-1  -3  5] 3  6  7      <strong> 5</strong>
 1  3  -1 [-3  5  3] 6  7       <strong>5</strong>
 1  3  -1  -3 [5  3  6] 7       <strong>6</strong>
 1  3  -1  -3  5 [3  6  7]      <strong>7</strong>
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1], k = 1
<strong>Output:</strong> [1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
	<li><code>1 &lt;= k &lt;= nums.length</code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 滑动窗口最大值 (Sliding Window Maximum)
// @Author: robert.sunq
// @Date: 2021-06-18 00:42:09
// @Runtime: 33 ms
// @Memory: 52.7 MB

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length<2) return nums;
        // 双向队列保存降序数值的坐标  当前窗口的最大值数组位置
        LinkedList<Integer> queue = new LinkedList<>();
        int i =0;
        int[] res = new int[nums.length-k+1];
        while(i<nums.length){
            // 队列不为空，将队列中小于当前元素的坐标全部弹出，因为当前窗口内的最小值可以为当前值
            while(!queue.isEmpty() && nums[queue.getLast()] <= nums[i]){
                queue.removeLast();
            }
            // 当前位置的元素即为队列中的最小值，将当前元素放到队列末尾
            queue.addLast(i);
            // 当前队列头部的元素 不在窗口内 放出
            if(queue.getFirst() <= i-k){
                queue.removeFirst();
            }
            // 当窗口长度已经到带 K是 保存当前最大值
            if(i >= k -1){
                res[i-k + 1] = nums[queue.getFirst()];
            }
            i++;
        }
        return res;
    }
}
```



## Related Topics

- [Queue](https://leetcode.cn//tag/queue)
- [Array](https://leetcode.cn//tag/array)
- [Sliding Window](https://leetcode.cn//tag/sliding-window)
- [Monotonic Queue](https://leetcode.cn//tag/monotonic-queue)
- [Heap (Priority Queue)](https://leetcode.cn//tag/heap-priority-queue)

## Similar Questions

- [Minimum Window Substring](../minimum-window-substring/README_EN.md)
- [Min Stack](../min-stack/README_EN.md)
- [Longest Substring with At Most Two Distinct Characters](../longest-substring-with-at-most-two-distinct-characters/README_EN.md)
- [Paint House II](../paint-house-ii/README_EN.md)
