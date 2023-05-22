
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 40. 最小的k个数](https://leetcode.cn//problems/zui-xiao-de-kge-shu-lcof/)

## 题目描述

<p>输入整数数组 <code>arr</code> ，找出其中最小的 <code>k</code> 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>arr = [3,2,1], k = 2
<strong>输出：</strong>[1,2] 或者 [2,1]
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>arr = [0,1,2,1], k = 1
<strong>输出：</strong>[0]</pre>

<p>&nbsp;</p>

<p><strong>限制：</strong></p>

<ul>
	<li><code>0 &lt;= k &lt;= arr.length &lt;= 10000</code></li>
	<li><code>0 &lt;= arr[i]&nbsp;&lt;= 10000</code></li>
</ul>


## 题解


### Java

```Java
// @Title: 最小的k个数 (最小的k个数  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-28 23:20:13
// @Runtime: 814 ms
// @Memory: 39.9 MB

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        // 冒泡排序法，将最小值放到后面，排序K次即可
        int len = arr.length;
        // 冒泡排序K次
        for (int i = 1;i<=k;i++){
            // 注意，这里采用 j 与 j+1 比较 故I从1开始
            for(int j=0;j<len-i;j++){
                if(arr[j] < arr[j+1]){
                    // 交换
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        // 取后K位即可
        int[] res = new int[k];
        while(k > 0){
            res[k-1] = arr[len-k];
            k--;
        }
        return res;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [分治](https://leetcode.cn//tag/divide-and-conquer)
- [快速选择](https://leetcode.cn//tag/quickselect)
- [排序](https://leetcode.cn//tag/sorting)
- [堆（优先队列）](https://leetcode.cn//tag/heap-priority-queue)

## 相似题目



