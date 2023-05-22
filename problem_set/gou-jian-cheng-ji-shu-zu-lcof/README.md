
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 66. 构建乘积数组](https://leetcode.cn//problems/gou-jian-cheng-ji-shu-zu-lcof/)

## 题目描述

<p>给定一个数组 <code>A[0,1,…,n-1]</code>，请构建一个数组 <code>B[0,1,…,n-1]</code>，其中 <code>B[i]</code> 的值是数组 <code>A</code> 中除了下标 <code>i</code> 以外的元素的积, 即 <code>B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]</code>。不能使用除法。</p>

<p> </p>

<p><strong>示例:</strong></p>

<pre>
<strong>输入:</strong> [1,2,3,4,5]
<strong>输出:</strong> [120,60,40,30,24]</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li>所有元素乘积之和不会溢出 32 位整数</li>
	<li><code>a.length <= 100000</code></li>
</ul>


## 题解


### Java

```Java
// @Title: 构建乘积数组 (构建乘积数组 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-31 21:31:56
// @Runtime: 1 ms
// @Memory: 51.1 MB

class Solution {
    public int[] constructArr(int[] a) {
        int temp = 1;
        if(a.length < 1) return new int[0];
        int[] res = new int[a.length];
        for(int i=0;i<a.length;i++){
            res[i] = temp;
            temp = temp*a[i];
        }
        temp = 1;
        for(int i=a.length-1;i>=0;i--){
            res[i] = res[i]*temp;
            temp = temp*a[i];
        }
        return res;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [前缀和](https://leetcode.cn//tag/prefix-sum)

## 相似题目



