
| English | [简体中文](README.md) |

# [42. Trapping Rain Water](https://leetcode.cn//problems/trapping-rain-water/)

## Description

<p>Given <code>n</code> non-negative integers representing an elevation map where the width of each bar is <code>1</code>, compute how much water it can trap after raining.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img src="https://assets.leetcode.com/uploads/2018/10/22/rainwatertrap.png" style="width: 412px; height: 161px;" />
<pre>
<strong>Input:</strong> height = [0,1,0,2,1,0,1,3,2,1,2,1]
<strong>Output:</strong> 6
<strong>Explanation:</strong> The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> height = [4,2,0,3,2,5]
<strong>Output:</strong> 9
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == height.length</code></li>
	<li><code>1 &lt;= n &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>0 &lt;= height[i] &lt;= 10<sup>5</sup></code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 接雨水 (Trapping Rain Water)
// @Author: robert.sunq
// @Date: 2021-07-01 22:00:29
// @Runtime: 1 ms
// @Memory: 38.2 MB

class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] left = new int[len];
        // 记录到当前位置的左侧最大值
        for(int i =0 ;i<len;i++){
            if(i == 0){
                left[i] = height[i];
            }else{
                left[i] = Math.max(left[i-1],height[i]);
            }
        }
        int res = 0;
        int temp = 0;
        int h = 0;
        for(int i = len-1;i>0;i--){
            if(i == len-1){
                temp = height[i];
            }else{
                // 记录到当前位置的右侧最大值
                temp = Math.max(temp,height[i]);
                // 可以接水的最大高度为左右侧的最小值
                h = Math.min(left[i],temp);
                if(h>height[i]){
                    res = res + (h - height[i]);
                }
            }
        }

        return res;
    }
}
```



### C++

```C++
// @Title: 接雨水 (Trapping Rain Water)
// @Author: robert.sunq
// @Date: 2020-05-13 14:54:01
// @Runtime: 8 ms
// @Memory: 6.8 MB

class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        if (n<3) return 0; 
        vector<int> left(n,0),right(n,0);
        for(int i=1;i<n-1;i++){
            left[i] = max(left[i-1],height[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            right[i] = max(right[i+1],height[i+1]);
        }
        int sum = 0;
        for(int i=1;i<n-1;i++){
            int temp = min(right[i],left[i]);
            if(temp > height[i])
                sum = sum+temp-height[i];
        }
        return sum;
    }
};
```



## Related Topics

- [Stack](https://leetcode.cn//tag/stack)
- [Array](https://leetcode.cn//tag/array)
- [Two Pointers](https://leetcode.cn//tag/two-pointers)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)
- [Monotonic Stack](https://leetcode.cn//tag/monotonic-stack)

## Similar Questions

- [Container With Most Water](../container-with-most-water/README_EN.md)
- [Product of Array Except Self](../product-of-array-except-self/README_EN.md)
- [Trapping Rain Water II](../trapping-rain-water-ii/README_EN.md)
- [Pour Water](../pour-water/README_EN.md)
