
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 075. 数组相对排序](https://leetcode.cn//problems/0H97ZC/)

## 题目描述

<p>给定两个数组，<code>arr1</code> 和&nbsp;<code>arr2</code>，</p>

<ul>
	<li><code>arr2</code>&nbsp;中的元素各不相同</li>
	<li><code>arr2</code> 中的每个元素都出现在&nbsp;<code>arr1</code>&nbsp;中</li>
</ul>

<p>对 <code>arr1</code>&nbsp;中的元素进行排序，使 <code>arr1</code> 中项的相对顺序和&nbsp;<code>arr2</code>&nbsp;中的相对顺序相同。未在&nbsp;<code>arr2</code>&nbsp;中出现过的元素需要按照升序放在&nbsp;<code>arr1</code>&nbsp;的末尾。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
<strong>输出：</strong>[2,2,2,1,4,3,3,9,6,7,19]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= arr1.length, arr2.length &lt;= 1000</code></li>
	<li><code>0 &lt;= arr1[i], arr2[i] &lt;= 1000</code></li>
	<li><code>arr2</code>&nbsp;中的元素&nbsp;<code>arr2[i]</code>&nbsp;各不相同</li>
	<li><code>arr2</code> 中的每个元素&nbsp;<code>arr2[i]</code>&nbsp;都出现在&nbsp;<code>arr1</code>&nbsp;中</li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 1122&nbsp;题相同：<a href="https://leetcode-cn.com/problems/relative-sort-array/">https://leetcode-cn.com/problems/relative-sort-array/</a>&nbsp;</p>


## 题解


### Java

```Java
// @Title: 数组相对排序 (数组相对排序)
// @Author: robert.sunq
// @Date: 2023-07-18 23:16:58
// @Runtime: 4 ms
// @Memory: 40.4 MB

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        int n2 = arr2.length;
        for (int i = 0; i < n2; i++) {
            map.put(arr2[i], i);
        }
        List<Integer> list = new ArrayList<>();
        for (int n : arr1) {
            list.add(n);
        }
        list.sort((a , b) -> {
            // 注意， 如果值不再 arr2 中，需要保持其为升序
            // 同时还要排在 arr2 中存在元素的最后面，所以改成 n2 + a.
            return map.getOrDefault(a, n2 + a) - map.getOrDefault(b, n2 + b);
        });

        for (int i = 0 ; i < arr1.length; i++) {
            arr1[i] = list.get(i);
        }
        return arr1;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [哈希表](https://leetcode.cn//tag/hash-table)
- [计数排序](https://leetcode.cn//tag/counting-sort)
- [排序](https://leetcode.cn//tag/sorting)

## 相似题目



