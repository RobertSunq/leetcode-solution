
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 62. 圆圈中最后剩下的数字](https://leetcode.cn//problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/)

## 题目描述

<p>0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。</p>

<p>例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入:</strong> n = 5, m = 3
<strong>输出: </strong>3
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入:</strong> n = 10, m = 17
<strong>输出: </strong>2
</pre>

<p> </p>

<p><strong>限制：</strong></p>

<ul>
	<li><code>1 <= n <= 10^5</code></li>
	<li><code>1 <= m <= 10^6</code></li>
</ul>


## 题解


### Java

```Java
// @Title: 圆圈中最后剩下的数字 (圆圈中最后剩下的数字 LCOF)
// @Author: robert.sunq
// @Date: 2021-08-04 23:04:24
// @Runtime: 4 ms
// @Memory: 35.1 MB

class Solution {
    public int lastRemaining(int n, int m) {
        // ArrayList<Integer> res = new ArrayList<>();
        // for (int i =0 ;i<n;i++){
        //     res.add(i);
        // }
        // int d = 0;
        // while(n>1){
        //     d = (d+m-1)% n;
        //     res.remove(d);
        //     n--;
        // }
        // return res.get(0);
        // 最后剩下的人员编号
        int res = 0;
        // 最后一次删除是是两个数字，所以从2开始
        for(int i=2;i<=n;i++){
            res = (res + m) % i;
        }
        return res;
    }
}
```



## 相关话题

- [递归](https://leetcode.cn//tag/recursion)
- [数学](https://leetcode.cn//tag/math)

## 相似题目



