
| [English](README_EN.md) | 简体中文 |

# [42. 接雨水](https://leetcode.cn//problems/trapping-rain-water/)

## 题目描述

<p>给定&nbsp;<code>n</code> 个非负整数表示每个宽度为 <code>1</code> 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/rainwatertrap.png" style="height: 161px; width: 412px;" /></p>

<pre>
<strong>输入：</strong>height = [0,1,0,2,1,0,1,3,2,1,2,1]
<strong>输出：</strong>6
<strong>解释：</strong>上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>height = [4,2,0,3,2,5]
<strong>输出：</strong>9
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == height.length</code></li>
	<li><code>1 &lt;= n &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>0 &lt;= height[i] &lt;= 10<sup>5</sup></code></li>
</ul>


## 题解


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



## 相关话题

- [栈](https://leetcode.cn//tag/stack)
- [数组](https://leetcode.cn//tag/array)
- [双指针](https://leetcode.cn//tag/two-pointers)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)
- [单调栈](https://leetcode.cn//tag/monotonic-stack)

## 相似题目


- [盛最多水的容器](../container-with-most-water/README.md)
- [除自身以外数组的乘积](../product-of-array-except-self/README.md)
- [接雨水 II](../trapping-rain-water-ii/README.md)
- [倒水](../pour-water/README.md)
