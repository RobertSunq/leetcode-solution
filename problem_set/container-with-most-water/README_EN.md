
| English | [简体中文](README.md) |

# [11. Container With Most Water](https://leetcode.cn//problems/container-with-most-water/)

## Description

<p>You are given an integer array <code>height</code> of length <code>n</code>. There are <code>n</code> vertical lines drawn such that the two endpoints of the <code>i<sup>th</sup></code> line are <code>(i, 0)</code> and <code>(i, height[i])</code>.</p>

<p>Find two lines that together with the x-axis form a container, such that the container contains the most water.</p>

<p>Return <em>the maximum amount of water a container can store</em>.</p>

<p><strong>Notice</strong> that you may not slant the container.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/17/question_11.jpg" style="width: 600px; height: 287px;" />
<pre>
<strong>Input:</strong> height = [1,8,6,2,5,4,8,3,7]
<strong>Output:</strong> 49
<strong>Explanation:</strong> The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> height = [1,1]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == height.length</code></li>
	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= height[i] &lt;= 10<sup>4</sup></code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 盛最多水的容器 (Container With Most Water)
// @Author: robert.sunq
// @Date: 2021-06-02 00:11:44
// @Runtime: 5 ms
// @Memory: 51.8 MB

class Solution {
    public int maxArea(int[] height) {
        // 双指针， 由两边向内收缩
        int i = 0 , j = height.length -1;
        int res = 0;
        while(i < j){
            // 容量由，两个板子中最低的决定
            res = Math.max(res,Math.min(height[i],height[j])*(j-i));
            // 移动长板子，段板子不动的话，不管移动到哪个位置，整体的高度只能比短板子小，或者相等
            // 因此 移动短板子，使得容量变为可能增大
            // 相等时，移动哪一个都一样
            if(height[i] <= height[j]){
                i++;
            }else{
                j--;
            }
        }
        return res;
    }
}
```



## Related Topics

- [Greedy](https://leetcode.cn//tag/greedy)
- [Array](https://leetcode.cn//tag/array)
- [Two Pointers](https://leetcode.cn//tag/two-pointers)

## Similar Questions

- [Trapping Rain Water](../trapping-rain-water/README_EN.md)
