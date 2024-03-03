
| English | [简体中文](README.md) |

# [274. H-Index](https://leetcode.cn//problems/h-index/)

## Description

<p>Given an array of integers <code>citations</code> where <code>citations[i]</code> is the number of citations a researcher received for their <code>i<sup>th</sup></code> paper, return <em>the researcher&#39;s h-index</em>.</p>

<p>According to the <a href="https://en.wikipedia.org/wiki/H-index" target="_blank">definition of h-index on Wikipedia</a>: The h-index is defined as the maximum value of <code>h</code> such that the given researcher has published at least <code>h</code> papers that have each been cited at least <code>h</code> times.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> citations = [3,0,6,1,5]
<strong>Output:</strong> 3
<strong>Explanation:</strong> [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> citations = [1,3,1]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == citations.length</code></li>
	<li><code>1 &lt;= n &lt;= 5000</code></li>
	<li><code>0 &lt;= citations[i] &lt;= 1000</code></li>
</ul>


## Solutions


### Java

```Java
// @Title: H 指数 (H-Index)
// @Author: robert.sunq
// @Date: 2023-10-14 21:02:08
// @Runtime: 1 ms
// @Memory: 39 MB

class Solution {
    public int hIndex(int[] citations) {
        int left = 0;
        // 注意这里是 数组的长度, 因为下面是 left < right, 所以要从 n 开始，而不是 n - 1 开始
        int right = citations.length;
        int count = 0;
        while (left < right) {
            // 因为要找到最大的一个符合结果的数据，所以要找到最后，
            // 为了避免到最后 mid 一直等于 left 且 < right, 所以这里向上取整
            int mid = (left + right + 1) / 2; // mid 就是
            count = 0;

            for (int i = 0; i < citations.length; i++) {
                if (citations[i] >= mid) {
                    count++;
                }
            } 

            if (count >= mid) {
                // 大于 mid 的引用数量，大于mid个数, 已经符合要求什  要继续提高mid找更大的
                // 在 mid right 中找
                left = mid;
            } else {
                // 这时候  大于 mid 的文章少，所以降低mid的大小，找
                right = mid -  1;

            }
        }


        return left;
    }


    // public int hIndex(int[] citations) {
    //     Arrays.sort(citations);

    //     int h = 0;
    //     int i = citations.length - 1;
    //     while (i >= 0 && citations[i] > h) {
    //         h++;
    //         i--;
    //     }
    //     return h;
    // }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Counting Sort](https://leetcode.cn//tag/counting-sort)
- [Sorting](https://leetcode.cn//tag/sorting)

## Similar Questions

- [H-Index II](../h-index-ii/README_EN.md)
