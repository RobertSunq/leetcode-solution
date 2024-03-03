
| [English](README_EN.md) | 简体中文 |

# [275. H 指数 II](https://leetcode.cn//problems/h-index-ii/)

## 题目描述

<p>给你一个整数数组 <code>citations</code> ，其中 <code>citations[i]</code> 表示研究者的第 <code>i</code> 篇论文被引用的次数，<code>citations</code> 已经按照&nbsp;<strong>升序排列&nbsp;</strong>。计算并返回该研究者的 h<strong><em>&nbsp;</em></strong>指数。</p>

<p><a href="https://baike.baidu.com/item/h-index/3991452?fr=aladdin" target="_blank">h 指数的定义</a>：h 代表“高引用次数”（high citations），一名科研人员的 <code>h</code> 指数是指他（她）的 （<code>n</code> 篇论文中）<strong>至少&nbsp;</strong>有 <code>h</code> 篇论文分别被引用了<strong>至少</strong> <code>h</code> 次。</p>

<p>请你设计并实现对数时间复杂度的算法解决此问题。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<strong>输入：</strong><code>citations = [0,1,3,5,6]</code>
<strong>输出：</strong><code>3</code>
<strong>解释：</strong>给定数组表示研究者总共有 <code>5</code> 篇论文，每篇论文相应的被引用了 <code>0, 1, 3, 5, 6</code> 次。
&nbsp;    由于研究者有<code>3</code>篇论文每篇<strong> 至少 </strong>被引用了 <code>3</code> 次，其余两篇论文每篇被引用<strong> 不多于</strong> <code>3</code> 次，所以她的<em> h </em>指数是 <code>3</code> 。</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<strong>输入：</strong><code>citations = [1,2,100]</code>
<strong>输出：</strong><code>2</code>
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == citations.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= citations[i] &lt;= 1000</code></li>
	<li><code>citations</code> 按 <strong>升序排列</strong></li>
</ul>


## 题解


### Java

```Java
// @Title: H 指数 II (H-Index II)
// @Author: robert.sunq
// @Date: 2023-10-30 23:08:54
// @Runtime: 0 ms
// @Memory: 49.8 MB

class Solution {
    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) /2;

            int h = citations.length - mid;
            // 符合 h 的要求， 但是此时 h 不是最大的，时比较小的，所以缩小上线(缩小 mid )，找更大的h， 因为 h = n - mid
            if (citations[mid] >= h) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return citations.length - left;
    }

}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [二分查找](https://leetcode.cn//tag/binary-search)

## 相似题目


- [H 指数](../h-index/README.md)
