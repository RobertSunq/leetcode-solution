
| [English](README_EN.md) | 简体中文 |

# [239. 滑动窗口最大值](https://leetcode.cn//problems/sliding-window-maximum/)

## 题目描述

<p>给你一个整数数组 <code>nums</code>，有一个大小为&nbsp;<code>k</code><em>&nbsp;</em>的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 <code>k</code>&nbsp;个数字。滑动窗口每次只向右移动一位。</p>

<p>返回 <em>滑动窗口中的最大值 </em>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<b>输入：</b>nums = [1,3,-1,-3,5,3,6,7], k = 3
<b>输出：</b>[3,3,5,5,6,7]
<b>解释：</b>
滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       <strong>3</strong>
 1 [3  -1  -3] 5  3  6  7       <strong>3</strong>
 1  3 [-1  -3  5] 3  6  7      <strong> 5</strong>
 1  3  -1 [-3  5  3] 6  7       <strong>5</strong>
 1  3  -1  -3 [5  3  6] 7       <strong>6</strong>
 1  3  -1  -3  5 [3  6  7]      <strong>7</strong>
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<b>输入：</b>nums = [1], k = 1
<b>输出：</b>[1]
</pre>

<p>&nbsp;</p>

<p><b>提示：</b></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>4</sup>&nbsp;&lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
	<li><code>1 &lt;= k &lt;= nums.length</code></li>
</ul>


## 题解


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



## 相关话题

- [队列](https://leetcode.cn//tag/queue)
- [数组](https://leetcode.cn//tag/array)
- [滑动窗口](https://leetcode.cn//tag/sliding-window)
- [单调队列](https://leetcode.cn//tag/monotonic-queue)
- [堆（优先队列）](https://leetcode.cn//tag/heap-priority-queue)

## 相似题目


- [最小覆盖子串](../minimum-window-substring/README.md)
- [最小栈](../min-stack/README.md)
- [至多包含两个不同字符的最长子串](../longest-substring-with-at-most-two-distinct-characters/README.md)
- [粉刷房子 II](../paint-house-ii/README.md)
